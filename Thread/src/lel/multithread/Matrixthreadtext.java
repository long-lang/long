package lel.multithread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Matrixthreadtext {
	private static int t;
	private static int[][] y;
	private static int[][] x;
	private static int[][] z;
	private CountDownLatch countDownLatch;
	public Matrixthreadtext(int t) {
		Random rand = new Random();
		this.t = t;
		 x = new int[t][t];
		 y = new int[t][t];
		 z = new int[t][t];
		for(int j = 0;j<t;j++) {
			for(int k = 0;k<t;k++) {
				x[j][k] = rand.nextInt(10);
				y[j][k] = rand.nextInt(10);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		Matrixthreadtext matrixthreadtext = new Matrixthreadtext(5000);
		int a = 100;
		CountDownLatch countDownLatch = new CountDownLatch(a);
		long t1 = System.currentTimeMillis();
		for(int i = 1;i<=a;i++) {
			Matrixthread  matrixthread = new Matrixthread(x,y,z,t,a,i-1,countDownLatch);
			Thread thread = new Thread(matrixthread);
			thread.start();
	}
		countDownLatch.await();
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);

}
}
