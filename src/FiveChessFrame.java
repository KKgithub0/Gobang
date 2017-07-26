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
	// 设置图片
	// 保存棋子的坐标
	int x = 0;
	int y = 0;
	boolean flag=false;
	// 保存之前下过全部数组的坐标 0= null 1 = black 2 = white 
	int[][] allChess = new int[19][19];
	Victorymethod Vic = new Victorymethod();
	String print="游戏信息：黑方先下";
	
	
	
	public FiveChessFrame(){
		// 设置标题	
		this.setTitle("五子棋");
		// 设置窗体大小
		this.setSize(500, 500);
		// 设置窗体位置
		this.setLocation((width-500)/2,(height-500)/2);
		// 设置窗体不可变
		this.setResizable(false);
		// 将窗体关闭方式设置为默认关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 为窗口加入监听器
		addMouseListener(this);
		
		// 将窗体显示出来
		this.setVisible(true);
		
		
			
	}
	
	public void paint(Graphics h){
		//双缓冲技术
		BufferedImage bi=new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
		Graphics h1=bi.createGraphics();
		
		// 绘制背景
		BufferedImage bgImage = null;
		try {
			bgImage = ImageIO.read(new File("C:/Users/lenovo/Pictures/lovewallpaper/11.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h1.drawImage(bgImage,0,0,this);
		// 输出信息
		h1.setColor(Color.black);
		h1.drawRect(390, 70, 70, 30);
		h1.drawString("开始游戏", 400, 90);
		h1.drawRect(390, 120, 70, 30);
		h1.drawString("游戏设置", 400, 140);
		h1.drawRect(390, 170, 70, 30);
		h1.drawString("游戏说明", 400, 190);
		h1.drawRect(390, 250, 50, 30);
		h1.drawString("关于", 400, 270);
		h1.drawRect(390, 300, 50, 30);
		h1.drawString("认输", 400, 320);
		
		// 绘制棋盘
		
		h1.setFont(new Font("黑体",Font.BOLD,20));
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
		 // 标注点位
		h1.fillOval(70, 126, 8, 8);  
		h1.fillOval(309, 125, 8, 8);
		h1.fillOval(69, 366,8,8);
		h1.fillOval(309, 366, 8, 8);
		h1.fillOval(189, 245, 10, 10);
		h1.fillOval(189, 366, 8, 8);
		h1.fillOval(69, 246, 8, 8);
		h1.fillOval(309, 246, 8, 8);
		h1.fillOval(189, 125, 8, 8);
		// 绘制棋子
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
			//System.out.println("此时的坐标为：" + x+","+y);
			x = (x-13)/20 ;
			y = (y-70)/20 ;
			if(allChess[x][y]==0)
			{
			if(flag==false)
			{allChess[x][y] = 1;
			print="游戏信息：白子落棋";
			flag=true;}
			else
			{
				allChess[x][y] = 2;
				print="游戏信息：黑子落棋";
				flag=false;
			}
			
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "当前位置已有棋子，请重新落子");
			}
			
			this.repaint();
			int v = Vic.Victory(allChess);
			if(v==1)
				JOptionPane.showMessageDialog(this, "黑子获胜！");
			else if(v==2)
				JOptionPane.showMessageDialog(this, "白子获胜！");
			/*else 
				JOptionPane.showMessageDialog(this, "!!!!!!!!!!!");*/
		}
			if(m.getX() >=390&&m.getX()<=470&&m.getY()>=70&&m.getY()<=100)
				{int a = JOptionPane.showConfirmDialog(this, "是否重新开始游戏？");
				if (a==0)
				{for(int i = 0;i<19;i++)
					for(int j= 0;j<19;j++)	
						allChess[i][j]=0;
				this.repaint();
				print="游戏信息：黑方先下";
				flag=false;
				}
				}
			if(m.getX() >=390&&m.getX()<=470&&m.getY()>=120&&m.getY()<=150)
				JOptionPane.showMessageDialog(this, "游戏设置");
			if(m.getX() >=390&&m.getX()<=470&&m.getY()>=170&&m.getY()<=200)
				JOptionPane.showMessageDialog(this, "双方开始下棋，先连成五子者获胜！");
			if(m.getX() >=390&&m.getX()<=440&&m.getY()>=250&&m.getY()<=280)
				JOptionPane.showMessageDialog(this, "作者：XK");
			if(m.getX() >=390&&m.getX()<=440&&m.getY()>=300&&m.getY()<=330)
				{int r = JOptionPane.showConfirmDialog(this, "是否确认认输？", "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION);
				if(r==0)
				{if(flag==false)
				JOptionPane.showMessageDialog(this, "黑子认输");
				else JOptionPane.showMessageDialog(this, "白子认输");
				}
				System.exit(0);
				}
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub

	}
	
	
			


}
