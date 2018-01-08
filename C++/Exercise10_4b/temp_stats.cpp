/*
Programming - Principles and Practice
Exercise 10.4b
Brian McDaniel 2014
*/

// Modify the store_temps.cpp program from exercise 2 to include a 
// temperature suffix c for Celsius or f for Fahrenheit temperatures. Then 
// modify the temp_stats.cpp program to test each temperature, converting the 
// Celsius readings to Fahrenheit before putting them into the vector.

#include "..\..\std_lib_facilities.h"

struct Reading {
	int hour;	// hour after midnight
	double temperature;
	char scale;  // must be either c or f
	Reading(int h, double t, char s):hour(h), temperature(t), scale(s) {}
};

istream& operator>>(istream& is, Reading& r)
{
	// format: (hour, temp)
	char ch;
	is >> ch;
	if (ch != '(') {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	if (!(is >> r.hour)) {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	is >> ch;
	if (ch != ',') {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	if (!(is >> r.temperature)) {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	is >> ch;
	if (ch != ',') {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	is >> ch;
	if (ch != 'C' && ch != 'c' && ch != 'F' && ch != 'f') {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	r.scale = ch;
	is >> ch;
	if (ch != ')') {
		is.unget();
		is.clear(ios::failbit);
		return is;
	}
	return is;
}

int main()
{
	class Not_number {};
	try {
		string iname("raw_temps.txt");
		ifstream ifs(iname.c_str());
		if (!ifs) error("can't open input file ", iname);

		ifs.exceptions(ifs.exceptions()|ios_base::badbit);	// throw if bad()

		Vector<Reading> in;
		while(true) {
			Reading r(0,0,' ');
			if (!(ifs >> r)) break;
			// convert Celsius to Fahrenheit
			if (r.scale == 'C' || r.scale == 'c') {
				r.temperature = r.temperature * 1.8 + 32;
				r.scale = 'F';
			}
			in.push_back(r);
		}

		cout << "read " << in.size() << " total readings\n";

		// calculate mean and median temperatures
		Vector<double> temps;
		for (int i = 0; i < int(in.size()); ++i) {
			temps.push_back(in[i].temperature);
		}
		double sum = 0;
		for (int i = 0; i < int(temps.size()); ++i) sum += temps[i];
		if (temps.size() >= 1) {
			cout << "Mean temperature: " << sum / temps.size() << endl;
			sort(temps.begin(),temps.end());
			cout << "Median temperature: " << temps[temps.size()/2] << endl;
		}

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