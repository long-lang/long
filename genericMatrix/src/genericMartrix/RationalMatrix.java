package genericMartrix;

public class RationalMatrix {
	static String[][] c=new String[2][2];
	static String[][] d=new String[2][2];
	public void addMatrix(String a[][],String b[][]) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				c[i][j]=a[i][j]+b[i][j];
			}
			
		}
	}
public void multiplyMatrix(String a[][],String b[][]){
		
	String[][] e=new String[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					e[i][k]=a[i][k]+b[k][j];
				}
				for(int m=0;m<2;)
				{
					d[i][j]=e[i][m]+e[i][m+1];
					m=m+2;
				}
			}
		}	
	}
public void print(String[][]a) {
	for(int i=0;i<2;i++) {
		for(int j=0;j<2;j++) {
			System.out.print(a[i][j]);
			System.out.print(",");
		}
		System.out.println();
	}
	System.out.println();
}
public void printMatrix(String[][]a, String[][]b,String[][]c) {
	print(a);
	print(b);
	print(c);
}
}
