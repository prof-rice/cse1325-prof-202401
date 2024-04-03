#include <iostream>
#include <vector>

int main(int argc, char* argv[]) {
    std::vector<std::string> odds;
    std::vector<std::string>* evens = new std::vector<std::string>{};
    
    for(int i=1; i<argc; ++i) {
        std::string s = std::string{argv[i]};
        if(s.size() % 2) odds.push_back(s);
        else evens->push_back(s);   
    }
    
    std::cout << "Odd lengths:\n";
    for(auto s : odds) std::cout << s << '\n';
    std::cout << "\n\n";
    
    std::cout << "Even lengths:\n";
    for(auto s : *evens) std::cout << s << '\n';
    std::cout << "\n\n";
}
    
