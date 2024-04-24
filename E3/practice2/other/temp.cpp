#include <iostream>

class Foo {
  public:
    const void* get_raw();
    inline virtual std::string to_string() {return "Base";}
    virtual Foo* clone() = 0;
    const virtual int num_items();
};

class Bar : public Foo {
  public:
    //const void* get_raw() override;
    inline std::string to_string() override {return "Derived";}
    Foo* clone() override;
    const int num_items() override;
};
 
