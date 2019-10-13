package lel.singlethread;

import java.util.Random;

public class Matrixthread implements Runnable {
	private int i;
	private int[][] z;
	private int[][] y;
	private int[][] x;
	
	public Matrixthread(int i) {
		this.i = i;
		Random rand = new Random();
		 x = new int[i][i];
		 y = new int[i][i];
		 z = new int[i][i];
		 
		for(int j = 0;j<i;j++) {
			for(int k = 0;k<i;k++) {
				x[j][k] = rand.nextInt(10);
				y[j][k] = rand.nextInt(10);
			}
		}
	}
public void  multiplyMatrix(int a[][],int b[][]){
		for(int j=0;j<i; j++) {
			for(int k=0;k<i;k++) {
				for(int m = 0;m<i;m++)
				z[j][k]+=a[j][m]*b[m][k];
			}
		}
		
	}
public  void print(int a[][]) {
	for(int j = 0;j<i;j++) {
		for(int k = 0;k<i;k++) {
			System.out.print(a[j][k]+"  ");
		}
		System.out.println();
		}
}
	public void run() {
		long t1 = System.currentTimeMillis();
		multiplyMatrix(x,y);
		long t2 = System.currentTimeMillis();
		long t3 = t2 - t1;
		System.out.println(t3);

		
		
	}
}