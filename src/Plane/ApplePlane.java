package Plane;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ApplePlane extends FlyingObject {
	BufferedImage apImage;//定义生命果的图片
	private int applespeed = 7;//定义生命果的速度

	public ApplePlane() {
		apImage = ImageUtil.getImg("/Photor/Icons-03_爱给网_aigei_com.png");
		x = (int) (Math.random() * 360) + 10; // 随机生成x坐标
		y = -100;
		this.width = apImage.getWidth();//获取生命果的宽度
		this.height = apImage.getHeight();//获取生命果的高度
	}

	public void velocity() {//定义的生命果的运动方法
		y += applespeed;
	}

	public void drawB(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(apImage, x, y, null);//画出生命果

	}
	//检测是否越界
		public boolean outOfBounds() {
			return this.y >= 700;
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
