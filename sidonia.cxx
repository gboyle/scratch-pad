
#include <iostream>
#include "sidonia-config.h"
#include "somelib.h"

int main() {

    std::cout << "sidonia " << SIDONIA_VERSION_MAJOR << "." << SIDONIA_VERSION_MINOR << std::endl;
    std::cout << somefun(3.14) << std::endl;
}