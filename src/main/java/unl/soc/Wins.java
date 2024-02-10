package unl.soc;

import java.util.List;

/**
 * Author: Matthew Landers
 *
 * Date: 2024-02-10 
 */	

public class Wins {
    public static void main(String[] args) {
        // Check if the correct number of command line arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: java ExpectedWinsCalculator <points_for> <points_against>");
            System.exit(1);
        }

        try {
            // Parse command line arguments as integers
            int pointsFor = Integer.parseInt(args[0]);
            int pointsAgainst = Integer.parseInt(args[1]);

            // Validate that pointsFor and pointsAgainst are non-negative
            if (pointsFor < 0 || pointsAgainst < 0) {
                System.out.println("Error: Points cannot be negative.");
                System.exit(1);
            }

            // Calculate expected values
            double[] results = calculateExpectedWins(pointsFor, pointsAgainst);

            // Print results
            System.out.printf("Win Percentage: %.2f%%\n", results[0] * 100);
            System.out.printf("Win/Loss: %d/%d\n", (int) results[1], (int) results[2]);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter valid integers for points_for and points_against.");
            System.exit(1);
        }
    }

    public static double[] calculateExpectedWins(int p, int a) {
        try {
            // Calculate expected win percentage using the Pythagorean expectation formula
            double winPercentage = Math.pow(p, 2.37) / (Math.pow(p, 2.37) + Math.pow(a, 2.37));

            // Calculate expected number of wins in a 12-game season
            int expectedWins = (int) Math.round(winPercentage * 12);

            // Calculate expected number of losses
            int expectedLosses = 12 - expectedWins;

            return new double[]{winPercentage, expectedWins, expectedLosses};

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero. Please make sure the denominator is not zero.");
            System.exit(1);
            return null; // Unreachable, added to satisfy the compiler
        }
    }
}
