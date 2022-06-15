package Plane;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HostilePlane extends FlyingObject{
	BufferedImage hostileplaneImage;//定义敌机的图片
	private int speedenemy = 5;//定义敌机的速度

	public HostilePlane() {//获取敌机的图片
		hostileplaneImage=ImageUtil.getImg("/Photor/雷霆战机+全民飞机大战+飞机大战全套素材-smallplan_爱给网_aigei_com.png");
		x = (int) (Math.random() * 360) + 10; // 随机生成x坐标
		y = -10;
		this.width = hostileplaneImage.getWidth();//获取敌机的宽度
		this.height = hostileplaneImage.getHeight();//获取敌机的高度
	}

	public void velocity() {//定义敌机的运动的方法
		y += speedenemy;
	}

	public void drawB(Graphics g) {//画敌机
		// TODO Auto-generated method stub
		g.drawImage(hostileplaneImage, x, y, null);
	}


	// x,y的get和set方法
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// 检测是否越界
	public boolean outOfBounds() {
		return this.y >= 700;
	}
}

