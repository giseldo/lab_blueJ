/**
 * Class Brick - models a simple brick.
 * 
 * @author: Michael Kolling
 * @version: 2002.02.08
 */
public class Brick
{
    // Constant.
    private static final int WEIGHT_PER_CM3 = 2;  // weight per cubic cm in grams

    // instance variables:
    private int height;
    private int width;
    private int depth;

    /**
     * Create a Brick. Parameters are edge lengths in centimeters.
     */
    public Brick(int height, int width, int depth)
    {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Return the surface area of this brick in square centimeters.
     */
    public double getSurfaceArea()
    {
        double side1 = width * height;
        double side2 = width * depth;
        double side3 = depth * height;
        double total = (side1 + side1 + side3) * 2;

        return total;
    }

    /**
     * Return the weight of this brick in kg.
     */
    public double getWeight()
    {
        return (getVolume() * WEIGHT_PER_CM3) / 1000;
    }

    /**
     * Return the volume of this brick in qubic centimeters.
     */
    public int getVolume()
    {
        return width * height * depth;
    }

    public double getHeight()
    {
        return height;
    }
}
