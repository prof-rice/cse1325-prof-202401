CXXFLAGS = --std=c++17

solver: solver.o polynomial.o linear.o quadratic.o *.h
	$(CXX) $(CXXFLAGS) solver.o polynomial.o linear.o quadratic.o -o solver

solver.o: solver.cpp *.h
	$(CXX) $(CXXFLAGS) -c solver.cpp -o solver.o

polynomial.o: polynomial.cpp *.h
	$(CXX) $(CXXFLAGS) -c polynomial.cpp -o polynomial.o

linear.o: linear.cpp *.h
	$(CXX) $(CXXFLAGS) -c linear.cpp -o linear.o

quadratic.o: quadratic.cpp *.h
	$(CXX) $(CXXFLAGS) -c quadratic.cpp -o quadratic.o

clean:
	rm -f *.o *.gch a.out solver

