package Java.myProjects.Battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class newMainWithThreadPlayer {

	public static void main(String[] args) {
		
		// INITIAL SETUP
		// ==========================================================================================================================================
		
		// create a scanner object
		Scanner userInput = new Scanner(System.in);
		
		// create the 2 players and the game itself
		Player player1;	
		Game myGame = new Game();
		
		// create the player's game grid that they will guess on
		String[][] player1GameGrid = new String[11][11];
		myGame.buildGrid(player1GameGrid);
		

		// create the player's ship placement grid
		String[][] player1Grid = new String[11][11];
		myGame.buildGrid(player1Grid);
		
		// explanation of the game waits until the user enters in the 'c' key
		while (true) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Welcome to battleship");
			System.out.println("This is the game grid. Place your ships in the grid then guess your openents' to sink them\nPress 'c' to continue\n");
			myGame.displayGrid(player1GameGrid);
			System.out.println("----------------------");
			String key = userInput.next();
			if (key.equals("c") || key.equals("C"))
				break;
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Please enter your name: ");
		player1 = new Player(userInput.next());
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");		
		myGame.placeShip(player1, player1Grid);
		
		while (true) {
			System.out.println("\n\n\n");
			System.out.println("This is the grid you have chosen:\nPress 'c' to start the game\n");
			myGame.displayGrid(player1Grid);
			System.out.println("----------------------");
			String key = userInput.next();
			if (key.equals("c") || key.equals("C"))
				break;
		}
		
		newThreadPlayer threadPlayer = new newThreadPlayer("The Computer", player1, player1GameGrid);	
		Thread myThread = new Thread(threadPlayer);
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");	
		
		List<String> guesses1 = new ArrayList<String>();
		int turnCounter = 0;
		String guess;
		
		
		// play the game
		// myThread.start();
		
		int count = 0;
		
		while (true) {
			
			guess = "";
			
			// checks if it is the computer has ships left and plays its turn if it can
			if (threadPlayer.getThreadPlayer().hasShipsLeft() == false)
				break;
			myThread.run();
			
			
			if (player1.hasShipsLeft() == false)
				break;
			
			
			if (count != 0) {
				if (player1.getHitorNot() == true)
					System.out.println(threadPlayer.getThreadPlayer().getName() + " got a hit!");
				if (player1.getHitorNot() == false)
					System.out.println(threadPlayer.getThreadPlayer().getName() + " missed!");
				if (player1.getShipGotSunk().equals("") == false)
					System.out.println(threadPlayer.getThreadPlayer().getName() + " sunk your" + player1.getShipGotSunk() + "!!");

				
				
				if (threadPlayer.getThreadPlayer().getHitorNot() == true)
					System.out.println("You got a hit!");
				if (threadPlayer.getThreadPlayer().getHitorNot() == false)
					System.out.println("You missed!");
				if (threadPlayer.getThreadPlayer().getShipGotSunk().equals("") == false)
					System.out.println("You sunk " + threadPlayer.getThreadPlayer().getName() + "'s "  + threadPlayer.getThreadPlayer().getShipGotSunk() + "!!");
			}
	
			
			while (true) {
				System.out.println("----------------------");
				System.out.println("Your turn");
				System.out.println("You have " + player1.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
				myGame.displayGrid(player1GameGrid);
				System.out.println("----------------------\nPlease enter your guess:\n");
				while (true) {
					guess = userInput.next();
					if (myGame.checkFirstLetter(guess.substring(0, 1)))
						break;
					else {
						System.out.println("\n\n\n\n\n\n\n\n");
						System.out.println("Invalid guess");
						if (player1.getHitorNot() == true)
							System.out.println(threadPlayer.getThreadPlayer().getName() + " got a hit!");
						if (player1.getHitorNot() == false)
							System.out.println(threadPlayer.getThreadPlayer().getName() + " missed!");
						if (threadPlayer.getThreadPlayer().getShipGotSunk().equals("") == false)
							System.out.println(player1.getName() + " sunk " + threadPlayer.getThreadPlayer().getName() + "'s "  + threadPlayer.getThreadPlayer().getShipGotSunk() + "!!");
						System.out.println("----------------------");
						System.out.println(player1.getName() + "'s turn");
						System.out.println("You have " + player1.getShipsLeft() + " ships left\n'X's are hits, 'O's are misses\n");
						myGame.displayGrid(player1GameGrid);
						System.out.println("----------------------\nPlease enter your guess:\n");
					}
				}
				if (guesses1.contains(guess) == false)
					break;
				System.out.println("\n\n\n\n\n\n\n\n");
				System.out.println("You guessed that already");
				if (player1.getHitorNot() == true)
					System.out.println(threadPlayer.getThreadPlayer().getName() + " got a hit!");
				if (player1.getHitorNot() == false)
					System.out.println(threadPlayer.getThreadPlayer().getName() + " missed!");
				if (threadPlayer.getThreadPlayer().getShipGotSunk().equals("") == false)
					System.out.println(player1.getName() + " sunk " + threadPlayer.getThreadPlayer().getName() + "'s "  + threadPlayer.getThreadPlayer().getShipGotSunk() + "!!");
				}
			System.out.println("\n\n\n\n\n\n\n\n");
			try {
				player1.guessCoord(Integer.parseInt(guess.substring(1)), myGame.convertLetter(guess.substring(0, 1)), threadPlayer.getThreadPlayer(), threadPlayer.getGrid(), player1GameGrid);
				count ++;
				guesses1.add(guess);
				threadPlayer.flipTurn();
			} catch (Exception e) {
				System.out.println("Invalid location entered");
			}	
		}
		
		
		
		
		
		
		// end of game
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if (player1.hasShipsLeft())
			System.out.println(threadPlayer.getThreadPlayer().getName() + " is out of ships! " + player1.getName() + " wins!!!");
		else
			System.out.println(player1.getName() + " is out of ships! " + threadPlayer.getThreadPlayer().getName() + " wins!!!");

	}

}
