// CS 272
// Lab 1
// Program:		Book.java
// Author: 		Phillip Powell
// Date: 		January 29, 2019
// 
package book;

import java.util.Arrays;

public class Book {
	
   private String title;
   private int numAuths;
   private String[ ] bookAuths;
   private String ISBN;
	
   // Default constructor
   public Book( ) {
      title = null;
	  ISBN = null;
	  numAuths = 0;
	  bookAuths = new String[ 3 ];
   } // end default constructor
	
   // Constructor
   public Book ( String mainTitle ) {
      title = mainTitle;
	  ISBN = null;
	  numAuths = 0;
	  bookAuths = new String [ 3 ];
   } // end constructor
	
   // Copy constructor
   public Book( Object obj ) {
	   
      if ( obj != null ) {
	     if ( obj instanceof Book ) {
		    Book ref = ( Book ) obj;
		    title = ref.getTitle( );
			ISBN = ref.getISBN( );
			numAuths = ref.getNumAuths( );
			bookAuths = new String [ 3 ];
				
			for ( int cpy = 0; cpy < ref.getNumAuths( ); cpy++ )
			   bookAuths[ cpy ] = ref.bookAuths[ cpy ];
		  
	     } // end instanceof if
	  } // end null check if	
   } // end copy constructor
	
   // Accessors
   public String getTitle( ) {
      return title;
   } // end getTitle accessor
	
   public int getNumAuths( ) {
      return numAuths;
   } // end getNumAuths accessor
	
   public String getISBN( ) {
      return ISBN;
   } // end getISBN accessor
	
   // Mutators
   public void setTitle( String inpTitle ) {
      title = inpTitle;
   } // end setTitle mutator
	
   public void setISBN( String inpISBN ) {
      ISBN = inpISBN;
   } // end setISBN mutator
	
   // Adds author names to bookAuths String array
   // Once the array is filled, it will stop taking names.
   public boolean addAuthor ( String inpAuth ) {
      if ( getNumAuths( ) < bookAuths.length ) {
	     bookAuths[ getNumAuths( ) ] = inpAuth;
		 numAuths++;
		 return true;
	  } // end if
	  return false;
   } // end addAuthor method
	
	// Checks if the ISBNs are the same between to objects
   public boolean equals( Object obj ) {
      if ( obj instanceof Book ) {
	     Book chosen = ( Book ) obj;
		 return chosen.ISBN == ISBN;
	  } // end if
	  return false;
   } // end equals method
	
   // Takes the String arrays of two book objects and compares them
   // Returns a String array with DISTINCT authors only
   public static String[ ] getAllAuthors( Book b1, Book b2 ) {
		
      int tmpCount = 0;
	  int b1Len = b1.getNumAuths( );
	  int b2Len = b2.getNumAuths( );
		
	  String[ ] combo = new String[ b1Len + b2Len ];
	  String[ ] temp = new String[ b1Len + b2Len ];
		
	  // filling up temp array with empty string in case of
	  // empty spaces; prevents "null" from being printed out
	  Arrays.fill( temp, "" );
		
	  // filling combo array with elements from b1.bookAuths array elements
	  for ( int bk1 = 0; bk1 < b1Len; bk1++ )
	     combo[ bk1 ] = b1.bookAuths[ bk1 ];
		
	  // filling the rest of combo array with b2.bookAuths array elements
	  for ( int bk2 = b1Len; bk2 < b1Len + b2Len ; bk2++ )
	     combo[ bk2 ] = b2.bookAuths[ bk2 - b1Len ];
		
	  // sorts the array to organize duplicates
	  Arrays.sort( combo );
		
	  // checks first element against second element for duplicates
	  // if no duplicate is found the element is copied to temp array
	  for( int chk = 0; chk < combo.length - 1; chk++ ) {
	     if ( combo[ chk ] != combo[ chk + 1 ] ) {
	        temp[ tmpCount ] = combo[ chk ];
		    tmpCount++;
	     } // end if
	  } // end for
		
	  // the last element will be printed regardless if there
	  // are duplicates or not; it will be the same result.  
	  temp[ tmpCount ] = combo[ combo.length - 1 ];	
		
	  return temp;
   } // end getAllAuthors method
	
   // converts an object to string
   public String toString( ) {
		
      // if numAuths == 3, then it returns string format including all 3 authors
      if ( getNumAuths( ) == 3 ) {
	     return "Title: \"" + getTitle( ) + "\" ISBN: \"" + getISBN( ) + "\" Number of Authors: \"" 
		        + getNumAuths( ) + "\" Authors: " + this.bookAuths[ 0 ] + ", " + this.bookAuths[ 1 ] 
				+ ", " + this.bookAuths[ 2 ];
	  } // end numAuths == 3 if
		
	  // if numAuths == 2, then it returns string format including only 2 authors
	  if ( getNumAuths( ) == 2 ) {
	     return "Title: \"" + getTitle( ) + "\" ISBN: \"" + getISBN( ) + "\" Number of Authors: \"" 
		        + getNumAuths( ) + "\" Authors: " + this.bookAuths[ 0 ] + ", " + this.bookAuths[ 1 ];
	  } // end numAuths == 2 if
		
	  // if numAuths == 1, then it returns string format including only 1 author
	  return "Title: \"" + getTitle( ) + "\" ISBN: \"" + getISBN( ) + "\" Number of Authors: \"" 
		     + getNumAuths( ) + "\" Author: " + this.bookAuths[ 0 ];
   } // end toString method
	
