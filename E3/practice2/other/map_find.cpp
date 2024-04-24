#include <map>
#include <iostream>

int main() {
    enum class Color{RED, WHITE, BLUE};
    Color color = Color::WHITE;
    std::map<Color, std::string> ctos = {{Color::RED, "red"}, {Color::WHITE, "white"}, {Color::BLUE, "blue"}};
    std::cout << ctos.find(color)->second << std::endl;
}
