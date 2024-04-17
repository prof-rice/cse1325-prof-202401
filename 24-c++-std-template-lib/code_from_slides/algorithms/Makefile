CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

count: count.cpp
	-$(CXX) $(CXXFLAGS) -o count count.cpp
	@printf "Now type ./count to execute the result\n\n"

findall: findall.cpp
	-$(CXX) $(CXXFLAGS) -o findall findall.cpp
	@printf "Now type ./findall to execute the result\n\n"

find: find.cpp
	-$(CXX) $(CXXFLAGS) -o find find.cpp
	@printf "Now type ./find to execute the result\n\n"

findif: findif.cpp
	-$(CXX) $(CXXFLAGS) -o findif findif.cpp
	@printf "Now type ./findif to execute the result\n\n"

generate_and_transform: generate_and_transform.cpp
	-$(CXX) $(CXXFLAGS) -o generate_and_transform generate_and_transform.cpp
	@printf "Now type ./generate_and_transform to execute the result\n\n"

generate: generate.cpp
	-$(CXX) $(CXXFLAGS) -o generate generate.cpp
	@printf "Now type ./generate to execute the result\n\n"

minmax: minmax.cpp
	-$(CXX) $(CXXFLAGS) -o minmax minmax.cpp
	@printf "Now type ./minmax to execute the result\n\n"

shuffle_and_sort: shuffle_and_sort.cpp
	-$(CXX) $(CXXFLAGS) -o shuffle_and_sort shuffle_and_sort.cpp
	@printf "Now type ./shuffle_and_sort to execute the result\n\n"

transform1: transform1.cpp
	-$(CXX) $(CXXFLAGS) -o transform1 transform1.cpp
	@printf "Now type ./transform1 to execute the result\n\n"

transform: transform.cpp
	-$(CXX) $(CXXFLAGS) -o transform transform.cpp
	@printf "Now type ./transform to execute the result\n\n"

all:  count findall find findif generate_and_transform generate minmax shuffle_and_sort transform1 transform

clean:
	rm -f *.o *.gch a.out  count findall find findif generate_and_transform generate minmax shuffle_and_sort transform1 transform

