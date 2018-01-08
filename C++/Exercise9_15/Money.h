/*
Programming - Principles and Practice
Money.h
Brian McDaniel 2013
*/

#include <iostream>

using namespace std;

//------------------------------------------------------------------------------

namespace Mon {

	//------------------------------------------------------------------------------

	class Money {
	public:
		Money(string u, long m);   // check for valid params and initialize
		Money(string u, int d, int c);
		Money(string u, double d);	// allow double as initializer 
		Money();                   // default constructor
		long get_amount() const;
		void set_amount(long m);
		string get_units() const;
		void set_units(string m);
	private:
		string units;
		long amount;
	};	// end class Money

	//------------------------------------------------------------------------------

	//------------------------------------------------------------------------------
	ostream& operator<<(ostream& os, const Money& r);
	Money operator+(const Money& a, const Money& b);
	Money operator-(const Money& a, const Money& b);
	Money operator*(const Money& a, const double d);
	Money operator/(const Money& a, const double d);
	bool operator==(const Money& a, const Money& b);

	long round_to_cents(double d);
	//------------------------------------------------------------------------------

}	// end namespace Mon