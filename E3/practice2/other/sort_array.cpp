#include <array>
#include <algorithm>
#include <iostream>

class Name {
  public:
    Name(std::string last) : _last{last} { }
    std::string last() {return _last;}
  private:
    std::string _last;
};

int main() {
    std::array<Name,3> names = {Name{"Rice"}, Name{"Roscoe"}, Name{"Jones"}};
    std::sort(names.begin(), names.end(), [] (Name& lhs, Name& rhs) {return lhs.last() < rhs.last();});
    // std::sort(names.begin(), names.end());
    // std::sort(names); 
    // names.sort();
    for(auto& n : names) std::cout << n.last() << std::endl;
}
