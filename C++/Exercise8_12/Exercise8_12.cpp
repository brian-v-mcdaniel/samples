/*
Programming - Principles and Practice
Exercise 8.12
Brian McDaniel 2014
*/

// Write a function that finds the smallest and the largest element of a 
// vector argument and also computes the mean and the median. Do not 
// use global variables. Either return a struct containing the results or pass 
// them back through reference arguments. Which of the two ways of returning 
// several result values do you prefer and why?

#include "..\..\std_lib_facilities.h"

// I prefer to use a struct because it keeps the called function and the calling function 
// from getting connected too closely. If reference arguments are used, the calling 
// function has to set up a bunch of extra things just to call the other function.

struct Results {
	double min;
	double max;
	double mean;
	double median;
	Results(double min_in, double max_in, double mean_in, double median_in) :
		min(min_in), max(max_in), mean(mean_in), median(median_in) {}
};

Results calc(const vector<double>& in)
{
	int min_index = 0;
	for(int i = 1; i < int(in.size()); ++i) {
		if (in[min_index] > in[i])
			min_index = i;
	}

	int max_index = 0;
	for(int i = 1; i < int(in.size()); ++i) {
		if (in[max_index] < in[i])
			max_index = i;
	}

	double mean = 0;
	for(int i = 0; i < int(in.size()); ++i) {
		mean += in[i];
	}
	mean /= in.size();

	double median = 0;
	vector<double> in_sort = in;
	sort(in_sort.begin(),in_sort.end());
	if (in_sort.size() % 2 == 0) {	// even, average the middle two
		median = in_sort[(in_sort.size() / 2) - 1];
		median += in_sort[in_sort.size() / 2];
		median /= 2;
	}
	else	// odd
		median = in_sort[in_sort.size()/2];

	return Results(in[min_index], in[max_index], mean, median);
}

int main()
{
	try {
		vector<double> vals;

		vals.push_back(2.4);
		vals.push_back(4.5);
		vals.push_back(5.6);
		vals.push_back(6.7);
		vals.push_back(7.8);
		vals.push_back(8.9);
		vals.push_back(234);
		vals.push_back(12);
		vals.push_back(1);
		vals.push_back(454);
		vals.push_back(70000);
		vals.push_back(0);
		vals.push_back(-234);
		vals.push_back(234.34543);
		vals.push_back(123.56);
		vals.push_back(77777);
		vals.push_back(34);
		vals.push_back(99);
		vals.push_back(0.345345);
		vals.push_back(999999);

		cout << "The values are : \n";
		for(int i = 0; i < int(vals.size()); ++i) {
			cout << vals[i] << "\t";
		}
		cout << "\n\n";

		Results res = calc(vals);
		cout << "The minimum value is " << res.min << ".\n\n";
		cout << "The maximum value is " << res.max << ".\n\n";
		cout << "The mean value is " << res.mean << ".\n\n";
		cout << "The median value is " << res.median << ".\n\n";
		keep_window_open();
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