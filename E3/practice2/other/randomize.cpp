#include <iostream>

class Secret { };

template<class T>
void randomize(T object, int seed) { }

int main() {
  Secret secret;
  randomize(secret, 42);
  randomize<Secret>(secret, 36);

}
