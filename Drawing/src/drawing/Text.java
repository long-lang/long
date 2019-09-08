package drawing;

import java.awt.Graphics;

public abstract class Text extends Shape {
	int height;
	int angle;
	String text;
	void CText(int x,int y,int h,int a,String t)
	{
		Type=drawing.ElementType.TEXT;
		OrgX=x;//原点坐标
		OrgY=y;
		new Initialization();
		height=h;
		angle=a;
		text=t;
	}
	void Draw(Graphics g)//绘制
	{
		g.drawString(text, OrgX, OrgY);
		g.setColor(BorderColor);	
	}
	
	void SetValue(int x, int y, int Width, int h, String s)
	{
		OrgX = x;
		OrgY = y;
		angle = Width;
		height = h;
		text = s;
	}
	void GetValue(ElementType type, int x, int y, int Width, int h,String s)//获取图元形状参数
	{
		type = Type;
		x = OrgX;
		y = OrgY;
		Width = angle;
		h = height;
		s = text;
	}

}
