#include "linear.h"

#include <stdexcept>

Linear::Linear(std::vector<double> coefficients)
    : Polynomial{coefficients} {
    if(coefficients.size() != 2 || coefficients[0] == 0.0) 
        throw std::runtime_error{"a may not be 0"};
}
std::vector<double> Linear::solve() {
    return std::vector<double>{-_coefficients[1] / _coefficients[0]};
}

