package Plane;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageUtil {
	public static BufferedImage getImg(String path) {
			//加载图片
			try {
				//尝试拿着地址去找图片
				BufferedImage img=ImageIO.read(ImageUtil.class.getResource(path));
				//找到了，就将图片返回
				return img;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//会输出找不到的原因
				e.printStackTrace();
			}
			return null;
		}

	public static Image getImage(String path) {
		//加载图片
		try {
			//尝试拿着地址去找图片
			Image img=ImageIO.read(ImageUtil.class.getResource(path));
			//找到了，就将图片返回
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//会输出找不到的原因
			e.printStackTrace();
		}
		return null;
	}
}
