/*
Programming - Principles and Practice
Exercise 9.8
Brian McDaniel 2014
*/

// Create a Patron class for the library. The class will have a user's name, 
// library card number, and library fees (if owed). Have functions that access 
// these methods, as well as a function to set the fee of the user. Have a 
// helper method that returns a Boolean (bool) depending on whether or 
// not the user owes a fee.

#include "..\..\std_lib_facilities.h"

class Book {
public:
	enum Genre { fiction, nonfiction, periodical, biography, children };

	Book(string i, string t, string a, string c, Genre g);
	string get_isbn() const { return isbn; }
	string get_title() const { return title; }
	string get_author() const { return author; }
	string get_copyright_date() const { return copyright_date; }
	Genre get_genre() const { return book_genre; }
	bool get_checked_out() const { return checked_out; }
	void check_out() { checked_out = true; }
	void check_in() { checked_out = false; }

private:
	string isbn;
	string title;
	string author;
	string copyright_date;
	Genre book_genre;
	bool checked_out;

	bool number(char in);
	bool good_isbn(string in);
};

bool Book::number(char in)
{
	switch (in) {
	case '0': case '1': case '2': case '3': 
	case '4': case '5': case '6': case '7': 
	case '8': case '9':
		return true;
	default:
		return false;
	}
}

bool Book::good_isbn(string in)
{
	int total_nums = 0;
	// only ISBN-13 with four hyphens accepted
	if (in.size() < 17)
		return false;
	int j=0;
	// first block
	while (number(in[j])) {
		total_nums++;
		j++;
		if (j > int(in.size()))
			return false;
	}
	if (in[j] != '-')
		return false;
	j++;
	// second block
	while (number(in[j])) {
		total_nums++;
		j++;
		if (j > int(in.size()))
			return false;
	}
	if (in[j] != '-')
		return false;
	j++;
	// third block
	while (number(in[j])) {
		total_nums++;
		j++;
		if (j > int(in.size()))
			return false;
	}
	if (in[j] != '-')
		return false;
	j++;
	// checksum
	if (number(in[j])||in[j]=='X') {
		total_nums++;
		if (total_nums > 13)
			error("Too many digits in ISBN");
		else 
			return true;
	}
	return false;
}

Book::Book(string i, string t, string a, string c, Genre g)
{
	if (i.size() <= 0)
		error("empty ISBN");
	if (good_isbn(i))
		isbn = i;
	else
		error("bad ISBN");
	if (t.size() > 0)
		title = t;
	else
		error("empty title");
	if (a.size() > 0)
		author = a;
	else
		error("empty author");
	if (c.size() > 0) {
		for(int i = 0; i < int(c.size()); ++i) {
			if (!number(c[i]))
				error("bad copyright date");
		}
		copyright_date = c;
	}
	else
		error("empty copyright date");
	if (g < fiction || children < g)
		error("empty genre");
	else
		book_genre = g;
	checked_out = false;
}

bool operator==(const Book& a, const Book& b)
{
	return a.get_isbn() == b.get_isbn();
}

bool operator!=(const Book& a, const Book& b)
{
	return a.get_isbn() != b.get_isbn();
}

ostream& operator<<(ostream& os, const Book& b)
{
	return os << b.get_title() << endl 
		<< b.get_author() << endl 
		<< b.get_isbn();
}

ostream& operator<<(ostream& os, const Book::Genre& g)
{
	switch (g) {
	case Book::fiction:
		return os << "fiction" << endl;
	case Book::nonfiction:
		return os << "nonfiction" << endl;
	case Book::periodical:
		return os << "periodical" << endl;
	case Book::biography:
		return os << "biography" << endl;
	case Book::children:
		return os << "children" << endl;
	}
	error("bad genre");
	return os << "**BAD**" << endl;
}

class Patron {
public:
	Patron::Patron(string n, string cn);
	string get_name() const { return name; }
	string get_card_num() const { return card_num; }
	double get_fines() const { return fines; }
	void set_fines(double);
private:
	string name;
	string card_num;
	double fines;
};

Patron::Patron(string n, string cn)
{
	if (n.size() > 0)
		name = n;
	else
		error("empty name");
	if (cn.size() == 12)
		card_num = cn;
	else
		error("card number not 12 digits");
	fines = 0.0;
}

void Patron::set_fines(double f)
{
	if (f >= 0)
		fines = f;
	else
		error("fines < 0");
}

bool has_fines(const Patron& p)
{
	return(p.get_fines() > 0);
}

int main()
{
	try {
		Book book_1("978-0-321-54372-1","Code Complete","Scott McConnell","1994",Book::nonfiction);
		cout << endl 
			<< "New Book:" << endl << endl
			<< "ISBN: " << book_1.get_isbn() << endl
			<< "title: " << book_1.get_title() << endl
			<< "author: " << book_1.get_author() << endl
			<< "copyright date: " << book_1.get_copyright_date() << endl
			<< "genre: " << book_1.get_genre() << endl
			<< endl;

		book_1.check_out();
		if(book_1.get_checked_out())
			cout << book_1.get_title() << " is now checked out." << endl;
		else
			cout << book_1.get_title() << " is now checked in." << endl;

		book_1.check_in();
		if(book_1.get_checked_out())
			cout << book_1.get_title() << " is now checked out." << endl;
		else
			cout << book_1.get_title() << " is now checked in." << endl;

		cout << "\n";

		// test two
		Book book_2("978-0-321-54372-1","C-D-B!","William Steig","1964",Book::children);
		cout << endl 
			<< "New Book:" << endl << endl
			<< "ISBN: " << book_2.get_isbn() << endl
			<< "title: " << book_2.get_title() << endl
			<< "author: " << book_2.get_author() << endl
			<< "copyright date: " << book_2.get_copyright_date() << endl
			<< "genre: " << book_2.get_genre() << endl
			<< endl;

		cout << (book_1 == book_2 ? "Book 1 == Book 2\n" : "Book 1 != Book 2\n");

		// test three
		Book book_3("978-0-321-54472-1","Atlas Shrugged","Ayn Rand","1957",Book::fiction);
		cout << endl 
			<< "New Book:" << endl << endl
			<< "ISBN: " << book_3.get_isbn() << endl
			<< "title: " << book_3.get_title() << endl
			<< "author: " << book_3.get_author() << endl
			<< "copyright date: " << book_3.get_copyright_date() << endl
			<< "genre: " << book_3.get_genre() << endl
			<< endl;

		cout << (book_2 != book_3 ? "Book 2 != Book 3\n" : "Book 2 == Book 3\n");

		cout << endl << book_3 << endl;

		Patron p1("Shinichi Mechazawa", "314159265359");
		cout << endl 
			<< "New Patron:" << endl << endl
			<< "name: " << p1.get_name() << endl
			<< "card number: " << p1.get_card_num() << endl
			<< endl;

		cout << "Fines are now: " << p1.get_fines() << endl;
		p1.set_fines(0.50);
		if (has_fines(p1))
			cout << p1.get_name() << " has fines." << endl;
		else
			cout << p1.get_name() << " does not have fines." << endl;			
		cout << "Fines are now: " << p1.get_fines() << endl << endl;

		// bad patron
		//Patron p2("", "314159265359");

		// bad patron
		//Patron p3("Shinichi Mechazawa", "31415926535");

		// bad fines
		//p1.set_fines(-345);

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