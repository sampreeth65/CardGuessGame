import java.util.Scanner;
/**
 * A class to play the card guess game
 * 
 * @author Sampreeth Amith Kumar
 * @version 08.05.2020
 */
public class Game
{
    //Object of Player class to store and retreive player details
    private Player cardGamePlayer;

    /**
     * Create Game
     */
    public Game()
    {
        welcome();
        cardGamePlayer = new Player(enterName());   //creates the object of Player class with parameter
        suitCompare();
    }

    /**
     * Taking input from the user.
     * @return name user name
     */
    public String enterName()
    {
        String name;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.print("Enter your Name: ");
            name = scan.nextLine();
            name = name.trim();
        } while (!isAlphabetic(name));
        scan.close();
        return name;
    }

    /**
     * Taking card number input from the user.
     * @return enteredNumber card number choosen by the user.
     */
    public int enterNumber() 
    {
        Scanner scan = new Scanner(System.in);
        String inputNumber;
        int enteredNumber = 0;
        int numberCheck = 0;
        while (numberCheck == 0)
        {
            try
            {
                System.out.print("Guess the number value: ");
                inputNumber = scan.nextLine();
                enteredNumber = Integer.parseInt(inputNumber);
                numberCheck = 1;
            }
            catch (Exception e)
            {
                System.out.println("Invalid Input. !!ONLY NUMBERS ACCEPTED!!");
                System.out.println();
            }
        }
        
        scan.close();
        return enteredNumber;
    }

    /**
     * Taking card suit value input from the user.
     * @return enteredCard card suit choosen by the user.
     */
    public char enterSuit()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Guess the Suit Value: ");
        char enteredCard = scan.nextLine().charAt(0);
        enteredCard = Character.toUpperCase(enteredCard);
        scan.close();
        return enteredCard;
    }

    /**
     * checks if the entered name by the user is only alphabete
     * @return true  when the name entered by the user is only alphabetes.
     */
    public boolean isAlphabetic(String nameCheck)
    {
        char[] characterArray = nameCheck.toCharArray();
        if (characterArray.length == 0)
        {
            System.out.println("Name can't be blank.");
            return false;
        }
        for (int i = 0; i < characterArray.length; i++)
        {
            if(!Character.isLetter(characterArray[i]))
            {
                System.out.println("Invalid Name Entered.");
                System.out.println("Name can't have numbers.");
                return false;
            }
        }
        return true;
    }

    /**
     * Compares the number value of the card entered by the with the random number 
     * taken from the computer.
     */
    public void numberCompare()
    {
        System.out.println();
        System.out.println("############################################################");
        System.out.println("Now guess the Number Value, You only have 4 chances.");
        System.out.println();
        RandomNumber randomNumber =new RandomNumber(13); //object of RandomNumber with maximum value 13
        int choosenNumber = enterNumber();
        int numberGuessCount = 4;
        Card cardChoosen = new Card();  //object of Card class
        do 
        {
            if (choosenNumber == randomNumber.getRandomNumber())
            {
                //If user entered number matches with random number taken by the computer.
                System.out.println("Correct guess");
                System.out.println("############################################################");
                cardChoosen.setNumber(choosenNumber);
                numberGuessCount = 0;
            }
            else if (choosenNumber <= 0 || choosenNumber >13)
            {
                //If user enters a number less than 0 or greater than 13.
                System.out.println("Invalid Input");
                System.out.println("Please Enter between Number between 1-13.");
                System.out.println("Dont't worry Points and Number of Guesses are not deducted");
                choosenNumber = enterNumber();
            }
            else
            {
                //If the user entered number is not matching with the random number taken by the computer.
                System.out.println("Incorrect guess");
                numberGuessCount--;

                if (numberGuessCount == 0)
                {
                    cardGamePlayer.setScore(cardGamePlayer.getScore() - 20);  //20 points are deducted when user makes 4 incorrect guess.
                    System.out.println("You have made 4 incorrect guess");
                    System.out.println("Correct number is: " + randomNumber.getRandomNumber());
                    System.out.println("############################################################");
                    cardChoosen.setNumber(choosenNumber);
                }
                if (numberGuessCount != 0)
                {
                    if (numberGuessCount == 3)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 2);  //2 points are deducted when user makes 1st incorrect guess.
                        System.out.println("You have only 3 Guesses left.");
                        if (cardGamePlayer.getScore() <= 0)
                        {
                            System.out.println("Score is below zero.");
                            System.out.println("Correct number is: " + randomNumber.getRandomNumber());
                            break;
                        }
                    }   
                    else if (numberGuessCount == 2)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 6);  //6 points are deducted when user makes 2nd incorrect guess.
                        System.out.println("You have only 2 Guesses left.");
                        if (cardGamePlayer.getScore() <= 0)
                        {
                            System.out.println("Score is below zero.");
                            System.out.println("Correct number is: " + randomNumber.getRandomNumber());
                            break;
                        }
                    }
                    else
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 12); //12 points are deducted when user makes 3rd incorrect guess.
                        if (cardGamePlayer.getScore() <= 0)
                        {
                            System.out.println("Score is below zero.");
                            System.out.println("Correct number is: " + randomNumber.getRandomNumber());
                            break;
                        }
                        System.out.println("You have only 1 Guess left");
                    }    
                    System.out.println();
                    cardChoosen.setNumber(choosenNumber);
                    if (choosenNumber > randomNumber.getRandomNumber())
                        System.out.println("Card number is less than entered number.");
                    else
                        System.out.println("Card number is greater than entered number.");
                    choosenNumber = enterNumber();
                }
            }
        } while (numberGuessCount != 0);
        cardGamePlayer.setHighestScore(cardGamePlayer.getScore());  //set highest score of the player in Player class
        cardGamePlayer.setNumberOfGamesPlayed(cardGamePlayer.getNumberOfGamesPlayed() + 1);  //increase the number of games played by 1 in Player Class
        if (cardGamePlayer.getScore() > 0)
            cardGamePlayer.setNumberOfGamesWon(cardGamePlayer.getNumberOfGamesWon() + 1);  //if player score is greater than 0, player has won the game.
        cardChoosen.setGuess(Integer.toString(choosenNumber));
        resultNumberCompare(choosenNumber);
        resultEndGame();
    }

    /**
     * Display player details when the player chooses to end the game.
     */
    public void playerDetails()
    {
        System.out.print('\u000C');
        System.out.println("############################################################");
        System.out.printf("%40s %n","Thank You for playing see you again");
        System.out.printf("%30s %n","Game Over");
        System.out.println();
        System.out.println("Below is your game details");
        System.out.println();
        System.out.println("Name: " + cardGamePlayer.getName());
        System.out.println("Score: " + cardGamePlayer.getScore());
        System.out.println("Last Game Guess: " + cardGamePlayer.getGuess());
        System.out.println("Higest Score: " + cardGamePlayer.getHighestScore());
        System.out.println("Number of Games Played: " + cardGamePlayer.getNumberOfGamesPlayed());
        System.out.println("Number of Games Won: " + cardGamePlayer.getNumberOfGamesWon());
        System.out.println();
        System.out.println("############################################################");
    }

    /**
     * Display players end game result.
     */
    public void resultEndGame()
    {
        System.out.println("############################################################");
        System.out.printf("%30s %n","Game Ended");
        System.out.println("Game Details");
        System.out.println("Score: " + cardGamePlayer.getScore());
        System.out.println("Game Guess: " + cardGamePlayer.getGuess());
        System.out.println("Higest Score: " + cardGamePlayer.getHighestScore());
        System.out.println("Number of Games Played: " + cardGamePlayer.getNumberOfGamesPlayed());
        System.out.println("Number of Games Won: " + cardGamePlayer.getNumberOfGamesWon());
        System.out.println("############################################################");
        stopPlaying();
    }

    /**
     * Player choosen number is stored in the Player class.
     * @param choosenNumber last choosen card number by the player
     */
    public void resultNumberCompare(int choosenNumber)
    {
        if (choosenNumber == 1)
            cardGamePlayer.setGuess("Ace");
        else if (choosenNumber == 11)
            cardGamePlayer.setGuess("Jack");
        else if (choosenNumber == 12)
            cardGamePlayer.setGuess("Queen");
        else if (choosenNumber == 13)
            cardGamePlayer.setGuess("King");
        else
            cardGamePlayer.setGuess(Integer.toString(choosenNumber));
    }

    /**
     * Player choosen suit value is stored in the Player class
     * @param choosenSuit last choosen card suit by the player.
     */
    public void resultSuitCompare(char choosenSuit)
    {
        if (choosenSuit == 'H')
            cardGamePlayer.setGuess("Hearts ");
        else if (choosenSuit == 'D')
            cardGamePlayer.setGuess("Diamond ");
        else if (choosenSuit == 'C')
            cardGamePlayer.setGuess("Clubs ");
        else
            cardGamePlayer.setGuess("Spades ");
    }

    /**
     * Player is asked if he likes to end the game or play again
     */
    public void stopPlaying()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play again? (Y/N): ");
        char playerChoice = scan.nextLine().charAt(0);
        playerChoice = Character.toUpperCase(playerChoice);
        scan.close();
        if (playerChoice == 'Y')
        {
            cardGamePlayer.setScore(40);    //Player score is reset to 40
            cardGamePlayer.setGuess("");
            System.out.print('\u000C');
            System.out.println();
            System.out.printf("%40s %n","All The Best Guessing Again!");
            suitCompare();
        }
        else if (playerChoice == 'N')
            playerDetails();
        else
        {
            System.out.println("Invalid Input.");
            stopPlaying();
        }
    }

    /**
     * Suit value guessed by the user is compared with the computer 
     * choosen suit value.
     */
    public void suitCompare()
    {
        System.out.println();
        System.out.println("############################################################");
        System.out.println("Now guess the Suit Value, You only have 3 chances.");
        System.out.println();
        RandomNumber randomNumber = new RandomNumber(4);
        char choosenCard = enterSuit();
        int suitGuessCount = 3;
        Card cardChoosen = new Card();
        if ((cardChoosen.getGuess()).length() > 1)
            cardChoosen.setGuess("");   //player guess is initialized to empty at the begining of each game
        do 
        {
            if (choosenCard == 'H')
            {
                if (randomNumber.getRandomNumber() == 1)
                {
                    System.out.println("Correct guess");
                    System.out.println("############################################################");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount = 0;
                }   
                else 
                {
                    System.out.println("Incorrect guess, try again.");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount--;
                    if (suitGuessCount == 2)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
                        System.out.println("You only have 2 Guesses left");
                        choosenCard = enterSuit();
                    }
                    else if (suitGuessCount == 1)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 10);
                        System.out.println("You only have 1 Guess left");
                        choosenCard = enterSuit();
                    }
                    else
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
                        System.out.println("You have made 3 Incorrect guesses.");
                        System.out.println();
                        if (randomNumber.getRandomNumber() == 2)
                            System.out.println("Correct Suit is Diamond.");
                        else if (randomNumber.getRandomNumber() == 3)
                            System.out.println("Correct Suit is Clubs.");
                        else 
                            System.out.println("Correct Suit is Spades");
                        System.out.println("############################################################");
                    }
                }
            }
            else if (choosenCard == 'D')
            {
                if (randomNumber.getRandomNumber() == 2)
                {
                    System.out.println("Correct guess");
                    System.out.println("############################################################");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount = 0;
                }
                else 
                {
                    System.out.println("Incorrect guess, try again.");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount--;
                    if (suitGuessCount == 2)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
                        System.out.println("You only have 2 Guesses left");
                        choosenCard = enterSuit();
                    }
                    else if (suitGuessCount == 1)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 10);
                        System.out.println("You only have 1 Guess left");
                        choosenCard = enterSuit();
                    }
                    else
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
                        System.out.println("You have made 3 Incorrect guesses.");
                        System.out.println();
                        if (randomNumber.getRandomNumber() == 1)
                            System.out.println("Correct Suit is Hearts.");
                        else if (randomNumber.getRandomNumber() == 3)
                            System.out.println("Correct Suit is Clubs.");
                        else 
                            System.out.println("Correct Suit is Spades");
                        System.out.println("############################################################");
                    }
                }
            }
            else if (choosenCard == 'C')
            {
                if (randomNumber.getRandomNumber() == 3)
                {
                    System.out.println("Correct guess");
                    System.out.println("############################################################");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount = 0;
                }
                else 
                {
                    System.out.println("Incorrect guess, try again");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount--;
                    if (suitGuessCount == 2)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
                        System.out.println("You only have 2 Guesses left");
                        choosenCard = enterSuit();
                    }
                    else if (suitGuessCount == 1)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 10);
                        System.out.println("You only have `1 Guess left");
                        choosenCard = enterSuit();
                    }
                    else
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
                        System.out.println("You have made 3 Incorrect guesses.");
                        System.out.println();
                        if (randomNumber.getRandomNumber() == 2)
                            System.out.println("Correct Suit is Diamond.");
                        else if (randomNumber.getRandomNumber() == 1)
                            System.out.println("Correct Suit is Hearts.");
                        else 
                            System.out.println("Correct Suit is Spades");
                        System.out.println("############################################################");
                    }
                }
            }
            else if (choosenCard == 'S')
            {
                if (randomNumber.getRandomNumber() == 4)
                {
                    System.out.println("Correct guess");
                    System.out.println("############################################################");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount = 0;
                }
                else 
                {
                    System.out.println("Incorrect guess, try again");
                    cardChoosen.setSuit(choosenCard);
                    suitGuessCount--;
                    if (suitGuessCount == 2)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
                        System.out.println("You only have 2 Guesses left");
                        choosenCard = enterSuit();
                    }
                    else if (suitGuessCount == 1)
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 10);
                        System.out.println("You only have 1 Guess left");
                        choosenCard = enterSuit();
                    }
                    else
                    {
                        cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
                        System.out.println("You have made 3 Incorrect guesses.");
                        System.out.println();
                        if (randomNumber.getRandomNumber() == 2)
                            System.out.println("Correct Suit is Diamond.");
                        else if (randomNumber.getRandomNumber() == 3)
                            System.out.println("Correct Suit is Clubs.");
                        else 
                            System.out.println("Correct Suit is Hearts.");
                        System.out.println("############################################################");
                    }
                }
            }
            else 
            {
                cardChoosen.setSuit(choosenCard);
                System.out.println();
                System.out.println("Invalid Input");
                System.out.println("Please enter H: Hearts, D: Diamonds, C: Clubs, S: Spades");
                System.out.println("Dont't worry Points and Number of Guesses are not deducted");
                System.out.println();
                choosenCard = enterSuit();
            }
        } while (suitGuessCount != 0);
        cardChoosen.setGuess(Character.toString(choosenCard));
        resultSuitCompare(choosenCard);
        numberCompare();
    }

    /**
     * Display welcome message with instuctions of the game for the player to begin the game.
     */
    public void welcome()
    {
        System.out.print('\u000C');
        System.out.println("############################################################");
        System.out.printf("%40s %n","Welcome to Card Guess Game");
        System.out.println();
        System.out.println("Instructions: ");
        System.out.println();
        System.out.println("You will be given 40 points for every Game.");
        System.out.println();
        System.out.println("Every card has a suit and a number.");
        System.out.println();
        System.out.println("Suits in card are ");
        System.out.println("H: Hearts");
        System.out.println("D: Diamonds");
        System.out.println("C: Clubs");
        System.out.println("S: Spades");
        System.out.println();
        System.out.println("Numbers are from 1 -13");
        System.out.println("Ace - 1, Jack - 11, Queen - 12, King - 13");
        System.out.println();
        System.out.println("First you will have to guess the suit of the card.");
        System.out.println("Second you will have to guess the Number of the card.");
        System.out.println();
        System.out.printf("%30s %n","!!!CAUTION!!!");
        System.out.printf("%45s %n","You are penalised for every wrong guess.");
        System.out.println();
        System.out.println();
        System.out.printf("%40s %n","All The Best Taking Guess!");
        System.out.println("############################################################");
    }
}