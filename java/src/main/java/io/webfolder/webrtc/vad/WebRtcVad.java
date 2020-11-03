package io.webfolder.webrtc.vad;

import static java.lang.System.getProperty;

import static java.util.Locale.ENGLISH;

public class WebRtcVad {

    private static final String  OS_NAME  = getProperty("os.name").toLowerCase(ENGLISH);

    private static final boolean WINDOWS  = OS_NAME.startsWith("windows");

    static {
        if (WINDOWS) {
            System.loadLibrary("webrtc-vad-java");
        } else {
            System.loadLibrary("libwebrtc-vad-java");
        }
    }

    public static native void initializeVad(int mode);

    public static native void stopVad();

    public static native boolean isVoice(short[] audioFrame,
                                         int     sampleRate,
                                         int     frameLength);
}
