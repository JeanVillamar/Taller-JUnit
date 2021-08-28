/*
 * 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

/**
 *
 * @author jeanf
 */
public class MovieRentalTest {
    
    MovieRental MovMulanRental;
    Movie MovieMulan ;
    
    
    public MovieRentalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    	
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	MovieMulan = new Movie("Mulan", Movie.CHILDRENS);
    	MovMulanRental = new MovieRental(MovieMulan,4);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDaysRented method, of class MovieRental.
     */
    @Test
    public void testGetDaysRented() {
        assertEquals(4,MovMulanRental.getDaysRented());
    }

    /**
     * Test of getMovie method, of class MovieRental.
     */
    @Test
    public void testGetMovie() {
        assertEquals(MovieMulan,MovMulanRental.getMovie());
       
    }
    
}
