package Plane;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PlaneBullet extends FlyingObject {
	
	private int speed = 10 ;// 定义飞机的速度
	BufferedImage pB;// 定义子弹图片

	public PlaneBullet(int x1, int y1) {// 初始化定义子弹
		pB = ImageUtil.getImg("/Photor/bullet.png");// 读取子弹的图片
		this.x = x1;//获取子弹x坐标
		this.y = y1;//获取子弹y坐标
		this.width = pB.getWidth();//获取子弹的宽度
		this.height = pB.getHeight();//获取子弹的高度
	}

	public void move() {// 子弹移动的方法
		 y -= speed;
	}
	
	public void drawB(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(pB,x,y,null);//画子弹
	}

	//检测是否越界
	public boolean outOfBounds() {
		return this.y <= -this.height;
	}

	 //x,y的get和set方法
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

}
