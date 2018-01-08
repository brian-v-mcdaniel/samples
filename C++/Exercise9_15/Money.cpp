#include "Money.h"
#include "..\..\std_lib_facilities.h"

namespace Mon {

	// member function definitions:

	Money::Money(string u, long m) 
		: units(u), amount(m)
	{
	}
	Money::Money(string u, int d, int c)
		: units(u), amount(d * 100 + c)
	{
	}
	Money::Money(string u, double d)
		: units(u)
	{
		d = round_to_cents(d);
		amount = long(d);
	}
	long Money::get_amount() const { return amount; }
	void Money::set_amount(long m) { amount = m; }
	string Money::get_units() const { return units; }
	void Money::set_units(string m) { units = m; }

//------------------------------------------------------------------------------
// helper functions including overloaded operators

	ostream& operator<<(ostream& os, const Money& m)
	{
		int cents = m.get_amount() % 100;
		// if cents is negative make it positive
		if (cents < 0) cents = -cents;
		int dollars = m.get_amount() / 100;
		if (cents > 9)
			return os << "$" << dollars << "." << cents;
		else
			return os << "$" << dollars << ".0" << cents;
	}

	Money operator+(const Money& a, const Money& b)
	{
		if (a.get_units() != b.get_units())
			throw exception("units do not match");
		return Money(a.get_units(), a.get_amount() + b.get_amount());
	}

	Money operator-(const Money& a, const Money& b)
	{
		if (a.get_units() != b.get_units())
			throw exception("units do not match");
		return Money(a.get_units(), a.get_amount() - b.get_amount());
	}

	Money operator*(const Money& a, const double d)
	{
		double first = double(a.get_amount()) / 100;
		first *= d;
		// round off using 4/5 rule
		return Money(a.get_units(), round_to_cents(first));
	}

	Money operator/(const Money& a, const double d)
	{
		double first = double(a.get_amount()) / 100;
		first /= d;
		// round off using 4/5 rule
		return Money(a.get_units(), round_to_cents(first));
	}

	bool operator==(const Money& a, const Money& b)
	{
		if (a.get_units() != b.get_units())
			throw exception("units do not match");
		return(a.get_amount() == b.get_amount());
	}

	long round_to_cents(double d)
	{
		// multiply by 1000
		int scratch = int(d * 1000);
		// look at last digit
		int last = scratch % 10;
		// if last digit >= 5 add 10
		if (last >= 5)
			scratch += 10;
		// divide by 10
		return long(scratch / 10);
	}
//------------------------------------------------------------------------------

} // end namespace Mon