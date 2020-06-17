/**
 * A class to hold details of card choosen
 *
 * @author Sampreeth Amith Kumar
 * @version 08.05.2020
 */
public class Card
{
   //fields to set the suit,number and guess made by the player.
   private char suit;
   private int number;
   private String guess;
    
   /**
    * Create a Card to store initial values 
    */
    public Card()
    {
        suit = 'H';
        number = 1;
        guess = "";
    }
    
   /**
    * create a Card with inital suit and number 
    * entered by the player.
    * @param newSuit suit value entered by the player.
    * @param newNumber number value entered by the player.
    */
    public Card(char newSuit,int newNumber)
    {
        suit = newSuit;
        number = newNumber;
        guess = "";
    }
    
   /**
    * Return the guess made by player.
    * @return the guess made by player.
    */
    public String getGuess()
    {
        return guess;
    }
    
   /**
    * Return the number choosen by player.
    * @return the number choosen by player.
    */
    public int getNumber()
    {
        return number;
    }
    
   /**
    * Return the suit choosen by player.
    * @return the suit choosen by player.
    */
    public char getSuit()
    {
        return suit;
    }
    
   /**
    * Set guess made by the player.
    * @param newGuess sets the guess made by the player.
    * every new game guess is set to empty.
    */
    public void setGuess(String newGuess)
    {
        if (newGuess.length() == 0)
            guess = newGuess;
        else
            guess = guess + newGuess;
    }
    
   /**
    * Set the number choosen by player.
    * @param newNumber set the number choosen by player.
    */
    public void setNumber(int newNumber)
    {
        number = newNumber;
    }
    
   /**
    * Set suit value choosen by player.
    * @param newSuit set the number choosen by the player.
    */
    public void setSuit(char newSuit)
    {
        suit = newSuit;
    }
}
