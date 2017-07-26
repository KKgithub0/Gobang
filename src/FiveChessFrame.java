package org.liky.game.frame;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FiveChessFrame extends JFrame implements MouseListener {
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	// ����ͼƬ
	// �������ӵ�����
	int x = 0;
	int y = 0;
	boolean flag=false;
	// ����֮ǰ�¹�ȫ����������� 0= null 1 = black 2 = white 
	int[][] allChess = new int[19][19];
	Victorymethod Vic = new Victorymethod();
	String print="��Ϸ��Ϣ���ڷ�����";
	
	
	
	public FiveChessFrame(){
		// ���ñ���	
		this.setTitle("������");
		// ���ô����С
		this.setSize(500, 500);
		// ���ô���λ��
		this.setLocation((width-500)/2,(height-500)/2);
		// ���ô��岻�ɱ�
		this.setResizable(false);
		// ������رշ�ʽ����ΪĬ�Ϲرպ�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ϊ���ڼ��������
		addMouseListener(this);
		
		// ��������ʾ����
		this.setVisible(true);
		
		
			
	}
	
	public void paint(Graphics h){
		//˫���弼��
		BufferedImage bi=new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
		Graphics h1=bi.createGraphics();
		
		// ���Ʊ���
		BufferedImage bgImage = null;
		try {
			bgImage = ImageIO.read(new File("C:/Users/lenovo/Pictures/lovewallpaper/11.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h1.drawImage(bgImage,0,0,this);
		// �����Ϣ
		h1.setColor(Color.black);
		h1.drawRect(390, 70, 70, 30);
		h1.drawString("��ʼ��Ϸ", 400, 90);
		h1.drawRect(390, 120, 70, 30);
		h1.drawString("��Ϸ����", 400, 140);
		h1.drawRect(390, 170, 70, 30);
		h1.drawString("��Ϸ˵��", 400, 190);
		h1.drawRect(390, 250, 50, 30);
		h1.drawString("����", 400, 270);
		h1.drawRect(390, 300, 50, 30);
		h1.drawString("����", 400, 320);
		
		// ��������
		
		h1.setFont(new Font("����",Font.BOLD,20));
		h1.drawString(print, 120, 60); 
		for(int i=13;i<=375;)
		{
			h1.drawLine(i, 70, i, 430);
			i+=20;
		}
		for(int j=70;j<=430;)
		{
			h1.drawLine(13, j, 373, j);
			j+=20;
		}
		 // ��ע��λ
		h1.fillOval(70, 126, 8, 8);  
		h1.fillOval(309, 125, 8, 8);
		h1.fillOval(69, 366,8,8);
		h1.fillOval(309, 366, 8, 8);
		h1.fillOval(189, 245, 10, 10);
		h1.fillOval(189, 366, 8, 8);
		h1.fillOval(69, 246, 8, 8);
		h1.fillOval(309, 246, 8, 8);
		h1.fillOval(189, 125, 8, 8);
		// ��������
		for (int i = 0; i<19;i++)
		{
			for (int j=0;j<19;j++)
			{
				if(allChess[i][j]==1)
				{
					// black
					int tempX = i*20 + 13;
					int tempY = j*20 + 70;
					h1.fillOval(tempX-7, tempY-7, 14, 14);
					
				}
				if(allChess[i][j]==2)
				{
					// white
					int tempX = i*20 + 13;
					int tempY = j*20 + 70;
					h1.setColor(Color.WHITE);
					h1.fillOval(tempX-7, tempY-7, 14, 14);
					h1.setColor(Color.black);
					h1.drawOval(tempX-7, tempY-7, 14, 14);
					
				}
			}
		}
		
		h.drawImage(bi,0,0,this);
	}
	
	@Override	
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		/*System.out.println(m.getX());
		System.out.println(m.getY());*/
		 x = m.getX();
		 y = m.getY();
		if(x>=13&&x<=373&&y>=70&&y<=430){
			//System.out.println("��ʱ������Ϊ��" + x+","+y);
			x = (x-13)/20 ;
			y = (y-70)/20 ;
			if(allChess[x][y]==0)
			{
			if(flag==false)
			{allChess[x][y] = 1;
			print="��Ϸ��Ϣ����������";
			flag=true;}
			else
			{
				allChess[x][y] = 2;
				print="��Ϸ��Ϣ����������";
				flag=false;
			}
			
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "��ǰλ���������ӣ�����������");
			}
			
			this.repaint();
			int v = Vic.Victory(allChess);
			if(v==1)
				JOptionPane.showMessageDialog(this, "���ӻ�ʤ��");
			else if(v==2)
				JOptionPane.showMessageDialog(this, "���ӻ�ʤ��");
			/*else 
				JOptionPane.showMessageDialog(this, "!!!!!!!!!!!");*/
		}
			if(m.getX() >=390&&m.getX()<=470&&m.getY()>=70&&m.getY()<=100)
				{int a = JOptionPane.showConfirmDialog(this, "�Ƿ����¿�ʼ��Ϸ��");
				if (a==0)
				{for(int i = 0;i<19;i++)
					for(int j= 0;j<19;j++)	
						allChess[i][j]=0;
				this.repaint();
				print="��Ϸ��Ϣ���ڷ�����";
				flag=false;
				}
				}
			if(m.getX() >=390&&m.getX()<=470&&m.getY()>=120&&m.getY()<=150)
				JOptionPane.showMessageDialog(this, "��Ϸ����");
			if(m.getX() >=390&&m.getX()<=470&&m.getY()>=170&&m.getY()<=200)
				JOptionPane.showMessageDialog(this, "˫����ʼ���壬�����������߻�ʤ��");
			if(m.getX() >=390&&m.getX()<=440&&m.getY()>=250&&m.getY()<=280)
				JOptionPane.showMessageDialog(this, "���ߣ�XK");
			if(m.getX() >=390&&m.getX()<=440&&m.getY()>=300&&m.getY()<=330)
				{int r = JOptionPane.showConfirmDialog(this, "�Ƿ�ȷ�����䣿", "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION);
				if(r==0)
				{if(flag==false)
				JOptionPane.showMessageDialog(this, "��������");
				else JOptionPane.showMessageDialog(this, "��������");
				}
				System.exit(0);
				}
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub

	}
	
	
			


}
