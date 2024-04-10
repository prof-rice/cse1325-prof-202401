#ifndef __LINEAR_H
#define __LINEAR_H

#include "polynomial.h"

class Linear : public Polynomial {
  public:
    Linear(std::vector<double> coefficients);
    std::vector<double> solve() override;
};
#endif
