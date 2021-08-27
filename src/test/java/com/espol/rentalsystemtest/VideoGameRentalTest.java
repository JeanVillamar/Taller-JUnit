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
	VideoGameRental wii;
	VideoGameRental ps3;
    VideoGameRental xbox;
    
    Ps3Game littleBigPlanet;
    Xbox360Game fable2;
    WiiGame superSmashBrosBrawl; 
	
	
    
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
        littleBigPlanet = new Ps3Game("Little Big Planet");
    	fable2 = new Xbox360Game("Fable 2");
    	superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl"); 
    	ps3 = new VideoGameRental(littleBigPlanet,4,true);
    	xbox = new VideoGameRental(fable2,4,true);
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
        assertEquals(4,ps3.getDaysRented());
        assertEquals(4,xbox.getDaysRented());
        assertEquals(2,wii.getDaysRented());	
    }

    /**
     * Test of getVideoGame method, of class VideoGameRental.
     */
    @Test
    public void testGetVideoGame() {
        System.out.println("getVideoGame");
        assertEquals(littleBigPlanet,ps3.getVideoGame());
        assertEquals(fable2,xbox.getVideoGame());
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
    
}
