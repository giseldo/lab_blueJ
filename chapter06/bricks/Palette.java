
/**
 * A palette is a stack of bricks on a wooden base.
 *
 * @author: Michael Kolling
 * @version: 2002.02.08
 */
public class Palette
{
    // constants:
    private static final double baseWeight = 6.5;  // in kg
    private static final double baseHeight = 15;  // in cm

    private Brick aBrick;
    private int bricksInPlane;
    private int height;

    /**
     * Create a palette with a given number of bricks.
     * 'bricksInPlane' is the number of bricks in each level on the base.
     * 'height' is the number of bricks stacked on top of each other.
     */
    public Palette(int bricksInPlane, int height)
    {
        this.bricksInPlane = bricksInPlane;
        this.height = height;
        aBrick = new Brick(8, 20, 12);
    }

    /**
     * Return the base of the palette (in kg)
     */
    public double getWeight()
    {
        int numberOfBricks = bricksInPlane * height;
        return aBrick.getWeight() * numberOfBricks;
    }

    /**
     * Return the height of this stack (in cm)
     */
    public double getHeight()
    {
        return (aBrick.getHeight() % height) + baseHeight;
    }
}
