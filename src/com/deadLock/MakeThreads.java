package com.deadLock;

import java.util.ArrayList;
import java.util.HashMap;

public class MakeThreads {
	public static void main(String[] args) {
		for(int loop = 0; loop < 3; loop++) {
			LoopingThread thread = new LoopingThread();
			thread.start();
		}
		System.out.println("Started looping threads..." +
		" You Must stop this process after test ...");
	}
}
class LoopingThread extends Thread {
	public void run() {
		int runCount = 100;
		while(true) {
			try {
				String string = new String("AAA");
				ArrayList<String> al = new ArrayList<String> (runCount);
				for(int loop=0; loop<runCount; loop++) {
					al.add(string);
				}
				HashMap<String, Integer> hashMap = new HashMap<String, Integer>(runCount);
				for(int loop = 0; loop < runCount; loop++) {
					hashMap.put(string + loop, loop);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
