CXXFLAGS = --std=c++17

all: universities test_generic_fn_with_map

universities: universities.o university.o *.h
	-$(CXX) $(CXXFLAGS) universities.o university.o -o universities

universities.o: universities.cpp *.h
	-$(CXX) $(CXXFLAGS) -c universities.cpp -o universities.o

university.o: university.cpp *.h
	-$(CXX) $(CXXFLAGS) -c university.cpp -o university.o

test_generic_fn_with_map: test_generic_fn_with_map.cpp
	-$(CXX) $(CXXFLAGS) test_generic_fn_with_map.cpp -o test_generic_fn_with_map

clean:
	rm -f *.o *.gch a.out *~  universities test_generic_fn_with_map
