#include "university.h"

#include <iostream>
#include <fstream>
#include <iomanip>
#include <map>

typedef std::string State;

int main (int argc, char const* argv[]) {
    if(argc < 2) {
        std::cerr << "usage: " << argv[0] << " datafile" << std::endl;
        return -1;
    }
    
    std::multimap<State, University> universities;
    
    std::ifstream ifs{std::string{argv[1]}};
    if(!ifs) {
        std::cerr << argv[1] << ": file not found" << std::endl;
        return -2;
    }
    
    State state;
    University new_U;

    while(true) {
        std::getline(ifs, state);
        ifs >> new_U;
        if(!ifs) break;
        // std::cerr << "Adding " << new_U.name() << " to " << state << std::endl;
        universities.insert(std::make_pair(state, new_U));
    }
    
    // Print state table
    std::ifstream ifsa{"state_abbrev.txt"};
    if(!ifsa) std::cout << "State abbreviations not found" << std::endl;
    std::map<std::string, std::string> state_abbrevs;
    int count = 0;
    while(ifsa) {
        std::string st, abbr;
        std::getline(ifsa, st);
        std::getline(ifsa, abbr);
        if(ifsa) state_abbrevs[abbr] = st;
    }
    for(auto& [abbr, st] : state_abbrevs) {
        std::cout << std::left << std::setw(4) << abbr  << std::setw(18) << st;
        if((++count % 4) == 0) std::cout << std::endl;
    }
    std::cout << std::endl;
    
    while(true) {
        std::cout << "\nWhich state (2-character abbreviation): ";
        std::getline(std::cin, state);
        if(state.empty()) break;
        int count = 0;
        for(auto it = universities.begin(); it != universities.end(); ++it) {
            if(it->first == state) {
                std::cout << it->second << std::endl;
                ++count;
            }
        }
        if(count == 0) std::cerr << "No universities found in " << state << std::endl;
    }

    return 0;
}
