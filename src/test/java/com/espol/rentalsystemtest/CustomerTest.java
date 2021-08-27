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
    public void testStatement() {
        System.out.println("statement");
        Customer instance = null;
        String expResult = "asd";
        String result = instance.statement();
        assertEquals(expResult, result);

    }
    
}
