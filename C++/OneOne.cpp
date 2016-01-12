#include <iostream>
#include <vector>

using namespace std;

/*
  Write an algorithm to determine if a string has all unique
  characters. What if you cannot use any additional data
  structures?
*/

int checkVector(vector<char> input);

int main()
{

  cout << "Input a word:" << endl;
  
  bool letters[128];
  
  vector<char> input;
  char c;
  
  while(cin >> c) {
    if(c == '\n') break;
    input.push_back(c);
  }
  
  return checkVector(input);
}

int checkVector(vector<char> input)
{
  // Set default to false.
  bool letters[128] = { false };
  
  for(int i=0;i<input.size();i++) {
    if(letters[input.at(i)]) {
      cout << input.at(i) << endl;
      cout << letters[input.at(i)] << endl;
      cout << "Word failed test" << endl;
      return 1;
    }
    
    // We've encountered this letter now.
    letters[input.at(i)] = true;
    
    // cout << "(" << input.at(i) << ", " << letters[input.at(i)] << ")" << endl;
  }
  
  cout << "Word has unique characters!" << endl;
  
  return 0;
}
