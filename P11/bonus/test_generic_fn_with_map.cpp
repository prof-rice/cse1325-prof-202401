#include <map>
#include <iostream>

// Define operator << for std::pair
//   (Why doesn't the STL do this? No idea.)
template<class T, class U>
std::ostream& operator<<(std::ostream& ost, const std::pair<T,U>& p) {
    return ost << "[" << p.first << "," << p.second << "]";
}

// Here's the generic function from the P11 bonus
template<class T> 
void print_container(T t) {
    typename T::iterator it = t.begin();
    while(it != t.end()) {
        std::cout << *it << std::endl;
        ++it;
    }
}

// And here's a simple test case
int main (int argc, char const* argv[]) {
    std::map<std::string, double> m {
        {"Pi", 3.14},
        {"e", 2.718},
    };
    print_container(m);
}
