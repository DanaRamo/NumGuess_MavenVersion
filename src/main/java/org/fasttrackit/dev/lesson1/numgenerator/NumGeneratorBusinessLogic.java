package org.fasttrackit.dev.lesson1.numgenerator;

/**
 * Created by condor on 29/11/14.
 * FastTrackIT, 2015
 */


/* didactic purposes

Some items are intentionally not optimized or not coded in the right way

FastTrackIT 2015

*/

public class NumGeneratorBusinessLogic {

    private static final int MAX_NUMBER = 6;

    private boolean isFirstTime = true;
    private boolean successfulGuess;
    private int numberOfGuesses;
    private int generatedNumber;
    private String hint;

    public NumGeneratorBusinessLogic(){
        resetNumberGenerator();
    }

    public boolean getSuccessfulGuess(){
        return successfulGuess;
    }

    public String getHint(){
        return hint;
    }

    public int getNumGuesses(){
        return numberOfGuesses;
    }

    public boolean isFirstTime(){
        return isFirstTime;
    }

    public void resetNumberGenerator(){
        isFirstTime = true;
        numberOfGuesses = 0;
        hint = "";
    }

    public boolean determineGuess(int guessNumber){
        if (isFirstTime) {
            generatedNumber = NumGenerator.generate(MAX_NUMBER);
            System.out.println("gennr:"+generatedNumber);
            isFirstTime = false;
        }
        numberOfGuesses++;
        if (guessNumber == generatedNumber && guessNumber < 11 && guessNumber > 0) {
            hint="";
            successfulGuess = true;
        } else if (guessNumber < generatedNumber && guessNumber < 11 && guessNumber > 0) {
            hint = "higher";
            successfulGuess = false;
        } else if (guessNumber > generatedNumber && guessNumber < 11 && guessNumber > 0) {
            hint = "lower";
            successfulGuess = false;
        } else if (guessNumber > 10 || guessNumber < 1){
            hint = "incorrect";
            successfulGuess = false;
        }
        return successfulGuess;
    }


}