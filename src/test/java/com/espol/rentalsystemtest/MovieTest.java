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
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jeanf
 */
public class MovieTest {
	
	Movie theManWKTM, Mulan, slumdogM;
	
    public MovieTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp(){
        theManWKTM = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        Mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogM = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPriceCode method, of class Movie.
     */
    @Test
    public void testGetPriceCode() {
        assertEquals(Movie.CHILDRENS, Mulan.getPriceCode());				//children
        assertEquals(Movie.REGULAR, theManWKTM.getPriceCode());				//regular
        assertEquals(Movie.NEW_RELEASE, slumdogM.getPriceCode());			//new release
    }

    /**
     * Test of setPriceCode method, of class Movie.
     */
    @Test
    public void testSetPriceCode() {
    	Mulan.setPriceCode(1);
        assertEquals(1,Mulan.getPriceCode());  //children
        theManWKTM.setPriceCode(2);
        assertEquals(2,theManWKTM.getPriceCode());  //regular
        slumdogM.setPriceCode(0);
        assertEquals(0,slumdogM.getPriceCode());    //new release
    } 
}
