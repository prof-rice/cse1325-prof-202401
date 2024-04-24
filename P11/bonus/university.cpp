#include "university.h"

University::University(std::string name, int enrollment)
    : _name{name}, _enrollment{enrollment} {
    validate();
}
std::string University::name() const {return _name;}
int University::enrollment() const {return _enrollment;}

std::istream& operator>>(std::istream& ist, University& u) {
    std::getline(ist, u._name);
    ist >> u._enrollment;
    ist.ignore();
    if(ist) u.validate();
    return ist;
}

std::ostream& operator<<(std::ostream& ost, const University& u) {
    return ost << u.name() << " has an enrollment of " 
               << u.enrollment();
}

void University::validate() {
    if(_enrollment < 0)
        throw std::invalid_argument{"University enrollment cannot be negative"};
    if(_enrollment > 0 && _name.empty())
        throw std::invalid_argument{"University cannot be anonymous"};
}
