project(webrtc-vad-java)

cmake_minimum_required(VERSION 3.4.1)

find_package(JNI REQUIRED)

if(WIN32)
  find_package(pthreads REQUIRED)
endif()

set(CMAKE_POSITION_INDEPENDENT_CODE ON)

include_directories(${JAVA_INCLUDE_PATH})
include_directories(${JAVA_INCLUDE_PATH2})

file(GLOB webrtc_vad_sources
        "../webrtc/*.c"
        "../webrtc/common_audio/*/*.c"
        )

add_library(
        webrtc-vad-java
        SHARED
        ${webrtc_vad_sources}
        src/main/cpp/VoiceActivityDetector.cpp
        src/main/cpp/VoiceActivityDetector.extern.cpp
        )

find_path(PTHREAD_INCLUDE_DIR pthread.h)

include_directories(../)
include_directories(../webrtc/common_audio/vad/include/)
include_directories(../webrtc/common_audio/signal_processing/include/)

target_include_directories(webrtc-vad-java PRIVATE ${PTHREAD_INCLUDE_DIR})

if(WIN32)
  target_link_libraries(webrtc-vad-java PThreads4W::PThreads4W)
else()
  target_link_libraries(webrtc-vad-java pthread)
endif()
