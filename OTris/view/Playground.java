package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import blocks.Block;



public class Playground extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int EMPTY = 0;
	public static final int SQUARE = 1;
	public static final int IBLOCK = 2;
	public static final int LLBLOCK = 3;
	public static final int RLBLOCK=7;
	public static final int LSBLOCK = 4;
	public static final int RSBLOCK= 5;
	public static final int TRIANGLE = 6;
	public static final int BROKEN = 8; 
	public Block currentBlock;
	
	private int[][] field = new int[10][18];

	public void paintComponent(Graphics g){
		refreshField();
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());//Empty field
		
		this.paintBlocks(g);
		this.paintField(g);
	}
	private void paintBlocks(Graphics g){
		for(int y = 0;y<18;y++){
			for (int x =0; x<10;x++){
				if(field[x][y]==Playground.BROKEN){
					g.setColor(Color.gray);
					g.fillRect(x*20, y*20, 20, 20);
				}
				if(field[x][y]!=Playground.BROKEN&&field[x][y]!=Playground.EMPTY){
					g.setColor(Color.green);
					g.fillRect(x*20, y*20, 20, 20);
				}
				
			}
		}	
	}
	
	private void paintField(Graphics g){
		
		g.setColor(Color.black);
		for(int y = 0;y<18;y++){
			for (int x =0; x<10;x++){
				g.drawLine(0, y*20, this.getWidth(), y*20);
				g.drawLine(x*20, 0, x*20, this.getHeight());
			}
		}
	}
	
	public void printField(){
		
		
		
		for(int i = 0;i<18;i++){
			for (int n =0; n<10;n++){
				System.out.print(field[n][i]);
			}
			System.out.println();
		}
	}
	
	
	public void refreshField(){
		for(int i = 0;i<18;i++){
			for (int n =0; n<10;n++){
				if(field[n][i]!=Playground.BROKEN){
					field[n][i]=Playground.EMPTY;
				}
			}
		}
		addCurrentBlockToField();
	}
	
	
	/*
	 * Sets the field empty
	 */
	public void restart() {
		for(int i = 0;i<18;i++){
			for (int n =0; n<10;n++){
				field[n][i]=Playground.EMPTY;
			}
		}
	
	}
	
	public void setCurrentBlock(Block b){
		this.currentBlock = b;
	}
	
	private void addCurrentBlockToField(){
		if (currentBlock.getClass() == blocks.Square.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.SQUARE;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.SQUARE;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.SQUARE;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.SQUARE;
		}
		if (currentBlock.getClass() == blocks.IBlock.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.IBLOCK;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.IBLOCK;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.IBLOCK;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.IBLOCK;
		}
		if (currentBlock.getClass() == blocks.LLBlock.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.LLBLOCK;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.LLBLOCK;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.LLBLOCK;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.LLBLOCK;
		}
		if (currentBlock.getClass() == blocks.LSBlock.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.LSBLOCK;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.LSBLOCK;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.LSBLOCK;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.LSBLOCK;
		}
		if (currentBlock.getClass() == blocks.RLBlock.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.RLBLOCK;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.RLBLOCK;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.RLBLOCK;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.RLBLOCK;
		}
		if (currentBlock.getClass() == blocks.RSBlock.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.RSBLOCK;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.RSBLOCK;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.RSBLOCK;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.RSBLOCK;
		}
		if (currentBlock.getClass() == blocks.Triangle.class){
			this.field[currentBlock.getCoord1().x][currentBlock.getCoord1().y]=Playground.TRIANGLE;
			this.field[currentBlock.getCoord2().x][currentBlock.getCoord2().y]=Playground.TRIANGLE;
			this.field[currentBlock.getCoord3().x][currentBlock.getCoord3().y]=Playground.TRIANGLE;
			this.field[currentBlock.getCoord4().x][currentBlock.getCoord4().y]=Playground.TRIANGLE;
		}
		
	}


	public int[][] getField() {
		return field;
	}

/*
 * sets the current block to broken
 */
	public void setToBroken() {
		field[this.currentBlock.getCoord1().x][this.currentBlock.getCoord1().y]=Playground.BROKEN;
		field[this.currentBlock.getCoord2().x][this.currentBlock.getCoord2().y]=Playground.BROKEN;
		field[this.currentBlock.getCoord3().x][this.currentBlock.getCoord3().y]=Playground.BROKEN;
		field[this.currentBlock.getCoord4().x][this.currentBlock.getCoord4().y]=Playground.BROKEN;
	}
	
	
	
	
	
}
