package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Triangle extends Shape {
		int width;	
		Triangle(int x,int y,int w)
		{
			Type=drawing.ElementType.TRIANGLE;
			OrgX=x;//ԭ������
			OrgY=y;
			BorderColor=Color.black;//�߽���ɫ
			BorderType=FillType;//�߽�����--ʵ�ߡ����ߡ�����ߵ�
			BorderWidth=1;//�߽���
			FillColor=Color.blue;//�����ɫ
			FillType=BasicStroke.CAP_BUTT;//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����
			width=w;
		}
		void Draw(Graphics g)//����������
		{
			int px1[]={50,400,450};
			int py1[]={50,100,200};
			g.drawPolygon(px1,py1,3);
			g.fillPolygon(px1, py1, 3);
			g.setColor(BorderColor);
		    
		}
		/*boolean IsMatched(int pnt)//���ص�pnt�Ƿ�����ͼԪ��
		{
			POINT polygon[3] = {  CPoint(OrgX-width/2,OrgY),CPoint(OrgX+width/2,OrgY), CPoint(OrgX,OrgY-width) };
			CRgn rgnA;
			rgnA.CreatePolygonRgn(polygon, 3, ALTERNATE);
			BOOL flag = rgnA.PtInRegion(pnt);                 //�ж϶���� ��cRgn���ж�
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
		void GetValue(ElementType type, int x, int y, int Width, int h, String s) //��ȡͼԪ��״����
		{
			type = Type;
			x = OrgX;
			y = OrgY;
			Width=width;
			s = "Hello";
		}
};
