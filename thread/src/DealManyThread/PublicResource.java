package DealManyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * ��������
 * 1����̷߳���һ��������Դ
 * ��������ȥͬһ���̳����·�
 * ����������������
 * synchronizedͬ����
 * ���η���������synchronized(������Դ�Ķ���)
 */
public class PublicResource {
	private static List<String> clothes;
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
	
	/*public static synchronized void buyClothes(){
		int boughtClothes=new Random().nextInt(clothes.size());
		String s=clothes.remove(boughtClothes);
		System.out.println("������"+s);
	}*/
	public static  void buyClothes(){
		synchronized(clothes){
			int boughtClothes=new Random().nextInt(clothes.size());
			String s=clothes.remove(boughtClothes);
			System.out.println("������"+s);
		}
		
	}
}
