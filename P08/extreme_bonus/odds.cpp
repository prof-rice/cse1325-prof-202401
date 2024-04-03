#include <iostream>
#include <vector>
#include <algorithm>
#include <random> 
#include <chrono> 

int main(int argc, char* argv[]) {
    std::vector<std::string> odds;
    std::vector<std::string>* evens = new std::vector<std::string>{};
    
    for(int i=1; i<argc; ++i) {
        std::string s = std::string{argv[i]};
        if(s.size() % 2) odds.push_back(s);
        else evens->push_back(s);   
    }
    
    std::sort(odds.begin(), odds.end());
    std::cout << "Odd lengths (sorted):\n";
    for(auto s : odds) std::cout << s << '\n';
    std::cout << "\n\n";
    
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::shuffle(evens->begin(), evens->end(),std::default_random_engine(seed));
    std::cout << "Even lengths (shuffled):\n";
    for(auto s : *evens) std::cout << s << '\n';
    std::cout << "\n\n";
}
    
