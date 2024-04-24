CXXFLAGS += --std=c++17

all: alls

debug: CXXFLAGS += -g
debug: alls

maps: maps.cpp
	-$(CXX) $(CXXFLAGS) maps.cpp -o maps
rule3: rule3.cpp
	-$(CXX) $(CXXFLAGS) rule3.cpp -o rule3
sort_array: sort_array.cpp
	-$(CXX) $(CXXFLAGS) sort_array.cpp -o sort_array
temp: temp.cpp
	-$(CXX) $(CXXFLAGS) temp.cpp -o temp
template: template.cpp
	-$(CXX) $(CXXFLAGS) template.cpp -o template
template_soln1: template_soln1.cpp
	-$(CXX) $(CXXFLAGS) template_soln1.cpp -o template_soln1
template_soln2: template_soln2.cpp
	-$(CXX) $(CXXFLAGS) template_soln2.cpp -o template_soln2
transform: transform.cpp
	-$(CXX) $(CXXFLAGS) transform.cpp -o transform

alls:  maps rule3 sort_array temp template template_soln1 template_soln2 transform

clean:
	rm -f *.o *.gch a.out  maps rule3 sort_array temp template template_soln1 template_soln2 transform

