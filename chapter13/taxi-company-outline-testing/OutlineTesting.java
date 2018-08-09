/**
 * Implement some testing of the outline project.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002.07.01
 */
public class OutlineTesting
{
    /**
     */
    public OutlineTesting()
    {
    }
    
    /**
     * Run a set of tests, and report any failures.
     */
    public void runTests()
    {
        if(!sourcePickupTest()) {
            System.out.println("Source-generated passenger pickup failed.");
        }
        if(!taxiPickupTest()) {
            System.out.println("Taxi pickup test failed.");
        }
        if(!passengerCreationTest()) {
            System.out.println("Passenger creation test failed.");
        }
    }

    /**
     * Request the passenger source to generate a new passenger
     * and find a pickup for it.
     * @return true if the request succeeds, false otherwise.
     */
    public boolean sourcePickupTest()
    {
        TaxiCompany company = new TaxiCompany();
        PassengerSource source = new PassengerSource(company);
        return source.requestPickup();
    }
    
    /**
     * Check basic passenger functionality. Ensure that
     * a passenger returns the correct pickup and destination
     * locations.
     * @return true if the test is passed, false otherwise.
     */
    public boolean passengerCreationTest()
    {
        boolean ok = true;
        Location pickup = new Location();
        Location destination = new Location();
        Passenger p = new Passenger(pickup, destination);
        ok &= p.getPickupLocation().equals(pickup);
        ok &= p.getDestination().equals(destination);
        return ok;
    }
    
    /**
     * Test that the following basic sequence is correct:
     *     A newly created taxi is free.
     *     A taxi ceases to be free when it picks up a passenger.
     *     A taxi becomes free when it has offloaded a passenger.
     * @return true if the test is passed, false otherwise.
     */
    public boolean taxiPickupTest()
    {
        boolean ok = true;
        TaxiCompany company = new TaxiCompany();
        Taxi taxi = new Taxi(company, new Location());
        ok &= taxi.isFree();
        Passenger passenger =
            new Passenger(new Location(), new Location());
        taxi.pickup(passenger);
        ok &= !taxi.isFree();
        taxi.offloadPassenger();
        ok &= taxi.isFree();
        return ok;
    }
}
