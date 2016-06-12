
#include <iostream>
#include "sidonia-config.h"

#ifdef USE_SOMELIB
#include "somelib.h"
#endif

int main() {

    std::cout << "sidonia " << SIDONIA_VERSION_MAJOR << "." << SIDONIA_VERSION_MINOR << std::endl;

    #ifdef USE_SOMELIB
    std::cout << somefun(3.14) << std::endl;
    #endif
}