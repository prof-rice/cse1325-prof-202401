#include "university.h"

#include <iostream>
#include <fstream>
#include <iomanip>
#include <map>
#include <vector>

typedef std::string State;
typedef std::vector<University> Universities;

template<class T> 
void print_container(T t) {
    typename T::iterator it = t.begin();
    while(it != t.end()) {
        std::cout << *it << std::endl;
        ++it;
    }
}

int main (int argc, char const* argv[]) {
    if(argc < 2) {
        std::cerr << "usage: " << argv[0] << " datafile" << std::endl;
        return -1;
    }
    
    std::map<State, Universities> universities;
    
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
        if(universities.find(state) == universities.end()) {
            // std::cerr << "Creating state " << state << std::endl;
            universities[state] = Universities{};
        }
        // std::cerr << "Adding " << new_U.name() << " to " << state << std::endl;
        universities[state].push_back(new_U);
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
        
        if(universities.find(state) == universities.end()) {
            std::cerr << "No universities found in " << state << std::endl;
        } else {
            print_container(universities[state]);
/*
            Universities::iterator it = universities[state].begin();
            while(it != universities[state].end()) {
                std::cout << it->name() << " has an enrollment of " 
                          << it->enrollment() << std::endl;
                ++it;
            }
*/
/*
            for(University u : universities[state]) {
                std::cout << u.name() << " has an enrollment of " 
                          << u.enrollment() << std::endl;
            }
*/
        }
    }

    return 0;
}
