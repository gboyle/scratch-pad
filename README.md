# git test 

    [scratch-pad]$ cmake .
    -- The C compiler identification is GNU 5.3.1
    -- The CXX compiler identification is GNU 5.3.1
    -- Check for working C compiler: /usr/bin/cc
    -- Check for working C compiler: /usr/bin/cc -- works
    -- Detecting C compiler ABI info
    -- Detecting C compiler ABI info - done
    -- Detecting C compile features
    -- Detecting C compile features - done
    -- Check for working CXX compiler: /usr/bin/c++
    -- Check for working CXX compiler: /usr/bin/c++ -- works
    -- Detecting CXX compiler ABI info
    -- Detecting CXX compiler ABI info - done
    -- Detecting CXX compile features
    -- Detecting CXX compile features - done
    -- Configuring done
    -- Generating done
    -- Build files have been written to: /xxx/scratch-pad
    [scratch-pad]$ make
    Scanning dependencies of target sidonia
    [ 50%] Building CXX object CMakeFiles/sidonia.dir/sidonia.cxx.o
    [100%] Linking CXX executable sidonia
    [100%] Built target sidonia
    [scratch-pad]$ ./sidonia 
    sidonia 0.1

### list currently changed files

    git status
    
### remove all untracked directories and files

    git clean -df

### build with optional module

    mkdir out
    cd out
    cmake -DUSE_SOMELIB=1 ..
    make
    make test
    ./sidonia


(testing 123)