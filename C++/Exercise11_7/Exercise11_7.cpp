/*
Programming - Principles and Practice
Exercise 11.7
Brian McDaniel 2014
*/

// Use the program from the previous exercise to make a dictionary (as an 
// alternative to the approach in §11.7). Run the result on a multi-page text 
// file, look at the result, and see if you can improve the program to make a 
// better dictionary.

// improvement: get rid of "words" that are just all digits

#include "..\..\std_lib_facilities.h"

void punct_in_word(char punct, char prev, ifstream& ist, stringstream& ss){
	if (isalpha(prev)) {
		char in;
		if (ist.get(in)){
			ist.unget();
			if (isalpha(in)) ss << punct; // middle of word so output punct
			else ss << ' '; // no so output space
		}
	}
	else ss << ' ';
}

string expand(char c, stringstream& ss){
	// expand common contractions
	string out = " ";
	if (isalpha(c)) {
		// get word and look for match
		ss.unget();
		ss >> out;
		// if this list was much longer it might be better to 
		// load it in from a file
		if (out == "don't") out = "do not";
		else if (out == "can't") out = "can not";
		else if (out == "isn't") out = "is not";
		else if (out == "aren't") out = "are not";
		else if (out == "wasn't") out = "was not";
		else if (out == "weren't") out = "were not";
		else if (out == "haven't") out = "have not";
		else if (out == "hasn't") out = "has not";
		else if (out == "hadn't") out = "had not";
		else if (out == "doesn't") out = "does not";
		else if (out == "didn't") out = "did not";
		else if (out == "couldn't") out = "could not";
		else if (out == "mightn't") out = "might not";
		else if (out == "mustn't") out = "must not";
		else if (out == "shan't") out = "shall not";
		else if (out == "shouldn't") out = "should not";
		else if (out == "won't") out = "will not";
		else if (out == "wouldn't") out = "would not";
		else if (out == "daren't") out = "dare not";
		else if (out == "needn't") out = "need not";
		else if (out == "oughtn't") out = "ought not";
		else if (out == "aren't") out = "are not";
		else if (out == "isn't") out = "is not";
		else if (out == "let's") out = "let us";
		else if (out == "i'm") out = "i am";
		else if (out == "it's") out = "it is";
		else if (out == "we're") out = "we are";
		else if (out == "you're") out = "you are";
		else if (out == "they're") out = "they are";
		else if (out == "i've") out = "i have";
		else if (out == "you've") out = "you have";
		else if (out == "we've") out = "we have";
		else if (out == "they've") out = "they have";
		else if (out == "i'd") out = "i had";
		else if (out == "you'd") out = "you had";
		else if (out == "who'd") out = "who had";
	}
	else out = c;
	return out;
}

int main()
{
	try {
		string filename = " ";
		cout << "Please enter filename to load: >";
		cin >> filename;
		ifstream ist(filename.c_str());
		if (!ist) error("can't open input file ", filename);
		ofstream ost("output.txt");

		stringstream ss;
		char prev = ' ';
		char in = ' ';
		// first pass: get rid of punctuation except 
		// hyphens and apostrophes inside of words
		while (ist.get(in)) { // get preserves whitespace
			if (in == '-') {
				punct_in_word('-', prev, ist, ss);
			}
			else if (in == '\'') {
				punct_in_word('\'', prev, ist, ss);
			}
			else if (ispunct(in)) ss << ' ';
			else ss << char(tolower(in));
			prev = in;
		}

		// second pass: substitute for contractions
		// this is where we change don't to do not etc.
		stringstream ss2;
		char c = ' ';
		string out = " ";
		while (ss.get(c)){
			out = expand(c, ss);	// expand contractions
			ss2 << out;
		}

		stringstream ss3;
		// third pass: remove remaining apostrophes inside of words
		while (ss2.get(in)){
			if (in == '\'')
				ss3 << ' ';
			else
				ss3 << in;
		}

		// assemble dictionary
		vector<string> dict;
		string out2 = " ";
		bool all_digits = true;
		while (ss3 >> out2) {
			// only add "words" that are not all digits
			all_digits = true;
			// check each character to make sure there is at least one non-digit
			for (int i = 0; i < out2.size(); ++i) { 
				if (!isdigit(out2[i])) all_digits = false;
			}
			if (!all_digits) dict.push_back(out2);
		}
		sort(dict.begin(), dict.end());

		// output dictionary
		for (int i = 0; i < dict.size(); ++i) {
			if (i == 0 || dict[i] != dict[i - 1])
				ost << dict[i] << endl;
		}

		cout << "\n";
		cout << "\n";

		keep_window_open();
		return 0;
	}	// end try

	catch (exception& e) {
		cerr << "error: " << e.what() << "\n\n";
		keep_window_open("Q");
		return 1;
	}
	catch (...) {
		cerr << "unknown exception!\n\n";
		keep_window_open("Q");
		return 2;
	}
}	// end main