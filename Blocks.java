/**
 * Name: Bryce Sulin (sulin) 
 * Course: CSCI-241 - Computer Science I
 * Section: 001
 * Assignment: 8
 * 
 * Program Description:
 * Uses static methods and loops, some of which were nested, to help design, manipulate, and print 2D arrays
 * of characters in different block patterns.
 * 
 * Known Bugs: none.
 */

import java.util.*;

public class Blocks
{
    // Add constant to hold pattern character and variable to hold
    // the number of rows and columns
    public static final char STAR = '*';
    private static int dimension = 0;

    /**
     * The main method calls the getDimension method to get the array dimension.
     * It declares a 2D array of characters using that inputted dimension value.
     * It also calls different pattern-building methods to print a revised array
     * grid from each method, utilizing the clear and print methods as well.
     * It returns no value.
     */
    public static void main (String [] args)
    {
        dimension = getDimension();
        char [] [] array;
        array = new char [dimension] [dimension];
        clear(array);
        verticalInside(array);
        System.out.println("Running verticalInside()");
        print(array);
        clear(array);
        horizontalInside(array);
        System.out.println("Running horizontalInside()");
        print(array);
        clear(array);
        innerBox(array);
        System.out.println("Running innerBox()");
        print(array);
        clear(array);
        flag(array);
        System.out.println("Running flag()");
        print(array);
        clear(array);
        leftArrow(array);
        System.out.println("Running leftArrow()");
        print(array);
        clear(array);
        rightArrow(array);
        System.out.println("Running rightArrow()");
        print(array);
        clear(array);
        diamond(array);
        System.out.println("Running diamond()");
        print(array);
    }

    /**
     * The getDimension method takes no parameters and returns an integer representing
     * the dimension value (# rows/columns) for the array. 
     * The dimension value must be an odd number between 5 and 11, inclusive.
     */
    public static int getDimension ()
    {
        Scanner keyboard = new Scanner(System.in);
        int getDimension = 0;
        boolean check = true;
        while (check) 
        {
            System.out.print("Enter grid dimension (odd number) : ");
            getDimension = keyboard.nextInt();
            if ((getDimension == 5 || getDimension == 7 || getDimension == 9 ||
                getDimension == 11))
            {
                check = false;
            }
        }
        return getDimension;
    }

    /**
     * The print method takes a 2D array of characters as a parameter and returns nothing.
     * It neatly prints the array contents from the parameter.
     */
    public static void print (char array [] [])
    {
        int r, c = 0;
        int dash = STAR * 2 + 1;
        for (c = 0; c < array.length; c++)
        {
            System.out.print("--"); 
        }
        System.out.print("-");
        System.out.println();
        for (r = 0; r < array.length; r++)
        {
            for (c = 0; c < array.length; c++)
            {
                System.out.print(" " + array[r][c]);
            }
            System.out.println();
        }
        for (c = 0; c < array.length; c++)
        {
            System.out.print("--");
        }
        System.out.print("-");
        System.out.println();
    }

    /**
     * The clear method takes a 2D array of characters as a parameter and returns nothing.
     * It places the space character in each location in the array.
     */
    public static void clear (char array [] [])
    {
        int r, c = 0;
        for (r = 0; r < array.length; r++)
        {
            for (c = 0; c < array.length; c++)
            {
                array[r][c] = ' ';
            }
        }
    }

    /**
     * The verticalInside method takes a 2D array of characters as a parameter, 
     * and returns nothing. Its pattern should resemble 2 vertical lines.
     */
    public static void verticalInside (char array [] [])
    {
        int r = 1;
        int c = 0;
        for (r = 1; r < array.length - 1; r++)
        {
            c = 1;
            array[r][c] = '*';
        }
        for (r = 1; r < array.length - 1; r++)
        {
            c = array.length - 2;
            array[r][c] = '*';
        }
    }

