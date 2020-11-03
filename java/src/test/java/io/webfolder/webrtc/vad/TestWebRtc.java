package io.webfolder.webrtc.vad;

import org.junit.Test;

public class TestWebRtc {

	@Test
	public void testInit() {
		WebRtcVad.initializeVad(1);
		WebRtcVad.stopVad();
	}
}
