package drawing;

import java.awt.Graphics;

public abstract class CIRCLE extends Shape {
		int radius;
		void CCircle(int x,int y,int r)
		{
			Type=drawing.ElementType.CIRCLE;
			OrgX=x;//ԭ������
			OrgY=y;
			new Initialization();
			radius=r;
		}
		void Draw(Graphics g)
		{
		   g.drawOval(OrgX, OrgY, radius, radius);
		   g.fillOval(OrgX, OrgY, radius, radius);
		   g.setColor(BorderColor);
		}//����Բ��
		

		void SetValue(int x, int y, int Width, int h, String s)
		{
			OrgX = x;
			OrgY = y;
			radius = Width;
		}
		void GetValue(ElementType type, int x, int y, int Width, int h, String s)
		{
			type = Type;
			x = OrgX;
			y = OrgY;
			Width = radius;
			h = 0;
			s = " ";
		}//��ȡͼԪ��״����
	

}
