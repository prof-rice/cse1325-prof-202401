#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <vector>

class Polynomial {
  public:
    Polynomial(std::vector<double> coefficients);
    virtual ~Polynomial();
    virtual std::vector<double> solve() = 0;
  protected:
    std::vector<double> _coefficients;
};

#endif
