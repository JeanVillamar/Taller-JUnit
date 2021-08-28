/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jeanf
 */
public class CustomerTest {
	 Customer johnDoe  ;
	 MovieRental rentedm;
	 VideoGameRental smashrented;

    
    public CustomerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    	johnDoe  = new Customer("John Doe");
    	rentedm = new MovieRental(new Movie("Mulan",Movie.CHILDRENS),2);
        smashrented = new VideoGameRental(new WiiGame("Super Smash Bros, Brawl"),3,false);
    	
    	
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMovieRental method, of class Customer.
     */
    @Test
    public void testAddMovieRental() {
        System.out.println("addMovieRental");
        johnDoe.addMovieRental(rentedm);
        assertTrue(johnDoe .getMovieRentals().contains(rentedm));
        
    }

    /**
     * Test of addVideoGameRental method, of class Customer.
     */
    @Test
    public void testAddVideoGameRental() {
        System.out.println("addVideoGameRental");
        johnDoe .addVideoGameRental(smashrented);
        assertTrue(johnDoe .getVideoGameRental().contains(smashrented));
    }

    /**
     * Test of statement method, of class Customer.
     */
    
    @Test
    public void testStatementNewReleaseOnly() {
        System.out.println("StatementNewReleaseOnly");
        Movie spidermanNWH = new Movie("Spiderman: No Way Home", Movie.NEW_RELEASE);
        MovieRental spidermanRental = new MovieRental(spidermanNWH,3);
        johnDoe.addMovieRental(spidermanRental);
        

        String expResult = "Rental Record for " + johnDoe.getName() + "\n";
        
        double amount = 0;
        amount +=spidermanRental.getDaysRented()*3;
        expResult += "\t" + spidermanRental.getMovie()._title+ "\t"+ String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        frequentRenterPoints++;
        expResult += "You earned " + String.valueOf(frequentRenterPoints)+ " frequent renter points";
            
        String result = johnDoe.statement();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testStatementRegularMovieOnly() {
        System.out.println("StatementRegularMovieOnly");
        Movie Titanic= new Movie("Titanic", Movie.REGULAR);
        MovieRental titanicRental = new MovieRental(Titanic,3);
        johnDoe.addMovieRental(titanicRental);
        

        double amount = 0;
        amount+=2;
        amount+=(titanicRental.getDaysRented()-2)*1.5;
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        
        
        String expResult = "Rental Record for " + johnDoe.getName() + "\n";
        expResult += "\t" + titanicRental.getMovie()._title+ "\t"+ String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        expResult += "You earned " + String.valueOf(frequentRenterPoints)+ " frequent renter points";
            
        String result = johnDoe.statement();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testChildrenMovieStatementMoreThan3() {
        System.out.println("ChildrenMovieStatementMoreThan3");
        
        MovieRental mulanrented10 = new MovieRental(new Movie("Mulan",Movie.CHILDRENS),10);
        johnDoe.addMovieRental(mulanrented10);
        
        

        int frequentRenterPoints = 1;
        
        
        String expResult = "Rental Record for " + johnDoe.getName() + "\n";
        double amount = 1.5;
        amount += (mulanrented10.getDaysRented()-3)*1.25;
        
        expResult += "\t" + mulanrented10.getMovie()._title+ "\t"+ String.valueOf(amount) + "\n";
        expResult += "Amount owed is " + String.valueOf(amount) + "\n";
        expResult += "You earned " + String.valueOf(frequentRenterPoints)+ " frequent renter points";
            
        String result = johnDoe.statement();    
        assertEquals(expResult, result);
    }
    
    
    
}
