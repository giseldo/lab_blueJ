/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2002.07.02
 */
public class LocationTests
{
    /**
     * Constructor for objects of class LocationTests
     */
    public LocationTests()
    {
    }

    /**
     * Test the distance method of the Location class.
     * @return true if all tests pass, false otherwise.
     */
    public boolean runDistanceTests()
    {
        boolean ok = true;
        int startX = 10, startY = 10;
        Location startLocation = new Location(startX, startY);
        
        // Calculate the distance from startLocation to other
        // locations around it. The distance should always
        // be equal to offset.
        int offset = 5;
        ok &= startLocation.distance(
            new Location(startX, startY + offset)) == offset;
        ok &= startLocation.distance(
            new Location(startX + offset, startY)) == offset;
        ok &= startLocation.distance(
            new Location(startX + 1, startY + offset)) == offset;
        ok &= startLocation.distance(
            new Location(startX + offset, startY + 1)) == offset;
        ok &= startLocation.distance(
            new Location(startX + offset, startY + offset)) == offset;
        ok &= startLocation.distance(
            new Location(startX + offset - 1, startY + offset)) == offset;
        ok &= startLocation.distance(
            new Location(startX + offset, startY + offset - 1)) == offset;
        return ok;
    }
    
    /**
     * Run tests of the nextLocation method of the Location class.
     * @return true if all tests pass, false otherwise.
     */
    public boolean runNextLocationTests()
    {
        boolean ok = true;
        int startX = 10, startY = 10;
        Location startLocation = new Location(startX, startY);
        
        Location destination;
        Location nextLocation;
        // Test immediate adjacency.
        // (x, y) offsets for each direction from (startX, startY).
        int[][] offsets = {
            { 0, 1, 0, 1, -1, 0, -1, 1, -1},
            { 0, 0, 1, 1, 0, -1, -1, -1, 1},
        };

        for(int i = 0; i < offsets[0].length; i++) {
            destination = new Location(startX + offsets[0][i],
                                       startY + offsets[1][i]);
            nextLocation = startLocation.nextLocation(destination);
            ok &= nextLocation.equals(destination);
        }

        // Test with destination that are not adjacent.
        // Use different values for xDist and yDist for more
        // varied tests.
        int xDist = 7;
        int yDist = 3;
        for(int i = 0; i < offsets[0].length; i++) {
            destination = new Location(startX + xDist * offsets[0][i],
                                       startY + yDist * offsets[1][i]);
            Location expectedNextLocation =
                        new Location(startX + offsets[0][i],
                                     startY + offsets[1][i]);
            nextLocation = startLocation.nextLocation(destination);            
            ok &= expectedNextLocation.equals(nextLocation);
        }
        return ok;
    }
}
