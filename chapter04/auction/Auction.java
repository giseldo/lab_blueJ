import java.util.*;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 * @author David J. Barnes and Michael Kolling.
 * @version 2001.06.08
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * Lots can only by entered into the auction by an
     * Auction object.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lot numbers and lot descriptions in
     * this auction. Include any details of the highest bids.
     */
    public void showLots()
    {
        Iterator it = lots.iterator();
        while(it.hasNext()) {
            Lot lot = (Lot) it.next();
            System.out.println(lot.getNumber() + ": " +
                               lot.getDescription());
            // Include any details of a highest bid.
            Bid highestBid = lot.getHighestBid();
            if(highestBid != null) {
                System.out.println("    Bid: " + 
                                   highestBid.getValue());
            }
            else {
                System.out.println("    (No bid)");
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param number The number of the lot to return.
     */
    public Lot getLot(int number)
    {
        if((number >= 1) && (number < nextLotNumber)) {
            // The number seems to be reasonable.
            Lot selectedLot = (Lot) lots.get(number-1);
            // Include a confidence check to be sure we have the
            // right lot.
            if(selectedLot.getNumber() != number) {
                System.out.println("Internal error: " +
                                   "Wrong lot returned. " +
                                   "Number: " + number);
            }
            return selectedLot;
        }
        else {
            System.out.println("Lot number: " + number +
                               " does not exist.");
            return null;
        }
    }
}
