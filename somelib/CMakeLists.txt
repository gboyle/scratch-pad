
add_library(somelib somelib.cxx)

install (TARGETS somelib DESTINATION bin)
install (FILES somelib.h DESTINATION include)
