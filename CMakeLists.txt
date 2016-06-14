
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

install (TARGETS sidonia DESTINATION bin)
install (FILES "${PROJECT_BINARY_DIR}/sidonia-config.h" DESTINATION include)


include(CTest)

add_test(SidoniaRuns sidonia 25)

add_test(SidoniaComputesDouble sidonia 25)
set_tests_properties(SidoniaComputesDouble PROPERTIES PASS_REGULAR_EXPRESSION "25 is 5")

add_test(SidoniaNegative sidonia -25)
set_tests_properties(SidoniaNegative PROPERTIES PASS_REGULAR_EXPRESSION "-25 is 0")

add_test(SidoniaSmall sidonia 0.0001)
set_tests_properties(SidoniaSmall PROPERTIES PASS_REGULAR_EXPRESSION "0.0001 is 0")

add_test(SidoniaUsage sidonia)
set_tests_properties(SidoniaUsage PROPERTIES PASS_REGULAR_EXPRESSION "Usage:.*number")

macro (do_test arg result)
    add_test(SidoniaTest${arg} sidonia ${arg})
    set_tests_properties(SidoniaTest${arg} PROPERTIES PASS_REGULAR_EXPRESSION ${result})
endmacro (do_test)

do_test(25 "25 is 5")
do_test(-25 "-25 is 0")
do_test(16 "16 is 4")