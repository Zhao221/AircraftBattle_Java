package Plane;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemyPlane extends FlyingObject {
	BufferedImage enemyPlaneImage;//定义敌机图片
	private int speedenemy = 5;//设计敌机的速度
	
	public EnemyPlane() {//构造方法
		enemyPlaneImage = ImageUtil.getImg("/Photor/dj.png");//获取敌机的图片
		x = (int) (Math.random() * 360) + 10; // 随机生成x坐标
		y = -10;
		this.width = enemyPlaneImage.getWidth();//获取敌机的宽度
		this.height = enemyPlaneImage.getHeight();//获取敌机的高度
	}

	public void movement() {//设置敌机的运动速度方法
		y += speedenemy;
	}

	public void drawB(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(enemyPlaneImage, x, y, null);//画敌机
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