    /**
     * The horizontalInside method takes a 2D array of characters as a parameter, 
     * and returns nothing. Its pattern should resemble 2 horizontal lines.
     */
    public static void horizontalInside (char array [] [])
    {
        int r = 0;
        int c = 1;
        for (c = 1; c < array.length - 1; c++)
        {
            r = 1;
            array[r][c] = '*';
        }
        for (c = 1; c < array.length - 1; c++)
        {
            r = array.length - 2;
            array[r][c] = '*';
        }
    }

    /**
     * The innerBox method takes a 2D array of characters as a parameter, 
     * and returns nothing. Its pattern should resemble a box.
     */
    public static void innerBox (char array [] [])
    {
        verticalInside(array);
        horizontalInside(array);
    }

    /**
     * The flag method takes a 2D array of characters as a parameter, 
     * and returns nothing. Its pattern should resemble a flag.
     */
    public static void flag (char array [] [])
    {
        for (int r = 0; r < array.length; r++)
        {
            for (int c = 0; c < array.length; c++)
            {
                if (r == 0 && c == 0)
                {
                    array[r][c]= '*';
                }
                if (c == 0 && r == array.length - 1)
                {
                    array[r][c] = '*';
                }
                if (r == 0 && c == array.length - 1)
                {
                    array[r][c] = '*';
                }
                if (c == array.length - 1 && r == array.length - 1)
                {
                    array[r][c] = '*';
                }
            }
        }
        innerBox(array);
    }

    /**
     * The leftArrow method takes a 2D array of characters as a parameter,
     * and returns nothing. Its pattern should resemble an arrow pointing left.
     */
    public static void leftArrow (char array [] [])
    {
        int c = 0;
        int r = 0;
        for (r = 0; r < array.length; r++)
        {
            c = array.length / 2;
            array[r][c] = '*';
        }
        for (c = 0; c < array.length; c++)
        {
            r = array.length / 2;
            array[r][c] = '*';
        }
        for (r = 1; r < array.length - 1; r++)
        {
            c = array.length / 2 - 1;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 - 2;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 + 1;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 + 2;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length - 1;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length - 2;
            array[r][c] = '*';
        }
        for (r = 3; r < array.length - 3; r++)
        {
            c = array.length / array.length;
            array[r][c] = '*';
        }
    }

    /**
     * The rightArrow method takes a 2D array of characters as a parameter, 
     * and returns nothing. Its pattern should resemble an arrow pointing right.
     */
    public static void rightArrow (char array [] [])
    {
        int c = 0;
        int r = 0;
        for (r = 0; r < array.length; r++)
        {
            c = array.length / 2;
            array[r][c] = '*';
        }
        for (c = 0; c < array.length; c++)
        {
            r = array.length / 2;
            array[r][c] = '*';
        }
        for (r = 1; r < array.length - 1; r++)
        {
            c = array.length / 2 + 1;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 + 2;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 - 1;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 - 2;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = 0;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = 1;
            array[r][c] = '*';
        }
        for (r = 3; r < array.length - 3; r++)
        {
            c = array.length - 2;
            array[r][c] = '*';
        }
    }

    /**
     * The diamond method takes a 2D array of characters as a parameter,
     * and returns nothing. Its pattern should resemble a diamond.
     */
    public static void diamond (char array [] [])
    {
        int c = 0;
        int r = 0;
        for (r = 0; r < array.length; r++)
        {
            c = array.length / 2;
            array[r][c] = '*';
        }
        for (c = 0; c < array.length; c++)
        {
            r = array.length / 2;
            array[r][c] = '*';
        }
        for (r = 1; r < array.length - 1; r++)
        {
            c = array.length / 2 + 1;
            array[r][c] = '*';
        }
        for (r = 1; r < array.length - 1; r++)
        {
            c = array.length / 2 - 1;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 + 2;
            array[r][c] = '*';
        }
        for (r = 2; r < array.length - 2; r++)
        {
            c = array.length / 2 - 2;
            array[r][c] = '*';
        }
        for (r = 3; r < array.length - 3; r++)
        {
            c = array.length - 2;
            array[r][c] = '*';
        }
        for (r = 3; r < array.length - 3; r++)
        {
            c = array.length / array.length;
            array[r][c] = '*';
        }
    }
}