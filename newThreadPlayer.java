package Java.myProjects.Battleship;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class newThreadPlayer implements Runnable{
	
	// PLACE SHIPS

	

	
	// place ships
	
	private Random random = new Random();
	private Player threadPlayer;
	private String[][] threadPlayerGrid = new String[11][11];
	private String[][] threadPlayerGameGrid = new String[11][11];
	private List<String> guesses = new ArrayList<String>();
	private Game game = new Game();
	private Player otherPlayer;
	private String[][] otherPlayerGrid;
	private boolean computerTurn = false;
	
	public newThreadPlayer(String name, Player otherPlayer, String[][] otherPlayerGrid) {
		this.threadPlayer = new Player(name);
		this.otherPlayer = otherPlayer;
		this.otherPlayerGrid = otherPlayerGrid;
		
		this.guesses.add("`");
		
		this.game.buildGrid(this.threadPlayerGrid);
		this.game.buildGrid(this.threadPlayerGameGrid);
		
		String end1 = "";
		
		this.threadPlayer.createShip("carrier");
		this.threadPlayer.createShip("battleship");
		this.threadPlayer.createShip("submarine");
		this.threadPlayer.createShip("destroyer");
		this.threadPlayer.createShip("cruiser");
		
		// place carrier
		while (true) {		
			end1 = this.getCoord();
			if (end1.length() > 1) {
				if (end1.length() < 3)
					if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), this.game.convertLetter(end1.substring(1, 2))))
						break;
					else
						System.out.println("Invalid end point");
				if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
					if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), 10))
						break;
			}
		}
		
		if (end1.length() != 3)
			this.threadPlayer.getCarrier().setEnd1x(this.game.convertLetter(end1.substring(1, 2)));
		else
			this.threadPlayer.getCarrier().setEnd1x(10);
		this.threadPlayer.getCarrier().setEnd1y(this.game.convertLetter(end1.substring(0, 1)));
		
		while (true) {	
			if(this.game.checkUp(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd1x(), this.threadPlayer.getCarrier().getEnd1y(), "carrier") == true) {
				this.threadPlayer.getCarrier().setEnd2y(this.threadPlayer.getCarrier().getEnd1y() - 4);
				this.threadPlayer.getCarrier().setEnd2x(this.threadPlayer.getCarrier().getEnd1x());
				break;
			}
			if(this.game.checkDown(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd1x(), this.threadPlayer.getCarrier().getEnd1y(), "carrier") == true) {
				this.threadPlayer.getCarrier().setEnd2y(this.threadPlayer.getCarrier().getEnd1y() + 4);
				this.threadPlayer.getCarrier().setEnd2x(this.threadPlayer.getCarrier().getEnd1x());
				break;
			}
			if(this.game.checkLeft(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd1x(), this.threadPlayer.getCarrier().getEnd1y(), "carrier") == true) {
				this.threadPlayer.getCarrier().setEnd2y(this.threadPlayer.getCarrier().getEnd1y());
				this.threadPlayer.getCarrier().setEnd2x(this.threadPlayer.getCarrier().getEnd1x() - 4);
				break;
			}
			if(this.game.checkRight(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd1x(), this.threadPlayer.getCarrier().getEnd1y(), "carrier") == true) {
				this.threadPlayer.getCarrier().setEnd2y(this.threadPlayer.getCarrier().getEnd1y());
				this.threadPlayer.getCarrier().setEnd2x(this.threadPlayer.getCarrier().getEnd1x() + 4);
				break;
			}
		}
		
		if (this.threadPlayer.getCarrier().isHorizontal() == true)
			this.threadPlayer.getCarrier().fillCoordsHoriz("carrier");
		if (this.threadPlayer.getCarrier().isVertical() == true)
			this.threadPlayer.getCarrier().fillCoordsVert("carrier");
		
		// places actual 'O's in the location of the newly placed ship
		this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd1x(), this.threadPlayer.getCarrier().getEnd1y());
		this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd2x(), this.threadPlayer.getCarrier().getEnd2y());
		if (this.threadPlayer.getCarrier().getEnd1y() == 10 && this.threadPlayer.getCarrier().isHorizontal()) {
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(2, 3)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(0, 2)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(2, 3)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(0, 2)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(2, 3)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(0, 2)));
		}
		if (this.threadPlayer.getCarrier().getEnd1y() == 10 && this.threadPlayer.getCarrier().isVertical() && this.threadPlayer.getCarrier().getEnd1x() != 10) {
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(1, 2)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(0, 1)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(1, 2)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(0, 1)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(1, 2)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(0, 1)));
		}
		if (this.threadPlayer.getCarrier().getEnd1y() == 10 && this.threadPlayer.getCarrier().isVertical() && this.threadPlayer.getCarrier().getEnd1x() == 10) {
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(1, 3)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(0, 1)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(1, 3)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(0, 1)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(1, 3)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(0, 1)));
		}
		if (this.threadPlayer.getCarrier().getEnd1y() != 10) {
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(1)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[1].substring(0, 1)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(1)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[2].substring(0, 1)));
			this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(1)), Integer.parseInt(this.threadPlayer.getCarrier().getCoords()[3].substring(0, 1)));
		}
		
		end1 = "";
		
		// place battleship
				while (true) {	
					end1 = this.getCoord();
					if (end1.length() > 1) {
						if (end1.length() < 3)
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), this.game.convertLetter(end1.substring(1, 2))))
								break;
							else
								System.out.println("Invalid end point");
						if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), 10))
								break;
					}
				}
				
				if (end1.length() != 3)
					this.threadPlayer.getBattleShip().setEnd1x(this.game.convertLetter(end1.substring(1, 2)));
				else
					this.threadPlayer.getBattleShip().setEnd1x(10);
				this.threadPlayer.getBattleShip().setEnd1y(this.game.convertLetter(end1.substring(0, 1)));
				
				while (true) {	
					if(this.game.checkUp(this.threadPlayerGrid, this.threadPlayer.getBattleShip().getEnd1x(), this.threadPlayer.getBattleShip().getEnd1y(), "battleship") == true) {
						this.threadPlayer.getBattleShip().setEnd2y(this.threadPlayer.getBattleShip().getEnd1y() - 3);
						this.threadPlayer.getBattleShip().setEnd2x(this.threadPlayer.getBattleShip().getEnd1x());
						break;
					}
					if(this.game.checkDown(this.threadPlayerGrid, this.threadPlayer.getBattleShip().getEnd1x(), this.threadPlayer.getBattleShip().getEnd1y(), "battleship") == true) {
						this.threadPlayer.getBattleShip().setEnd2y(this.threadPlayer.getBattleShip().getEnd1y() + 3);
						this.threadPlayer.getBattleShip().setEnd2x(this.threadPlayer.getBattleShip().getEnd1x());
						break;
					}
					if(this.game.checkLeft(this.threadPlayerGrid, this.threadPlayer.getBattleShip().getEnd1x(), this.threadPlayer.getBattleShip().getEnd1y(), "battleship") == true) {
						this.threadPlayer.getBattleShip().setEnd2y(this.threadPlayer.getBattleShip().getEnd1y());
						this.threadPlayer.getBattleShip().setEnd2x(this.threadPlayer.getBattleShip().getEnd1x() - 3);
						break;
					}
					if(this.game.checkRight(this.threadPlayerGrid, this.threadPlayer.getBattleShip().getEnd1x(), this.threadPlayer.getBattleShip().getEnd1y(), "battleship") == true) {
						this.threadPlayer.getBattleShip().setEnd2y(this.threadPlayer.getBattleShip().getEnd1y());
						this.threadPlayer.getBattleShip().setEnd2x(this.threadPlayer.getBattleShip().getEnd1x() + 3);
						break;
					}
				}
				
				if (this.threadPlayer.getBattleShip().isHorizontal() == true)
					this.threadPlayer.getBattleShip().fillCoordsHoriz("battleship");
				if (this.threadPlayer.getBattleShip().isVertical() == true)
					this.threadPlayer.getBattleShip().fillCoordsVert("battleship");
				
				// places actual 'O's in the location of the newly placed ship
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getBattleShip().getEnd1x(), this.threadPlayer.getBattleShip().getEnd1y());
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getBattleShip().getEnd2x(), this.threadPlayer.getBattleShip().getEnd2y());
				if (this.threadPlayer.getBattleShip().getEnd1y() == 10 && this.threadPlayer.getBattleShip().isHorizontal()) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(2, 3)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(0, 2)));
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(2, 3)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(0, 2)));
				}
				if (this.threadPlayer.getBattleShip().getEnd1y() == 10 && this.threadPlayer.getBattleShip().isVertical() && this.threadPlayer.getBattleShip().getEnd1x() != 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(1, 2)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(0, 1)));
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(1, 2)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(0, 1)));
				}
				if (this.threadPlayer.getBattleShip().getEnd1y() == 10 && this.threadPlayer.getBattleShip().isVertical() && this.threadPlayer.getBattleShip().getEnd1x() == 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(1, 3)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(0, 1)));
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(1, 3)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(0, 1)));
				}
				if (this.threadPlayer.getBattleShip().getEnd1y() != 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(1)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[1].substring(0, 1)));
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(1)), Integer.parseInt(this.threadPlayer.getBattleShip().getCoords()[2].substring(0, 1)));
				}
				
				end1 = "";
				
				// place submarine
				while (true) {		
					end1 = this.getCoord();
					if (end1.length() > 1) {
						if (end1.length() < 3)
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), this.game.convertLetter(end1.substring(1, 2))))
								break;
							else
								System.out.println("Invalid end point");
						if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), 10))
								break;
					}
				}
				
				if (end1.length() != 3)
					this.threadPlayer.getSubmarine().setEnd1x(this.game.convertLetter(end1.substring(1, 2)));
				else
					this.threadPlayer.getSubmarine().setEnd1x(10);
				this.threadPlayer.getSubmarine().setEnd1y(this.game.convertLetter(end1.substring(0, 1)));
				
				while (true) {	
					if(this.game.checkUp(this.threadPlayerGrid, this.threadPlayer.getSubmarine().getEnd1x(), this.threadPlayer.getSubmarine().getEnd1y(), "submarine") == true) {
						this.threadPlayer.getSubmarine().setEnd2y(this.threadPlayer.getSubmarine().getEnd1y() - 2);
						this.threadPlayer.getSubmarine().setEnd2x(this.threadPlayer.getSubmarine().getEnd1x());
						break;
					}
					if(this.game.checkDown(this.threadPlayerGrid, this.threadPlayer.getSubmarine().getEnd1x(), this.threadPlayer.getSubmarine().getEnd1y(), "submarine") == true) {
						this.threadPlayer.getSubmarine().setEnd2y(this.threadPlayer.getSubmarine().getEnd1y() + 2);
						this.threadPlayer.getSubmarine().setEnd2x(this.threadPlayer.getSubmarine().getEnd1x());
						break;
					}
					if(this.game.checkLeft(this.threadPlayerGrid, this.threadPlayer.getSubmarine().getEnd1x(), this.threadPlayer.getSubmarine().getEnd1y(), "submarine") == true) {
						this.threadPlayer.getSubmarine().setEnd2y(this.threadPlayer.getSubmarine().getEnd1y());
						this.threadPlayer.getSubmarine().setEnd2x(this.threadPlayer.getSubmarine().getEnd1x() - 2);
						break;
					}
					if(this.game.checkRight(this.threadPlayerGrid, this.threadPlayer.getSubmarine().getEnd1x(), this.threadPlayer.getSubmarine().getEnd1y(), "submarine") == true) {
						this.threadPlayer.getSubmarine().setEnd2y(this.threadPlayer.getSubmarine().getEnd1y());
						this.threadPlayer.getSubmarine().setEnd2x(this.threadPlayer.getSubmarine().getEnd1x() + 2);
						break;
					}
				}
				
				if (this.threadPlayer.getSubmarine().isHorizontal() == true)
					this.threadPlayer.getSubmarine().fillCoordsHoriz("submarine");
				if (this.threadPlayer.getSubmarine().isVertical() == true)
					this.threadPlayer.getSubmarine().fillCoordsVert("submarine");
				
				// places actual 'O's in the location of the newly placed ship
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getSubmarine().getEnd1x(), this.threadPlayer.getSubmarine().getEnd1y());
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getSubmarine().getEnd2x(), this.threadPlayer.getSubmarine().getEnd2y());
				if (this.threadPlayer.getSubmarine().getEnd1y() == 10 && this.threadPlayer.getSubmarine().isHorizontal()) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(2, 3)), Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(0, 2)));
				}
				if (this.threadPlayer.getSubmarine().getEnd1y() == 10 && this.threadPlayer.getSubmarine().isVertical() && this.threadPlayer.getSubmarine().getEnd1x() != 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(1, 2)), Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(0, 1)));
				}
				if (this.threadPlayer.getSubmarine().getEnd1y() == 10 && this.threadPlayer.getSubmarine().isVertical() && this.threadPlayer.getSubmarine().getEnd1x() == 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(1, 3)), Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(0, 1)));
				}
				if (this.threadPlayer.getSubmarine().getEnd1y() != 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(1)), Integer.parseInt(this.threadPlayer.getSubmarine().getCoords()[1].substring(0, 1)));
				}
				
				end1 = "";
				
				// place destroyer
				while (true) {		
					end1 = this.getCoord();
					if (end1.length() > 1) {
						if (end1.length() < 3)
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), this.game.convertLetter(end1.substring(1, 2))))
								break;
							else
								System.out.println("Invalid end point");
						if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), 10))
								break;
					}
				}
				
				if (end1.length() != 3)
					this.threadPlayer.getDestroyer().setEnd1x(this.game.convertLetter(end1.substring(1, 2)));
				else
					this.threadPlayer.getDestroyer().setEnd1x(10);
				this.threadPlayer.getDestroyer().setEnd1y(this.game.convertLetter(end1.substring(0, 1)));
				
				while (true) {	
					if(this.game.checkUp(this.threadPlayerGrid, this.threadPlayer.getDestroyer().getEnd1x(), this.threadPlayer.getDestroyer().getEnd1y(), "destroyer") == true) {
						this.threadPlayer.getDestroyer().setEnd2y(this.threadPlayer.getDestroyer().getEnd1y() - 2);
						this.threadPlayer.getDestroyer().setEnd2x(this.threadPlayer.getDestroyer().getEnd1x());
						break;
					}
					if(this.game.checkDown(this.threadPlayerGrid, this.threadPlayer.getDestroyer().getEnd1x(), this.threadPlayer.getDestroyer().getEnd1y(), "destroyer") == true) {
						this.threadPlayer.getDestroyer().setEnd2y(this.threadPlayer.getDestroyer().getEnd1y() + 2);
						this.threadPlayer.getDestroyer().setEnd2x(this.threadPlayer.getDestroyer().getEnd1x());
						break;
					}
					if(this.game.checkLeft(this.threadPlayerGrid, this.threadPlayer.getCarrier().getEnd1x(), this.threadPlayer.getDestroyer().getEnd1y(), "destroyer") == true) {
						this.threadPlayer.getCarrier().setEnd2y(this.threadPlayer.getCarrier().getEnd1y());
						this.threadPlayer.getCarrier().setEnd2x(this.threadPlayer.getCarrier().getEnd1x() - 2);
						break;
					}
					if(this.game.checkRight(this.threadPlayerGrid, this.threadPlayer.getDestroyer().getEnd1x(), this.threadPlayer.getDestroyer().getEnd1y(), "destroyer") == true) {
						this.threadPlayer.getDestroyer().setEnd2y(this.threadPlayer.getDestroyer().getEnd1y());
						this.threadPlayer.getDestroyer().setEnd2x(this.threadPlayer.getDestroyer().getEnd1x() + 2);
						break;
					}
				}
				
				if (this.threadPlayer.getDestroyer().isHorizontal() == true)
					this.threadPlayer.getDestroyer().fillCoordsHoriz("destroyer");
				if (this.threadPlayer.getDestroyer().isVertical() == true)
					this.threadPlayer.getDestroyer().fillCoordsVert("destroyer");
				
				// places actual 'O's in the location of the newly placed ship
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getDestroyer().getEnd1x(), this.threadPlayer.getDestroyer().getEnd1y());
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getDestroyer().getEnd2x(), this.threadPlayer.getDestroyer().getEnd2y());
				if (this.threadPlayer.getDestroyer().getEnd1y() == 10 && this.threadPlayer.getDestroyer().isHorizontal()) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(2, 3)), Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(0, 2)));
				}
				if (this.threadPlayer.getDestroyer().getEnd1y() == 10 && this.threadPlayer.getDestroyer().isVertical() && this.threadPlayer.getDestroyer().getEnd1x() != 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(1, 2)), Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(0, 1)));
				}
				if (this.threadPlayer.getDestroyer().getEnd1y() == 10 && this.threadPlayer.getDestroyer().isVertical() && this.threadPlayer.getDestroyer().getEnd1x() == 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(1, 3)), Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(0, 1)));
				}
				if (this.threadPlayer.getDestroyer().getEnd1y() != 10) {
					this.game.placeO(this.threadPlayerGrid, Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(1)), Integer.parseInt(this.threadPlayer.getDestroyer().getCoords()[1].substring(0, 1)));
				}
				
				end1 = "";
				
				// place cruiser
				while (true) {	
					end1 = this.getCoord();
					if (end1.length() > 1) {
						if (end1.length() < 3)
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), this.game.convertLetter(end1.substring(1, 2))))
								break;
							else
								System.out.println("Invalid end point");
						if (end1.length() == 3 && end1.substring(1, 3).equals("10"))
							if (this.game.checkEndPoint(this.threadPlayerGrid, this.game.convertLetter(end1.substring(0, 1)), 10))
								break;
					}
				}
				
				if (end1.length() != 3)
					this.threadPlayer.getCruiser().setEnd1x(this.game.convertLetter(end1.substring(1, 2)));
				else
					this.threadPlayer.getCruiser().setEnd1x(10);
				this.threadPlayer.getCruiser().setEnd1y(this.game.convertLetter(end1.substring(0, 1)));
				
				while (true) {	
					if(this.game.checkUp(this.threadPlayerGrid, this.threadPlayer.getCruiser().getEnd1x(), this.threadPlayer.getCruiser().getEnd1y(), "cruiser") == true) {
						this.threadPlayer.getCruiser().setEnd2y(this.threadPlayer.getCruiser().getEnd1y() - 1);
						this.threadPlayer.getCruiser().setEnd2x(this.threadPlayer.getCruiser().getEnd1x());
						break;
					}
					if(this.game.checkDown(this.threadPlayerGrid, this.threadPlayer.getCruiser().getEnd1x(), this.threadPlayer.getCruiser().getEnd1y(), "cruiser") == true) {
						this.threadPlayer.getCruiser().setEnd2y(this.threadPlayer.getCruiser().getEnd1y() + 1);
						this.threadPlayer.getCruiser().setEnd2x(this.threadPlayer.getCruiser().getEnd1x());
						break;
					}
					if(this.game.checkLeft(this.threadPlayerGrid, this.threadPlayer.getCruiser().getEnd1x(), this.threadPlayer.getCruiser().getEnd1y(), "cruiser") == true) {
						this.threadPlayer.getCruiser().setEnd2y(this.threadPlayer.getCruiser().getEnd1y());
						this.threadPlayer.getCruiser().setEnd2x(this.threadPlayer.getCruiser().getEnd1x() - 1);
						break;
					}
					if(this.game.checkRight(this.threadPlayerGrid, this.threadPlayer.getCruiser().getEnd1x(), this.threadPlayer.getCruiser().getEnd1y(), "cruiser") == true) {
						this.threadPlayer.getCruiser().setEnd2y(this.threadPlayer.getCruiser().getEnd1y());
						this.threadPlayer.getCruiser().setEnd2x(this.threadPlayer.getCruiser().getEnd1x() + 1);
						break;
					}
				}
				
				if (this.threadPlayer.getCruiser().isHorizontal() == true)
					this.threadPlayer.getCruiser().fillCoordsHoriz("cruiser");
				if (this.threadPlayer.getCruiser().isVertical() == true)
					this.threadPlayer.getCruiser().fillCoordsVert("cruiser");	
				
				// places actual 'O's in the location of the newly placed ship
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getCruiser().getEnd1x(), this.threadPlayer.getCruiser().getEnd1y());
				this.game.placeO(this.threadPlayerGrid, this.threadPlayer.getCruiser().getEnd2x(), this.threadPlayer.getCruiser().getEnd2y());
	}
	
	
	public Player getThreadPlayer() {
		return this.threadPlayer;
	}
	
	public String[][] getGrid() {
		return this.threadPlayerGrid;
	}
	
	public void flipTurn() {
		this.computerTurn = true;
	}
	
	public String getCoord() {
		String guess = "";
		int guessLetter = random.nextInt(1, 11);
		
		if (guessLetter == 1)
			guess += "a";
		if (guessLetter == 2)
			guess += "b";
		if (guessLetter == 3)
			guess += "c";
		if (guessLetter == 4)
			guess += "d";
		if (guessLetter == 5)
			guess += "e";
		if (guessLetter == 6)
			guess += "f";
		if (guessLetter == 7)
			guess += "g";
		if (guessLetter == 8)
			guess += "h";
		if (guessLetter == 9)
			guess += "i";
		if (guessLetter == 10)
			guess += "j";
		
		int guessLetter2 = random.nextInt(1, 11);
		
		if (guessLetter2 == 1)
			guess += "a";
		if (guessLetter2 == 2)
			guess += "b";
		if (guessLetter2 == 3)
			guess += "c";
		if (guessLetter2 == 4)
			guess += "d";
		if (guessLetter2 == 5)
			guess += "e";
		if (guessLetter2 == 6)
			guess += "f";
		if (guessLetter2 == 7)
			guess += "g";
		if (guessLetter2 == 8)
			guess += "h";
		if (guessLetter2 == 9)
			guess += "i";
		if (guessLetter2 == 10)
			guess += "j";
		
		return guess;
	}
	
	public boolean getTurn() {
		return this.computerTurn;
	}
	
	

	
	public List<String> getGuesses() {
		return this.guesses;
	}
	
	
	
	public void run() {
		String newGuess;
		
		if (this.computerTurn) {
			System.out.println("\n\n\n\n\n\n\n\n");
			while (true) {
				newGuess = this.getCoord();
				if (this.guesses.contains(newGuess) == false) 
					break;
			}
			this.threadPlayer.guessCoord(this.game.convertLetter(newGuess.substring(1)), this.game.convertLetter(newGuess.substring(0, 1)), this.otherPlayer, this.otherPlayerGrid, this.threadPlayerGameGrid);
			this.guesses.add(newGuess);
			this.computerTurn = false;
		} 
	}
}