package genericMartrix;

public class IntegerMatrix extends GenericMatrix{
	static int[][] c=new int[5][5];
	static int[][] d=new int[5][5];
	public void addMatrix(int a[][],int b[][]) {
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				c[i][j]=a[i][j]+b[i][j];
			}
		}
		
	
	}
	public void multiplyMatrix(int a[][],int b[][]){
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++)
				d[i][j]+=a[i][k]*b[k][j];
			}
		}
		
	}
	public void print(int[][]a) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(a[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void printMatrix(int[][] a, int[][]b,int[][]c) {
		print(a);
		print(b);
		print(c);
}
}
