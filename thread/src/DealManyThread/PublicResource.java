package DealManyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 场景问题
 * 1多个线程访问一个公共资源
 * 如两个人去同一个商场买衣服
 * 针对这种现象可以用
 * synchronized同步锁
 * 修饰方法或代码块synchronized(共享资源的对象)
 */
public class PublicResource {
	private static List<String> clothes;
	static{
		clothes=new ArrayList<String>();
		clothes.add("01");
		clothes.add("02");
		clothes.add("03");
		//商场有3件衣服
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				buyClothes();
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				buyClothes();
			}
		});
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println("还剩"+clothes);
	}
	
	/*public static synchronized void buyClothes(){
		int boughtClothes=new Random().nextInt(clothes.size());
		String s=clothes.remove(boughtClothes);
		System.out.println("我买了"+s);
	}*/
	public static  void buyClothes(){
		synchronized(clothes){
			int boughtClothes=new Random().nextInt(clothes.size());
			String s=clothes.remove(boughtClothes);
			System.out.println("我买了"+s);
		}
		
	}
}
