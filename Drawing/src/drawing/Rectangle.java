package drawing;

//import java.awt.BasicStroke;
//import java.awt.Color;
import java.awt.Graphics;

public abstract class Rectangle extends Shape{
		int width;
		int height;
		void CRectangle(int x,int y,int w,int h)
		{
			Type=drawing.ElementType.RECTANGLE;
			OrgX=x;//原点坐标 nbb                                                           
			OrgY=y;
			 //BorderColor=Color.cyan;//边界颜色
		//	BorderType=BasicStroke.CAP_BUTT;//边界线型--实线、虚线、虚点线等
		//	BorderWidth=1;//边界宽度
			//FillColor=Color.darkGray;//填充颜色
			//FillType=BasicStroke.CAP_BUTT;//填充类型--实心、双对角、十字交叉等
			new Initialization();
			width=w;
			height=h;
		}
		void Draw(Graphics g)
		{
			g.drawRect(OrgX, OrgY, width, height);
			g.fillRect(OrgY, OrgY, width, height);
			g.setColor(BorderColor);
			
		}//绘制长方形

		void SetValue(int x, int y, int Width, int h, String s)
		{
			OrgX = x;
			OrgY = y;
			width = Width;
			height = h;
		}
		void GetValue(ElementType type, int x, int y, int Width, int h, String s)
		{
			type = Type;
			x = OrgX;
			y = OrgY;
			Width = width;
			h = height;
			s = "hello";
		}//获取图元形状参数

	
}
