/**
 * A class to model an item (or set of items) in an
 * auction: a lot.
 * @author David J. Barnes and Michael Kolling.
 * @version 2001.06.08
 */
public class Lot
{
    // A unique identifying number.
    private final int number;
    // A description of the lot.
    private String description;
    // The current highest bid for this lot.
    private Bid highestBid;

    /**
     * Construct a Lot, setting its number and description.
     * @param number The lot number.
     * @param description A description of this lot.
     */
    public Lot(int number, String description)
    {
        this.number = number;
        this.description = description;
    }

    /**
     * Attempt to bid for this lot. A successful bid
     * must have a value higher than any existing bid.
     * @param bidder Who is bidding.
     * @param value The value of the bid.
     */
    public void bidFor(Person bidder, long value)
    {
        // We trust that lot is genuine. There is nothing to
        // prevent a spurious lot from being bid for, but it
        // would not appear in the auction list.
        if((highestBid == null) ||
               (highestBid.getValue() < value)) {
            // This bid is the best so far.
            setHighestBid(new Bid(bidder, value));
        }
        else {
            System.out.println("Lot number: " + getNumber() +
                               " (" + getDescription() + ")" +
                               " already has a bid of: " +
                               highestBid.getValue());
        }
    }

    /**
     * @return The lot's number.
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * @return The lot's description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The highest bid for this lot. This could be null if
     *         there are no current bids.
     */
    public Bid getHighestBid()
    {
        return highestBid;
    }

    /**
     * @param highestBid The new highest bid.
     */
    private void setHighestBid(Bid highestBid)
    {
        this.highestBid = highestBid;
    }
}
