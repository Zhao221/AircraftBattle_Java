package Plane;

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject {
	
	int life;//飞机的生命
	BufferedImage plane;// 定义飞机图片
	
	// 游戏有两个状态：开始，暂停
	boolean isStart = false;// 默认游戏是暂停的
	
	public void init() {//初始化飞机的坐标
		x = 200;
		y = 500;
	}
	public Airplane() {
		init();//调用init()方法
		plane = ImageUtil.getImg("/Photor/hero.png");// 读取飞机的图片
		this.width = plane.getWidth();//得到这个飞机的宽度
		this.height = plane.getHeight();//得到这个飞机的高度
		this.life = 1;

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