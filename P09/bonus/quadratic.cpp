#include "quadratic.h"

#include <cmath>
#include <stdexcept>

Quadratic::Quadratic(std::vector<double> coefficients)
    : Polynomial{coefficients} {
    if(coefficients.size() != 3 || coefficients[0] == 0.0) 
        throw std::runtime_error{"a may not be 0"};
}
// (-b ± √(b²-4ac)) / 2a
std::vector<double> Quadratic::solve() {
    double a = _coefficients[0];
    double b = _coefficients[1];
    double c = _coefficients[2];
    double x = b*b - 4*a*c;
    if(x < 0) throw std::runtime_error{"No real roots!"};
    x = std::sqrt(x);
    return std::vector<double>{(-b+x)/(2*a), (-b-x)/(2*a)};
}

