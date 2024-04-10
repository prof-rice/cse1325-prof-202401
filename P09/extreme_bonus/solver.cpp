#include <iostream>
#include <sstream>
#include <iomanip>

#include "polynomial.h" // not really needed
#include "linear.h"
#include "quadratic.h"

void usage(char* executable) {
    std::cerr << "usage: " << executable << " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0" << std::endl;
}

// I'm unhappy with the default << formatting for std::complex, which is (1, 2)
//   so I wrote a to_string that uses 1+2i instead

// String streams work exactly like std::cout and std::cin, but to and from strings!
std::string to_string(std::complex<double> c) {
    std::ostringstream oss;
    //     up to 8 digits       no trailing 0 (or .)   don't use + for positive numbers
    oss << std::setprecision(8) << std::noshowpoint << std::noshowpos;
    if(c.real() != 0.0 || c.imag() == 0.0) oss << c.real();
    oss << std::showpos;
    if(c.imag() != 0.0) oss << c.imag() << "i";
    return oss.str();
}
/* Here's reasonable formatting without using string streams
std::string to_string(std::complex<double> c) {
    std::string s;
    if(c.real() != 0.0) {
        s += std::to_string(c.real());
        if(c.imag() > 0) {
            s += "+";
        }
    }
    if(c.imag() != 0.0) {
        s += std::to_string(c.imag()) + "i";
    }
    return s;
} 
*/

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
        std::vector<std::complex<double>> roots = p -> solve();
        std::cout << (roots.size() == 1 ? " root is " : " roots are ");
        for(auto d : roots) std::cout << to_string(d) << " ";
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


