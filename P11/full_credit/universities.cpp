#include "university.h"

#include <iostream>
#include <fstream>
#include <iomanip>
#include <map>
#include <vector>

typedef std::string State;
typedef std::vector<University> Universities;

int main (int argc, char const* argv[]) {
    // Validate correct number of arguments
    if(argc < 2) {
        std::cerr << "usage: " << argv[0] << " datafile" << std::endl;
        return -1;
    }
    
    // Open univerisites data file
    std::ifstream ifs{std::string{argv[1]}};
    if(!ifs) {
        std::cerr << argv[1] << ": file not found" << std::endl;
        return -2;
    }
    
    // Load university data into universities map
    std::map<State, Universities> universities;
    
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

    // Print universities for user-selected state
    while(true) {
        std::cout << "\nWhich state (2-character abbreviation): ";
        std::getline(std::cin, state);
        if(state.empty()) break;
        
        if(universities.find(state) == universities.end()) {
            std::cerr << "No universities found in " << state << std::endl;
        } else {
            Universities::iterator it = universities[state].begin();
            while(it != universities[state].end()) {
                std::cout << *it << std::endl;
                ++it;
            }
/*          // This is the for-each loop version with explicit getter access
            for(University u : universities[state]) {
                std::cout << u.name() << " has an enrollment of " 
                          << u.enrollment() << std::endl;
            }
*/
        }
    }

    return 0;
}
