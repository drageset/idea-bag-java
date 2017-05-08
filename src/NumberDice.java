import java.util.Random;

/**
 * A dice with 6 sides by default, each side being a number
 * Created by Olve on 07.05.2017.
 */
public class NumberDice implements DiceInterface<Integer> {
    private Object[][] sidesAndFrequencies = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0}};

    public NumberDice() {
    }

    /**
     * Construct a custom dice with any amount of sides that are integers
     * @param sides must be a non-empty array of integers
     */
    public NumberDice(Object[] sides){
        setSides(sides);
    }

    /**
     * returns the amount of times a given side has come up during the lifetime of this DiceInterface instance
     *
     * @param side is the side that we would like to check the frequency of
     * @return the frequency of the specified side
     */
    public int getFrequencyOfSide(Integer side){
        for (Object[] sideFrequencyPair : sidesAndFrequencies){
            if (sideFrequencyPair[0].equals(side)){
                return (Integer) sideFrequencyPair[1];
            }
        }
        return -1;
    }

    /**
     * returns the array containing two-place arrays of sidesAndFrequencies at i=0 and their frequencies at i=1.
     * @return array of side-frequency pairs in arrays
     */
    public Object[] getSides() {
        Object[] sidesOnly = new Object[sidesAndFrequencies.length];
        for (int i = 0; i < sidesAndFrequencies.length; i++) {
            sidesOnly[i] = sidesAndFrequencies[i][0];
        }
        return sidesOnly;
    }


    /**
     * sets the side at a particular index in the side-frequency array
     *
     * @param index where we wish to insert the side
     * @param side  that we wish to insert at given index
     */
    public void setSide(int index, Integer side) {
        sidesAndFrequencies[index][0] = side;
    }

    /**
     * Gets the side at a particular index in the side-frequency array
     *
     * @param index which we wish to retrieve a side from
     */
    public Integer getSide(int index) {
        return (Integer) sidesAndFrequencies[index][0];
    }

    /**
     * Get the first index of an object that matches the side you specify
     *
     * @param side that you wish to return the index of
     * @return the index of side, given that it exists. Otherwise -1.
     */
    public int getIndexOfSide(Integer side) {
        for (int i = 0; i < sidesAndFrequencies.length; i++) {
            if(sidesAndFrequencies[i][0].equals(side)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Setts new sides for the dice, and resets the frequency counters
     * @param newSides is a full array of at least one new side(s) that should be of same type T as the old sides.
     * @throws IllegalArgumentException is thrown if the type of the sides in newSides array does not match the type of the old sides.
     */
    public void setSides(Object[] newSides) throws IllegalArgumentException {
        Object[][] sidesAndFrequencies = new Object[newSides.length][2]; //creates a fresh side dice representation that fits our new sides perfectly
        for (int i = 0; i < newSides.length; i++) {
            if (newSides[i].getClass().equals(getSide(0).getClass())){ //checks if the class of the new side is the same as the class of the first item in the array. This is sufficient for maintaining the dice type.
                throw new IllegalArgumentException("Class of the side(s) in the array given as argument does not match the type of the dice");
            }
            sidesAndFrequencies[i][0] = newSides[i]; //sets the new side
            sidesAndFrequencies[i][1] = 0; //sets the frequency of the side
        }
        this.sidesAndFrequencies = sidesAndFrequencies;
    }

    /**
     * Throw the dice, which will turn up a side on the dice and increment the frequency counter for that side
     * @return the side that has turned up.
     */
    public Integer throwDice(){
        Random random = new Random();
        int UPPER_RANGE = sidesAndFrequencies.length-1;
        int randomArrayIndex = random.nextInt(UPPER_RANGE);
        Object[] sideFrequencyPair = sidesAndFrequencies[randomArrayIndex];
        Integer side = (Integer) sideFrequencyPair[0];
        Integer frequency = (Integer) sideFrequencyPair[1];
        sideFrequencyPair[1] = frequency+1; //increments the frequency of the particular side showing
        return side; //returns the value of the showing side
    }

} // end of NumDice class
