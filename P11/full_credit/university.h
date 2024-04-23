#ifndef __UNIVERSITY_H
#define __UNIVERSITY_H

#include <iostream>
#include <stdexcept>

class University {
  public:
    University(std::string name = "", int enrollment = 0);
    std::string name() const;
    int enrollment() const;
    friend std::istream& operator>>(std::istream& ist, University& u);
    friend std::ostream& operator<<(std::ostream& ost, const University& u);
  private:
    std::string _name;
    int _enrollment;
    void validate();
};

#endif
