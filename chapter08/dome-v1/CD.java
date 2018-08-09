/**
 * The CD class represents a CD object. Information about the 
 * CD is stored and can be retrieved.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2002-05-02
 */
public class CD
{
    private String title;
    private String artist;
    private int numberOfTracks;
    private int playingTime;
    private boolean gotIt;
    private String comment;

    /**
     * Initialize the CD.
     */
    public CD(String theTitle, String theArtist, int tracks, int time)
    {
        title = theTitle;
        artist = theArtist;
        numberOfTracks = tracks;
        playingTime = time;
        gotIt = false;
        comment = "<no comment>";
    }

    /**
     * Enter a comment for this CD.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * Return the comment for this CD.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Set the flag indicating whether we own this CD.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * Return information whether we own a copy of this CD.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Print details about this CD to the text terminal.
     */
    public void print()
    {
        System.out.print("CD: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + artist);
        System.out.println("    tracks: " + numberOfTracks);
        System.out.println("    " + comment);
    }
}
