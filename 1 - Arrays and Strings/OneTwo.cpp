/*
Problem 1.2 - Cracking the Coding Interview

Implement a function void reverse(char* str) in C or C++ which reverse a null-
terminated string.

James Earle - August 26, 2015
*/

#include <string.h> 
#include <iostream> 
using namespace std; 
void reverse(char*); 

int main() 
{
	cout << "Enter a string: ";

	//100 Characters seems like enough.
 	char str[101];

 	//Gets user input into char array, while getline(cin, str_name) gets for string type
 	cin.getline(str,101);

 	int size = strlen(str);
 	cout << size << endl;

 	reverse(str); 
 	cout << str << endl;

 	return 0; 
}

void reverse(char* str) 
{ 	
	char* start = str;
	char* end = start + strlen(str) - 1;
	
	while(end > start) {
		char temp = *end;
		*end = *start;
		*start = temp;
		start++;
		end--;
	}
} 
