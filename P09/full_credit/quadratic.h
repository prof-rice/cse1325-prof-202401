#ifndef __QUADRATIC_H
#define __QUADRATIC_H

#include "polynomial.h"

class Quadratic : public Polynomial {
  public:
    Quadratic(std::vector<double> coefficients);
    std::vector<double> solve() override;
};
#endif
