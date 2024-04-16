#include "inch.h"

#include <iostream>
#include <sstream>

int main (int argc, char const* argv[]) {
    int vector = 1;
    int result = 0;
    std::ostringstream oss;
    std::string actual;
    std::string expected;
    
    Inch in0{0, 0, 2};
    Inch in1{1, 3, 8};
    Inch in2{2, 2, 8};
    Inch in3{2, 5, 8};
    Inch in4{0, 1, 64};
    Inch in5{1, 0, 2};
    Inch in3_2{2, 5, 8};
    Inch in4_2{0, 1, 64};
    Inch in5_2{1, 0, 2};
    
    // Basic output
    {
        oss.str("");
        oss << in0 << ", " << in4 << ", " << in5 << ", " << in2;
        actual = oss.str();
        expected = "0, 1/64, 1, 2 1/4";
        if(expected != actual) {
            std::cerr << "ERROR: output formatting failed\n"
                      << "  Expected: \"" << expected << "\"\n"
                      << "  Actual:   \"" << actual << "\"\n";
            result |= vector;
        }
    }
    vector << 1;
    
    // Comparison operators
    {
        // !=
        if(in3 != in3_2) {
            std::cerr << "ERROR: equal inches reported as not equal\n"
                      << "  " << in3 << " !=? " << in3_2;
            result |= vector;
        }
        if(in4 != in4_2) {
            std::cerr << "ERROR: equal inches reported as not equal\n"
                      << "  " << in4 << " !=? " << in4_2;
            result |= vector;
        }
        if(in5 != in5_2) {
            std::cerr << "ERROR: equal inches reported as not equal\n"
                      << "  " << in5 << " !=? " << in5_2;
            result |= vector;
        }
        // ==
        if(in3 == in4 || in4 == in5 || in3 == in5) {
            std::cerr << "ERROR: Unequal inches reported as equal\n"
                      << "  " << in3 << " ==? " << in4 << " ==? " << in5;
            result |= vector;
        }
        // <
        if(!(in4 < in3) || !(in4 < in5) || !(in5 < in3)) {
            std::cerr << "ERROR: Less than inches reported as not\n"
                      << "  " << in4 << " <? " << in3 << "\n"
                      << "  " << in4 << " <? " << in5 << "\n"
                      << "  " << in5 << " <? " << in3 << "\n";
            result |= vector;
        }
        // <=
        if(!(in4 <= in3) || !(in4 <= in5) || !(in5 < in3) ||
           !(in3 <= in3) || !(in3 <= in3_2) ||
           !(in4 <= in4) || !(in4 <= in4_2) ||
           !(in5 <= in5) || !(in5 <= in5_2)) {
            std::cerr << "ERROR: Less than or equals inches reported as not\n"
                      << "  " << in4 << " <=? " << in3 << "\n"
                      << "  " << in4 << " <=? " << in5 << "\n"
                      << "  " << in5 << " <=? " << in3 << "\n"
                      << "  " << in3 << " <=? " << in3 << "\n"
                      << "  " << in3 << " <=? " << in3_2 << "\n"
                      << "  " << in4 << " <=? " << in4 << "\n"
                      << "  " << in4 << " <=? " << in4_2 << "\n"
                      << "  " << in5 << " <=? " << in5 << "\n"
                      << "  " << in5 << " <=? " << in5_2 << "\n";
            result |= vector;
        }
        // >
        if(!(in3 > in4) || !(in5 > in4) || !(in3 > in5)) {
            std::cerr << "ERROR: Greater than inches reported as not\n"
                      << "  " << in3 << " >? " << in4 << "\n"
                      << "  " << in5 << " >? " << in4 << "\n"
                      << "  " << in3 << " >? " << in5 << "\n";
            result |= vector;
        }
        // >=
        if(!(in3 >= in4) || !(in5 >= in4) || !(in3 >= in5) ||
           !(in3 >= in3) || !(in3 >= in3_2) ||
           !(in4 >= in4) || !(in4 >= in4_2) ||
           !(in5 >= in5) || !(in5 >= in5_2)) {
            std::cerr << "ERROR: Greater than or equals inches reported as not\n"
                      << "  " << in4 << " >=? " << in3 << "\n"
                      << "  " << in4 << " >=? " << in5 << "\n"
                      << "  " << in5 << " >=? " << in3 << "\n"
                      << "  " << in3 << " >=? " << in3 << "\n"
                      << "  " << in3 << " >=? " << in3_2 << "\n"
                      << "  " << in4 << " >=? " << in4 << "\n"
                      << "  " << in4 << " >=? " << in4_2 << "\n"
                      << "  " << in5 << " >=? " << in5 << "\n"
                      << "  " << in5 << " >=? " << in5_2 << "\n";
            result |= vector;
        }
    }
    vector << 1;

    // Basic input
    {
        std::istringstream iss3{"2 5/8"};
        Inch inn3; iss3 >> inn3;
        if(in3 != inn3) {
            std::cerr << "ERROR: failed to read inches\n"
                      << "  Expected: \"" << in3 << "\"\n"
                      << "  Actual:   \"" << inn3 << "\"\n";
            result |= vector;
        }
        
        std::istringstream iss4{"1/64"};
        Inch inn4; iss4 >> inn4;
        if(in4 != inn4) {
            std::cerr << "ERROR: failed to read inches\n"
                      << "  Expected: \"" << in4 << "\"\n"
                      << "  Actual:   \"" << inn4 << "\"\n";
            result |= vector;
        }
        
        std::istringstream iss5{"1"};
        Inch inn5; iss5 >> inn5;
        if(in5 != inn5) {
            std::cerr << "ERROR: failed to read inches\n"
                      << "  Expected: \"" << in5 << "\"\n"
                      << "  Actual:   \"" << inn5 << "\"\n";
            result |= vector;
        }
    }
    vector << 1;

    // Basic addition
    {
        oss.str("");
        oss << in1 << " + " << in2 << " = " << (in1 + in2);
        actual = oss.str();
        expected = "1 3/8 + 2 1/4 = 3 5/8";
        if(expected != actual) {
            std::cerr << "ERROR: failed to add inches\n"
                      << "  Expected: \"" << expected << "\"\n"
                      << "  Actual:   \"" << actual << "\"\n";
            result |= vector;
        }
        
        oss.str("");
        oss << in1 << " + " << in3 << " = " << (in1 + in3);
        actual = oss.str();
        expected = "1 3/8 + 2 5/8 = 4";
        if(expected != actual) {
            std::cerr << "ERROR: failed to add inches\n"
                      << "  Expected: \"" << expected << "\"\n"
                      << "  Actual:   \"" << actual << "\"\n";
            result |= vector;
        }
        
        oss.str("");
        oss << in1 << " + " << in4 << " = " << (in1 + in4);
        actual = oss.str();
        expected = "1 3/8 + 1/64 = 1 25/64";
        if(expected != actual) {
            std::cerr << "ERROR: failed to add inches\n"
                      << "  Expected: \"" << expected << "\"\n"
                      << "  Actual:   \"" << actual << "\"\n";
            result |= vector;
        }
    }
    vector << 1;
    
    return result;
}
