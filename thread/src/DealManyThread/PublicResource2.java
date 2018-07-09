package DealManyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 场景问题
 * 1多个线程访问一个公共资源
 * 如两个人去同一个商场买衣服
 * 针对这种现象可以用
 * lock
 */
public class PublicResource2 {
	private static List<String> clothes;
	private static ReentrantLock lock = new ReentrantLock();
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
	
	public static  void buyClothes(){
		lock.lock();//上锁
		int boughtClothes=new Random().nextInt(clothes.size());
		String s=clothes.remove(boughtClothes);
		System.out.println("我买了"+s);
		lock.unlock();//解锁
	}
}
