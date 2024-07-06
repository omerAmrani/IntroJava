package mmn_11;

import java.util.Scanner;

/**
 * Class: Triangle.java
 * Author: Omer Amrani
 * ID: 207804899
 * Date: 27.03.2024
 */
public class Triangle {
    /**
     * The function received 3 sizes of triangle and output the
     * perimeter and area of the given triangle.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the area "
                + "and the perimeter of a given triangle. ");
        System.out.println("Please enter the three lengths"
                + " of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println("The lengths of the triangle sides are: " + a + ", "
                + b + ", " + c);

        // The sides must follow Triangle Inequality Theorem
        if ((a + b > c) && (b + c > a) && (a + c > b)) {
            // Calculate perimeter and area
            int perimeter = a + b + c;
            double p = (double) perimeter / 2;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

            System.out.println("The perimeter of the triangle is: " + perimeter);
            System.out.println("The area of the triangle is: " + area);
        } else {
            System.out.println("The given three sides don't represent a triangle");
        }
    }
}
