import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a only taxis.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002.07.02
 */
public class TaxiCompany  
{
    // The vehicles operated by the company.
    private List vehicles;
    private City city;
    // The associations between vehicles and the passengers
    // they are to pick up.
    private Map assignments;

    private static final int NUMBER_OF_TAXIS = 3;

    /**
     * @param city The city.
     */
    public TaxiCompany(City city)
    {
        this.city = city;
        vehicles = new LinkedList();
        assignments = new HashMap();
        setupVehicles();
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        Vehicle vehicle = scheduleVehicle();
        if(vehicle != null) {
            assignments.put(vehicle, passenger);
            vehicle.setPickupLocation(passenger.getPickupLocation());
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * A vehicle has arrived at a pickup point.
     * @param The vehicle at the pickup point.
     * @throws MissingPassengerException If there is no passenger waiting.
     */
    public void arrivedAtPickup(Vehicle vehicle)
    {
        Passenger passenger = (Passenger) assignments.remove(vehicle);
        if(passenger == null) {
            throw new MissingPassengerException(vehicle);
        }
        city.removeItem(passenger);
        vehicle.pickup(passenger);
    }
    
    /**
     * A vehicle has arrived at a passenger's destination.
     * @param The vehicle at the destination.
     * @param The passenger being dropped off.
     */
    public void arrivedAtDestination(Vehicle vehicle,
                                     Passenger passenger)
    {
    }
    
    /**
     * @return The list of vehicles.
     */
    public List getVehicles()
    {
        return vehicles;
    }
    
    /**
     * Find a free vehicle, if any.
     * @return A free vehicle, or null if there is none.
     */
    private Vehicle scheduleVehicle()
    {
        Iterator it = vehicles.iterator();
        while(it.hasNext()) {
            Vehicle vehicle = (Vehicle) it.next();
            if(vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Set up this company's vehicles. The optimum number of
     * vehicles should be determined by analysis of the
     * data gathered from the simulation.
     *
     * Vehicles start at random locations.
     */
    private void setupVehicles()
    {
        int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();
        // Used a fixed random seed for predictable behavior.
        // Use different seeds for less predictable behavior.
        Random rand = new Random(12345);

        // Create the taxis.
        for(int i = 0; i < NUMBER_OF_TAXIS; i++){
            Taxi taxi =
                new Taxi(this,
                         new Location(rand.nextInt(cityWidth),
                                      rand.nextInt(cityHeight)));
            vehicles.add(taxi);
            city.addItem(taxi);
        }
   }
}
