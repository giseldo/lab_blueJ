import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A class to maintain an arbitrary number of contact details.
 * Details are indexed by both name and phone number.
 * @author David J. Barnes and Michael Kolling.
 * @version 2002.06.11
 */
public class AddressBook implements Serializable
{
    // Storage for an arbitrary number of details.
    private TreeMap book;
    private int numberOfEntries;

    /**
     * Perform any initialization for the address book.
     */
    public AddressBook()
    {
        book = new TreeMap();
        numberOfEntries = 0;
    }
    
    /**
     * Look up a name or phone number and return the
     * corresponding contact details.
     * @param key The name or number to be looked up.
     * @return The details corresponding to the key.
     */
    public ContactDetails getDetails(String key)
    {
        return (ContactDetails) book.get(key);
    }

    /**
     * Return whether or not the current key is in use.
     * @param key The name or number to be looked up.
     * @return true if the key is in use, false otherwise.
     */
    public boolean keyInUse(String key)
    {
        return book.containsKey(key);
    }

    /**
     * Add a new set of details to the notebook.
     * @param details The details to associate with the person.
     */
    public void addDetails(ContactDetails details)
    {
        if(details != null) {
            book.put(details.getName(), details);
            book.put(details.getPhone(), details);
            numberOfEntries++;
        }
    }
    
    /**
     * Change the details previously stored under the given key.
     * @param oldKey One of the keys used to store the details.
                     This should be a key that is currently in use.
     * @param details The replacement details.
     */
    public void changeDetails(String oldKey,
                              ContactDetails details)
    {
        if(keyInUse(oldKey) && details != null) {
            removeDetails(oldKey);
            addDetails(details);
        }
    }
    
    /**
     * Search for all details stored under a key that starts with
     * the given prefix.
     * @param keyPrefix The key prefix to search on. This may be
     *                  of zero length, but must not be null.
     * @return An array of those details that have been found.
     */
    public ContactDetails[] search(String keyPrefix)
    {
        // Build a list of the matches.
        LinkedList matches = new LinkedList();
        if(keyPrefix != null) {
            // Find keys that are equal-to or greater-than the prefix.
                SortedMap tail = book.tailMap(keyPrefix);
            Iterator it = tail.keySet().iterator();
            // Stop when we find a mismatch.
            boolean endOfSearch = false;
            while(!endOfSearch && it.hasNext()) {
                String key = (String) it.next();
                if(key.startsWith(keyPrefix)) {
                    matches.add(book.get(key));
                }
                else {
                    endOfSearch = true;
                }
            }
        }
        ContactDetails[] results =
                        new ContactDetails[matches.size()];
        matches.toArray(results);
        return results;
    }

    /**
     * @return The number of entries currently in the
     *         address book.
     */
    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }

    /**
     * Remove the entry with the given key from the address book.
     * The key should be one that is currently in use.
     * @param key One of the keys of the entry to be removed.
     */
    public void removeDetails(String key)
    {
        if(keyInUse(key)) {
            ContactDetails details =
                        (ContactDetails) book.get(key);
            book.remove(details.getName());
            book.remove(details.getPhone());
            numberOfEntries--;
        }
    }

    /**
     * @return A list of all the contact details, sorted according
     * to the sort order of the ContactDetails class.
     */
    public String listDetails()
    {
        // Because each entry is stored under two keys, it is
        // necessary to build a set of the ContactDetails. This
        // eliminates duplicates.
        StringBuffer allEntries = new StringBuffer();
        TreeSet sortedDetails = new TreeSet(book.values());
        Iterator it = sortedDetails.iterator();
        while(it.hasNext()) {
            ContactDetails details = (ContactDetails) it.next();
            allEntries.append(details);
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
}
