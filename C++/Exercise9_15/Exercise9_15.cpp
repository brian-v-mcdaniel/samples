/*
Programming - Principles and Practice
Exercise 9.15
Brian McDaniel 2014
*/

// Refine the Money class by adding a currency (given as a constructor 
// argument). Accept a floating-point initializer as long as it can be exactly 
// represented as a long. Don't accept illegal operations. For example, 
// Money*Money doesn't make sence, and USD1.23+DKK5.00 makes sense 
// only if you provide a conversion table defining the conversion factor 
// between U.S. dollars (USD) and Danish kroner (DKK).

#include "..\..\std_lib_facilities.h"
#include "Money.h"

int main()
{
	class Not_number {};
	try {
		using namespace Mon;

		// get first amount
		string in_1 = "";
		cout << "Enter a currency unit: >";
		cin >> in_1;
		int in_2 = 0;
		cout << "Enter a dollar amount: >";
		cin >> in_2;
		if(!cin)
			throw Not_number();
		int in_3 = 0;
		cout << "Enter a cents amount: >";
		cin >> in_3;
		if(!cin)
			throw Not_number();
		// test constructor
		Money m1(in_1, in_2, in_3);
		// test get_amount
		// test set_amount()
		// get second amount
		string in_4 = "";
		cout << "Enter a currency unit: >";
		cin >> in_4;
		int in_5 = 0;
		cout << "Enter a dollar amount: >";
		cin >> in_5;
		if(!cin)
			throw Not_number();
		int in_6 = 0;
		cout << "Enter a cents amount: >";
		cin >> in_6;
		if(!cin)
			throw Not_number();
		Money m2(in_4, in_5, in_6);
		// test addition
		Money m3 = m1 + m2;
		cout << "\n" << m1 << " + "	<< m2 
			<< " = " << m3 << "\n\n";
		// test subtraction
		Money m4 = m1 - m2;
		cout << "\n" << m1 << " - " << m2 
			<< " = " << m4 << "\n\n";
		// test multiplication
		Money m5 = m1 * 2.5;
		cout << "\n" << m1 << " * " << "2.5" 
			<< " = " << m5 << "\n\n";
		// test division
		Money m6 = m1 / 2.5;
		cout << "\n" << m1 << " / "	<< "2.5" 
			<< " = " << m6 << "\n\n";
		// test equality
		string eq_or_not;
		if (m1 == m2) 
			eq_or_not = " equals ";
		else
			eq_or_not = " does NOT equal ";
		cout << "\n" << m1 << eq_or_not << m2 << "\n\n";

		// test assignment
		Money m9 = m1;

		cout << "\nm9 is " << m9 << "\n";
		m9.set_amount(567);
		cout << "\nNow m9 is " << m9 << "\n";
		cout << "\nm1 is " << m1 << "\n";

		cout << "\n";
		cout << "\n";

		keep_window_open();
		return 0;
	}
	catch(Not_number) {
		cerr << "\nerror: Not a valid number\n"; 
		keep_window_open("Q");
		return 1;
	}
	catch(exception& e) {
		cerr << "\nerror: " << e.what() << "\n\n";
		keep_window_open("Q");
		return 1;
	}
	catch (...) {
		cerr << "\nunknown exception!\n\n";
		keep_window_open("Q");
		return 2;
	}
}