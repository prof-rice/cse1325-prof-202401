#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <vector>
#include <complex>

class Polynomial {
  public:
    Polynomial(std::vector<double> coefficients);
    virtual ~Polynomial();
    virtual std::vector<std::complex<double>> solve() = 0;
  protected:
    std::vector<double> _coefficients;
};

#endif
