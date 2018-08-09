/**
 * Name, address and telephone number details.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2002.05.08
 */
public class ContactDetails implements Comparable
{
    private String name;
    private String phone;
    private String address;

    /**
     * Set up the contact details. All details are trimmed to remove
     * trailing white space.
     * @param name The name.
     * @param phone The phone number.
     * @param address The address.
     * @throws IllegalStateException If both name and phone are blank.
     */
    public ContactDetails(String name, String phone, String address)
    {
        // Use blank strings if any of the arguments is null.
        if(name == null) {
            name = "";
        }
        if(phone == null) {
            phone = "";
        }
        if(address == null) {
            address = "";
        }

        this.name = name.trim();
        this.phone = phone.trim();
        this.address = address.trim();

        if(this.name.length() == 0 && this.phone.length() == 0) {
            throw new IllegalStateException(
                      "Either the name or phone must not be blank.");
        }
    }
    
    /**
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The telephone number.
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @return The address.
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * Provide a content-equality test.
     */
    public boolean equals(Object other)
    {
        if(other instanceof ContactDetails) {
            ContactDetails otherDetails = (ContactDetails) other;
            return name.equals(otherDetails.getName()) &&
                    phone.equals(otherDetails.getPhone()) &&
                     address.equals(otherDetails.getAddress());
        }
        else {
            return false;
        }
    }
    
    /**
     * Compare these details against another set, for the purpose
     * of sorting. The fields are sorted by name, phone, and address.
     */
    public int compareTo(Object other)
    {
        ContactDetails otherDetails = (ContactDetails) other;
        int comparison = name.compareTo(otherDetails.getName());
        if(comparison != 0) {
            return comparison;
        }
        comparison = phone.compareTo(otherDetails.getPhone());
        if(comparison != 0) {
            return comparison;
        }
        return address.compareTo(otherDetails.getAddress());
    }

    /**
     * @return A multi-line string containing the name, phone, and address.
     */
    public String toString()
    {
        return name + "\n" + phone + "\n" + address;
    }
}
