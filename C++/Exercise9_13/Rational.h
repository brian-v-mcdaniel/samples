/*
Programming - Principles and Practice
Rational.h
Brian McDaniel 2014
*/

#include <iostream>

using namespace std;

//------------------------------------------------------------------------------

namespace Rat {

	//------------------------------------------------------------------------------

	class Rational {
	public:
		class Undefined {}; // empty class to throw as exception

		Rational(int n, int d);       // check for valid params and initialize
		Rational();                   // default constructor
		int get_numer() const;
		int get_denom() const;
		void set_numer(int);
		void set_denom(int);
		double to_double();
		// The following line allows implicit conversion from Rational to double.
		// However, I got it from the internet and 
		// use of implicit conversion operators is discouraged.
		// operator const double() const{ return double(numer)/double(denom); }
	private:
		int numer;	// numerator
		int denom;	// denominator
	};	// end class Rational

	//------------------------------------------------------------------------------

	//------------------------------------------------------------------------------
	ostream& operator<<(ostream& os, const Rational& r);
	Rational operator+(const Rational& a, const Rational& b);
	Rational operator-(const Rational& a, const Rational& b);
	Rational operator*(const Rational& a, const Rational& b);
	Rational operator/(const Rational& a, const Rational& b);
	bool operator==(const Rational& a, const Rational& b);

	//------------------------------------------------------------------------------

}	// end namespace Rat