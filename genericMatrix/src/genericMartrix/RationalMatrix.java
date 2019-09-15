package genericMartrix;

public class RationalMatrix {
	static int n=3;
	static String[][] c=new String[n][n];
	static String[][] d=new String[n][n];
	public void addMatrix(String a[][],String b[][]) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				c[i][j]=a[i][j]+b[i][j];
			}
			
		}
	}
public void multiplyMatrix(String a[][],String b[][]){
	String[][] e=new String[n][n];
	String[][] f=new String[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					e[i][k]=a[i][k]+b[k][j];
				}
				if(a.length%2==0) {//数组长度为偶数时
				for(int m=0;m<2;)
				{
					f[i][j]=e[i][m]+e[i][m+1];
					m=m+2;
				}
				d[i][j]=f[i][j];
			}
				else
				{
					for(int m=0;m<n-2;) {
						f[i][j]=e[i][m]+e[i][m+1];
						m=m+2;
					}
					f[i][j]=f[i][j]+e[i][a.length-1];
				}
				d[i][j]=f[i][j];
			}
			
		}
		
	}
public void print(String[][]a) {
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
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
