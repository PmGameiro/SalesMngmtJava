**Java Project: SalesManagement** 

**Sales Management of a Distribution Chain**

**1. Introduction.**

The Java project's fundamental objective is to help consolidate theoretical and practical knowledge of Object-Oriented Programming.

**2.- Prerequisites.**

The Java project has the same text files as its data sources, used in the C project, so the structure of each line of the text file will be the same.

**3.- Requirements of the program to be developed.**

The aim is to develop a Java program that is capable of, first of all, reading and storing information from various files in appropriate data structures (Java collections), so that, subsequently, various queries can be carried out., some statistics and some “performance” tests.

The aggregating class of the entire Java project will be the Hypermarket class. A hypermarket must contain a Customer Catalog (all their codes), a Product Catalog (available product codes), an Invoice (listing products and their sales, branch by branch and globally) and a global record of all purchases made in each branch, by whom and when, which we will call Branch. 3 branches must be considered, identified by 1, 2 and 3.

Each of these information substructures of a hypermarket maintains the requirements that were presented in the C project.

The design and implementation of the program code must take into account that it must have two large groups of functionalities (corresponding to 75% of the value of the work):

1) Reading data from secondary memory and population of data structures in central memory; Saving the data structure (instance of the Hipermercado class) in an object file;
2) Queries: query operations on data structures;

In addition, equivalent to 25% of the value of the work, it is intended that a set of small programs be developed (or one that carries out all tests), independent of the **SalesManagement** application, that perform the functionality designated by:

3) Performance measures of code and data structures.

**3.1.- Reading, structure population and data persistence.**

` `The program must be able to read the text files at any time and load the respective data into memory. During the first execution of the program, this operation is mandatory. The program should cf. user indication, read one of the text files containing information relating to registered sales (cf. Sales\_1M.txt, Sales\_3M.txt or Sales\_5M.txt) as well as the Customers.txt and Products.txt files. **

An option must be available at any time that allows the user to record the entire data structure persistently using ObjectStreams, creating the hypermercado.dat file by default or another file if indicated by the user.

At any time, the user should also be able to load data from an ObjectStream with a given name, thus repopulating all the information from the data structure previously existing in memory. This may be useful to avoid multiple validations.

**3.2.- Statistics and interactive queries.**

As there are countless possible pieces of information to extract from the data structure, they should be grouped for the user as follows:

3\.2.1.- Statistical queries.

3\.2.1.1.- Presents the user with data relating to the last sales file read, namely, file name, total number of erroneous sales records, total number of products, total number of different products purchased, total number of non-purchased products, number total number of customers and total number of customers who made purchases, total number of customers who purchased nothing, total number of purchases with a total value equal to 0.0 and total billing.

3\.2.1.2.- Displays on screen to the user the general numbers relating to the current data already registered in the structures, namely:

- Total number of purchases per month (not billing);
- Total invoicing per month (total value of purchases/sales) for each branch and
  - global total value;
- Number of different customers who purchased each month (it does not matter how many times the customer purchased but only who actually purchased);

3\.2.2.- Interactive queries.

1. List ordered alphabetically with the codes of products never purchased and their respective total;
2. Given a valid month, determine the total global number of sales made and the total number of distinct customers who made them;
3. Given a customer code, determine, for each month, how many purchases you made, how many different products you purchased and how much you spent in total. ;
4. Given the code of an existing product, determine, month by month, how many times it was purchased, by how many different customers and the total billed;
5. Given a customer's code, determine the list of product codes that they purchased the most (and how many), ordered in descending order of quantity and, for equal quantities, in alphabetical order of codes;
6. Determine the set of X best-selling products throughout the year (in number of units sold) indicating the total number of different customers who purchased it (X is an integer given by the user);
7. Determine, for each branch, the list of the three largest buyers in terms of money invoiced;
8. Determine the codes of the X customers (X being given by the user) who purchased more different products (the quantity or value does not matter), indicating how many, the ordering criterion being the descending order of the number of products;

9. Given the code of a product that must exist, determine the set of X customers who purchased the most and, for each one, the amount spent (ordering cf. 5);

The creation of queries must be carried out in a sufficiently structured way so that it is simple to change the identifier and text of the query in the query menu and invoke the respective associated method.

All queries carried out must, even before the results are presented, and regardless of the way in which the final results are presented, indicate to the user the execution times using the long System.nanoTime() method;

which measures time differences in nanoseconds and which must be converted to seconds and milliseconds for presentation.

**3.3.- Performance measures.**

The intention is to carry out some purely experimental “performance” tests and only with the intention of introducing the idea, not yet very internalized for obvious reasons, that programs are entities that have some attributes that are measurable and whose analysis can be useful ( cf. testing and profiling).

` `These tests can and should be performed outside the context of the previously developed program (they will not be part of the program's functionality) using the parts of the code and data structures necessary for each test.

Therefore, as a complementary requirement of the project, carry out the following tests and present their results in the simplest and most illustrative way possible:

1\.- Reading times (without parsing) of the base file, Vendas\_1M.txt, using the Scanner() and BufferedReader() classes; Then use the Vendas\_3M.txt and Vendas\_5M.txt files and make new time measurements; Perform the same tests but now including parsing time, that is, separating the fields in the line and creating the instance of the class that will represent a Sale. Present the results in the form of a table and also in graphic form.

2\.- It is clear to everyone that the project's data structure will be based on the use of collections of the type Map<K, V>, as well as the use of collections of the type Set<E> and List<E> , it is important to compare the performances of some of the more complex queries that were requested (from 5 to 9).
