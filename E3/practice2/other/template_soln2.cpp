 #include <iostream>
 #include <thread>
 #include <chrono>
 #include <ctime>

 template<class T>
 class Ticker {
  public:
    Ticker(T text, int x=60) : _text{text}, _x{x} { }
    bool tic() {
        std::cout << std::string(_x--, ' ') << _text << " \r"; std::cout.flush();
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
        return (_x > 0);
    }
  private:
    T _text;  // String to be scrolled across terminal
    int _x;   // Number of spaces until first char of _text
 };

 int main() {
    Ticker<double> t{3.14159};
    while(t.tic());
 }

