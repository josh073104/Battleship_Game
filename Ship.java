package Java.myProjects.Battleship;

public class Ship {
	
	private String type;
	private int length;
	private int activeLength;
	private int end1x;
	private int end1y;
	private int end2x;
	private int end2y;
	private String[] coords; // to get x and y return integer version of 0 and 1 index

	
	public Ship(String type) {
		this.type = type;
		if (type.equals("carrier")) {
			this.length = 5;
			this.activeLength = 5;
			this.coords = new String[5];
		}
		if (type.equals("battleship")) {
			this.length = 4;
			this.activeLength = 4;
			this.coords = new String[4];
		}
		if (type.equals("submarine")) {
			this.length = 3;
			this.activeLength = 3;
			this.coords = new String[3];
		}
		if (type.equals("destroyer")) {
			this.length = 3;
			this.activeLength = 3;
			this.coords = new String[3];
		}
		if (type.equals("cruiser")) {
			this.length = 2;
			this.activeLength = 2;
			this.coords = new String[2];
		}
	}
	
	// GETTERS
	public String getType() {
		return this.type;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int getActiveLength() {
		return this.activeLength;
	}
	
	public int getEnd1x() {
		return this.end1x;
	}
	
	public int getEnd1y() {
		return this.end1y;
	}
	
	public int getEnd2x() {
		return this.end2x;
	}
	
	public int getEnd2y() {
		return this.end2y;
	}
	
	public String[] getCoords() {
		return this.coords;
	}
	
	public String getSpecCoord(int index) {
		return this.coords[index];
	}
	
	// SETTERS
	public void setActiveLength(int actLength) {
		this.activeLength = actLength;
	}
	
	public void setEnd1x(int end1x) {
		this.end1x = end1x;
	}
	
	public void setEnd1y(int end1y) {
		this.end1y = end1y;
	}
	
	public void setEnd2x(int end2x) {
		this.end2x = end2x;
	}
	
	public void setEnd2y(int end2y) {
		this.end2y = end2y;
	}
	
	
	
	// OTHER METHODS
	public boolean isHit(int x, int y) {
		String coord = String.valueOf(y) + String.valueOf(x);
		for (int i = 0; i < this.length; i ++) {
			if (this.coords[i].equals(coord)) 
				return true;
		}
		return false;
	}
	
	public boolean isSunk() {
		if (this.activeLength == 0) 
			return true;
		else 
			return false;
	}
	
	public void gotHit() {
		this.activeLength --;
	}	
	
	public void moveEndPoint() {
		
	}
	
	public boolean isHorizontal() {
		if (this.end1y - this.end2y == 0)
			return true;
		else
			return false;
	}
	
	public boolean isVertical() {
		if (this.end1x - this.end2x == 0)
			return true;
		else
			return false;
	}
	
	public void fillCoordsVert(String type) {
		if (this.end1y < this.end2y) {
			if (type.equals("carrier")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y + 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end1y + 2) + String.valueOf(this.end1x);
				this.coords[3] = String.valueOf(this.end1y + 3) + String.valueOf(this.end1x);
				this.coords[4] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("battleship")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y + 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end1y + 2) + String.valueOf(this.end1x);
				this.coords[3] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("submarine")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y + 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("destroyer")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y + 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("cruiser")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
		}
		else {
			if (type.equals("carrier")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y - 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end1y - 2) + String.valueOf(this.end1x);
				this.coords[3] = String.valueOf(this.end1y - 3) + String.valueOf(this.end1x);
				this.coords[4] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("battleship")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y - 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end1y - 2) + String.valueOf(this.end1x);
				this.coords[3] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("submarine")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y - 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("destroyer")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y - 1) + String.valueOf(this.end1x);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("cruiser")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
		}
	}
	
	public void fillCoordsHoriz(String type) {
		if (this.end1x < this.end2x) {
			if (type.equals("carrier")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 1);
				this.coords[2] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 2);
				this.coords[3] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 3);
				this.coords[4] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("battleship")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 1);
				this.coords[2] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 2);
				this.coords[3] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("submarine")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 1);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("destroyer")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x + 1);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("cruiser")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
		}
		else {
			if (type.equals("carrier")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 1);
				this.coords[2] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 2);
				this.coords[3] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 3);
				this.coords[4] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("battleship")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 1);
				this.coords[2] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 2);
				this.coords[3] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("submarine")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 1);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("destroyer")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end1y) + String.valueOf(this.end1x - 1);
				this.coords[2] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
			if (type.equals("cruiser")) {
				this.coords[0] = String.valueOf(this.end1y) + String.valueOf(this.end1x);
				this.coords[1] = String.valueOf(this.end2y) + String.valueOf(this.end2x);
			}
		}
	}
}