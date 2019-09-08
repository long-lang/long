package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Triangle extends Shape {
		int width;	
		Triangle(int x,int y,int w)
		{
			Type=drawing.ElementType.TRIANGLE;
			OrgX=x;//原点坐标
			OrgY=y;
			BorderColor=Color.black;//边界颜色
			BorderType=FillType;//边界线型--实线、虚线、虚点线等
			BorderWidth=1;//边界宽度
			FillColor=Color.blue;//填充颜色
			FillType=BasicStroke.CAP_BUTT;//填充类型--实心、双对角、十字交叉等
			width=w;
		}
		void Draw(Graphics g)//绘制三角形
		{
			int px1[]={50,400,450};
			int py1[]={50,100,200};
			g.drawPolygon(px1,py1,3);
			g.fillPolygon(px1, py1, 3);
			g.setColor(BorderColor);
		    
		}
		/*boolean IsMatched(int pnt)//重载点pnt是否落在图元内
		{
			POINT polygon[3] = {  CPoint(OrgX-width/2,OrgY),CPoint(OrgX+width/2,OrgY), CPoint(OrgX,OrgY-width) };
			CRgn rgnA;
			rgnA.CreatePolygonRgn(polygon, 3, ALTERNATE);
			BOOL flag = rgnA.PtInRegion(pnt);                 //判断多边形 用cRgn类判断
			if (flag)
				return true;
			else
				return false;
		}*/

		void SetValue(int x, int y, int Width, int h, String s)
		{
			OrgX = x;
			OrgY = y;
			width=Width;
		}
		void GetValue(ElementType type, int x, int y, int Width, int h, String s) //获取图元形状参数
		{
			type = Type;
			x = OrgX;
			y = OrgY;
			Width=width;
			s = "Hello";
		}
};
