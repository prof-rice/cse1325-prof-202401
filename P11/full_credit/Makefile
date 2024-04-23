CXXFLAGS = --std=c++17

universities: universities.o university.o *.h
	-$(CXX) $(CXXFLAGS) universities.o university.o -o universities

universities.o: universities.cpp *.h
	-$(CXX) $(CXXFLAGS) -c universities.cpp -o universities.o

university.o: university.cpp *.h
	-$(CXX) $(CXXFLAGS) -c university.cpp -o university.o

clean:
	rm -f *.o *.gch a.out *~  universities

