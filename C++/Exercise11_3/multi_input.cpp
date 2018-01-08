/*
multi_input.cpp
Programming - Principles and Practice
Exercise 11.3
Brian McDaniel 2014
*/

// Write a program called multi_input.cpp that prompts the user to enter several integers in any combination 
// of octal, decimal, or hexadecimal, using the 0 and 0x base prefixes; interprets the number correctly; and 
// converts them to decimal form. Then your program should output the values in properly spaced columns like this: 
// 0x43	hexadecimal	converts to		67	decimal
// 0123	octal		converts to		83	decimal
//	 65	decimal		converts to		65	decimal

#include "..\..\std_lib_facilities.h"

void skip_junk()
{
	if (cin.fail()) {
		cin.clear();
		string junk;
		getline(cin,junk);
	}
}

int main()
{
	try {
		cout << "Multi Input\n\n";
		cout << "Enter decimal, octal starting with 0 or hex starting with 0x\n\n";

		cin.unsetf(ios::dec);
		cin.unsetf(ios::oct);
		cin.unsetf(ios::hex);
		cout << showbase;

		char in = ' ';
		vector<int> numbers;
		vector<char> bases;
		char base = ' ';
		while (true) {
			cout << "\nEnter an integer: (Q to quit) >";
			cin >> in;
			if (in == 'Q') break;
			if (in == '0') {
				char in2;
				cin >> in2;
				if (in2 == 'x') {
					base = 'h';
				}
				else if (isdigit(in2))
					base = 'o';
				else base = 'd';	// plain zero?
				cin.putback(in2);
			}
			else base = 'd';
			cin.putback(in);
			int num;
			if (cin >> num) {
				numbers.push_back(num);
				bases.push_back(base);
			}
			else {
				cerr << "not a valid integer\n";
				skip_junk();
			}
		}

		cout << endl;
		for (int i = 0; i < numbers.size(); ++i) {
			switch (bases[i]) {
			case 'h':
				cout << hex << setw(12) << numbers[i]
					<< " hexadecimal  converts to " << dec << setw(12) << numbers[i] << " decimal\n";
				break;
			case 'o':
				cout << oct << setw(12) << numbers[i]
					<< " octal        converts to " << dec << setw(12) << numbers[i] << " decimal\n";
				break;
			case 'd':
				cout << setw(12) << numbers[i];
				cout << " decimal      converts to " << dec << setw(12) << numbers[i] << " decimal\n";
				break;
			}
		}

		cout << "\n\n";
		keep_window_open("Q");
		return 0;
	}	// end try

	catch (exception& e) {
		cerr << "error: " << e.what() << "\n\n";
		keep_window_open("Q");
		return 1;
	}
	catch (...) {
		cerr << "unknown exception!\n\n";
		keep_window_open("Q");
		return 2;
	}
}	// end main