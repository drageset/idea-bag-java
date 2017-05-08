/**
 * Created by Olve on 07.05.2017.
 */
public interface DiceInterface<T> {

    /**
     * returns the array containing the dice of the dice.
     * @return array of the dice of the dice
     */
    public Object[] getSides();

    /**
     * Sets the dice of the dice to be those contained in the input array. Frequencies are not reset.
     * @param sides is an array containing the new dice of the dice
     */
    public void setSides(Object[] sides);

    /**
     * sets the side at a particular index in the side-frequency array
     * @param index where we wish to insert the side
     * @param side that we wish to insert at given index
     */
    public void setSide(int index, T side);

    /**
     * Gets the side at a particular index in the side-frequency array
     * @param index which we wish to retrieve a side from
     */
    public T getSide(int index);

    /**
     * Get the first index of an object that matches the side you specify
     * @param side that you wish to return the index of
     * @return the index of side, given that it exists. Otherwise -1.
     */
    public int getIndexOfSide(T side);

    /**
     * returns the amount of times a given side has come up during the lifetime of this DiceInterface instance
     * @param side is the side that we would like to check the frequency of
     * @return the frequency of the specified side
     */
    public int getFrequencyOfSide(T side);

    /**
     * Throw the dice, which will turn up a side on the dice and increment the frequency counter for that side
     * @return the side that has turned up.
     */
    public T throwDice();

}
