package Plane;

import java.awt.Rectangle;


public class Collision  {
	//创建飞机、子弹、敌机、生命果的矩形对象
	private static Rectangle fjrectangle= new Rectangle(),djrectangle = new Rectangle();
	private static Rectangle zdrectangle =new Rectangle(),pgrectangle = new Rectangle();
	private static Rectangle dj2rectangle=new Rectangle();
	  public static boolean check1(FlyingObject f1 , FlyingObject f2){
	    fjrectangle.x = f1.x;//获取飞机的x、y、宽度、高度
	    fjrectangle.y = f1.y;
	    fjrectangle.width = f1.width;
	    fjrectangle.height = f1.height;

	    djrectangle.x = f2.x;//获取敌机的x、y、宽度、高度
	    djrectangle.y = f2.y;
	    djrectangle.width = f2.width;
	    djrectangle.height = f2.height;
	    
	    return fjrectangle.intersects(djrectangle);//判断这两个矩形是否有交集
	  }
	 public static boolean check2(FlyingObject f2 , FlyingObject f3){

			    djrectangle.x = f2.x;//获取敌机的x、y、宽度、高度
			    djrectangle.y = f2.y;
			    djrectangle.width = f2.width;
			    djrectangle.height = f2.height;
			    
			    zdrectangle.x = f3.x;//获取子弹的x、y、宽度、高度
			    zdrectangle.y = f3.y;
			    zdrectangle.width = f3.width;
			    zdrectangle.height = f3.height;

			    return djrectangle.intersects(zdrectangle);//判断这两个矩形是否有交集
	  }
	 public static boolean check3(FlyingObject f1 , FlyingObject f4){
		    fjrectangle.x = f1.x;//获取飞机的x、y、宽度、高度
		    fjrectangle.y = f1.y;
		    fjrectangle.width = f1.width;
		    fjrectangle.height = f1.height;

		    pgrectangle.x = f4.x;
		    pgrectangle.y = f4.y;//获取生命果的x、y、宽度、高度
		    pgrectangle.width = f4.width;
		    pgrectangle.height = f4.height;
		    
		    return fjrectangle.intersects(pgrectangle);//判断这两个矩形是否有交集
		  }
	 
	 public static boolean check4(FlyingObject f5 , FlyingObject f3){

		    dj2rectangle.x = f5.x;//获取敌机的x、y、宽度、高度
		    dj2rectangle.y = f5.y;
		    dj2rectangle.width = f5.width;
		    dj2rectangle.height = f5.height;
		    
		    zdrectangle.x = f3.x;//获取子弹的x、y、宽度、高度
		    zdrectangle.y = f3.y;
		    zdrectangle.width = f3.width;
		    zdrectangle.height = f3.height;

		    return dj2rectangle.intersects(zdrectangle);//判断这两个矩形是否有交集
}
	  public static boolean check5(FlyingObject f1 , FlyingObject f6){
		    fjrectangle.x = f1.x;//获取飞机的x、y、宽度、高度
		    fjrectangle.y = f1.y;
		    fjrectangle.width = f1.width;
		    fjrectangle.height = f1.height;

		    dj2rectangle.x = f6.x;//获取敌机的x、y、宽度、高度
		    dj2rectangle.y = f6.y;
		    dj2rectangle.width = f6.width;
		    dj2rectangle.height = f6.height;
		    
		    return fjrectangle.intersects(dj2rectangle);//判断这两个矩形是否有交集
		  }

	// 判断子弹和敌机碰撞
	public static boolean Boom1(PlaneBullet z, EnemyPlane d) {
		  djrectangle.setBounds(d.getX(),d.getY(),58,55);
		  zdrectangle.setBounds(z.getX(), z.getY(),50, 50);
		return  djrectangle.intersects(zdrectangle);
	}
	 //飞机和敌机相撞
  public static boolean Boom2(EnemyPlane d, Airplane a) {
        fjrectangle.setBounds(a.getX()+10, a.getY()+30, 100, 80);
        djrectangle.setBounds(d.getX(),d.getY(),58,55);
        return djrectangle.intersects(fjrectangle);
    }
  //飞机和生命果相撞
  public static boolean Boom3(ApplePlane p, Airplane a) {
      fjrectangle.setBounds(a.getX()+10, a.getY()+30, 100, 80);
      pgrectangle.setBounds(p.getX(),p.getY(),24,24);
      return pgrectangle.intersects(fjrectangle);
  }
  //子弹和敌机相撞
  public static boolean Boom4(PlaneBullet z, HostilePlane h) {
      dj2rectangle.setBounds(h.getX(), h.getY(),39 ,75 );
      zdrectangle.setBounds(z.getX(),z.getY(),50,50);
      return zdrectangle.intersects(dj2rectangle);
  }
  //飞机和敌机相撞
  public static boolean Boom5(HostilePlane h, Airplane a) {
      fjrectangle.setBounds(a.getX()+10, a.getY()+30, 100, 80);
      dj2rectangle.setBounds(h.getX(),h.getY(),39,75);
      return dj2rectangle.intersects(fjrectangle);
  }
}
