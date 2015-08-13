package org.fasttrackit.dev.lesson1.numgenerator;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumGeneratorBusinessLogicTest {

    @Test
    public void testResetNumberGenerator() throws Exception {
      NumGeneratorBusinessLogic nbr = new NumGeneratorBusinessLogic();
        nbr.resetNumberGenerator();
        assertTrue(nbr.isFirstTime());
        assertEquals(nbr.getNumGuesses(), 0);
        assertEquals(nbr.getHint(),"");
        System.out.println("First test passed!");
    }

    @Test
    public void testDetermineGuess() throws Exception {
        NumGeneratorBusinessLogic nbr = new NumGeneratorBusinessLogic();
        int startWith=50;
        boolean lucky = nbr.determineGuess(startWith);
        while(!lucky)
        {
            if(nbr.getHint().equals("lower")) {
                startWith=startWith-1;
                lucky = nbr.determineGuess(startWith);
            }
                else {
                startWith=startWith+1;
                lucky = nbr.determineGuess(startWith);
            }
        }
        System.out.println("trials:"+nbr.getNumGuesses());
        System.out.println("nr:"+startWith);
        assertTrue(lucky);
        System.out.println("Second test passed!");

    }

    @Test
    public void testGetSuccess() throws Exception {
     NumGeneratorBusinessLogic nbr = new NumGeneratorBusinessLogic();
        boolean success = nbr.getSuccessfulGuess();
        assertFalse(success);
        System.out.println("Third test passed!");
    }

    @Test
    public void testGetHint() throws Exception {
        NumGeneratorBusinessLogic nbr = new NumGeneratorBusinessLogic();
        int myTry=60;
        boolean b= nbr.determineGuess(myTry);
        String s =nbr.getHint();
        if(!b) {
            boolean result = s.equals("higher") || s.equals("lower") || s.equals("incorrect");
            System.out.println(s);
            assertTrue(result);
        }
        else {
            boolean result=s.equals("");
            System.out.println("wow, found from the first tentative");
            assertTrue(result);
            System.out.println("Fourth test passed!");
        }
    }

    @Test
    public void testGetNumGuesses() throws Exception {
        NumGeneratorBusinessLogic nbr = new NumGeneratorBusinessLogic();
        int numGuesses = nbr.getNumGuesses();
        assertEquals(numGuesses, 0);
        System.out.println("Fifth test passed!");

    }

    @Test
    public void testIsFirstTime() throws Exception {
        NumGeneratorBusinessLogic nbr = new NumGeneratorBusinessLogic();
        boolean firstTime = nbr.isFirstTime();
        assertTrue(firstTime);
        System.out.println("Sixth test passed!");
    }
}