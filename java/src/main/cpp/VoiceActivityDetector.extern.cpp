#include "VoiceActivityDetector.h"
#include <jni.h>
#include <string>


extern "C" {

VoiceActivityDetector *vad = nullptr;

void initialize(int mode) {
    vad = new VoiceActivityDetector(mode);
}

void stop() {
    delete vad;
    vad = nullptr;
}

}

extern "C" JNIEXPORT void JNICALL
Java_io_webfolder_webrtc_vad_WebRtcVad_initializeVad(
        JNIEnv
        *env,
        jobject /* this */,
        jint mode) {
    initialize((int) mode);

}

extern "C" JNIEXPORT void JNICALL
Java_io_webfolder_webrtc_vad_WebRtcVad_stopVad(
        JNIEnv
        *env,
        jobject /* this */) {
    stop();

}

extern "C" JNIEXPORT jboolean
JNICALL
Java_io_webfolder_webrtc_vad_WebRtcVad_isVoice(
        JNIEnv *env,
        jobject /* this */,
        jshortArray audioFrame,
        jint sampleRate,
        jint frameLength
) {

    if (vad == nullptr) return jboolean(0);

    jshort* audioFramePtr = env->GetShortArrayElements(audioFrame, NULL);

    jboolean isVoice = (jboolean) vad->
            isVoice(audioFramePtr, sampleRate, frameLength);

    env->ReleaseShortArrayElements(audioFrame, audioFramePtr, 0);

    return isVoice;
}


