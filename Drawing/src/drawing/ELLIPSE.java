package drawing;

import java.awt.Graphics;

public abstract class ELLIPSE extends Shape {
	int width;
	int height;
	void CEllipse(int x,int y,int w,int h)
	{
		Type=drawing.ElementType.ELLIPSE;
		OrgX=x;//原点坐标
		OrgY=y;
		new Initialization();
		width=w;
		height=h;
	}
	void Draw(Graphics g)
	{
		g.drawOval(OrgX, OrgY, width, height);
		g.fillOval(OrgX, OrgY, width, height);
		g.setColor(BorderColor);
	}//绘制椭圆形
	void SetValue(int x, int y, int w, int h, String s)
	{
		OrgX = x;
		OrgY = y;
		width = w;
		height = h;
	}
	void GetValue(ElementType type, int x, int y, int Width, int h, String s)
	{
		type = Type;
		x = OrgX;
		y = OrgY;
		Width = width;
		h = height;
		s = " ";
	}//获取图元形状参数
}
