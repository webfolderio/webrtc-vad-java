package io.webfolder.webrtc.vad;

public class WebRtcVad {

	static {
		System.loadLibrary("vad");
	}

    public static native void initializeVad(int mode);

    public static native void stopVad();

    public static native boolean isVoice(short[] audioFrame,
                                          int     sampleRate,
                                          int     frameLength);
}
