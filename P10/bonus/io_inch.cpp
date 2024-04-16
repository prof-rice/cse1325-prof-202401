#include "inch.h"

#include <iostream>
#include <fstream>

void usage(const char* progname) {
    std::cout << "usage: " << progname << " [-h] [-|infile [outfile]]" << std::endl;
    exit(0);
} 
int main (int argc, char const* argv[]) {
    std::ifstream ifs;
    std::string infile  = (argc > 1) ? std::string{argv[1]} : "";
    std::string outfile = (argc > 2) ? std::string{argv[2]} : "";
    if(argc > 1) {
        if(infile == "-h") usage(argv[0]);
        if(infile != "-") {
            ifs = std::ifstream{infile};
            if(!ifs) std::cerr << "Unable to open " << infile << std::endl;
        }
    }
    std::ofstream ofs;
    if(argc > 2) {
        ofs = std::ofstream{outfile};
        if(ofs) std::cout << "Writing inputs to " << outfile << std::endl;
        else std::cerr << "#### Unable to open " << outfile << std::endl;
    }
    
    Inch in;
    Inch last_in;
    Inch sum;
    std::cout << "Starting sum is " << sum << ", last entry was " << last_in << std::endl;
    
    while(std::cin) {
        if(ifs) {
            try {
                ifs >> in;
                if(!ifs) continue;
            } catch(std::exception e) {
                continue;
            }
            std::cout << "\nRead " << in << " from " << infile << std::endl;
        } else {
            try {
                std::cout << "Enter one or more measurements (in inches): ";
                std::cin >> in;
                if(!std::cin) continue;
            } catch(std::exception e) {
                continue;
            }
            std::cout << "\nYou entered " << in << std::endl;
        }
        if(true) {
            sum = sum + in;
            
            if(in == last_in) std::cout << "Same length as last time!" << std::endl;
            if(in != last_in) std::cout << "NOT the same length as last time." << std::endl;
            if(in < last_in) std::cout << "Smaller than last time." << std::endl;
            if(in <= last_in) std::cout << "Smaller or same length as last time." << std::endl;
            if(in > last_in) std::cout << "Bigger length than last time." << std::endl;
            if(in >= last_in) std::cout << "Bigger or same length as last time!" << std::endl;
 
            last_in = in;
            if(ofs) ofs << in << std::endl;
            std::cout << "Sum so far is " << sum << std::endl;
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}
