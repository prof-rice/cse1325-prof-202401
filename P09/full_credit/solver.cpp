#include <iostream>

#include "polynomial.h" // not really needed
#include "linear.h"
#include "quadratic.h"

void usage(char* executable) {
    std::cerr << "usage: " << executable << " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0" << std::endl;
}

int main (int argc, char* argv[]) {
    if(argc < 3 || argc > 4) {
        std::cerr << "Invalid polynomial size - must be linear or quadratic" << std::endl;
        return -1;
    }
    Polynomial* p = NULL;
    if(argc == 3) {
        // std::cout << "linear\n";
        double a = std::stod(std::string(argv[1]));
        double b = std::stod(std::string(argv[2]));
        p = new Linear{{a, b}};
    } else {
        // std::cout << "quadratic\n";
        double a = std::stod(std::string(argv[1]));
        double b = std::stod(std::string(argv[2]));
        double c = std::stod(std::string(argv[3]));
        p = new Quadratic{{a, b, c}};
    }
    std::vector<double> roots = p -> solve();
    std::cout << "Root(s) are ";
    for(auto d : roots) std::cout << d << " ";
    std::cout << std::endl;
    delete p;
}


