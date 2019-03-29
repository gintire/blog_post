package util;

public class StopWatch {
	long startTime;
	long elapsedTime = 0;
	StringBuffer currentName;
	boolean threadFlag = false;
	
	public StopWatch() {
		this.currentName = new StringBuffer();
		this.startTime = System.nanoTime();
	}
	public StopWatch(boolean threadFalg) {
		changeMessage("", true, true);
	}
	public StopWatch(String currentName) {
		changeMessage(currentName, false, false);
	}
	public StopWatch(String currentName, boolean threadFlag) {
		changeMessage(currentName, threadFlag, true);
	}
	public void start() {
		startTime = System.nanoTime();
		elapsedTime = 0;
	}
	public void stop() {
		elapsedTime = System.nanoTime() - startTime;
	}
	private void changeMessage(String message, boolean threadFlag, boolean resetFlag) {
		StringBuffer threadName = new StringBuffer();
		this.threadFlag = threadFlag;
		if(threadFlag) {
			threadName.append("ThreadName=")
			.append(Thread.currentThread().getName());
		}
		currentName.append("[").append(message)
		.append(threadName).append("] ");
		if(resetFlag) {
			start();
		}
	}
	public double getElapsedMS() {
		if(elapsedTime==0) stop();
		return elapsedTime / 100000.0;
	}
	public double getElapsedNano() {
		if(elapsedTime==0) stop();
		return elapsedTime;
	}
	public String toString() {
		if(elapsedTime==0) stop();
		currentName.append("elapsedTime: ")
		.append(elapsedTime/100000.0)
		.append("ms");
		return currentName.toString();
	}
}
