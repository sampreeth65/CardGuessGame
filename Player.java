/**
 * A class to hold player details
 *
 * @author  Sampreeth Amith Kumar 
 * @version 08.05.2020
 */
public class Player
{
    //fields for storing playerName,PlayerScore and game details. 
    private String name;
    private int score;
    private String guess;
    private int highestScore;
    private int numberOfGamesPlayed;
    private int numberOfGamesWon;

    /**
     * Create Player to initialize the fields.
     */
    public Player()
    {
        name = "abc";
        score = 40;
        guess = "";
        highestScore = 0;
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;
    }

    /**
     * Create Player to initialize the fields.
     * @param newName name of the player.
     */
    public Player(String newName)
    {
        name = newName;
        score = 40;
        guess = ""; //last suite or number guessed
        highestScore = 0;
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;
    }

    /**
     * Return the guess made by the player.
     * @return last guess.
     */
    public String getGuess()
    {
        return guess;
    }

    /**
     * Return highest score in the game.
     * @return overall highest score.
     */
    public int getHighestScore()
    {
        return highestScore;
    }

    /**
     * Return the name of the player.
     * @return player name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return total games played
     * @return total number of games played.
     */
    public int getNumberOfGamesPlayed()
    {
        return numberOfGamesPlayed;
    }

    /**
     * Return number of games won by the player.
     * @return number of games won by the player.
     */
    public int getNumberOfGamesWon()
    {
        return numberOfGamesWon;
    }

    /**
     * Return the score at the end of game.
     * @return the final score at the end of each game.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Set the last guess made by the user.
     * @param newGuess guess made by the user.
     */
    public void setGuess(String newGuess)
    {
        if (newGuess.length() == 0)
            guess = newGuess;
        else
            guess = guess + newGuess;
    }

    /**
     * Set the Highest Score made by the user.
     * @param newHighestScore is compared with the old score 
     * if newHighestScore is greater then set that to
     * higeshtScore.
     */
    public void setHighestScore(int newHighestScore)
    {
        if (newHighestScore > highestScore)
            highestScore = newHighestScore;
    }

    /**
     * Set the name of the player.
     * @param newName sets the name of the player.
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Set number of games played
     * @param newNumberOfGamesPlayed increases by one each time player
     * plays a game.
     */
    public void setNumberOfGamesPlayed(int newNumberOfGamesPlayed)
    {
        numberOfGamesPlayed = newNumberOfGamesPlayed;
    }

    /**
     * Set number of Games won
     * @param newNumberOfGamesWon increases by one, when player score
     * is greater then zero.
     */
    public void setNumberOfGamesWon(int newNumberOfGamesWon)
    {
        numberOfGamesWon = newNumberOfGamesWon;
    }

    /**
     * Set score of each game.
     * @param newScore set game score.
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }
}