
cmake_minimum_required(VERSION 3.4)
project (sidonia)

# version number
set(SIDONIA_VERSION_MAJOR 0)
set(SIDONIA_VERSION_MINOR 1)

# cmake header file to pass info to project
configure_file (
    "${PROJECT_SOURCE_DIR}/sidonia-config.h.in"
    "${PROJECT_BINARY_DIR}/sidonia-config.h"
)

# add binary directory to search path so configuration header will be found
include_directories("${PROJECT_BINARY_DIR}")


option(USE_SOMELIB "Use somelib library implementation" ON)

if (USE_SOMELIB)
    include_directories("${PROJECT_SOURCE_DIR}/somelib")
    add_subdirectory(somelib)
	set(EXTRA_LIBS ${EXTRA_LIBS} somelib)
endif (USE_SOMELIB)


# add the executable
add_executable(sidonia sidonia.cxx)
target_link_libraries(sidonia ${EXTRA_LIBS})
