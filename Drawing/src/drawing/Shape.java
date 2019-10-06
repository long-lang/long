package drawing;
import java.awt.*;
enum ElementType { NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT };

public abstract class Shape{

	ElementType Type;//ͼԪ����
	int OrgX;//ԭ������
	int OrgY;
	Color   BorderColor;//�߽���ɫ
	int BorderType;//�߽�����--ʵ�ߡ����ߡ�����ߵ�
	int BorderWidth;//�߽���
	Color  FillColor;//�����ɫ
	int FillType;//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����
		void CShape()
		{
			Type = drawing.ElementType.NOTSET;
			OrgX = 0;
			OrgY = 0;
			SetPen (Color.black, BasicStroke.CAP_BUTT, 2);
			SetBrush(Color.blue, BasicStroke.CAP_BUTT);
		}

		abstract void Draw(Graphics g);//����ͼԪ
		abstract void SetValue(int x, int y, int width, int h, String s); //����ͼԪ��״����
		abstract void GetValue(int type, int x, int y, int width, int h, String s);//��ȡͼԪ��״����
		abstract  boolean IsMatched(int pnt);//���Ƿ�����ͼ���ڲ�
		//abstract void Serialize(CArchive ar) ;
		// IsMatched �� Serialize �������������޸ġ���֮������ж�û�ж���˵��
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
