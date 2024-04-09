#include <iostream>

#include "polynomial.h" // not really needed
#include "linear.h"
#include "quadratic.h"

void usage(char* executable) {
    std::cerr << "usage: " << executable << " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0" << std::endl;
}

int main (int argc, char* argv[]) {
    if(argc > 1 && std::string{argv[1]} == "-h") {
        usage(argv[0]);
        return 0;
    }
    Polynomial* p = NULL;
    try {
        if(argc < 3 || argc > 4) 
            throw std::runtime_error{"Invalid polynomial size - must be linear or quadratic"};
        if(argc == 3) {
            double a = std::stod(std::string(argv[1]));
            double b = std::stod(std::string(argv[2]));
            
            if(a != 0) {
                if(a == -1) std::cout << "-";
                if(std::abs(a) != 1) std::cout << argv[1];
                std::cout << "x";
            }
            if(b != 0) {
                if(b > 0) std::cout << "+";
                std::cout << argv[2];
            }
            
            p = new Linear{{a, b}};
            
        } else {
            double a = std::stod(std::string(argv[1]));
            double b = std::stod(std::string(argv[2]));
            double c = std::stod(std::string(argv[3]));
            
            if(a != 0) {
                if(a == -1) std::cout << "-";
                if(std::abs(a) != 1) std::cout << argv[1];
                std::cout << "x²";
            }
            if(b != 0) {
                if(b > 0) std::cout << "+";
                if(b == -1) std::cout << "-";
                if(std::abs(b) != 1) std::cout << argv[2];
                std::cout << "x";
            }
            if(c != 0) {
                if(c > 0) std::cout << "+";
                std::cout << argv[3];
            }
            
            p = new Quadratic{{a, b, c}};
        }
        std::vector<double> roots = p -> solve();
        std::cout << (roots.size() == 1 ? " root is " : " roots are ");
        for(auto d : roots) std::cout << d << " ";
        std::cout << std::endl;
    } catch(std::runtime_error& e) {
        std::cerr << "\nRuntime error: " << e.what() << std::endl;
        usage(argv[0]);
        return -1;
    } catch(std::out_of_range& e) {
        std::cerr << "\nOut of range: " << e.what() << std::endl;
        usage(argv[0]);
        return -2;
    } catch(std::invalid_argument& e) {
        std::string msg{"Invalid argument: All coefficients must be double"};
        std::cerr << msg << std::endl;
        usage(argv[0]);
        return -3;
    } catch(std::exception& e) {
        std::cerr << "\nError: " << e.what() << std::endl;
        usage(argv[0]);
        return -4;
    } 
    delete p;
}


