package Plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class LeaveInterface extends JFrame {
	
	PlaneFrame pf = null;
	JLabel begin = new JLabel("重新开始", JLabel.CENTER);// 定义一个重新开始的标签
	JLabel end = new JLabel("结束游戏", JLabel.CENTER);// 定义一个结束游戏的标签

	// 设置结束游戏的窗口
	public LeaveInterface(PlaneFrame pf) {// 传入游戏窗口的对象
		this.pf = pf;//
		this.setSize(500, 400);// 窗口大小
		this.setVisible(true);// 窗口显现
		this.setResizable(false);// 窗口固定
		this.setLocationRelativeTo(null);// 窗口居中

		JPanel jp = new JPanel();// 把面板加入到窗口上
		this.add(jp);
		jp.setLayout(null);//布局方式为空 

		// 对“重新开始”这四个字设置
		begin.setFont(new Font("微软雅黑", Font.BOLD, 28));// 字体大小型号
		begin.setForeground(Color.WHITE);// 字体颜色
		begin.setBounds(180, 120, 130, 30);// 字体位置
		begin.addMouseListener(new MyMouseListener());// 加入监听

		// 对“结束游戏”这四个字设置
		end.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 28));// 字体型号大小
		end.setForeground(Color.WHITE);// 字体颜色
		end.setBounds(180, 160, 130, 30);// 字体位置
		end.addMouseListener(new MyMouseListener());// 加入监听

		jp.add(begin);// 把start加入面板中
		jp.add(end);// 把exit加入面板中

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 窗口关闭

	}

	class MyMouseListener extends MouseAdapter {// 监听类(鼠标)

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == begin) {
				begin .setForeground(Color.GREEN);// 鼠标进入标签start的时候显示绿色
			} else if (e.getSource() == end) {
				end.setForeground(Color.RED);// 鼠标进入标签exit的时候显示红色
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == begin ) {
				begin.setForeground(Color.WHITE);// 鼠标离开标签start的时候显示绿色
			} else if (e.getSource() == end) {
				end.setForeground(Color.WHITE);// 鼠标离开标签exit的时候显示红色
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == begin) {// 当点击“开始游戏”时，跳转到游戏窗口
				LeaveInterface.this.dispose();// 开始游戏的界面随之消失
				pf.dispose();// 关闭之前的游戏界面
				PlaneFrame tf = new PlaneFrame();// 打开一个新界面
			} else if (e.getSource() == end) {// 当点击“结束游戏”时，退出程序
				System.exit(0);
			}
		}
	}
}