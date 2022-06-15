package Plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class PlanePanel extends JPanel {

	int x, y, state, score;// 定义横坐标，纵坐标，状态，分数
	BufferedImage bg;// 定义背景图片

	Airplane ap = new Airplane();// 设置飞机对象

	PlaneBullet planeBullet = new PlaneBullet(ap.x + 50, ap.y);// 设置子弹对象并传入坐标，使其位于飞机正中间
	List<PlaneBullet> bPlanes = new ArrayList<PlaneBullet>(); // 存储子弹对象

	EnemyPlane enemyPlane = new EnemyPlane(); // 建立敌机对象
	List<EnemyPlane> ePlanes = new ArrayList<EnemyPlane>(); // 存储敌机对象

	ApplePlane applePlane = new ApplePlane();// 设置生命果的对象
	List<ApplePlane> aPlanes = new ArrayList<ApplePlane>();// 储存生命果对象

	HostilePlane hostilePlane = new HostilePlane();// 设置第二个敌机的对象
	List<HostilePlane> hPlanes = new ArrayList<HostilePlane>();// 储存第二个敌机的对象

	long pretime; // 发射上一颗子弹的时间
	long starttime; // 上一个敌机出现的时间
	long firsttime; // 上一个生命果出现的时间

	public final int OVER = 4;// 运行状态常量——结束

	PlaneFrame pf = null;// 使游戏窗口对象为空

	public PlanePanel(PlaneFrame pf) {// 构造方法，传入游戏窗口的对象
		this.pf = pf;// 将该对象的名称与该对象的索引连接起来
		bg = ImageUtil.getImg("/Photor/back.jpg");// 读取背景图
		System.currentTimeMillis(); // 现在的时间,时间戳
	}

	@Override
	public void paint(Graphics g) {// 画的方法
		super.paint(g);

		g.drawImage(bg, 0, 0, null);// 画背景图
		g.drawImage(ap.plane, ap.x, ap.y, null); // 画飞机
		// 画子弹
		if (System.currentTimeMillis() - pretime > 200) {// 当时间戳>200毫秒的时候
			bPlanes.add(new PlaneBullet(ap.x + 50, ap.y));// 获取下一颗子弹
			pretime = System.currentTimeMillis(); // 把现在的时间赋给上一颗子弹发射的时间
			if (score >= 1000) {
				bPlanes.add(new PlaneBullet(ap.x + 30, ap.y));// 获取下一颗子弹
				pretime = System.currentTimeMillis();// 把现在的时间赋给上一颗子弹发射的时间
			}
			if (score >= 2000) {
				bPlanes.add(new PlaneBullet(ap.x + 70, ap.y));// 获取下一颗子弹
				pretime = System.currentTimeMillis();// 把现在的时间赋给上一颗子弹发射的时间
			}
			if (score >= 3000) {
				bPlanes.add(new PlaneBullet(ap.x + 10, ap.y));// 获取下一颗子弹
				bPlanes.add(new PlaneBullet(ap.x + 90, ap.y));// 获取下一颗子弹
				pretime = System.currentTimeMillis();// 把现在的时间赋给上一颗子弹发射的时间
			}
		}
		for (int i = 0; i < bPlanes.size(); i++) {// 遍历集合
			bPlanes.get(i).drawB(g); // 画出所有子弹
			bPlanes.get(i).move(); // 调用子弹移动的方法
		}
		// 画敌机
		if (System.currentTimeMillis() - starttime > 500) {// 当时间戳>500毫秒的时候
			hPlanes.add(new HostilePlane());// 获取下一个敌机
			hPlanes.add(new HostilePlane());// 获取下一个敌机
			starttime = System.currentTimeMillis(); // 把现在的时间赋给上一个敌机发射的时间
			if (score > 1000) {
				ePlanes.add(new EnemyPlane()); // 获取下一个敌机
				ePlanes.add(new EnemyPlane()); // 获取下一个敌机
				hPlanes.add(new HostilePlane()); // 获取下一个敌机
				starttime = System.currentTimeMillis(); // 把现在的时间赋给上一个敌机发射的时间
				if (score > 2000) {
					ePlanes.add(new EnemyPlane()); // 获取下一个敌机
					starttime = System.currentTimeMillis();// 把现在的时间赋给上一个敌机发射的时间
					if (score > 3000) {
						hPlanes.add(new HostilePlane());// 获取下一个敌机
						ePlanes.add(new EnemyPlane()); // 获取下一个敌机
						starttime = System.currentTimeMillis();// 把现在的时间赋给上一个敌机发射的时间
					}
				}
			}
		}
		for (int j = 0; j < ePlanes.size(); j++) {// 遍历敌机集合
			ePlanes.get(j).drawB(g);// 画出所有敌机
			ePlanes.get(j).movement();// 调用敌机运动的方法
		}
		for (int l = 0; l < hPlanes.size(); l++) {// 遍历敌机集合
			hPlanes.get(l).drawB(g);// 画出所有敌机·
			hPlanes.get(l).velocity();// 调用敌机运动的方法
		}
		// 画生命果
		if (System.currentTimeMillis() - firsttime > 20000) {// 每隔20秒出一个生命果
			aPlanes.add(new ApplePlane());// 产生第一个生命果
			firsttime = System.currentTimeMillis();// 把现在的时间赋给上一个生命果出现的时间
		}
		for (int k = 0; k < aPlanes.size(); k++) {// 遍历生命果的集合
			aPlanes.get(k).drawB(g);// 画出所有生命果
			aPlanes.get(k).velocity();// 调用生命果的移动方法
		}
		// 画分数
	
			g.setColor(Color.white);// 添加颜色
			g.setFont(new Font("楷体", Font.BOLD, 20));// 设置字体大小型号
			g.drawString("分数 " + score, 10, 30);// 位置大小、
		

		// 画生命
		g.setColor(Color.white);// 添加颜色
		g.setFont(new Font("楷体", Font.BOLD, 20));// 设置字体大小型号
		g.drawString("生命： " + ap.life, 10, 50);// 位置大小
		
		//画暂停字体
		if(PlaneFrame.pause) {//如果暂停就出现就出现以下字
			g.setColor(Color.white);// 添加颜色
			g.setFont(new Font("楷体", Font.BOLD, 50));// 设置字体大小型号
			g.drawString("游戏已暂停", 110, 300);// 位置大小
			g.setFont(new Font("楷体", Font.BOLD, 30));// 设置字体大小型号
			g.drawString("点击空格，继续游戏", 100,350 );// 位置大小
		}
		//画胜利字样
		if(score==4000) {
			new LeaveInterface(pf);//如果分数达到4000分，就弹出结束窗口
			pf.isStart=false;//游戏暂停
			g.setColor(Color.green);// 添加颜色
			g.setFont(new Font("楷体", Font.BOLD, 30));// 设置字体大小型号
			g.drawString("游戏胜利,你真棒!", 130, 50);// 位置大小
		}
		
		if (state == OVER) {
			new LeaveInterface(pf);// 如果游戏结束弹出结束窗口
		}
	}

	public void display() {// 在方法里写一个线程

		new Thread() {// 匿名线程
			@Override
			public void run() {
				while (true) {
					if (pf.isStart == true) {// 飞机移动的距离
						if (pf.up) {
							ap.y -= 8;
						}
						if (pf.down) {
							ap.y += 8;
						}
						if (pf.left) {
							ap.x -= 8;
						}
						if (pf.right) {
							ap.x += 8;
						}

						// 子弹和敌机碰撞
						for (int i = 0; i < bPlanes.size(); i++) {
							PlaneBullet z = bPlanes.get(i);
							for (int j = 0; j < ePlanes.size(); j++) {
								EnemyPlane d = ePlanes.get(j);
								if (Collision.Boom1(z, d)) { // 调用Collision类的Boom1方法判断是否相撞
									score += 20;
									ePlanes.remove(j); // 从集合中删除敌机
									bPlanes.remove(i); // 从集合中删除子弹
									break;
								}
							}
						}
						for (int i = 0; i < bPlanes.size(); i++) {
							PlaneBullet z = bPlanes.get(i);
							for (int l = 0; l < hPlanes.size(); l++) {
								HostilePlane h = hPlanes.get(l);
								if (Collision.Boom4(z, h)) { // 调用Collision类的Boom4方法判断是否相撞
									score += 10;
									hPlanes.remove(l); // 从集合中删除敌机
									bPlanes.remove(i); // 从集合中删除子弹.
									break;
								}
							}
						}
						// 飞机和生命果相撞
						for (int k = 0; k < aPlanes.size(); k++) {
							ApplePlane p = aPlanes.get(k);
							if (Collision.Boom3(p, ap)) {// 调用Collision类的Boom3方法判断是否相撞
								ap.life++;
								aPlanes.remove(k); // 从集合中删除子弹
								break;
							}
						}
						// 子弹的越界处理
						for (int i = 0; i < bPlanes.size(); i++) {
							PlaneBullet z1 = bPlanes.get(i);
							if (z1.outOfBounds()) {
								bPlanes.remove(i);
							}
						}
						// 敌机越界处理
						for (int l = 0; l < hPlanes.size(); l++) {
							HostilePlane j1 = hPlanes.get(l);
							if (j1.outOfBounds()) {
								hPlanes.remove(l);
							}
						}
						// 敌机的越界处理
						for (int j = 0; j < ePlanes.size(); j++) {
							EnemyPlane d1 = ePlanes.get(j);
							if (d1.outOfBounds()) {
								ePlanes.remove(j);
							}
						}
						// 生命果的越界处理
						for (int k = 0; k < aPlanes.size(); k++) {
							ApplePlane p1 = aPlanes.get(k);
							if (p1.outOfBounds()) {
								aPlanes.remove(k);
							}
						}
						if (ap.y <= 0) {// 飞机超屏幕解决办法
							ap.y = 600;
						}
						if (ap.y > 600) {
							ap.y = 500;
						}
						if (ap.x < -50) {
							ap.x = 400;
						}
						if (ap.x > 400) {
							ap.x = 0;
						}
						// 判断敌机和飞机相撞
						for (int j = 0; j < ePlanes.size(); j++) {
							EnemyPlane d = ePlanes.get(j);
							if (Collision.Boom2(d, ap)) {
								ePlanes.remove(j);
								ap.life--;
							}
						}
						// 要重置页面
						 repaint();
						// 判断敌机和飞机相撞
						for (int l = 0; l < hPlanes.size(); l++) {
							HostilePlane h = hPlanes.get(l);
							if (Collision.Boom5(h, ap)) {
								hPlanes.remove(l);
								ap.life--;
							}
						}
						// 重置页面
                        // repaint();
						if (ap.life <=0) { // 游戏结束
							state = OVER;
							pf.isStart = false;
						}
					}
					// 线程休眠
					try {
						sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
