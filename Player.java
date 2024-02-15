package Java.myProjects.Battleship;

import java.util.List;
import java.util.ArrayList;

public class Player {
	private String name;
	private int shipsLeft = 5;
	private Ship carrier;
	private Ship battleship;
	private Ship submarine;
	private Ship destroyer;
	private Ship cruiser;
	private boolean gotHit = false;
	private String gotSunk = "";
	private List<Ship> ships = new ArrayList<Ship>();
	
	public Player(String name) {
		this.name = name;
	}
	
	// GETTERS
	public String getName() {
		return this.name;
	}
	
	public int getShipsLeft() {
		return this.shipsLeft;
	}
	
	public Ship getCarrier() {
		return this.carrier;
	}
	
	public Ship getBattleShip() {
		return this.battleship;
	}
	
	public Ship getSubmarine() {
		return this.submarine;
	}
	
	public Ship getDestroyer() {
		return this.destroyer;
	}
	
	public Ship getCruiser() {
		return this.cruiser;
	}
	
	public List<Ship> getShips() {
		return this.ships;
	}
	
	public boolean getHitorNot() {
		return this.gotHit;
	}
	
	public String getShipGotSunk() {
		return this.gotSunk;
	}
	
	public void createShip(String type) {
		if (type.equals("carrier")) {
			carrier = new Ship("carrier");
			this.ships.add(this.carrier);
		}
		if (type.equals("battleship")) {
			this.battleship = new Ship("battleship");
			this.ships.add(this.battleship);
		}
		if (type.equals("submarine")) {
			this.submarine = new Ship("submarine");
			this.ships.add(this.submarine);
		}
		if (type.equals("destroyer")) {
			this.destroyer = new Ship("destroyer");
			this.ships.add(this.destroyer);
		}
		if (type.equals("cruiser")) {
			this.cruiser = new Ship("cruiser");
			this.ships.add(this.cruiser);
		}
	}
	
	public void shipGotSunk() {
		this.shipsLeft --;
	}
	
	public boolean hasShipsLeft() {
		if (this.shipsLeft > 0)
			return true;
		else
			return false;
	}
	
	public void guessCoord(int x, int y, Player otherPlayer, String[][] grid, String[][] playGrid) {
		otherPlayer.gotHit = false;
		otherPlayer.gotSunk = "";
		
		if (otherPlayer.getCarrier().isHit(x, y) || otherPlayer.getBattleShip().isHit(x, y) || otherPlayer.getSubmarine().isHit(x , y) || otherPlayer.getDestroyer().isHit(x, y) || otherPlayer.getCruiser().isHit(x, y)) {
			playGrid[y][x] = "X";
			
			if (otherPlayer.getCarrier().isHit(x, y)) {
				otherPlayer.getCarrier().gotHit();
				if (otherPlayer.getCarrier().isSunk()) {
					otherPlayer.shipGotSunk();
					otherPlayer.gotSunk = "Carrier";
				}
			}
			if (otherPlayer.getBattleShip().isHit(x, y)) {
				otherPlayer.getBattleShip().gotHit();
				if (otherPlayer.getBattleShip().isSunk()) {
					otherPlayer.shipGotSunk();
					otherPlayer.gotSunk = "Battleship";
				}
			}
			if (otherPlayer.getSubmarine().isHit(x, y)) {
				otherPlayer.getSubmarine().gotHit();
				if (otherPlayer.getSubmarine().isSunk()) {
					otherPlayer.shipGotSunk();
					otherPlayer.gotSunk = "Submarine";
				}
			}
			if (otherPlayer.getDestroyer().isHit(x, y)) {
				otherPlayer.getDestroyer().gotHit();
				if (otherPlayer.getDestroyer().isSunk()) {
					otherPlayer.shipGotSunk();
					otherPlayer.gotSunk = "Destroyer";
				}
			}
			if (otherPlayer.getCruiser().isHit(x, y)) {
				otherPlayer.getCruiser().gotHit();
				if (otherPlayer.getCruiser().isSunk()) {
					otherPlayer.shipGotSunk();
					otherPlayer.gotSunk = "Cruiser";
				}
			}
			otherPlayer.gotHit = true;
		}
		else {
			playGrid[y][x] = "O";
		}
			
			
	}
	
}
