package Java.myProjects.Battleship;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		// INITIAL SETUP
		// ==========================================================================================================================================
		
		// create a scanner object
		Scanner userInput = new Scanner(System.in);
		
		// create the 2 players and the game itself
		Player player1;
		Player player2;	
		Game myGame = new Game();
		
		// create the two players' game grid that they will guess on
		String[][] player1GameGrid = new String[11][11];
		myGame.buildGrid(player1GameGrid);
		String[][] player2GameGrid = new String[11][11];
		myGame.buildGrid(player2GameGrid);
		
		// create the two players' ship placement grids
		String[][] player1Grid = new String[11][11];
		myGame.buildGrid(player1Grid);
		String[][] player2Grid = new String[11][11];
		myGame.buildGrid(player2Grid);

		
		// explanation of the game waits until the user enters in the 'c' key
		while (true) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Welcome to Battleship!!\n=======================\n");
			System.out.println("This is the game grid. Place your ships in the grid then guess the loction of your openent's ships to sink them\nPress 'c' to continue\n");
			myGame.displayGrid(player1GameGrid);
			System.out.println("----------------------");
			String key = userInput.next();
			if (key.equals("c") || key.equals("C"))
				break;
		}

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Please enter a name for player 1: ");
		player1 = new Player(userInput.next());
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");		
		myGame.placeShip(player1, player1Grid);
		
		while (true) {
			System.out.println("\n\n\n");
			System.out.println("This is the grid you have chosen:\nPress 'c' to continue then pass the computer to player2\n");
			myGame.displayGrid(player1Grid);
			System.out.println("----------------------");
			String key = userInput.next();
			if (key.equals("c") || key.equals("C"))
				break;
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");	
		System.out.println("Please enter a name for player 2: ");
		player2 = new Player(userInput.next());
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		myGame.placeShip(player2, player2Grid);

		while (true) {
			System.out.println("\n\n\n");
			System.out.println("This is the grid you have chosen:\nPress 'c' and the game will start!!\n");
			myGame.displayGrid(player2Grid);
			System.out.println("----------------------");
			String key = userInput.next();
			if (key.equals("c") || key.equals("C"))
				break;
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");	
		
		List<String> guesses1 = new ArrayList<String>();
		List<String> guesses2 = new ArrayList<String>();
		int turnCounter = 0;
		String guess;
		
		while (true) {
			
			guess = "";
	
			if (turnCounter == 0) {
				while (true) {
					try {
						System.out.println("L E T ' S   P L A Y   B A T T L E S H I P ! ! !\n===============================================\n\n" + player1.getName() + " guesses first");
						System.out.println("You have " + player1.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
						myGame.displayGrid(player1GameGrid);
						System.out.println("----------------------\nPlease enter your guess:\n");
						while (true) {
							guess = userInput.next();
							if (myGame.checkFirstLetter(guess.substring(0, 1)))
								break;
							else
								System.out.println("\n\n\n\n\n\n\n\n");
								System.out.println("Invalid guess");
								System.out.println("L E T ' S   P L A Y   B A T T L E S H I P ! ! !\n===============================================\n\n" + player1.getName() + " guesses first");
								System.out.println("You have " + player1.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
								myGame.displayGrid(player1GameGrid);
								System.out.println("----------------------\nPlease enter your guess:\n");
						}
						System.out.println("\n\n\n\n\n\n\n\n");
						player1.guessCoord(Integer.parseInt(guess.substring(1)), myGame.convertLetter(guess.substring(0, 1)), player2, player2Grid, player1GameGrid);
						turnCounter += 2;
						guesses1.add(guess);
					} catch (Exception e) {
						System.out.println("Invalid location entered");
					}
					break;
				}	
			}
			
			if (player1.hasShipsLeft() == false)
				break;
			
			if (turnCounter == 1) {
				if (player1.getHitorNot() == true)
					System.out.println(player2.getName() + " got a hit!");
				if (player1.getHitorNot() == false)
					System.out.println(player2.getName() + " missed!");
				if (player1.getShipGotSunk().equals("") == false)
					System.out.println(player2.getName() + " sunk " + player1.getName() + "'s "  + player1.getShipGotSunk() + "!!");
				
				while (true) {
					System.out.println("----------------------");
					System.out.println(player1.getName() + "'s turn");
					System.out.println("You have " + player1.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
					myGame.displayGrid(player1GameGrid);
					System.out.println("----------------------\nPlease enter your guess:\n");
					while (true) {
						guess = userInput.next();
						if (myGame.checkFirstLetter(guess.substring(0, 1)))
							break;
						else
							System.out.println("\n\n\n\n\n\n\n\n");
							System.out.println("Invalid guess");
							if (player1.getHitorNot() == true)
								System.out.println(player2.getName() + " got a hit!");
							if (player1.getHitorNot() == false)
								System.out.println(player2.getName() + " missed!");
							if (player1.getShipGotSunk().equals("") == false)
								System.out.println(player2.getName() + " sunk " + player1.getName() + "'s "  + player1.getShipGotSunk() + "!!");
							System.out.println("----------------------");
							System.out.println(player1.getName() + "'s turn");
							System.out.println("You have " + player1.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
							myGame.displayGrid(player1GameGrid);
							System.out.println("----------------------\nPlease enter your guess:\n");

					}
					if (guesses1.contains(guess) == false)
						break;
					System.out.println("\n\n\n\n\n\n\n\n");
					System.out.println("You guessed that already");
					if (player1.getHitorNot() == true)
						System.out.println(player2.getName() + " got a hit!");
					if (player1.getHitorNot() == false)
						System.out.println(player2.getName() + " missed!");
					if (player1.getShipGotSunk().equals("") == false)
						System.out.println(player2.getName() + " sunk " + player1.getName() + "'s "  + player1.getShipGotSunk() + "!!");
				}
				System.out.println("\n\n\n\n\n\n\n\n");
				try {
					player1.guessCoord(Integer.parseInt(guess.substring(1)), myGame.convertLetter(guess.substring(0, 1)), player2, player2Grid, player1GameGrid);
					turnCounter ++;
					guesses1.add(guess);
				} catch (Exception e) {
					System.out.println("Invalid location entered");
				}
			}

			
			if (player2.hasShipsLeft() == false)
				break;
			
			if (turnCounter == 2) {
				if (player2.getHitorNot() == true)
					System.out.println(player1.getName() + " got a hit!");
				if (player2.getHitorNot() == false)
					System.out.println(player1.getName() + " missed!");
				if (player2.getShipGotSunk().equals("") == false)
					System.out.println(player1.getName() + " sunk " + player2.getName() + "'s "  + player2.getShipGotSunk() + "!!");
				
				while (true) {
					System.out.println("----------------------");
					System.out.println(player2.getName() + "'s turn");
					System.out.println("You have " + player2.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
					myGame.displayGrid(player2GameGrid);
					System.out.println("----------------------\nPlease enter your guess:\n");
					while (true) {
						guess = userInput.next();
						if (myGame.checkFirstLetter(guess.substring(0, 1)))
							break;
						else
							System.out.println("\n\n\n\n\n\n\n\n");
							System.out.println("Invalid guess");
							if (player2.getHitorNot() == true)
								System.out.println(player1.getName() + " got a hit!");
							if (player2.getHitorNot() == false)
								System.out.println(player1.getName() + " missed!");
							if (player2.getShipGotSunk().equals("") == false)
								System.out.println(player1.getName() + " sunk " + player2.getName() + "'s "  + player2.getShipGotSunk() + "!!");
							System.out.println("----------------------");
							System.out.println(player2.getName() + "'s turn");
							System.out.println("You have " + player2.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
							myGame.displayGrid(player2GameGrid);
							System.out.println("----------------------\nPlease enter your guess:\n");
					}
					if (guesses2.contains(guess) == false)
						break;
					System.out.println("\n\n\n\n\n\n\n\n");
					System.out.println("You guessed that already");
					if (player2.getHitorNot() == true)
						System.out.println(player1.getName() + " got a hit!");
					if (player2.getHitorNot() == false)
						System.out.println(player1.getName() + " missed!");
					if (player2.getShipGotSunk().equals("") == false)
						System.out.println(player1.getName() + " sunk " + player2.getName() + "'s "  + player2.getShipGotSunk() + "!!");
				}
				System.out.println("\n\n\n\n\n\n\n\n");
				try {
					player2.guessCoord(Integer.parseInt(guess.substring(1)), myGame.convertLetter(guess.substring(0, 1)), player1, player1Grid, player2GameGrid);
					turnCounter --;
					guesses2.add(guess);
				} catch (Exception e) {
					System.out.println("Invalid location entered");
				}
			}
		}
		
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if (player1.hasShipsLeft())
			System.out.println(player2.getName() + " is out of ships! " + player1.getName() + " wins!!!");
		else
			System.out.println(player1.getName() + " is out of ships! " + player2.getName() + " wins!!!");	
	}
	
	
	// FIX ENTERING NO LETTER FOR GUESS
}
