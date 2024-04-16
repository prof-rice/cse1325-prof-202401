#include "inch.h"

#include <iostream>

int main (int argc, char const* argv[]) {
    Inch in;
    Inch last_in;
    Inch sum;
    std::cout << "Starting sum is " << sum << ", last entry was " << last_in << std::endl;
    while(std::cin) {
        std::cout << "Enter one or more measurements (in inches): ";
        if(std::cin >> in) {
            sum = sum + in;
            std::cout << "\nYou  entered  " << in << std::endl;
            if(in == last_in) std::cout << "Same length as last time!" << std::endl;
            if(in != last_in) std::cout << "NOT the same length as last time." << std::endl;
            if(in < last_in) std::cout << "Smaller than last time." << std::endl;
            if(in <= last_in) std::cout << "Smaller or same length as last time." << std::endl;
            if(in > last_in) std::cout << "Bigger length than last time." << std::endl;
            if(in >= last_in) std::cout << "Bigger or same length as last time!" << std::endl;
            last_in = in;
            std::cout << "Sum so far is " << sum << std::endl;
        }
        std::cout << std::endl;
    }
}
