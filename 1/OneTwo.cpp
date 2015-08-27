/*
Problem 1.2 - Cracking the Coding Interview

Implement a function void reverse(char* str) in C or C++ which reverse a null-
terminated string.

James Earle - August 26, 2015
*/

#include <string> 
#include <iostream> 
using namespace std; 
void reverse(char*); 

int main() 
{
	//100 Characters seems like enough.
 	char str[101];
 	cin >> str;
 	reverse(str); 

 	return 0; 
}

void reverse(char* str) 
{ 
	cout << str;
} 
