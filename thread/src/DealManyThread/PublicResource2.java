package DealManyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ��������
 * 1����̷߳���һ��������Դ
 * ��������ȥͬһ���̳����·�
 * ����������������
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
		//�̳���3���·�
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
		System.out.println("��ʣ"+clothes);
	}
	
	public static  void buyClothes(){
		lock.lock();//����
		int boughtClothes=new Random().nextInt(clothes.size());
		String s=clothes.remove(boughtClothes);
		System.out.println("������"+s);
		lock.unlock();//����
	}
}
