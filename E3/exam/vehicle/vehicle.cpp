#include <iostream>
#include <sstream>

 class Vehicle {
   public:
     Vehicle(int year, std::string make, std::string model);
     Vehicle(Vehicle& v);
     Vehicle operator=(const Vehicle& v);
     virtual ~Vehicle();
     friend std::ostream& operator<<(std::ostream& ost, const Vehicle& v);
   private:
     int _year;
     std::string  _make;
     std::string  _model;
     std::string* _log;
 };
 
 // Question a
 Vehicle::Vehicle(int year, std::string make, std::string model)
       : _year{year}, _make{make}, _model{model},
         _log{new std::string[256]} { }
 
 // Question b
 Vehicle::~Vehicle() {
    delete[] _log;
 }
 
 // Question c - Rule of 3
 
 // Question d
 std::ostream& operator<<(std::ostream& ost, const Vehicle& v) {
    return ost << v._year << ' ' << v._make << ' ' << v._model;
 }
 
 // Question e
 std::string to_string(const Vehicle& v) {
    std::ostringstream oss;
    oss << v;
    return oss.str();
 }
 
 // Question f
 class Truck : public Vehicle { // f ends here
   public:
     Truck(int year, std::string make, std::string model);
 };

 // Question g
 Truck::Truck(int year, std::string make, std::string model)
      : Vehicle(year, make, model) { }
 
 int main() {
     Vehicle v{1964, "Ford", "Mustang"};
     std::cout << to_string(v) << std::endl;
     Truck t{2021, "Ford", "F-150"};
     std::cout << to_string(t) << std::endl;
 }


