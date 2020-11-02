mkdir build
cd build
cmake -DCMAKE_BUILD_TYPE=Release -DVCPKG_TARGET_TRIPLET=x64-windows -G"Visual Studio 15 2017 Win64"
cmake --build .
