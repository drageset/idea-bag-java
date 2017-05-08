import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A diceSides that can have values of any type, as long as all the values are of the same type.
 * You can add and remove sides from the diceSides.
 * A side has both a value and a frequency.
 * The value of the side is "the thing you see" on a physical diceSides,
 * while the frequency is the amount of times this side has been rolled.
 * Created by Olve on 08.05.2017.
 */
public class GenericDice<T> {

    private List<DiceSide<T>> diceSides = new ArrayList<DiceSide<T>>(6);

    public GenericDice(ArrayList<T> sides){
        setValues(sides);
    }

    public GenericDice(List<DiceSide<T>> newDiceSides){
        diceSides = newDiceSides;
    }

    /**
     * Give the diceSides a new set of sides, and set frequencies to 0, making the diceSides completely fresh.
     * @param newSideValues is a List of values
     */
    public void setValues(List<T> newSideValues) {
        List<DiceSide<T>> newDice = new ArrayList<DiceSide<T>>(newSideValues.size());
        for (T sideValue : newSideValues){
            DiceSide<T> side = new DiceSide<T>(sideValue);
            newDice.add(side);
        }
        this.diceSides = newDice;
    }

    /**
     * returns a List with the values that are on the sides of the diceSides
     * @return arraylist of the sides of the diceSides
     */
    public List<T> getSideValues() {
        List<T> sidesOnly = new ArrayList<T>(diceSides.size());
        for (DiceSide<T> side : diceSides) {
            sidesOnly.add(side.getValue());
        }
        return sidesOnly;
    }

    /**
     * Lets you initialize the diceSides with a list of custom diceSides sides that can have non-zero frequencies
     * @param newDiceSides is a list of DiceSides that are to be the new sides of the diceSides.
     */
    public void setDiceSides(List<DiceSide<T>> newDiceSides) {
        this.diceSides = newDiceSides;
    }

    /**
     * Adds a new side to the diceSides, with the specified value, and a frequency of 0
     * @param sideValue
     */
    public void addSide(T sideValue){
        diceSides.add(new DiceSide<T>(sideValue));
    }

    /**
     * returns the cumulative frequency of sides that currently have a certain value.
     * @param sideValue : We return the added frequency off all sides that currently hold this value.
     * @return the frequency of all the sides that have the value sideValue, combined.
     */
    public int getFrequencyOfRoll(T sideValue){
        int frequency = 0;
        for (DiceSide<T> diceSide : diceSides) {
            if (diceSide.getValue().equals(sideValue)){
                frequency += diceSide.getFrequency();
            }
        }
        return -1;
    }

    /**
     * Throw the diceSides, which will turn up a side on the diceSides and increment the frequency counter for that side
     * @return the side that has turned up.
     */
    public T throwDice(){
        Random random = new Random();
        int UPPER_RANGE = diceSides.size()-1;
        int randomArrayIndex = random.nextInt(UPPER_RANGE);
        DiceSide<T> diceSide = diceSides.get(randomArrayIndex);
        diceSide.incrementFrequency();
        return diceSide.getValue(); //returns the value of the showing side
    }

//    /**
//     * Replace the value of exactly one side with the given value
//     * @param oldSideValue the side value to be replaced
//     * @param updatedSideValue the side value to replace the old value
//     */
//    public void replaceSideValue(T oldSideValue, T updatedSideValue){
//        for (DiceSide<T> diceSide : diceSides) {
//            if (diceSide.getValue().equals(oldSideValue)){
//                diceSide.setValue(updatedSideValue);
//                break;
//            }
//        }
//    }
//    /**
//     * Find the index of a side with a certain value
//     * @param targetSideValue
//     * @return
//     */
//    public int indexOf(T targetSideValue) {
//        for (DiceSide<T> diceSide : diceSides) {
//            if (diceSide.getValue().equals(targetSideValue)){
//                return diceSides.indexOf(diceSide);
//            }
//        }
//        return -1;
//    }

    /**
     * This list node-type class stores a value, and the frequency.
     * The value of the side is "the thing you see" on a physical diceSides,
     * while the frequency of the side is the amount of times this side has been rolled.
     * @param <T> is the type of the Dice, meaning the type of stuff that is on all the diceSides
     */
    public class DiceSide<T>{
        private T value;
        private int frequency;

        public DiceSide(T value){
            this.frequency = 0;
            this.value = value;
        }

        public DiceSide(T value, int frequency){
            this.frequency = frequency;
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public void incrementFrequency(){
            frequency++;
        }
    }//  end DiceSide
}// end GenericDice
