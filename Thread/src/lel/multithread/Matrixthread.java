package lel.multithread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;



public class Matrixthread implements Runnable {
	private int i;
	private volatile int[][] z;
	private int[][] y;
	private int[][] x;
	private int thread;
	private int one;
	private CountDownLatch countDownLatch;
	public Matrixthread(int[][]x,int[][]y,int[][]z, int i,int thread,int one,CountDownLatch countDownLatch) {
		 this.i = i;
		 this.x = x;
		 this.y = y;
		 this.z = z;
		 this.one = one;
		 this.thread = thread;
		 this.countDownLatch = countDownLatch;
		
	}
	public void set(int one) {
		this.one = one;
	}
public  void  multiplyMatrix(int a[][],int b[][]){
		for(int j=one;j<i;j = j+thread) {
			for(int k=0;k<i;k++) {
				for(int m = 0;m<i;m++)
				z[j][k]+=a[j][m]*b[m][k];
			}
		}
	}
public  void print(int a[][]) {
	for(int j =0 ;j<i;j++) {
		for(int k = 0;k<i;k++) {
			if(a[j][k]!=0)
				System.out.print(a[j][k]+"  ");
		}
		System.out.println();
		}
} 

	public void run() {
		
		multiplyMatrix(x,y);
		countDownLatch.countDown();
	}
	
}
