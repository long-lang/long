package drawing;

import java.awt.Graphics;

public abstract  class Square extends Shape {
		int width;
		void CSquare(int x,int y,int w)
		{
			Type=drawing.ElementType.SQUARE;
			OrgX=100;//ԭ������
			OrgY=100;
			new Initialization();
			width=100;
		}
		void Draw(Graphics g)
		{
			g.drawRect(OrgX, OrgY, width, width);
			g.fillRect(OrgX, OrgY, width, width);
			g.setColor(BorderColor);
		
		}//����������
		


		void SetValue(int x, int y, int Width, int h, String s)
		{
			OrgX = x;
			OrgY = y;
			width = Width;
		}
		void GetValue(ElementType type, int x, int y, int Width, int h, String s)
		{
			type = Type;
			x = OrgX;
			y = OrgY;
			Width = width;
			h = 0;
			s = " ";
		}//��ȡͼԪ��״����


	
}
