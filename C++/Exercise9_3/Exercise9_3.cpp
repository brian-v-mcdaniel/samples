/*
Programming - Principles and Practice
Exercise 9.3
Brian McDaniel 2014
*/

// Replace Name_pair::print() with a (global) operator<< and define == 
// and != for Name_pairs.

#include "..\..\std_lib_facilities.h"


class Name_pairs {
public:
	void read_names();
	void read_ages();
	void sort_pairs();
	const vector<string>& name_list() {return name;}
	const vector<double>& age_list() {return age;}
private:
	vector<string> name;
	vector<double> age;
};

void Name_pairs::read_names()
{
	string input = "";

	cout << "Enter name (enter quit to quit): >";
	cin >> input;
	while (input != "quit") {
		name.push_back(input);
		cout << "Enter name (enter quit to quit): >";
		cin >> input;
	}
}

void Name_pairs::read_ages()
{
	int input = 0;

	for (int i = 0; i < int(name.size()); i++) {
		cout << "Enter age for " << name[i] << ": >";
		cin >> input;
		if (!cin)
			error("Not a number");
		age.push_back(input);
	}
}

void Name_pairs::sort_pairs()
{
	vector<string> name_old = name;

	sort(name.begin(),name.end());

	vector<double> sorted_age;

	// for each name in name_sort
	for (int i=0; i < int(name.size()); i++) {
		// find the name in name_old
		int j = 0;
		while(j < int(name_old.size()) && name[i] != name_old[j])
			j++;
		if (name[i] == name_old[j]) {
			// get that element from age and push it into sorted_age
			sorted_age.push_back(age[j]);
			name_old[j] = "~+~+DO NOT USE DO NOT USE~+~+";
		}
	}
	age = sorted_age;
}

ostream& operator<<(ostream& os, Name_pairs& n)
{
	os << "NAMES AND AGES:" << endl << endl;
	vector<string>nl = n.name_list();
	vector<double>al = n.age_list();
	for (int i = 0; i < int(nl.size()); i++) {
		os << nl[i];
		os << "\t";
		os << al[i];
		os << endl;
	}
	return os;
}

bool operator==(Name_pairs& np_a, Name_pairs& np_b)
{
	vector<string>nl_a = np_a.name_list();
	vector<double>al_a = np_a.age_list();
	vector<string>nl_b = np_b.name_list();
	vector<double>al_b = np_b.age_list();

	if (nl_a.size() != nl_b.size())
		return false;
	if (al_a.size() != al_b.size())
		return false;

	// compare names
	for (int i = 0; i < int(nl_a.size()); i++) {
		if(nl_a[i] != nl_b[i]) {
			return false;
		}
	}

	// compare ages
	for (int i = 0; i < int(al_a.size()); i++) {
		if(al_a[i] == al_b[i]) {
			return false;
		}
	}

	return true;
}

bool operator!=(Name_pairs& np_a, Name_pairs& np_b)
{
	return !(np_a==np_b);
}

int main()
{
	try {
		Name_pairs test;
		
		cout << "TEST:\n";
		test.read_names();

		cout << "\n";

		Name_pairs test2;

		cout << "TEST2:\n";
		test2.read_names();

		cout << "\n";

		cout << "TEST:\n";
		test.read_ages();

		cout << "\n";

		cout << "TEST2:\n";
		test2.read_ages();

		cout << "\n";

		cout << test;

		cout << "\n";

		if (test == test2) {
			cout << "test == test2\n\n";
		}

		if (test != test2) {
			cout << "test != test2\n\n";
		}

		test.sort_pairs();
		cout << "Sorted." << endl << endl;

		cout << test;
		
		cout << "\n";
		cout << "\n";

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