
#include <iostream>
#include "sidonia-config.h"
#include <cmath>

#ifdef USE_SOMELIB
#include "somelib.h"
#endif

int main() {

    std::cout << "sidonia " << SIDONIA_VERSION_MAJOR << "." << SIDONIA_VERSION_MINOR << std::endl;

    #ifdef USE_SOMELIB
    std::cout << somefun(3.14) << std::endl;
    #endif

    #if defined(HAVE_LOG)
        std::cout << "log" << std:endln;
    #endif

    #if defined(HAVE_EXP)
        std::cout << "exp" << std:endln;
    #endif    
}