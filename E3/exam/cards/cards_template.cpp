#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

enum class Suit {S,H,D,C};
std::map<Suit, std::string> suit_to_char {
  {Suit::S,"♠"}, {Suit::H,"♥"}, {Suit::D,"♦"}, {Suit::C,"♣"}
};

std::ostream& operator<<(std::ostream& ost, const Suit& suit) {
    return ost << suit_to_char[suit];
}

class Card {
  public:
    Card(int rank, Suit suit);
    friend std::ostream& operator<<(std::ostream& ost, const Card& card);
  private:
    int _rank;
    Suit _suit;
};

Card::Card(int rank, Suit suit) 
  : _rank{rank}, _suit{suit} { }

std::map<int, std::string> rank_to_char {
  {1,"A"}, {2,"⒉"}, {3,"⒊"}, {4,"⒋"}, {5,"⒌"}, {6,"⒍"}, {7,"⒎"}, 
  {8,"⒏"}, {9,"⒐"}, {10,"⒑"}, {11,"J"}, {12,"Q"}, {13,"K"}
};


std::ostream& operator<<(std::ostream& ost, const Card& card) {
    return ost << rank_to_char[card._rank] << card._suit;
}

template<class T>
class Deck {
  public:
    void add_card(T card);
    void shuffle();
    T deal();
    bool empty();
  private:
    std::vector<T> _deck;
};

template<class T>
void Deck<T>::add_card(T card) {
    _deck.push_back(card);
}

template<class T>
void Deck<T>::shuffle() {
    std::random_shuffle(_deck.begin(), _deck.end());
}

template<class T>
T Deck<T>::deal() {
    T card = _deck.back();
    _deck.pop_back();
    return card;
}

template<class T>
bool Deck<T>::empty() {
    return _deck.empty();
}

int main() {
    Deck<Card> deck;
    deck.add_card(Card{ 1, Suit::S});
    deck.add_card(Card{ 6, Suit::H});
    deck.add_card(Card{10, Suit::D});
    deck.add_card(Card{13, Suit::C});
    deck.shuffle();
    while(!deck.empty()) std::cout << deck.deal() << ' ';
    std::cout << std::endl;
}
