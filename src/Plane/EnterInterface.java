package Plane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

public class EnterInterface extends JFrame {
	JLabel start = new JLabel("开始游戏", JLabel.CENTER);// 定义一个开始游戏的标签
	JLabel exit = new JLabel("结束游戏", JLabel.CENTER);// 定义一个结束游戏的标签

	// 设置开始游戏的窗口
	public EnterInterface() {
		this.setSize(500, 400);// 窗口大小
		this.setVisible(true);// 显现窗口
		this.setResizable(false);// 固定窗口
		this.setLocationRelativeTo(null);// 居中显示

//		JPanel jp = (JPanel) getContentPane();
		JPanel jp = new JPanel();// 把面板加入到窗口上
		this.add(jp);
		jp.setLayout(null);// 布局方式为空

		// 对“开始游戏”这四个字设置
		start.setFont(new Font("微软雅黑", Font.BOLD, 28));// 为“开始游戏”设置字体型号
		start.setForeground(Color.WHITE);// 添加颜色
		start.setBounds(180, 120, 130, 30);// 设置位置
		start.addMouseListener(new MyMouseListener());// 加入监听

		// 对“结束游戏”这四个字设置
		exit.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 28));// 为“结束游戏”设置字体型号
		exit.setForeground(Color.WHITE);// 添加颜色
		exit.setBounds(180, 160, 130, 30);// 设置位置
		exit.addMouseListener(new MyMouseListener());// 加入监听

		jp.add(start);// 把start加入面板中
		jp.add(exit);// 把exit加入面板中

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 窗口关闭

	}

	class MyMouseListener extends MouseAdapter {// 监听类(鼠标)

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == start) {// 鼠标进入标签start的时候显示绿色
				start.setForeground(Color.GREEN);
			} else if (e.getSource() == exit) {// 鼠标进入标签exit的时候显示红色
				exit.setForeground(Color.RED);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == start) {// 鼠标离开标签start的时候显示红色
				start.setForeground(Color.WHITE);
			} else if (e.getSource() == exit) {
				exit.setForeground(Color.WHITE);// 鼠标离开标签exit的时候显示绿色
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == start) {// 当点击“开始游戏”时，跳转到游戏窗口
				EnterInterface.this.dispose();// 开始游戏的界面随之消失
				PlaneFrame tf = new PlaneFrame();// 打开一个新界面
			} else if (e.getSource() == exit) {// 当点击“结束游戏”时，退出程序
				System.exit(0);
			}
		}
	}
}
