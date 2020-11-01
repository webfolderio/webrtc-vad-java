project(vad)

cmake_minimum_required(VERSION 3.4.1)

find_package(JNI REQUIRED)
find_package(Threads REQUIRED)

include_directories(${JAVA_INCLUDE_PATH})
include_directories(${JAVA_INCLUDE_PATH2})

file(GLOB webrtc_vad_sources
        "../webrtc/*.c"
        "../webrtc/common_audio/*/*.c"
        )

add_library(
        vad
        SHARED
        ${webrtc_vad_sources}
        src/main/cpp/VoiceActivityDetector.cpp
        src/main/cpp/VoiceActivityDetector.extern.cpp
        )

include_directories(../)
include_directories(../webrtc/common_audio/vad/include/)
include_directories(../webrtc/common_audio/signal_processing/include/)

target_link_libraries(vad Threads::Threads)
