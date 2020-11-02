package io.webfolder.webrtc.vad;

public class WebRtcVad {

    private static native void initializeVad(int mode);

    private static native void stopVad();

    private static native boolean isVoice(short[] audioFrame,
                                          int     sampleRate,
                                          int     frameLength);
}
