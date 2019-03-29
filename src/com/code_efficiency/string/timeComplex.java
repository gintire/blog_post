package code_efficiency.string;

import util.StopWatch;

public class timeComplex {

	public static void main(String[] args) {
		final String aValue = "abcde";
		StopWatch sw = new StopWatch();
		sw.start();
		for(int outloop=0; outloop<10; outloop++) {
			String a = new String();
			StringBuffer b = new StringBuffer();
			StringBuilder c = new StringBuilder();
			for(int inloop=0; inloop < 10000; inloop++) {
				a+=aValue;
			}
			for(int inloop=0; inloop < 10000; inloop++) {
				b.append(aValue);
			}
			String temp = b.toString();
			for(int inloop=0; inloop < 10000; inloop++) {
				c.append(aValue);
			}
			String temp2=c.toString();
		}
		sw.stop();
		System.out.println(sw);
	}

}
