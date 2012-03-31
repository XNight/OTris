package timer;

public class TimerRunable implements Runnable{

	private boolean runs = false;
	Timer t;
	
	public TimerRunable(Timer t){
		this.t=t;
		this.start();
	}
	@Override
	public void run() {
		
		while(runs){
			t.clock();
			try {
				Thread.sleep(1000);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void start(){
		this.runs=true;
	}
	public void stop(){
		this.runs=false;;
	}
	

}
