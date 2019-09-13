package genericMartrix;

import java.util.Random;



public class TextIntegerMatrix extends IntegerMatrix {
	public static void main(String[] args) {
		Random rand=new Random();
		int[][] a=new int[5][5];
		int[][] b=new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
	             a[i][j]=(int)rand.nextInt(10);
	             b[i][j]=(int)rand.nextInt(10);
			}
			}
		//给a，b赋值。
		IntegerMatrix x=new IntegerMatrix();
		x.addMatrix(a,b);
		System.out.println("矩阵相加为：");
		x.printMatrix(a, b, c);
		x.multiplyMatrix(a, b);
		System.out.println("矩阵相乘为：");
		x.printMatrix(a, b, d);	
		}
	}

