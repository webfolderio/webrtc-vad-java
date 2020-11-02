mkdir build
cd build
cmake -DCMAKE_BUILD_TYPE=Release -DVCPKG_TARGET_TRIPLET=x64-windows -DCMAKE_TOOLCHAIN_FILE="C:\tools\vcpkg\scripts\buildsystems\vcpkg.cmake" -G"Visual Studio 15 2017 Win64" ..
cmake --build . --target vad --config Release
