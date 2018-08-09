/**
 * The Video class represents a video object. Information about the 
 * video is stored and can be retrieved.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2002-05-04
 */
public class Video extends Item 
{
    private String director;

    /**
     * Constructor for objects of class Video
     */
    public Video(String theTitle, String theDirector, int time)
    {
        super(theTitle, time);
        director = theDirector;
    }

    /**
     * Return the director for this video.
     */
    public String getDirector()
    {
        return director;
    }
}
