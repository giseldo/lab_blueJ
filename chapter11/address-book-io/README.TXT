Project: address-book-io
Authors: David J. Barnes and Michael Kolling
Version: 2002.06.11

This project is part of the material for chapter 11 of the book

   Objects First with Java - A Practical Introduction using BlueJ
   David J. Barnes and Michael Kolling
   Pearson Education, 2002

A simple address-book implementation.

How to start this project:
    Either: Create an AddressBook object and add
    contact details (such as name, address, and phone) to it.
    Or: create an AddressBookDemo and call its run method.
    This will create a sample AddressBook along with a GUI for
    the purposes of interactive experimentation.

Create an AddressBookFileHandler to illustrate some basic
input-output operations on an AddressBook.

User instructions:
    + Search results are saved to "results.txt" in the project folder.
    + The file "sample.txt", in the project, folder contains a sample
      entry that can be added, using the addEntriesFromFile of
      the AddressBookFileHandler.
    + A complete address book object may be saved, in binary form,
      using the saveToFile method. This may be read in again with
      readFromFile.
