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
			OrgX=x;//ԭ������ nbb                                                           
			OrgY=y;
			 //BorderColor=Color.cyan;//�߽���ɫ
		//	BorderType=BasicStroke.CAP_BUTT;//�߽�����--ʵ�ߡ����ߡ�����ߵ�
		//	BorderWidth=1;//�߽���
			//FillColor=Color.darkGray;//�����ɫ
			//FillType=BasicStroke.CAP_BUTT;//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����
			new Initialization();
			width=w;
			height=h;
		}
		void Draw(Graphics g)
		{
			g.drawRect(OrgX, OrgY, width, height);
			g.fillRect(OrgY, OrgY, width, height);
			g.setColor(BorderColor);
			
		}//���Ƴ�����

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
		}//��ȡͼԪ��״����

	
}
