#include <algorithm>
#include <array>
#include <iostream>

int main() {
  std::array<double, 10> arr = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
  std::transform(arr.begin(), arr.end(), arr.begin(), [] (double& d) {return sqrt(d);});
  for(auto d : arr) std::cout << d << ' ';
  std::cout << std::endl;
}
