package blocks;

import java.awt.Point;

public abstract class Block {
	
	protected Point Coord1=new Point(0,0);
	protected Point Coord2=new Point(0,0);
	protected Point Coord3=new Point(0,0);
	protected Point Coord4=new Point(0,0);

	/*
	 * Moves a Block 1 line down
	 */
	public boolean moveDown(){
			
		this.Coord1.y++;
		this.Coord2.y++;
		this.Coord3.y++;
		this.Coord4.y++;
		return true;
	}
	
	
	
	public abstract void turnRight();
	public abstract void turnLeft();

	public Point getCoord1() {
		return Coord1;
	}

	public void setCoord1(Point coord1) {
		Coord1 = coord1;
	}

	public Point getCoord2() {
		return Coord2;
	}

	public void setCoord2(Point coord2) {
		Coord2 = coord2;
	}

	public Point getCoord3() {
		return Coord3;
	}

	public void setCoord3(Point coord3) {
		Coord3 = coord3;
	}

	public Point getCoord4() {
		return Coord4;
	}

	public void setCoord4(Point coord4) {
		Coord4 = coord4;
	}
	
	
}
