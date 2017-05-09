import java.util.List;

/**
 * Created by Olve on 07.05.2017.
 */
public interface DiceInterface<T> {

    /**
     * returns the array containing the dice of the dice.
     * @return array of the dice of the dice
     */
    public List<T> getValues();

    /**
     * Sets the value of the sides of the dice to be those contained in the input list. Frequencies are reset.
     * @param sides is a List containing the new sides of the dice
     */
    public void setValues(List<T> sides);

    /**
     * sets the side value at a particular index of the dice
     * @param index where we wish to insert the side
     * @param value that we wish to insert at given index
     * @return true if operation successful, false if index out of bounds or no dice side at index.
     */
    public boolean setSideValue(int index, T value);

    /**
     * Gets the side value at a particular index of the dice
     * @param index which we wish to retrieve a side value from
     */
    public T getSideValue(int index);

    /**
     * Get the first index of an object that matches the side you specify
     * @param side that you wish to return the index of
     * @return the index of side, given that it exists. Otherwise -1.
     */
    public int indexOf(T side);

    /**
     * returns the amount of times a given side has come up during the lifetime of this DiceInterface instance
     * @param value is the side that we would like to check the frequency of
     * @return the frequency of the specified side
     */
    public int getFrequencyOfValue(T value);

    /**
     * Throw the dice, which will turn up a side on the dice and increment the frequency counter for that side
     * @return the side that has turned up.
     */
    public T throwDice();

}
