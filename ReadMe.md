PROJECT TITLE: Guess a Card Game
PURPOSE OF PROJECT: To Guess a card randomly generated from the computer.
VERSION or DATE: 2020.05.07
HOW TO START THIS PROJECT: Create Game to start this project
AUTHORS: Sampreeth Amith Kumar  
USER INSTRUCTIONS: Start the game by creating by creating Game object.

# Introduction
The aim of the Guess a C♠rd Game is for a player to correctly guess a playing card drawn randomly by the
computer. The player has a set number of attempts to guess the card. However, palyer's points at
the start of the game and are penalised for each incorrect attempt. The game ends when a correct guess is
entered, the points are zero or less, or the player has run out of guesses. The points remaining at the end of
the game are counted as the score for the game. The player may play a series of games, with cumulative
game results displayed after the final game when the player decides to stop playing. 

The deck of cards from which the cards are drawn is a standard fifty-two card deck. It has four suits:
Hearts♥, Diamonds♦, Clubs♣ and Spades♠. Each suit has thirteen cards: an Ace, which is regarded as
number 1 for this game; cards numbered 2 to 10 inclusive. Each suit also three “face cards”: a Jack, number
11 for this game; a Queen, number 12 for this game; and a King, number 13 for this game.

The player starts each game with a point score of 40 points. They will first guess the suit of the card drawn
from the deck. The player will enter a single character to signify their choice of suit: H for Hearts, D for
Diamonds, C for Clubs and S for Spades. The player has three attempts to guess the correct suit. Points are
deducted from the player’s score each time the player guesses incorrectly. Points deduction during this part of the game are as follows

Incorrect Guess    |    Points deducted
      1st          |         5
      2nd          |        10
      3rd          |        15
     
The game continues while the player’s points score is greater than 0, until the player guesses correctly, or
they have run out of guesses.The player then has four attempts to guess the correct card number.Points are deducted from the player’s score each time the player guesses incorrectly. The points deducted during this part of the game are as follows

  Incorrect Guess    |    Points deducted
      1st            |         2
      2nd            |         6
      3rd            |        12
      4th            |        20
