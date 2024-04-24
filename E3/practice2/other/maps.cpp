#include <map>
#include <iostream>
#include <algorithm>

std::ostream& operator<<(std::ostream& ost, const std::pair<double, std::string>& pair) {
    ost << pair.first << ' ' << pair.second;
    return ost;
}

int main() {
    std::map<double, std::string> m = {{0, "Jon"}, {3.14, "Garfield"}, {2.17, "Odie"}};
    std::cout << *(std::find_if(m.begin(), m.end(), [] (auto it) {return it.second == "Garfield";}));
    std::cout << std::endl;
    // for(auto& [code, name] : m) if(name == "Garfield") std::cout << code << ' ' << name;
    for(auto& it : m) if(it.second == std::string{"Garfield"}) std::cout << it.first << ' ' << it.second;
    std::cout << std::endl;
    // for(auto it=m.begin(); it!=m.end(); ++it) if(it->second == std::string{"Garfield"}) std::cout << *it;
    for(auto it=m.begin(); it!=m.end(); ++it) if(it->second == "Garfield") std::cout << *it;
    std::cout << std::endl;
    for(auto& p : m) if(p.second == "Garfield") std::cout << p;
    std::cout << std::endl;

}
