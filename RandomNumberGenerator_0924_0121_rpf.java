// 代码生成时间: 2025-09-24 01:21:28
import java.util.Random;

public class RandomNumberGenerator {

    // The Random instance used for generating random numbers.
    private final Random random;

    /**
     * Constructor for RandomNumberGenerator.
     * Initializes the Random instance.
     */
    public RandomNumberGenerator() {
        this.random = new Random();
    }

    /**
     * Generates a random number between the specified minimum and maximum values.
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (exclusive).
     * @return The generated random number.
     * @throws IllegalArgumentException If min is greater than max.
     */
    public int generateRandomNumber(int min, int max) {
        // Check if the minimum value is greater than the maximum value.
        if (min > max) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value.");
        }

        // Calculate the range of random numbers.
        int range = max - min;

        // Generate and return the random number.
        return random.nextInt(range) + min;
    }

    /**
     * Main method for demonstration purposes.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try {
            RandomNumberGenerator rng = new RandomNumberGenerator();
            int randomNum = rng.generateRandomNumber(1, 10);
            System.out.println("Generated random number: " + randomNum);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}