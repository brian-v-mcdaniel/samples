#include "Rational.h"
#include "..\..\std_lib_facilities.h"

namespace Rat {

// member function definitions:

	Rational::Rational(int n, int d) 
		: numer(n), denom(d)
	{
		// denominator of 0 is undefined
		if (denom==0) throw Undefined();
	}
	int Rational::get_numer() const { return numer; }
	int Rational::get_denom() const { return denom; }
	void Rational::set_numer(int n)
	{
		numer = n;
	}
	void Rational::set_denom(int d)
	{
		// denominator of 0 is undefined
		if (d==0) throw Undefined();
		denom = d;
	}

	double Rational::to_double()
	{
		return double(numer) / double(denom);
	}

//------------------------------------------------------------------------------
// helper functions including overloaded operators

	ostream& operator<<(ostream& os, const Rational& r)
	{
		return os << '[' << r.get_numer() 
			<< "/" << r.get_denom() << ']';
	}

	Rational operator+(const Rational& a, const Rational& b)
	{
		Rational r1(1,1);
		Rational r2(1,1);
		Rational r3(1,1);
		r1.set_numer(a.get_numer() * b.get_denom());
		r1.set_denom(a.get_denom() * b.get_denom());
		r2.set_numer(b.get_numer() * a.get_denom());
		r2.set_denom(b.get_denom() * a.get_denom());
		r3.set_numer(r1.get_numer() + r2.get_numer());
		r3.set_denom(r1.get_denom());
		return r3;
	}

	Rational operator-(const Rational& a, const Rational& b)
	{
		Rational c(-b.get_numer(), b.get_denom());
		return (a + c);
	}

	Rational operator*(const Rational& a, const Rational& b)
	{
		Rational r1(0,1);
		r1.set_numer(a.get_numer() * b.get_numer());
		r1.set_denom(a.get_denom() * b.get_denom());
		return r1;
	}

	Rational operator/(const Rational& a, const Rational& b)
	{
		Rational c(b.get_denom(), b.get_numer());
		return (a * c);
	}

	bool operator==(const Rational& a, const Rational& b)
	{
		return(a.get_numer() == b.get_numer() &&
			a.get_denom() == b.get_denom());
	}

//------------------------------------------------------------------------------

} // end namespace Rat