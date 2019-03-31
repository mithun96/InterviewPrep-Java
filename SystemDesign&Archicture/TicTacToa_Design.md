# Software design for an tic-tac-toe game

# Panel: 
Design a Tic-tac-toe game that is played between two players on a n x n grid.

#You: 
Follow below approach to identify whether panel is interested in class design and its relation or interested in backend as it seems This is a pretty broad question.

From the application developer perspective, we should be telling the classes and its relation, class diagrams. We all know the time scarcity during a technical discussion and some time its difficult what other guy is expecting from us.

## A snapshot of Tic-Tac-Toe Game
A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.


## Use Cases and Scenarios
Use case: a set of scenarios tied together by a common user goal
• Scenario: a sequence of steps describing an interaction between a user and a system


Lets check the use case diagram below to have better understanding.


## Identifying Classes/Objects:
1. GameState
The GameState class contains all the information about the current state of a Tic Tac Toe game. The squares array contains a character value for each square in the Tic Tac Toe board. An empty square is represented by a space character. The player array contains the Players, who each have their own specified symbol which is used to fill the squares array. The playerTurn integer is an index which corresponds to the player in the player array whose turn it is. The constructor creates an empty Tic Tac Toe board, both Players, and initializes the playerTurn index to zero. The reseatBoard method returns the board to an empty state and resets the playerTurn to zero.


2. Player
The Player class is applied to manage the player’s information. The number of wins and symbol of the player should be got by the methods in the Player class. The variables and methods in Player class are described as follows:

wins: integer variable, represents the number of wins;

symbol: char variable, represents the symbol that is used in the board by the player;

Player (symbol: char): constructor, creates a new player, defines the new player’s symbol and initializes the number of wins is equal to zero;

getWins(): obtains the number of wins;

addWins(): the number of wins is increased 1;

getSymbol(): obtains the symbol of the player.


3. Move
The Move class is applied to mark the location of the symbol by the row-column method. The variables and methods in Move class are described as follows:

row: integer variable, represents the row number of the Tic-Tac-Toe board;

col: integer variable, represents the column number of the Tic-Tac-Toe board;

Move (r:int, c:int): constructor, according to the two integer parameters r and c, this method sets the location of the symbol on Tic-Tac-Toe board.