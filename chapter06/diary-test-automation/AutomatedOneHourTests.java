/**
 * Perform tests of the Day class that involve
 * making single-hour appointments. Automate these
 * tests as far as possible.
 * 
 * @author David J. Barnes and Michael Kolling. 
 * @version 2001.09.18
 */
public class AutomatedOneHourTests
{
    // The Day object being tested.
    private Day day;

    /**
     * Constructor for objects of class OneHourTests
     */
    public AutomatedOneHourTests()
    {
        // Create a Day object that can be used in testing.
        // Individual methods might choose to create
        // their own instances.
        day = new Day(1);
    }

    /**
     * Run each test and check the result. If any result indicates
     * a possible problem, print an error message.
     * @return Whether all tests passed.
     */
    public boolean runAllTests()
    {   
        boolean allPassed = true;
        System.out.println("runAllTests started ...");
        if(!makeThreeAppointments()) {
            System.out.println("makeThreeAppointments() failed.");
            allPassed = false;
        }
        if(!testDoubleBooking()) {
            System.out.println("testDoubleBooking() failed.");
            allPassed = false;
        }
        if(!fillTheDay()) {
            System.out.println("fillTheDay() failed.");
            allPassed = false;
        }
        System.out.println("runAllTests finished");
        return allPassed;
    }

    /**
     * Test basic functionality by booking at either end
     * of a day, and in the middle.
     * @return true if the test was successful, false otherwise.
     */
    public boolean makeThreeAppointments()
    {
        // Start with a fresh Day object.
        day = new Day(1);
        // Create three one-hour appointments.
        Appointment first = new Appointment("Java lecture", 1);
        Appointment second = new Appointment("Java class", 1);
        Appointment third = new Appointment("Meet John", 1);
        
        // Assume that the test is passed unless we discover
        // otherwise.
        boolean passed = true;
        // Make each appointment at a different time.
        passed &= day.makeAppointment(9, first);
        passed &= day.makeAppointment(13, second);
        passed &= day.makeAppointment(17, third);
        
        // Check that each appointment was made at the
        // correct time.
        passed &= day.getAppointment(9) == first;
        passed &= day.getAppointment(13) == second;
        passed &= day.getAppointment(17) == third;
        return passed;
    }
    
    /**
     * Check that double-booking is not permitted.
     * @return true if the test was successful, false otherwise.
     */
    public boolean testDoubleBooking()
    {
        // Assume that the test is passed unless we discover
        // otherwise.
        boolean passed = true;
        // Set up the day with three legitimate appointments.
        passed = makeThreeAppointments();
        Appointment badAppointment = new Appointment("Error", 1);
        
        // The time we will try to double book at.
        int time = 9;
        // Take a copy of the appointment at that time,
        // to ensure that it is not changed by the next test.
        Appointment first = day.getAppointment(time);
        // Note that we want this attempt to fail.
        passed &= !day.makeAppointment(time, badAppointment);
        // Check that first is still where it should be.
        passed &= day.getAppointment(time) == first;
        return passed;
    }

    /**
     * Test basic functionality by filling a complete
     * day with appointments.
     * @return true if the test was successful, false otherwise.
     */
    public boolean fillTheDay()
    {
        // Start with a fresh Day object.
        day = new Day(1);
        // Ensure that all appointments can be made.
        boolean passed = true;
        for(int time = Day.START_OF_DAY;
                    time <= Day.FINAL_APPOINTMENT_TIME;
                        time++) {
            passed &= day.makeAppointment(time,
                                new Appointment("Test " + time, 1));
        }
        // Check that all appointment times are now occupied.
        for(int time = Day.START_OF_DAY;
                    time <= Day.FINAL_APPOINTMENT_TIME;
                        time++) {
            passed &= day.getAppointment(time) != null;
        }
        return passed;
    }
}
