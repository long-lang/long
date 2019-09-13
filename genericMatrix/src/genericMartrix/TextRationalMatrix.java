package genericMartrix;

public class TextRationalMatrix extends RationalMatrix{
public static void main(String[] args) {
	String[][] a= {
			{"hello","world"},
			{"xiao","ming"},
			};
	String[][] b={
			{"world","long"},
			{"lang","xin"},
			};
	RationalMatrix x=new RationalMatrix();
	x.addMatrix(a,b);
	System.out.println("矩阵相加为：");
	x.printMatrix(a, b, c);
	x.multiplyMatrix(a, b);
	System.out.println("矩阵相乘为：");
	x.printMatrix(a, b, d);	
}
}
