CXXFLAGS += --std=c++17

odds: odds.cpp *.h
	-$(CXX) $(CXXFLAGS)  odds.cpp -o odds
	@printf "Now type ./odds and some words to execute the result\n\n"

clean:
	rm -f *.o *.gch *~ a.out odds

