import java.util.Random;

/**
 * Created by Olve on 07.05.2017.
 */
public class NumberDice implements DiceInterface<Integer> {
    Integer[][] sides = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0}};
    int UPPER_RANGE;

    public NumberDice() {
        UPPER_RANGE = sides.length-1;
    }

    /**
     * returns the amount of times a given side has come up during the lifetime of this DiceInterface instance
     *
     * @param side is the side that we would like to check the frequency of
     * @return the frequency of the specified side
     */
    public int getFrequencyOfSide(Integer side){
        for (int i = 0; i < sides.length; i++) {
            if(sides[i][0].equals(side)){
                return sides[i][1];
            }
        }
        return -1;
    }

    /**
     * returns the array containing two-place arrays of sides at i=0 and their frequencies at i=1.
     * @return array of side-frequency pairs in arrays
     */
    public Integer[][] getSides() {
        return sides;
    }


    /**
     * sets the side at a particular index in the side-frequency array
     *
     * @param index where we wish to insert the side
     * @param side  that we wish to insert at given index
     */
    public void setSide(int index, Integer side) {
        sides[index][0] = side;
    }

    /**
     * Gets the side at a particular index in the side-frequency array
     *
     * @param index which we wish to retrieve a side from
     */
    public Integer getSide(int index) {
        return sides[index][0];
    }

    /**
     * Get the first index of an object that matches the side you specify
     *
     * @param side that you wish to return the index of
     * @return the index of side, given that it exists. Otherwise -1.
     */
    public int getIndexOfSide(Integer side) {
        for (int i = 0; i < sides.length; i++) {
            if(sides[i].equals(side)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Setter for the array of side-frequency pairs
     *
     * @param sides
     */
    public void setSides(Integer[][] sides) {
        this.sides = sides;
    }

    /**
     * Throw the dice, which will turn up a side on the dice and increment the frequency counter for that side
     * @return the side that has turned up.
     */
    public Integer throwDice(){
        Random random = new Random();
        int diceThrow = random.nextInt(UPPER_RANGE);
        sides[diceThrow][1]++; //increments the frequency of this particular side showing
        return sides[diceThrow][0]; //returns the showing side
    }

    private static int findIndex(Object item, Object[] array){
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
}
