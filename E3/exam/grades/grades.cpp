#include <map>
#include <iostream>
#include <fstream>

int main(int argc, char* argv[]) {
    std::map<std::string, double> grades;
    std::ifstream ifs{std::string{argv[1]}};
    if(!ifs) std::cerr << "Invalid filename: " << argv[1] << std::endl;
    std::string s; 
    double d;
    while(ifs >> d) {
        std::getline(ifs, s);
        grades[s] = d;
    }
    for(auto& [name, grade] : grades) 
        std::cout << name << " " << grade << std::endl;
}
