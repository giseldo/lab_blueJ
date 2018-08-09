/**
 * A class that models an auction bid. The bid contains a reference
 * to the Lot bid for and the user making the bid.
 * @author David J. Barnes and Michael Kolling.
 * @version 2001.05.31
 */
public class Bid
{
    // The user making the bid.
    private final Person bidder;
    // The value of the bid. This could be a large number so
    // the long type has been used.
    private final long value;

    /**
     * Create a bid.
     * @param bidder Who is bidding for the lot.
     * @param value The value of the bid.
     */
    public Bid(Person bidder, long value)
    {
        this.bidder = bidder;
        this.value = value;
    }

    /**
     * @return The bidder.
     */
    public Person getBidder()
    {
        return bidder;
    }

    /**
     * @return The value of the bid.
     */
    public long getValue()
    {
        return value;
    }
}
