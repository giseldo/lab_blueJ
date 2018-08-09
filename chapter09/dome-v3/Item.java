/**
 * The Item class represents a multi-media item.
 * Information about the item is stored and can be retrieved.
 * This class serves as a superclass for more specific itms.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2002-05-06
 */
public class Item
{
    private String title;
    private int playingTime;
    private boolean gotIt;
    private String comment;

    /**
     * Initialise the fields of the item.
     */
    public Item(String theTitle, int time)
    {
        title = theTitle;
        playingTime = time;
        gotIt = false;
        comment = "<no comment>";
    }

    /**
     * Enter a comment for this item.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * Return the comment for this item.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Set the flag indicating whether we own this item.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * Return information whether we own a copy of this item.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Print details of this item to the text terminal.
     */
    public void print()
    {
        System.out.print(title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + comment);
    }
}
