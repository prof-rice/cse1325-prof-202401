#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>

typedef std::string State;
typedef double Area;
typedef std::pair<State, Area> P;

int main() {
    std::vector<P> areas;
    areas.push_back(std::pair{std::string{"California"}, 163696});
    areas.push_back(std::pair{std::string{"Florida"}, 65758});
    areas.push_back(std::pair{std::string{"New York"}, 54556});
    areas.push_back(std::pair{std::string{"Texas"}, 268497}); 
    
    std::sort(areas.begin(), areas.end(), [] (P p1, P p2) {return p1.second < p2.second;});
    for(auto p : areas) std::cout << p.first << " is " << p.second << " square miles" << std::endl;
}
