package unl.soc;

import java.util.ArrayList;
import java.util.List;

public class WaterUtils {

    /**
     * Calculates the remaining amount of water each household is allowed to use.
     *
     * @param limit The limit of water usage for each household.
     * @param usage The current water usage for each household.
     * @return A list containing the remaining amount of water each household is allowed to use.
     */
    public static List<Double> getRemainingWater(double limit, List<Double> usage) {
        List<Double> remuainingWater = new ArrayList<>();

        for (Double used : usage) {
            double remaining = Math.max(0.0, limit - used);
            remainingWater.add(remaining);
        }

        return remainingWater;
    }

    /**
     * Calculates the average rainfall based on the provided rainfall map.
     *
     * @param map The two-dimensional array representing the rainfall map.
     * @return The average rainfall.
     */
    public static double averageRainfall(double[][] map) {
        int validDataPoints = 0;
        double totalRainfall = 0.0;

        for (double[] row : map) {
            for (double value : row) {
                if (value >= 0.0) {
                    totalRainfall += value;
                    validDataPoints++;
                }
            }
        }

        if (validDataPoints == 0) {
            return 0.0; // Return 0 if no valid data points are available.
        }

        return totalRainfall / validDataPoints;
    }
}

