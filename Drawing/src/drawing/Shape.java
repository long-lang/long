package drawing;
import java.awt.*;
enum ElementType { NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT };

public abstract class Shape{

	ElementType Type;//图元类型
	int OrgX;//原点坐标
	int OrgY;
	Color   BorderColor;//边界颜色
	int BorderType;//边界线型--实线、虚线、虚点线等
	int BorderWidth;//边界宽度
	Color  FillColor;//填充颜色
	int FillType;//填充类型--实心、双对角、十字交叉等
		void CShape()
		{
			Type = drawing.ElementType.NOTSET;
			OrgX = 0;
			OrgY = 0;
			SetPen (Color.black, BasicStroke.CAP_BUTT, 2);
			SetBrush(Color.blue, BasicStroke.CAP_BUTT);
		}

		abstract void Draw(Graphics g);//绘制图元
		abstract void SetValue(int x, int y, int width, int h, String s); //设置图元形状参数
		abstract void GetValue(int type, int x, int y, int width, int h, String s);//获取图元形状参数
		abstract  boolean IsMatched(int pnt);//点是否落在图形内部
		//abstract void Serialize(CArchive ar) ;
		// IsMatched 和 Serialize 两个函数不会修改。在之后的类中都没有对其说明
		void SetPen(Color borderColor2 , int capButt , int borderwidth)
		{
			BorderColor = borderColor2;
			BorderType = capButt;
			BorderWidth = borderwidth;
		}
		void SetBrush(Color borderColor2 , int capButt )
		{
			FillColor = borderColor2;
			FillType = capButt;
		}
		void GetPen (Color penColor, int penType, int penWidth)
		{
			penColor = BorderColor;
	    	penType = BorderType;
	    	penWidth = BorderWidth;
		}
	    void GetBrush(Color fillColor, int fillType)
	    {
	    	fillColor = FillColor;
	    	fillType = FillType;
	    }
}
