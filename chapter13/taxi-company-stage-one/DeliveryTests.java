import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * A test rig for testing the pickup and delivery actions
 * in stage one of the development.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002.07.02
 */
public class DeliveryTests
{
    // In case of errors, limit the number of steps for tests
    // to ensure that they will eventually terminate.
    private static final int STEP_LIMIT = 500;
    // The list of actors.
    private List actors;
    // The single taxi to be used in the test.
    private Taxi taxi;
    // The single passenger to be used in the test.
    private Passenger passenger;
    // The taxi company.
    private TaxiCompany company;
    private Location taxiLocation;

    /**
     * Setup to run tests for stage one of the implementation.
     */
    public DeliveryTests()
    {
        actors = new LinkedList();
        setupDefaultLocations();
    }
    
    /**
     * Run a single delivery test.
     * Different taxi and passenger locations can be specified
     * via setupLocations, in order to test that
     * taxi movement in different directions works correctly.
     * @return true If the task is completed in the expected number
     *              of steps, false otherwise.
     */
    public boolean runDeliveryTest()
    {
        int expectedSteps = testSetup();
        int actualSteps = deliveryTest();
       return actualSteps == expectedSteps && taxi.isFree(); 
    }
    
    /**
     * Receive the locations to be used in the test.
     * The passenger is created.
     * @param taxiLocation Where the taxi starts from.
     * @param pickupLocation Where to pickup from.
     * @param passengerDestination Where the passenger wishes to go to.
     */
    public void setupLocations(Location taxiLocation, Location pickupLocation,
                               Location passengerDestination)
    {
        this.taxiLocation = taxiLocation;
        passenger = new Passenger(pickupLocation,
                                  passengerDestination);
    }
    
    /**
     * A pickup is requested for the passenger.
     * The test is run until the single taxi becomes free again,
     * or the step limit is reached.
     * @throws IllegalStateException If a pickup cannot be found for
     *                               the passenger.
     * @return The number of steps taken.
     */
    private int deliveryTest()
    {
        System.out.println("Request pickup for " + passenger +
                           " from " + taxi);
        if(!company.requestPickup(passenger)) {
            throw new IllegalStateException("No pickup found.");
        }

        int steps = 0;
        while(!taxi.isFree() && steps < STEP_LIMIT) {
            step();
            steps++;
        }
        return steps;
    }

    /**
     * Run the simulation for one step by requesting
     * all actors to act.
     */
    private void step()
    {
        Iterator it = actors.iterator();
        while(it.hasNext()) {
            Actor actor = (Actor) it.next();
            actor.act();
        }
    }
    
    /**
     * Create a default set of locations for the taxi and passenger.
     */
    private void setupDefaultLocations()
    {
        setupLocations(new Location(0, 0), new Location(0, 1),
                       new Location(0, 2));
    }
    
    /**
     * Create a taxi company and taxi to be used in the delivery test.
     * @return The number of steps it should take to complete the test.
     */
    private int testSetup()
    {
        company = new TaxiCompany();
        taxi = new Taxi(company, taxiLocation);
        List vehicles = company.getVehicles();
        vehicles.add(taxi);

        actors.addAll(vehicles);
        
        // Calculate the number of steps required for the test.
        Location pickupLocation = passenger.getPickupLocation();
        Location destination = passenger.getDestination();
        return taxiLocation.distance(pickupLocation) +
                    pickupLocation.distance(destination);
    }
}
