package Java.myProjects.Battleship;

import java.util.Scanner;

public class Game {
	
	Scanner userInput = new Scanner(System.in);
	
	private String cursor = "+";
	
	public void buildGrid(String[][] grid) {
		// creates grid for game
		
		grid[0][0] = " ";	// 0,0 spot is blank on game grid
		grid[0][10] = "10";	// place a 10 at the end of the grid

		char letterCoord = 'A';	// first letter coordinate along the side
		char numberCoord = '1';	// first number coordinate along the top
		
		for (int i = 1; i < 11; i ++) {
			// fill in the rest of the letter coordinates by adding one to the character
			grid[i][0] = Character.toString(letterCoord);
			letterCoord ++;
		}
		
		for (int j = 1; j < 10; j ++) {
			// fill in the rest of the number coordinates by adding one to the character
			grid[0][j] = Character.toString(numberCoord);
			numberCoord ++;
			
		}
		
		for (int i = 1; i < 11; i ++) {
			// fill in the rest of the board that isn't along the top or side (playable area)
			for (int j = 1; j < 11; j ++) {
				grid[i][j] = ".";
			}
		}
	}
	
	public void displayGrid(String[][] grid) {
		// displays the grid for the game		
		
		// prints out the grid with a spcae in between each character
		for (int i = 0; i < 11; i ++) {
			for (int j = 0; j < 11; j ++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean checkFirstLetter(String letter) {
		if (letter.toLowerCase().equals("a") == true || letter.toLowerCase().equals("b") == true || letter.toLowerCase().equals("c") == true || letter.toLowerCase().equals("d") == true || letter.toLowerCase().equals("e") == true || letter.toLowerCase().equals("f") == true || letter.toLowerCase().equals("g") == true || letter.toLowerCase().equals("h") == true || letter.toLowerCase().equals("i") == true || letter.toLowerCase().equals("j") == true)
			return true;
		else
			return false;
	}
	
	public int convertLetter(String end) {
		if (end.equals("A") || end.equals("a"))
			return 1;
		if (end.equals("B") || end.equals("b"))
			return 2;
		if (end.equals("C") || end.equals("c"))
			return 3;
		if (end.equals("D") || end.equals("d"))
			return 4;
		if (end.equals("E") || end.equals("e"))
			return 5;
		if (end.equals("F") || end.equals("f"))
			return 6;
		if (end.equals("G") || end.equals("g"))
			return 7;
		if (end.equals("H") || end.equals("h"))
			return 8;
		if (end.equals("I") || end.equals("i"))
			return 9;
		if (end.equals("J") || end.equals("j"))
			return 10;
		else
			return 0;
	}
	
	public void placeCursor(String[][] grid, int x, int y) {
		grid[y][x] = "+";
	}
	
	public void removeCursor(String[][] grid, int x, int y) {
		grid[y][x] = ".";
	}
	
	public void placeO(String[][] grid, int x, int y) {
		grid[y][x] = "O";
	}
	
	public void removeO(String[][] grid, int x, int y) {
		grid[y][x] = ".";
	}
	
	public void placeX(String[][] grid, int x, int y) {
		grid[y][x] = "X";
	}
	
	public void removeX(String[][] grid, int x, int y) {
		grid[y][x] = ".";
	}
	
	public boolean checkUp(String[][] grid, int x, int y, String type) {
		if (type.equals("carrier")) {
			if (y - 4 > 0 && grid[y-4][x].equals("O") != true && grid[y-3][x].equals("O") != true && grid[y-2][x].equals("O") != true && grid[y-1][x].equals("O") != true)
				return true;
		}
		if (type.equals("battleship")) {
			if (y - 3 > 0 && grid[y-3][x].equals("O") != true && grid[y-2][x].equals("O") != true && grid[y-1][x].equals("O") != true)
				return true;
		}
		if (type.equals("submarine")) {
			if (y - 2 > 0 && grid[y-2][x].equals("O") != true && grid[y-1][x].equals("O") != true)
				return true;
		}
		if (type.equals("destroyer")) {
			if (y - 2 > 0 && grid[y-2][x].equals("O") != true && grid[y-1][x].equals("O") != true)
				return true;
		}
		if (type.equals("cruiser")) {
			if (y - 1 > 0 && grid[y-1][x].equals("O") != true)
				return true;
		}
		
		return false;
		
	}
	
	public boolean checkDown(String[][] grid, int x, int y, String type) {
		if (type.equals("carrier")) {
			if (y + 4 < 11 && grid[y+4][x].equals("O") != true && grid[y+3][x].equals("O") != true && grid[y+2][x].equals("O") != true && grid[y+1][x].equals("O") != true)
				return true;
		}
		if (type.equals("battleship")) {
			if (y + 3 < 11 && grid[y+3][x].equals("O") != true && grid[y+2][x].equals("O") != true && grid[y+1][x].equals("O") != true)
				return true;
		}
		if (type.equals("submarine")) {
			if (y + 2 < 11 && grid[y+2][x].equals("O") != true && grid[y+1][x].equals("O") != true)
				return true;
		}
		if (type.equals("destroyer")) {
			if (y + 2 < 11 && grid[y+2][x].equals("O") != true && grid[y+1][x].equals("O") != true)
				return true;
		}
		if (type.equals("cruiser")) {
			if (y + 1 < 11 && grid[y+1][x].equals("O") != true)
				return true;
		}
		
		return false;
		
	}
	
	public boolean checkLeft(String[][] grid, int x, int y, String type) {
		if (type.equals("carrier")) {
			if (x - 4 > 0 && grid[y][x-4].equals("O") != true && grid[y][x-3].equals("O") != true && grid[y][x-2].equals("O") != true && grid[y][x-1].equals("O") != true)
				return true;
		}
		if (type.equals("battleship")) {
			if (x - 3 > 0 && grid[y][x-3].equals("O") != true && grid[y][x-2].equals("O") != true && grid[y][x-1].equals("O") != true)
				return true;
		}
		if (type.equals("submarine")) {
			if (x - 2 > 0 && grid[y][x-2].equals("O") != true && grid[y][x-1].equals("O") != true)
				return true;
		}
		if (type.equals("destroyer")) {
			if (x - 2 > 0 && grid[y][x-2].equals("O") != true && grid[y][x-1].equals("O") != true)
				return true;
		}
		if (type.equals("cruiser")) {
			if (x - 1 > 0 && grid[y][x-1].equals("O") != true)
				return true;
		}
		
		return false;
		
	}
	
	public boolean checkRight(String[][] grid, int x, int y, String type) {
		if (type.equals("carrier")) {
			if (x + 4 < 11 && grid[y][x+4].equals("O") != true && grid[y][x+3].equals("O") != true && grid[y][x+2].equals("O") != true && grid[y][x+1].equals("O") != true)
				return true;
		}
		if (type.equals("battleship")) {
			if (x + 3 < 11 && grid[y][x+3].equals("O") != true && grid[y][x+2].equals("O") != true && grid[y][x+1].equals("O") != true)
				return true;
		}
		if (type.equals("submarine")) {
			if (x + 2 < 11 && grid[y][x+2].equals("O") != true && grid[y][x+1].equals("O") != true)
				return true;
		}
		if (type.equals("destroyer")) {
			if (x + 2 < 11 && grid[y][x+2].equals("O") != true && grid[y][x+1].equals("O") != true)
				return true;
		}
		if (type.equals("cruiser")) {
			if (x + 1 < 11 && grid[y][x+1].equals("O") != true)
				return true;
		}
		
		return false;
	}
	
	public boolean checkEndPoint(String[][] grid, int y, int x) {
		if (grid[y][x].equals("O") != true && x > 0 && x < 11 && y > 0 && y < 11)
			return true;
		else
			return false;
	}
	
	public void placeShip(Player player, String[][] grid) {
		// PLACE PLAYER'S CARRIER
		// ==========================================================================================================================================
		
		// initialize player 1's carrier
		player.createShip("carrier");
		
		// placeholder string for the first end point
		String end1; 
		
		// get the first end point and make sure it is in bounds and not over another ship
		while (true) {
			System.out.println("First, place your carrier. It is 5 spaces long\nYour grid:\n");
			this.displayGrid(grid);
			System.out.println("----------------------\nPlease enter the first end point: ");
			
			end1 = userInput.next();
			
			try {
				if (end1.length() > 1) {
					if (end1.length() < 3)
						if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), Integer.parseInt(end1.substring(1, 2))))
							break;
						else
							System.out.println("Invalid end point");
					if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
						if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), 10))
							break;
						else
							System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					else
						System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
				}
				else
					System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
			} catch (NumberFormatException e) {
				System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
			}
		}
		
		// check where the end point is and set the ship's actual end points to that location
		if (end1.length() != 3)
			player.getCarrier().setEnd1x(Integer.parseInt(end1.substring(1, 2)));
		else
			player.getCarrier().setEnd1x(10);
		player.getCarrier().setEnd1y(this.convertLetter(end1.substring(0, 1)));
		
		// place a cursor '+' at the location where player 1 placed their first end point
		this.placeCursor(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y());
		
		// check where the ship's second end point can possibly go
		String end2Poss = "You can place the second end point: ";
		if (this.checkUp(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier")) {
			end2Poss += "up ";
		}
		if (this.checkDown(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier")) {
			end2Poss += "down ";
		}
		if (this.checkLeft(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier")) {
			end2Poss += "left ";
		}
		if (this.checkRight(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier")) {
			end2Poss += "right ";
		}
		
		// spacing
		System.out.println("\n\n\n\n\n\n\n");
		
		// asks player for selection out of possible second end point locations and checks to make sure that their selection is a valid one
		// if it is, sets the second end point for the ship
		while (true) {	
			System.out.println("Your grid:\n");
			this.displayGrid(grid);
			System.out.println("----------------------");
			System.out.println(end2Poss);
			System.out.println("Please enter your selection:");
			
			String selection = userInput.next();
			if(selection.equals("up") && this.checkUp(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier") == true) {
				player.getCarrier().setEnd2y(player.getCarrier().getEnd1y() - 4);
				player.getCarrier().setEnd2x(player.getCarrier().getEnd1x());
				break;
			}
			if(selection.equals("down") && this.checkDown(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier") == true) {
				player.getCarrier().setEnd2y(player.getCarrier().getEnd1y() + 4);
				player.getCarrier().setEnd2x(player.getCarrier().getEnd1x());
				break;
			}
			if(selection.equals("left") && this.checkLeft(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier") == true) {
				player.getCarrier().setEnd2y(player.getCarrier().getEnd1y());
				player.getCarrier().setEnd2x(player.getCarrier().getEnd1x() - 4);
				break;
			}
			if(selection.equals("right") && this.checkRight(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y(), "carrier") == true) {
				player.getCarrier().setEnd2y(player.getCarrier().getEnd1y());
				player.getCarrier().setEnd2x(player.getCarrier().getEnd1x() + 4);
				break;
			}
			else
				System.out.println("\n\n\n\n\n\n\nInvalid Selection");
		}
		
		// checks whether the ship is vertical or horizontal and fills in the coordinates accordingly
		if (player.getCarrier().isHorizontal() == true)
			player.getCarrier().fillCoordsHoriz("carrier");
		if (player.getCarrier().isVertical() == true)
			player.getCarrier().fillCoordsVert("carrier");
		
		// places actual 'O's in the location of the newly placed ship
		this.placeO(grid, player.getCarrier().getEnd1x(), player.getCarrier().getEnd1y());
		this.placeO(grid, player.getCarrier().getEnd2x(), player.getCarrier().getEnd2y());
		if (player.getCarrier().getEnd1y() == 10 && player.getCarrier().isHorizontal()) {
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[1].substring(2, 3)), Integer.parseInt(player.getCarrier().getCoords()[1].substring(0, 2)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[2].substring(2, 3)), Integer.parseInt(player.getCarrier().getCoords()[2].substring(0, 2)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[3].substring(2, 3)), Integer.parseInt(player.getCarrier().getCoords()[3].substring(0, 2)));
		}
		if (player.getCarrier().getEnd1y() == 10 && player.getCarrier().isVertical() && player.getCarrier().getEnd1x() != 10) {
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[1].substring(1, 2)), Integer.parseInt(player.getCarrier().getCoords()[1].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[2].substring(1, 2)), Integer.parseInt(player.getCarrier().getCoords()[2].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[3].substring(1, 2)), Integer.parseInt(player.getCarrier().getCoords()[3].substring(0, 1)));
		}
		if (player.getCarrier().getEnd1y() == 10 && player.getCarrier().isVertical() && player.getCarrier().getEnd1x() == 10) {
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[1].substring(1, 3)), Integer.parseInt(player.getCarrier().getCoords()[1].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[2].substring(1, 3)), Integer.parseInt(player.getCarrier().getCoords()[2].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[3].substring(1, 3)), Integer.parseInt(player.getCarrier().getCoords()[3].substring(0, 1)));
		}
		if (player.getCarrier().getEnd1y() != 10) {
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[1].substring(1)), Integer.parseInt(player.getCarrier().getCoords()[1].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[2].substring(1)), Integer.parseInt(player.getCarrier().getCoords()[2].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getCarrier().getCoords()[3].substring(1)), Integer.parseInt(player.getCarrier().getCoords()[3].substring(0, 1)));
		}
		
		
		// ==========================================================================================================================================
		
		
		
		// RESET PLACEHOLDER VARIABLES AND SPACING
		end1 = "";
		end2Poss = "You can place the second end point: ";
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		

				
		// PLACE PLAYER'S BATTLESHIP
		// ==========================================================================================================================================
		
		// initialize player 1's battleship
		player.createShip("battleship");
		
		// get the first end point and make sure it is in bounds and not over another ship
		while (true) {
			System.out.println("Next, place your battleship. It is 4 spaces long\nThe 'O's represent ships you already placed on the board\nYour grid:\n");
			this.displayGrid(grid);
			System.out.println("----------------------\nPlease enter the first end point: ");
			
			end1 = userInput.next();
			
			try {
				if (end1.length() > 1) {
					if (end1.length() < 3)
						if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), Integer.parseInt(end1.substring(1, 2))))
							break;
						else
							System.out.println("Invalid end point");
					if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
						if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), 10))
							break;
						else
							System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					else
						System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
				}
				else
					System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
			} catch (NumberFormatException e) {
				System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
			}
		}
		
		// check where the end point is and set the ship's actual end points to that location
		if (end1.length() != 3)
			player.getBattleShip().setEnd1x(Integer.parseInt(end1.substring(1, 2)));
		else
			player.getBattleShip().setEnd1x(10);
		player.getBattleShip().setEnd1y(this.convertLetter(end1.substring(0, 1)));
		
		// place a cursor '+' at the location where player 1 placed their first end point
		this.placeCursor(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y());
		
		// check where the ship's second end point can possibly go
		if (this.checkUp(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship")) {
			end2Poss += "up ";
		}
		if (this.checkDown(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship")) {
			end2Poss += "down ";
		}
		if (this.checkLeft(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship")) {
			end2Poss += "left ";
		}
		if (this.checkRight(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship")) {
			end2Poss += "right ";
		}
		
		// spacing
		System.out.println("\n\n\n\n\n\n\n");
		
		// asks player for selection out of possible second end point locations and checks to make sure that their selection is a valid one
		// if it is, sets the second end point for the ship
		while (true) {	
			System.out.println("Your grid:\n");
			this.displayGrid(grid);
			System.out.println("----------------------");
			System.out.println(end2Poss);
			System.out.println("Please enter your selection:");
			
			String selection = userInput.next();
			if(selection.equals("up") && this.checkUp(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship") == true) {
				player.getBattleShip().setEnd2y(player.getBattleShip().getEnd1y() - 3);
				player.getBattleShip().setEnd2x(player.getBattleShip().getEnd1x());
				break;
			}
			if(selection.equals("down") && this.checkDown(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship") == true) {
				player.getBattleShip().setEnd2y(player.getBattleShip().getEnd1y() + 3);
				player.getBattleShip().setEnd2x(player.getBattleShip().getEnd1x());
				break;
			}
			if(selection.equals("left") && this.checkLeft(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship") == true) {
				player.getBattleShip().setEnd2y(player.getBattleShip().getEnd1y());
				player.getBattleShip().setEnd2x(player.getBattleShip().getEnd1x() - 3);
				break;
			}
			if(selection.equals("right") && this.checkRight(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y(), "battleship") == true) {
				player.getBattleShip().setEnd2y(player.getBattleShip().getEnd1y());
				player.getBattleShip().setEnd2x(player.getBattleShip().getEnd1x() + 3);
				break;
			}
			else
				System.out.println("\n\n\n\n\n\n\nInvalid Selection");
		}
		
		// checks whether the ship is vertical or horizontal and fills in the coordinates accordingly
		if (player.getBattleShip().isHorizontal() == true)
			player.getBattleShip().fillCoordsHoriz("battleship");
		if (player.getBattleShip().isVertical() == true)
			player.getBattleShip().fillCoordsVert("battleship");
		
		// places actual 'O's in the location of the newly placed ship
		this.placeO(grid, player.getBattleShip().getEnd1x(), player.getBattleShip().getEnd1y());
		this.placeO(grid, player.getBattleShip().getEnd2x(), player.getBattleShip().getEnd2y());
		if (player.getBattleShip().getEnd1y() == 10 && player.getBattleShip().isHorizontal()) {
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[1].substring(2, 3)), Integer.parseInt(player.getBattleShip().getCoords()[1].substring(0, 2)));
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[2].substring(2, 3)), Integer.parseInt(player.getBattleShip().getCoords()[2].substring(0, 2)));
		}
		if (player.getBattleShip().getEnd1y() == 10 && player.getBattleShip().isVertical() && player.getBattleShip().getEnd1x() != 10) {
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[1].substring(1, 2)), Integer.parseInt(player.getBattleShip().getCoords()[1].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[2].substring(1, 2)), Integer.parseInt(player.getBattleShip().getCoords()[2].substring(0, 1)));
		}
		if (player.getBattleShip().getEnd1y() == 10 && player.getBattleShip().isVertical() && player.getBattleShip().getEnd1x() == 10) {
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[1].substring(1, 3)), Integer.parseInt(player.getBattleShip().getCoords()[1].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[2].substring(1, 3)), Integer.parseInt(player.getBattleShip().getCoords()[2].substring(0, 1)));
		}
		if (player.getBattleShip().getEnd1y() != 10) {
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[1].substring(1)), Integer.parseInt(player.getBattleShip().getCoords()[1].substring(0, 1)));
			this.placeO(grid, Integer.parseInt(player.getBattleShip().getCoords()[2].substring(1)), Integer.parseInt(player.getBattleShip().getCoords()[2].substring(0, 1)));
		}
		
		// ===============================================================================================================================================================================
		
		
		
		// RESET PLACEHOLDER VARIABLES AND SPACING
		end1 = "";
		end2Poss = "You can place the second end point: ";
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
		
		
		// PLACE PLAYER'S SUBMARINE
		// ==========================================================================================================================================
		
		// initialize player 1's submarine
		player.createShip("submarine");
		
		// get the first end point and make sure it is in bounds and not over another ship
		while (true) {
			System.out.println("Next, place your submarine. It is 3 spaces long\nThe 'O's represent ships you already placed on the board\nYour grid:\n");
			this.displayGrid(grid);
			System.out.println("----------------------\nPlease enter the first end point: ");
			
			end1 = userInput.next();
			
			try {
				if (end1.length() > 1) {
					if (end1.length() < 3)
						if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), Integer.parseInt(end1.substring(1, 2))))
							break;
						else
							System.out.println("Invalid end point");
					if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
						if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), 10))
							break;
						else
							System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					else
						System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
				}
				else
					System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
			} catch (NumberFormatException e) {
				System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
			}

		}
		
		// check where the end point is and set the ship's actual end points to that location
		if (end1.length() != 3)
			player.getSubmarine().setEnd1x(Integer.parseInt(end1.substring(1, 2)));
		else
			player.getSubmarine().setEnd1x(10);
		player.getSubmarine().setEnd1y(this.convertLetter(end1.substring(0, 1)));
		
		// place a cursor '+' at the location where player 1 placed their first end point
		this.placeCursor(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y());
		
		// check where the ship's second end point can possibly go
		if (this.checkUp(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine")) {
			end2Poss += "up ";
		}
		if (this.checkDown(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine")) {
			end2Poss += "down ";
		}
		if (this.checkLeft(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine")) {
			end2Poss += "left ";
		}
		if (this.checkRight(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine")) {
			end2Poss += "right ";
		}
		
		// spacing
		System.out.println("\n\n\n\n\n\n\n");
		
		// asks player for selection out of possible second end point locations and checks to make sure that their selection is a valid one
		// if it is, sets the second end point for the ship
		while (true) {	
			System.out.println("Your grid:\n");
			this.displayGrid(grid);
			System.out.println("----------------------");
			System.out.println(end2Poss);
			System.out.println("Please enter your selection:");
			
			String selection = userInput.next();
			if(selection.equals("up") && this.checkUp(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine") == true) {
				player.getSubmarine().setEnd2y(player.getSubmarine().getEnd1y() - 2);
				player.getSubmarine().setEnd2x(player.getSubmarine().getEnd1x());
				break;
			}
			if(selection.equals("down") && this.checkDown(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine") == true) {
				player.getSubmarine().setEnd2y(player.getSubmarine().getEnd1y() + 2);
				player.getSubmarine().setEnd2x(player.getSubmarine().getEnd1x());
				break;
			}
			if(selection.equals("left") && this.checkLeft(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine") == true) {
				player.getSubmarine().setEnd2y(player.getSubmarine().getEnd1y());
				player.getSubmarine().setEnd2x(player.getSubmarine().getEnd1x() - 2);
				break;
			}
			if(selection.equals("right") && this.checkRight(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y(), "submarine") == true) {
				player.getSubmarine().setEnd2y(player.getSubmarine().getEnd1y());
				player.getSubmarine().setEnd2x(player.getSubmarine().getEnd1x() + 2);
				break;
			}
			else
				System.out.println("\n\n\n\n\n\n\nInvalid Selection");
		}
		
		// checks whether the ship is vertical or horizontal and fills in the coordinates accordingly
		if (player.getSubmarine().isHorizontal() == true)
			player.getSubmarine().fillCoordsHoriz("submarine");
		if (player.getSubmarine().isVertical() == true)
			player.getSubmarine().fillCoordsVert("submarine");
		
		// places actual 'O's in the location of the newly placed ship
		this.placeO(grid, player.getSubmarine().getEnd1x(), player.getSubmarine().getEnd1y());
		this.placeO(grid, player.getSubmarine().getEnd2x(), player.getSubmarine().getEnd2y());
		if (player.getSubmarine().getEnd1y() == 10 && player.getSubmarine().isHorizontal()) {
			this.placeO(grid, Integer.parseInt(player.getSubmarine().getCoords()[1].substring(2, 3)), Integer.parseInt(player.getSubmarine().getCoords()[1].substring(0, 2)));
		}
		if (player.getSubmarine().getEnd1y() == 10 && player.getSubmarine().isVertical() && player.getSubmarine().getEnd1x() != 10) {
			this.placeO(grid, Integer.parseInt(player.getSubmarine().getCoords()[1].substring(1, 2)), Integer.parseInt(player.getSubmarine().getCoords()[1].substring(0, 1)));
		}
		if (player.getSubmarine().getEnd1y() == 10 && player.getSubmarine().isVertical() && player.getSubmarine().getEnd1x() == 10) {
			this.placeO(grid, Integer.parseInt(player.getSubmarine().getCoords()[1].substring(1, 3)), Integer.parseInt(player.getSubmarine().getCoords()[1].substring(0, 1)));
		}
		if (player.getSubmarine().getEnd1y() != 10) {
			this.placeO(grid, Integer.parseInt(player.getSubmarine().getCoords()[1].substring(1)), Integer.parseInt(player.getSubmarine().getCoords()[1].substring(0, 1)));
		}
		
		// ===============================================================================================================================================================================
		
		
		
		// RESET PLACEHOLDER VARIABLES AND SPACING
		end1 = "";
		end2Poss = "You can place the second end point: ";
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
		
		
		// PLACE PLAYER'S DESTROYER
				// ==========================================================================================================================================
				
				// initialize player 1's destroyer
				player.createShip("destroyer");
				
				// get the first end point and make sure it is in bounds and not over another ship
				while (true) {
					System.out.println("Next, place your destroyer. It is 3 spaces long\nThe 'O's represent ships you already placed on the board\nYour grid:\n");
					this.displayGrid(grid);
					System.out.println("----------------------\nPlease enter the first end point: ");
					
					end1 = userInput.next();
					
					try {
						if (end1.length() > 1) {
							if (end1.length() < 3)
								if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), Integer.parseInt(end1.substring(1, 2))))
									break;
								else
									System.out.println("Invalid end point");
							if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
								if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), 10))
									break;
								else
									System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
							else
								System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
						}
						else
							System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					} catch (NumberFormatException e) {
						System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					}
				}
				
				// check where the end point is and set the ship's actual end points to that location
				if (end1.length() != 3)
					player.getDestroyer().setEnd1x(Integer.parseInt(end1.substring(1, 2)));
				else
					player.getDestroyer().setEnd1x(10);
				player.getDestroyer().setEnd1y(this.convertLetter(end1.substring(0, 1)));
				
				// place a cursor '+' at the location where player 1 placed their first end point
				this.placeCursor(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y());
				
				// check where the ship's second end point can possibly go
				if (this.checkUp(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer")) {
					end2Poss += "up ";
				}
				if (this.checkDown(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer")) {
					end2Poss += "down ";
				}
				if (this.checkLeft(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer")) {
					end2Poss += "left ";
				}
				if (this.checkRight(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer")) {
					end2Poss += "right ";
				}
				
				// spacing
				System.out.println("\n\n\n\n\n\n\n");
				
				// asks player for selection out of possible second end point locations and checks to make sure that their selection is a valid one
				// if it is, sets the second end point for the ship
				while (true) {	
					System.out.println("Your grid:\n");
					this.displayGrid(grid);
					System.out.println("----------------------");
					System.out.println(end2Poss);
					System.out.println("Please enter your selection:");
					
					String selection = userInput.next();
					if(selection.equals("up") && this.checkUp(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer") == true) {
						player.getDestroyer().setEnd2y(player.getDestroyer().getEnd1y() - 2);
						player.getDestroyer().setEnd2x(player.getDestroyer().getEnd1x());
						break;
					}
					if(selection.equals("down") && this.checkDown(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer") == true) {
						player.getDestroyer().setEnd2y(player.getDestroyer().getEnd1y() + 2);
						player.getDestroyer().setEnd2x(player.getDestroyer().getEnd1x());
						break;
					}
					if(selection.equals("left") && this.checkLeft(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer") == true) {
						player.getDestroyer().setEnd2y(player.getDestroyer().getEnd1y());
						player.getDestroyer().setEnd2x(player.getDestroyer().getEnd1x() - 2);
						break;
					}
					if(selection.equals("right") && this.checkRight(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y(), "destroyer") == true) {
						player.getDestroyer().setEnd2y(player.getDestroyer().getEnd1y());
						player.getDestroyer().setEnd2x(player.getDestroyer().getEnd1x() + 2);
						break;
					}
					else
						System.out.println("\n\n\n\n\n\n\nInvalid Selection");
				}
				
				// checks whether the ship is vertical or horizontal and fills in the coordinates accordingly
				if (player.getDestroyer().isHorizontal() == true)
					player.getDestroyer().fillCoordsHoriz("destroyer");
				if (player.getDestroyer().isVertical() == true)
					player.getDestroyer().fillCoordsVert("destroyer");
				
				// places actual 'O's in the location of the newly placed ship
				this.placeO(grid, player.getDestroyer().getEnd1x(), player.getDestroyer().getEnd1y());
				this.placeO(grid, player.getDestroyer().getEnd2x(), player.getDestroyer().getEnd2y());
				if (player.getDestroyer().getEnd1y() == 10 && player.getDestroyer().isHorizontal()) {
					this.placeO(grid, Integer.parseInt(player.getDestroyer().getCoords()[1].substring(2, 3)), Integer.parseInt(player.getDestroyer().getCoords()[1].substring(0, 2)));
				}
				if (player.getDestroyer().getEnd1y() == 10 && player.getDestroyer().isVertical() && player.getDestroyer().getEnd1x() != 10) {
					this.placeO(grid, Integer.parseInt(player.getDestroyer().getCoords()[1].substring(1, 2)), Integer.parseInt(player.getDestroyer().getCoords()[1].substring(0, 1)));
				}
				if (player.getDestroyer().getEnd1y() == 10 && player.getDestroyer().isVertical() && player.getDestroyer().getEnd1x() == 10) {
					this.placeO(grid, Integer.parseInt(player.getDestroyer().getCoords()[1].substring(1, 3)), Integer.parseInt(player.getDestroyer().getCoords()[1].substring(0, 1)));
				}
				if (player.getDestroyer().getEnd1y() != 10) {
					this.placeO(grid, Integer.parseInt(player.getDestroyer().getCoords()[1].substring(1)), Integer.parseInt(player.getDestroyer().getCoords()[1].substring(0, 1)));
				}
				
				// ===============================================================================================================================================================================
				
				
				
				// RESET PLACEHOLDER VARIABLES AND SPACING
				end1 = "";
				end2Poss = "You can place the second end point: ";
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				
				
				
				// PLACE PLAYER'S CRUISER
				// ==========================================================================================================================================
				
				// initialize player 1's cruiser
				player.createShip("cruiser");
				
				// get the first end point and make sure it is in bounds and not over another ship
				while (true) {
					System.out.println("Finally, place your cruiser. It is 2 spaces long\nThe 'O's represent ships you already placed on the board\nYour grid:\n");
					this.displayGrid(grid);
					System.out.println("----------------------\nPlease enter the first end point: ");
					
					end1 = userInput.next();
					
					try {
						if (end1.length() > 1) {
							if (end1.length() < 3)
								if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), Integer.parseInt(end1.substring(1, 2))))
									break;
								else
									System.out.println("Invalid end point");
							if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
								if (this.checkEndPoint(grid, this.convertLetter(end1.substring(0, 1)), 10))
									break;
								else
									System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
							else
								System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
						}
						else
							System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					} catch (NumberFormatException e) {
						System.out.println("\n\n\n\n\n\n\n\n\n\nInvalid end point");
					}

				}
				
				// check where the end point is and set the ship's actual end points to that location
				if (end1.length() != 3)
					player.getCruiser().setEnd1x(Integer.parseInt(end1.substring(1, 2)));
				else
					player.getCruiser().setEnd1x(10);
				player.getCruiser().setEnd1y(this.convertLetter(end1.substring(0, 1)));
				
				// place a cursor '+' at the location where player 1 placed their first end point
				this.placeCursor(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y());
				
				// System.out.println(player.getCruiser().getEnd1x() + " " + player.getCruiser().getEnd1y());
				
				// check where the ship's second end point can possibly go
				if (this.checkUp(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser")) {
					end2Poss += "up ";
				}
				if (this.checkDown(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser")) {
					end2Poss += "down ";
				}
				if (this.checkLeft(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser")) {
					end2Poss += "left ";
				}
				if (this.checkRight(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser")) {
					end2Poss += "right ";
				}
				
				// spacing
				System.out.println("\n\n\n\n\n\n\n");
				
				// asks player for selection out of possible second end point locations and checks to make sure that their selection is a valid one
				// if it is, sets the second end point for the ship
				while (true) {	
					System.out.println("Your grid:\n");
					this.displayGrid(grid);
					System.out.println("----------------------");
					System.out.println(end2Poss);
					System.out.println("Please enter your selection:");
					
					String selection = userInput.next();
					if(selection.equals("up") && this.checkUp(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser") == true) {
						player.getCruiser().setEnd2y(player.getCruiser().getEnd1y() - 1);
						player.getCruiser().setEnd2x(player.getCruiser().getEnd1x());
						break;
					}
					if(selection.equals("down") && this.checkDown(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser") == true) {
						player.getCruiser().setEnd2y(player.getCruiser().getEnd1y() + 1);
						player.getCruiser().setEnd2x(player.getCruiser().getEnd1x());
						break;
					}
					if(selection.equals("left") && this.checkLeft(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser") == true) {
						player.getCruiser().setEnd2y(player.getCruiser().getEnd1y());
						player.getCruiser().setEnd2x(player.getCruiser().getEnd1x() - 1);
						break;
					}
					if(selection.equals("right") && this.checkRight(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y(), "cruiser") == true) {
						player.getCruiser().setEnd2y(player.getCruiser().getEnd1y());
						player.getCruiser().setEnd2x(player.getCruiser().getEnd1x() + 1);
						break;
					}
					else
						System.out.println("\n\n\n\n\n\n\nInvalid Selection");
				}
				
				// checks whether the ship is vertical or horizontal and fills in the coordinates accordingly
				if (player.getCruiser().isHorizontal() == true)
					player.getCruiser().fillCoordsHoriz("cruiser");
				if (player.getCruiser().isVertical() == true)
					player.getCruiser().fillCoordsVert("cruiser");
				
				// places actual 'O's in the location of the newly placed ship
				this.placeO(grid, player.getCruiser().getEnd1x(), player.getCruiser().getEnd1y());
				this.placeO(grid, player.getCruiser().getEnd2x(), player.getCruiser().getEnd2y());
				
				// ===============================================================================================================================================================================
				
				
				
				// RESET PLACEHOLDER VARIABLES AND SPACING
				end1 = "";
				end2Poss = "You can place the second end point: ";
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
	}
	
}