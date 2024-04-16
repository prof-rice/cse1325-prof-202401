CXXFLAGS = --std=c++17

io_inch: io_inch.o inch.o *.h
	$(CXX) $(CXXFLAGS) io_inch.o inch.o -o io_inch

io_inch.o: io_inch.cpp *.h
	$(CXX) $(CXXFLAGS) -c io_inch.cpp -o io_inch.o



test_inch: test_inch.o inch.o *.h
	$(CXX) $(CXXFLAGS) test_inch.o inch.o -o test_inch

test_inch.o: test_inch.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_inch.cpp -o test_inch.o



inch.o: inch.cpp *.h
	$(CXX) $(CXXFLAGS) -c inch.cpp -o inch.o 


all: test_inch io_inch

clean:
	rm -f *.o *.gch a.out test_inch io_inch

