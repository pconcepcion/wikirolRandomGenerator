/**
 * @file: Dice.java
 * @author Pablo de la Concepcion <pconcepcion@gmail.com>
 *
 * @version 0.1
 *
 * Creation @date:17/12/2011 15:24:16
 * @copyright Copyright (c) Pablo de la Concepcion <pconcepcion@gmail.com> since 2011
 */

/**
 * @package org.wikirol.random
 */
package org.wikirol.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import android.util.Log;

/**
 * @author Pablo de la Concepcion <pconcepcion@gmail.com>
 * @class Dice, to generate random number from a Dice
 *
 * Can create a dice with the given number of sides or use one of the helpers for predefined dices:
 *  - d4
 *  - d6
 *  - d8
 *  - d10
 *  - d20
 *  - d100
 */
public class Dice {
    //------------//
    // Attributes //
    //------------//
    /**
     * Logging tag constant
     */
    private static final String LOGTAG = "org.wikirol.random.Dice";

    /** number of the sides of the dice */
    private int numSides;

    /** Random instance to generate the random numbers */
    private static Random randomGenerator = null;

    // Init the randomGenerator
    static {
        try {
            randomGenerator = SecureRandom.getInstance("SHA1PRNG");// new Random();
        } catch (NoSuchAlgorithmException nsae) {
            randomGenerator = new SecureRandom();
            // Log the exception
            Log.w(LOGTAG, "SHA1PRNG Algorithm not found", nsae);
        }
    }
    //--------------//
    // Constructors //
    //--------------//
    /**
     * Constructor
     *
     * @param numSides
     */
    public Dice(int numSides) {
        super();
        this.numSides = numSides;
    }

    //---------//
    // Methods //
    //---------//

    // Static methods for common dices

    /**
     * Generates a random integer between 1 and 4
     *
     * @return a random integer between 1 and 4
     */
    public static int d4() {
        return randomGenerator.nextInt(4) + 1;
    }

    /**
     * Generates a random integer between 1 and 6
     *
     * @return a random integer between 1 and 6
     */
    public static int d6() {
        return randomGenerator.nextInt(6) + 1;
    }

    /**
     * Generates a random integer between 1 and 8
     *
     * @return a random integer between 1 and 8
     */
    public static int d8() {
        return randomGenerator.nextInt(8) + 1;
    }

    /**
     * Generates a random integer between 1 and 10
     *
     * @return a random integer between 1 and 10
     */
    public static int d10() {
        return randomGenerator.nextInt(10) + 1;
    }

    /**
     * Generates a random integer between 1 and 12
     *
     * @return a random integer between 1 and 12
     */
    public static int d12() {
        return randomGenerator.nextInt(12) + 1;
    }

    /**
     * Generates a random integer between 1 and 20
     *
     * @return a random integer between 1 and 20
     */
    public static int d20() {
        return randomGenerator.nextInt(20) + 1;
    }

    /**
     * Generates a random integer between 1 and 100
     *
     * @return a random integer between 1 and 100
     */
    public static int d100() {
        return randomGenerator.nextInt(100) + 1;
    }

    /**
     * Generates a random integer between 1 and <code>numsides</code>
     *
     * @param numSides
     *            number of sides of the dice
     * @return a random integer between 1 and <code>numSides</code>
     */
    public static int dx(int numSides) {
        int res = randomGenerator.nextInt(numSides) + 1;
        Log.d("Dice result", "sides: " + numSides + " result: " + res);
        return res;
    }

    // Instance methods

    /**
     * Return the result of a dice trow
     *
     * @return Random number between 1 and <code>numSides</code>
     */
    public int rollDice() {
        return randomGenerator.nextInt(this.numSides) + 1;

    }

    //---------------------//
    // Getters and Setters //
    //---------------------//

    /**
     * @return the numSides
     */
    public int getNumSides() {
        return numSides;
    }

    /**
     * @param numSides
     *            the numSides to set
     */
    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

}