   public static void main( String [ ] args ) {
		
      // Tests constructor with title parameter
      Book book1 = new Book( "Red" );
	  Book book2 = new Book( "Blue" );
		
	  // Adding book1 attributes
	  book1.addAuthor( "James Thompson" );
	  book1.addAuthor( "Hugh Lahrey" );
	  book1.addAuthor( "James Thompson" );
	  book1.setISBN( "123-08-122" );
			
	  // Adding book2 attributes
	  book2.addAuthor( "Jimmy Jones" );
	  book2.addAuthor( "Tom O'Larey" );
	  book2.addAuthor( "James Thompson" );
	  book2.setISBN( "94-76-873" );
		
	  // Copy Constructor Test #1
	  Book book3 = new Book( book1 );
	  System.out.println( "Copy Constructor Test #1." );
	  System.out.println( "Book1 Contents: " + book1.toString( ) );
	  System.out.println( "Book3 Contents: " + book3.toString( ) );
	  System.out.println( );
		
	  // Copy Constructor Test #2
	  Book book4 = new Book( book2 );
	  System.out.println( "Copy Constructor Test #2." );
	  System.out.println( "Book2 Contents: " + book2.toString( ) );
	  System.out.println( "Book4 Contents: " + book4.toString( ) );
	  System.out.println( );
		
	  // Testing equals method when false
	  System.out.println( "Equals Method Test #1" );
	  System.out.println( "Comparing book3 to book2." );
	  System.out.println( "Book 3 ISBN: " + book3.getISBN( ) );
	  System.out.println( "Book 2 ISBN: " + book2.getISBN( ) );
	  
	  // Prints out a message if the method returns true/false
	  if ( book3.equals( book2 ) ) {
	     System.out.println( "Result: True" );
	  } else {
	     System.out.println( "Result: False" );
	  } // end if
	  
	  System.out.println( );
	  
	  // Testing the equals method when true
	  System.out.println( "Equals Method Test #2" );
	  System.out.println( "Comparing book2 to book4." );
	  System.out.println( "Book 2 ISBN: " + book2.getISBN( ) );
	  System.out.println( "Book 4 ISBN: " + book4.getISBN( ) );
	  
	  // Prints out a message if true/false
	  if ( book2.equals( book4 ) ) {
	     System.out.println( "Result: True." );
	  } else {
	     System.out.println( "Result: False." );
	  } // end if
	  
	  // Storing the getAllAuthors method's return value in a new String array
	  // for simplification purposes
	  String [ ] allAuths1 = new String [ getAllAuthors( book1, book2 ).length ];
		
	  for( int fill = 0; fill < allAuths1.length; fill++ )
	     allAuths1[ fill ] = getAllAuthors( book1, book2 )[ fill ];
		
	  // Printing out getAllAuthors
	  System.out.println( );
	  System.out.println("Testing getAllAuthors( book1, book2 ):");
	  
	  System.out.print( allAuths1[ 0 ] );
	  
	  for ( int prt = 1; prt < allAuths1.length; prt++ ) {
	     if ( !allAuths1[ prt ].equals("") )
		    System.out.print( ", " + allAuths1[ prt ]);
	  } // end prt for
		
	  System.out.println( );
	  
	  // Testing getAllAuthors method with non-maxed arrays
	  Book getAllTest1 = new Book( );
	  Book getAllTest2 = new Book( );
	  
	  // Adding authors to both objects
	  getAllTest1.addAuthor( "Frank Sandburg" );
	  getAllTest1.addAuthor( "Terrence Williams" );
	  
	  getAllTest2.addAuthor( "Lucy Atwell" );
	  
	  // Creating a string array to store getAllAuthors' return value for simplification
	  String [ ] allAuths2 = new String [ getAllAuthors( getAllTest1, getAllTest2 ).length ];
	  
	  for ( int fill2 = 0; fill2 < allAuths2.length; fill2++ )
		  allAuths2[ fill2 ] = getAllAuthors( getAllTest1, getAllTest2 )[ fill2 ];
	  
	  System.out.println( );
	  System.out.println( "Testing getAllAuthors( getAllTest1, getAllTest2 )" );
	  
	  System.out.print( allAuths2[ 0 ] );
	  
	  for ( int prt2 = 1; prt2 < allAuths2.length; prt2++ ) {
	     if ( !allAuths2[ prt2 ].equals("") )
		    System.out.print( ", " + allAuths2[ prt2 ]);
	  } // end prt2 for
	  
	  System.out.println( );
	  
	  // Testing the toString method
      Book book5 = new Book( book1 );
	  System.out.println( "\nTesting book5.toString( )" );
	  System.out.println( book5.toString( ) );
	  System.out.println( );
		
	  // Testing toString method with title changed
	  book5.setTitle( "CS272" );
	  System.out.println( "Testing book5.toString( ) with title changed." );
	  System.out.println( book5.toString( ) );
	  System.out.println( );
		
	  // Testing toString method with just two authors
	  Book book6 = new Book( "Time and Again" );
		
	  book6.addAuthor( "Eugene Banks" );
	  book6.addAuthor( "Thomas Brown" );
	  book6.setISBN( "946-8745-231" );
	  
	  System.out.println( "Testing book6.toString( )" );
	  System.out.println( book6.toString( ) );
		
   } // end main
} // end Book class