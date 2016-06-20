


add_executable(MakeTable someprep.cxx)

add_custom_command(
    OUTPUT ${CMAKE_CURRENT_BINARY_DIR}/table.h
    COMMAND MakeTable ${CMAKE_CURRENT_BINARY_DIR}/table.h
    DEPENDS MakeTable
)

include_directories(${CMAKE_CURRENT_BINARY_DIR})

add_library(somelib somelib.cxx ${CMAKE_CURRENT_BINARY_DIR}/table.h)

install (TARGETS somelib DESTINATION bin)
install (FILES somelib.h DESTINATION include)
