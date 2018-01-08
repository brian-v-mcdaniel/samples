/*
Programming - Principles and Practice
Exercise 8.9
Brian McDaniel 2014
*/

// Write a function that - using randint() from the previous exercise - computes 
// a pseudo-random integer in the range [a:b): rand_in_range(int a, int b). 
// Note: This function is very useful for writing simple games.

#include "..\..\std_lib_facilities.h"

int randint()
{
	// linear congruential method after Knuth, TAOCP v. 2
	// x = (a*x + c) mod m
	// These are the m, a, and c values from ANSI C.
	static const int m = 2147483648;	// the modulus, 2^31
	static const int a = 1103515245;	// the multiplier
	static const int c = 12345;	// the increment

	static int randseed = 1;

	randseed = randseed * a + c % m;
	if (randseed < 0)
		randseed = -randseed;
	return randseed;
}
 
int rand_in_range(int a,int b)
{
	int rand = randint() % (b - a);
	return rand + a;
}

int main()
{
	try {
		char in;
		cout << "Enter a key to get a random integer (q to quit): >";
		cin >> in;
		while (in != 'q') {
			if (!cin) error("bad input");
			cout << "Random integer: " << rand_in_range(0,10) << "\n\n";
			cout << "Enter a key to get a random integer from 0 to 9 (q to quit): >";
			cin >> in;
		}

		keep_window_open();
		return 0;
	}
	catch(exception& e) {
		cerr << "error: " << e.what() << "\n\n";
		keep_window_open();
		return 1;
	}
	catch (...) {
		cerr << "unknown exception!\n\n";
		keep_window_open();
		return 2;
	}
}