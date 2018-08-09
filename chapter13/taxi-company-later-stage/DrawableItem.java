import java.awt.Image;
    
/**
 * An item that is able to return an image of itself.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002.07.02
 */

public interface DrawableItem extends Item
{
    public Image getImage();
}
