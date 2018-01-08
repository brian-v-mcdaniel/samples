/*
Programming - Principles and Practice
Exercise 10.12
Brian McDaniel 2014
*/

// Write a program that given a file name and a word outputs each line that contains that word together 
// with the line number. Hint: getline().

#include "..\..\std_lib_facilities.h"

bool word_found(string& word, string& line, int& place){
	// determine if line contains word at place
	int i = 0;
	while (i < word.size()) {
		if (line[place + i] != word[i]) return false;
		++i;
	}
	return true;
}

int main()
{
	try {
		cout << "Find Word\n\n";
		cout << "Please enter word to find: >";
		string word = "";
		cin >> word;
		cout << "Please enter filename to load: >";
		string filename = "";
		cin >> filename;
		ifstream ist(filename.c_str());
		if (!ist) error("can't open input file ", filename);
		cout << "\n";

		cout << "Matching lines: \n\n";
		int count = 0;
		string line;
		bool match = false;
		bool no_matches = true;
		getline(ist, line);
		while (ist) {
			++count;
			// go through line and look for a match
			int i = 0;
			while (i < line.size()) {
				if (line[i] == word[0]) {	// found first letter
					match = word_found(word,line,i);
					no_matches = false;
					break;
				}
				++i;
			}
			if (match) cout << count << ": " << line << "\n";
			match = false;	// reset
			getline(ist, line);
		}

		if (no_matches) cout << "none";

		cout << "\n";
		cout << "\n";

		keep_window_open("Q");
		return 0;
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