/*
Programming - Principles and Practice
Exercise 9.13
Brian McDaniel 2014
*/

// Design and implement a rational number class, Rational. A rational 
// number has two parts: a numerator and a denominator, for example, 5/6 
// (five-sixths, also known as approximately .83333). Look up the 
// definition if you need to. Provide assignment, addition, subtraction, 
// multiplication, division, and equality operators. Also, provide a 
// conversion to double. Why would people want to use a Rational class?

#include "..\..\std_lib_facilities.h"
#include "Rational.h"

int main()
{
	class Not_number {};
	try {
		using namespace Rat;

		// get first rational number
		int in_1 = 0;
		int in_2 = 0;
		cout << "Enter an integer: >";
		cin >> in_1;
		if(!cin)
			throw Not_number();
		cout << "Enter another integer: >";
		cin >> in_2;
		if(!cin)
			throw Not_number();

		// test constructor
		Rational r1(in_1, in_2);
		// test get_numer() and get_denom()
		cout << "\nr1 is " << r1 << "\n";
		// test set_numer() and set_denom()
		r1.set_numer(7);
		r1.set_denom(8);
		cout << "\nr1 is now " << r1 << "\n";
		r1.set_numer(in_1);
		r1.set_denom(in_2);
		cout << "\nr1 is now " << r1 << "\n";
		// get second rational number
		int in_3 = 0;
		int in_4 = 0;
		cout << "Enter an integer: >";
		cin >> in_3;
		if(!cin)
			throw Not_number();
		cout << "Enter another integer: >";
		cin >> in_4;
		if(!cin)
			throw Not_number();
		// test addition
		Rational r2(in_3, in_4);
		Rational r3 = r1 + r2;
		cout << "\n" << r1 << " + "	<< r2 
			<< " = " << r3 << "\n\n";
		// test subtraction
		Rational r4 = r1 - r2;
		cout << "\n" << r1 << " - " << r2 
			<< " = " << r4 << "\n\n";
		// test multiplication
		Rational r5 = r1 * r2;
		cout << "\n" << r1 << " * " << r2 
			<< " = " << r5 << "\n\n";
		// test division
		Rational r6 = r1 / r2;
		cout << "\n" << r1 << " / "	<< r2 
			<< " = " << r6 << "\n\n";
		// test equality
		string eq_or_not;
		if (r1 == r2) 
			eq_or_not = " equals ";
		else
			eq_or_not = " does NOT equal ";
		cout << "\n" << r1 << eq_or_not << r2 << "\n\n";
		// test conversion to double
		double d = 0;
		d = r1.to_double();
		cout << "r1 is " << r1 << "\n\n";
		cout.precision(50);
		cout << "r1 as a double is " << d << "\n\n";

		// test assignment
		Rational r9 = r1;

		cout << "\nr9 is " << r9 << "\n";
		r9.set_numer(5);
		cout << "\nNow r9 is " << r9 << "\n";
		cout << "\nr1 is " << r1 << "\n";

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
	catch(Rat::Rational::Undefined) {
		cerr << "\nerror: denominator 0 is undefined\n"; 
		keep_window_open("Q");
		return 1;
	}
	catch(exception& e) {
		cerr << "error: " << e.what() << "\n\n";
		keep_window_open("Q");
		return 1;
	}
	catch (...) {
		cerr << "unknown exception!\n\n";
		keep_window_open("Q");
		return 2;
	}
}