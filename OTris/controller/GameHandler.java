package controller;

import java.util.Random;

import timer.Timer;
import view.Playground;

import blocks.Block;
import blocks.IBlock;
import blocks.LLBlock;
import blocks.LSBlock;
import blocks.RLBlock;
import blocks.RSBlock;
import blocks.Square;
import blocks.Triangle;

public class GameHandler {

	private Random rnd = new Random();
	private Playground field;
	private Block currentBlock = null;
	private Timer timer;
	public GameHandler(Playground p){
		this.init(p);
	}

	/*
	 * Initiates a new Game
	 */
	private void init(Playground p) {
		this.field = p;
		
		field.restart();
		
		this.nextBlock();
		timer = new Timer(this);
		timer.start();
	}
	
	public void nextTurn(){
		System.out.println("next Turn");
		if(checkIfFree()){
			this.currentBlock.moveDown();
		}else{
			field.setToBroken();
			
		}
		
		this.refreshField();
		field.repaint();
		field.printField();
	}
	
	private void refreshField(){
		field.setCurrentBlock(currentBlock);
	}
	
	/*
	 * return true if there is something under the current block
	 */
	private boolean checkIfFree(){
		System.out.println(currentBlock.getCoord1().y);
		System.out.println(currentBlock.getCoord2().y);
		System.out.println(currentBlock.getCoord3().y);
		System.out.println(currentBlock.getCoord4().y);
		boolean b = true;

		if (currentBlock.getCoord1().y != 17
				&& currentBlock.getCoord2().y != 17
				&& currentBlock.getCoord3().y != 17
				&& currentBlock.getCoord4().y != 17) {
			if (field.getField()[currentBlock.getCoord1().x][currentBlock
					.getCoord1().y + 1] == Playground.BROKEN) {
				b = false;
			}
			if (field.getField()[currentBlock.getCoord2().x][currentBlock
					.getCoord2().y + 1] == Playground.BROKEN) {
				b = false;
			}
			if (field.getField()[currentBlock.getCoord3().x][currentBlock
					.getCoord3().y + 1] == Playground.BROKEN) {
				b = false;
			}
			if (field.getField()[currentBlock.getCoord4().x][currentBlock
					.getCoord4().y + 1] == Playground.BROKEN) {
				b = false;
			}
		}else{
			b=false;
		}
		
		if (!b) this.nextBlock();
		return b;
	}
	
	
	
	private void nextBlock() {
		int i = rnd.nextInt(7) + 1;

		System.out.println(i);
		
		
		switch (i) {
		case Playground.IBLOCK:
			this.currentBlock = new IBlock();
			break;
		case Playground.LLBLOCK:
			this.currentBlock = new LLBlock();
			break;
		case Playground.RLBLOCK:	
			this.currentBlock = new RLBlock();
			break;
		case Playground.RSBLOCK:
			this.currentBlock = new RSBlock();
			break;
		case Playground.LSBLOCK:
			this.currentBlock = new LSBlock();
			break;
		case Playground.SQUARE:
			this.currentBlock = new Square();
			break;
		case Playground.TRIANGLE:
			this.currentBlock = new Triangle();
			break;
		}
	}
}
