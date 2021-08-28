/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeanf
 */
public class VideoGameRentalTest {
	VideoGameRental ps3;
	VideoGameRental wii;
    VideoGameRental xbox;
    Ps3Game littleBigPlanet;
    WiiGame superSmashBrosBrawl;
    Xbox360Game fable2;
       
    
    public VideoGameRentalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	
    	//xbox
    	fable2 = new Xbox360Game("Fable 2");
        xbox = new VideoGameRental(fable2,4,true);
        
        //ps3
        littleBigPlanet = new Ps3Game("Little Big Planet");
        ps3 = new VideoGameRental(littleBigPlanet,4,true);
        
        //wii
        superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");
        wii = new VideoGameRental (superSmashBrosBrawl,2,false);
    	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDaysRented method, of class VideoGameRental.
     */
    @Test
    public void testGetDaysRented() {
        System.out.println("getDaysRented");
        //rented ps3
        assertEquals(4,ps3.getDaysRented());
        //rented xbox
        assertEquals(4,xbox.getDaysRented());
        //rented wii
        assertEquals(2,wii.getDaysRented());
    }

    /**
     * Test of getVideoGame method, of class VideoGameRental.
     */
    @Test
    public void testGetVideoGame() {
        System.out.println("getVideoGame");
        //get ps3
        assertEquals(littleBigPlanet,ps3.getVideoGame());
        //get xbox
        assertEquals(fable2,xbox.getVideoGame());
        //get wii
        assertEquals(superSmashBrosBrawl,wii.getVideoGame());
    }

    /**
     * Test of getCharge method, of class VideoGameRental.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");

        assertEquals(37.99,ps3.getCharge(),0.2);
        
        assertEquals(38.99,xbox.getCharge(),0.2);
        
        assertEquals(3.0,wii.getCharge(),0.2);
    }

    /**
     * Test of getFrequentRenterPoints method, of class VideoGameRental.
     */
    @Test
    public void testGetFrequentRenterPoints() {
        System.out.println("getFrequentRenterPoints");
        
        assertEquals(2,ps3.getFrequentRenterPoints());
        assertEquals(3,xbox.getFrequentRenterPoints());
        assertEquals(1,wii.getFrequentRenterPoints());
    }
    
    @Test
    public void testStatementPs3GameOnly() {

        Customer johnDoe = new Customer("John Doe");
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 1, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points",
           johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 3, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t4.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 4 frequent renter points",
           johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 5, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t5.25\n" +
                "Amount owed is 13.25\n" +
                "You earned 6 frequent renter points",
           johnDoe.statement());
    }

    @Test
    public void testStatementWiiGameOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 1, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                     "\tSuper Smash Bros. Brawl\t3.0\n" +
                     "Amount owed is 3.0\n" +
                     "You earned 1 frequent renter points",
                johnDoeJr.statement());
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 3, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                	 "\tSuper Smash Bros. Brawl\t3.0\n" +
                	 "\tSuper Smash Bros. Brawl\t3.0\n" +
                     "Amount owed is 6.0\n" +
                     "You earned 2 frequent renter points",
                johnDoeJr.statement());
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 5, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
           	         "\tSuper Smash Bros. Brawl\t3.0\n" +
        	         "\tSuper Smash Bros. Brawl\t3.0\n" +
        	         "\tSuper Smash Bros. Brawl\t4.5\n" +
                     "Amount owed is 10.5\n" +
                     "You earned 3 frequent renter points",
                johnDoeJr.statement());
    }
    
    @Test
    public void testStatementXbox360GameOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 1, false));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tFable 2\t3.5\n" +
                     "Amount owed is 3.5\n" +
                     "You earned 2 frequent renter points",
                janeDoe.statement());
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 2, false));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tFable 2\t3.5\n" +
                     "\tFable 2\t3.5\n" +
                     "Amount owed is 7.0\n" +
                     "You earned 4 frequent renter points",
           janeDoe.statement());
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 4, false));
        assertEquals("Rental Record for Jane Doe\n" +
	                 "\tFable 2\t3.5\n" +
	                 "\tFable 2\t3.5\n" +
	                 "\tFable 2\t5.0\n" +
	                 "Amount owed is 12.0\n" +
	                 "You earned 6 frequent renter points",
	      janeDoe.statement());
    }   
    
    
}
