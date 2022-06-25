/*
 * The counter class implements a counter that rolls over to the initial value
 * when the counter hits the maximum value.
 *
 * Team Name: Falcon and the Winter Soldier
 * @authors: Saravana Polisetti, Daiwik Swaminathan
 * @version 4.0
 */

/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 *
 * @author Charles Hoot
 * @version 4.0
 */
public class Counter {

    private int min, max, counter = 0;
    private boolean checker = false;
    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter() {
        min = 0;
        max = Integer.MAX_VALUE;
        counter = min;
    }


    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max) {
        this.min = min;
        this.max = max;
        counter = this.min;
        if(this.min >= this.max)
            throw new CounterInitializationException("Minimum is larger than Maximum");
    }

    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject) {
        boolean result = true;
        if (otherObject instanceof Counter) {
            if((this.min == ((Counter) otherObject).min) && (this.max == ((Counter) otherObject).max) &&
                    (this.checker == ((Counter) otherObject).checker) &&  (this.counter == ((Counter) otherObject).counter)) {
                result = true;
            }
            else
                result = false;
        }
        return result;
    }



    /**
     * Increases the counter by one
     */
    public void increase() {
        counter++;

        if(counter > max) {
            checker = true;
            counter = min;
        }
        else
            checker = false;
    }


    /**
     * Decreases the counter by one
     */
    public void decrease() {
        counter--;
        if(counter < min) {
            checker = true;
            counter = max;
        }
        else
            checker = false;
    }

    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value() {
        return counter;

    }


    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver() {
        return checker;
    }

    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        return "Min should have " + this.min + ", and Max should have " + this.max;
    }

}