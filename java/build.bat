mkdir build
cd build
cmake -DCMAKE_BUILD_TYPE=Release -DVCPKG_TARGET_TRIPLET=x64-windows -DCMAKE_TOOLCHAIN_FILE="C:\tools\vcpkg\scripts\buildsystems\vcpkg.cmake" .. -GNinja
ninja
