#include "inch.h"

#include <vector>
#include <algorithm>
#include <numeric>

const std::vector<int> valid_denominators{2, 4, 8, 16, 32, 64};

Inch::Inch() : Inch(0, 0, 2) { }

Inch::Inch(int whole, int numerator, int denominator)
    : _whole{whole}, _numerator{numerator}, _denominator{denominator} {
    validate();
}
void Inch::validate() {
    // 6 discrete comparisons or a loop are all fine here!
    if(std::count(valid_denominators.begin(), valid_denominators.end(), _denominator) == 0)
        throw std::invalid_argument{"Denominator must be 2, 4, 8, 16, 32, or 64"};
    while(_numerator >= _denominator) {
        _numerator -= _denominator;
        ++_whole;
    }
    // reduce the fraction
    int gcd = std::gcd(_numerator, _denominator);
    _numerator /= gcd;
    _denominator /= gcd;
}

Inch Inch::operator+(const Inch& rhs) {
    return Inch{_whole + rhs._whole, _numerator * 64 /     _denominator
                               + rhs._numerator * 64 / rhs._denominator, 64};
}

std::string vincula = "/";
std::ostream& operator<<(std::ostream& ost, const Inch& inch) {
    if(inch._whole != 0 || (inch._whole == 0 && inch._numerator == 0)) ost << inch._whole;
    if(inch._whole != 0 && inch._numerator != 0) ost << " ";
    if(inch._numerator != 0) ost << inch._numerator << vincula << inch._denominator;
    return ost;
}
std::istream& operator>>(std::istream& ist, Inch& inch) {
    std::string s;
    inch._whole = 0;
    inch._numerator = 0;
    inch._denominator = 2;
    
    if(ist >> s) {
        if(s.find(vincula) == std::string::npos) {
            inch._whole = std::stoi(s);
            ist >> s;
        }
    }
    if(ist) {
        int vinpos = s.find(vincula);
        if(vinpos != std::string::npos) {
            inch._numerator = std::stoi(s.substr(0, vinpos));
            inch._denominator = std::stoi(s.substr(vinpos+1));
        } else {
            for (int i = s.length()-1; i >= 0; --i)
                ist.putback(s[i]);
        }
    }
    return ist;
}
int Inch::compare(const Inch& rhs) const {
    double lvalue = static_cast<double>(_numerator) / _denominator + _whole;
    double rvalue = static_cast<double>(rhs._numerator) / rhs._denominator + rhs._whole;
    return (lvalue == rvalue) ?  0
        : ((lvalue  < rvalue) ? -1 : 1);
}
