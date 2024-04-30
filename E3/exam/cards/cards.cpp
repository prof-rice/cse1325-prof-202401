#include <iostream>
#include <vector>
#include <algorithm>

class Deck {
  public:
    void add_card(int card);
    void shuffle();
    int deal();
    bool empty();
  private:
    std::vector<int> _deck;
};

void Deck::add_card(int card) {
    // This code did nothing - no idea why not
    
    //int count = std::count(_deck.begin(), _deck.end(), card);
    //std::cerr << "count = " << count << std::endl;
    //if(card < 0 || 13 < card || count > 0) {
    //    std::cerr << "Invalid card: " << card << std::endl;
    //    throw std::invalid_argument{"Card already exists: " + card};
    //}
    _deck.push_back(card);
}

void Deck::shuffle() {
    std::random_shuffle(_deck.begin(), _deck.end());
}

int Deck::deal() {
    int card = _deck.back();
    _deck.pop_back();
    return card;
}

bool Deck::empty() {
    return _deck.empty();
}

int main() {
    Deck deck;
    for(int i=0; i<10; ++i) deck.add_card(i);
    deck.shuffle();
    while(!deck.empty()) std::cout << deck.deal() << ' ';
    std::cout << std::endl;
    /*
    try {
        deck.add_card(5);
        std::cerr << "No exception on duplicate card!" << std::endl;
    } catch(std::invalid_argument e) {
        std::cerr << e.what() << std::endl;
    }
    try {
        deck.add_card(-5);
        std::cerr << "No exception on out of range card!" << std::endl;
    } catch(std::invalid_argument e) {
        std::cerr << e.what() << std::endl;
    }
    */
}
