package Plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class PlaneFrame extends JFrame {
	PlanePanel pp = new PlanePanel(this);// 创建面板的对象(成员变量),将该对象传入到PlanePanel这个类的构造方法中
	public boolean isStart = true;// 默认游戏是开始的
	// 定义飞机的方向
	public boolean left;//左
	public boolean right;//右
	public boolean up;//上
	public boolean down;//下
    public static boolean pause=false;//控制暂停字体的开关
	public PlaneFrame() {// 构造方法

		setTitle("飞机大战");// 设置标题
		setSize(500, 650);// 设置屏幕大小setSize(宽度,高度);
		setLocationRelativeTo(null);// 居中(相对于左上角）
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口时关闭游戏，default:系统默认值。
		pp.display();// 调用线程
		add(pp); // 将面板添加到窗口上
		setResizable(false);// 将窗口固定
		setVisible(true);// true窗口显示，false窗口隐藏

		   this.addKeyListener(new KeyAdapter() {// 加一个监听效果

			public void keyPressed(KeyEvent e) {// 监听键盘的按压
				super.keyPressed(e);
				int keyCode = e.getKeyCode();// 获取你按的到底是哪个键
				if (keyCode == KeyEvent.VK_UP) {
					up = true;
				}
				if (keyCode == KeyEvent.VK_DOWN) {
					down = true;
				}
				if (keyCode == KeyEvent.VK_LEFT) {
					left = true;
				}
				if (keyCode == KeyEvent.VK_RIGHT) {
					right = true;
				}

			}

			public void keyReleased(KeyEvent e) {// 按键抬起的方法
				super.keyReleased(e);
				// 获取你按的到底是哪个键
	   			int keyCode = e.getKeyCode();
				if (keyCode == 32) {// 监听到点到空格了
					//按一次键，暂停，字出现
					//再按一次键，暂停结束，字消失
					pause =! pause;
					if (pp.state != 4) {
						isStart = !isStart;//使按压空格达到暂停的效果
						
						// 重新绘制页面
						repaint();
					}
				}
				if (keyCode == KeyEvent.VK_UP) {
					up = false;
				}
				if (keyCode == KeyEvent.VK_DOWN) {
					down = false;
				}
				if (keyCode == KeyEvent.VK_LEFT) {
					left = false;
				}
				if (keyCode == KeyEvent.VK_RIGHT) {
					right = false;
				}
			}

		});
	}
}
