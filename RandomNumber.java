/**
 * A class to generate integer RandomNumber in the given range.
 *
 * @author Sampreeth Amith Kumar
 * @version 08.05.2020
 */
public class RandomNumber
{
    //randomNumber to store the generated random integer.
    private int randomNumber;
    
    /**
     * Create a RandomNumber from 1 to maximun value.
     * @param maxValue is the maximun range from 1
     */
    public RandomNumber(int maxValue)
    {
        randomNumber = (int) (Math.random()*(maxValue)+1);
    }
    
    /**
     * Return random number 
     * @return random number 
     */
    public int getRandomNumber()
    {
        return randomNumber;
    }
}
