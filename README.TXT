TechSupport - the DodgySoft Technical support system, version #2.

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

This project is discussed in chapter 6.


This project implements a second version of the technical support system 
example. It is an intermediate version intended to demonstrate the first
few changes discussed in this book chapter.


To start this program, create a SupportSystem object and execute the "start" 
method.

Then start describing your problem by typing in the terminal window.


Answers:

24. A HashMap is a hash table–based implementation of the Map interface that allows null values and one null key.
    Its purpose is to store key–value pairs and provide fast access, update, and removal.
    You use it by creating a HashMap object and using methods like put, to add and get to retrieve data.

26. By using the size() method. 

28. When you add an entry with a key that already exists, the old value is replaced with the new one.

29. When you add an entry with two different keys, the map stores both entries separately.

30. HashMap<String, String> phoneBook = new HashMap<>();
    phoneBook.put("Timur", "123-4567");

    if (phoneBook.containsKey("Timur")) {
        System.out.println("Key found!");
    } else {
        System.out.println("Key not found.");
    }

31. If you look up a value with a key that does not exist, the map returns null.

32. You can print all keys using keySet().

34. Both HashSet and ArrayList store collections of objects and let you iterate through them but an ArrayList keeps elements in order, allows duplicates, and supports access by index while a HashSet does not allow duplicates, does not maintain order and uses hashing for fast lookups.

35. Returning words in an ArrayList gives them back in the order they were added and includes duplicates, while returning words in a HashSet removes duplicates and does not guarantee any order.

36. If there are two or more spaces the split may produce empty strings between words which can cause unwanted “empty words” in the result. 

37. 

 
