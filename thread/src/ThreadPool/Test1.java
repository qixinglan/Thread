package ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 多线程向公共资源插入
 * @author 七星
 *
 */

public class Test1 {
	static List<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
		Test1 test1=new Test1();
		list=Collections.synchronizedList(list);
		for(int i=0;i<10;i++){
			A a=new A(i,test1.list);
			executor.execute(a);
			
		}
		Thread.sleep(100);
		System.out.println(test1.list);
	}
	
}
class A implements Runnable {
	private int index;
	private List<Integer> list;
	public A(int index,List<Integer> list) {
		this.index = index;
		this.list = list;
	}

	public void run() {
		list.add(this.index);
	}
	
}
