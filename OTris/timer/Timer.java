package timer;

import controller.GameHandler;

public class Timer {

	private GameHandler gh = null;
	private TimerRunable tr = null;
	public Timer(GameHandler gh) {
		this.gh = gh;
		
		Thread t = new Thread(new TimerRunable(this));
		t.start();
		
		tr = new TimerRunable(this);
		tr.start();
	}

	public void start() {
		tr.start();
	}

	public void stop() {
		tr.stop();
	}

	public void clock() {
		gh.nextTurn();		
	}
}
