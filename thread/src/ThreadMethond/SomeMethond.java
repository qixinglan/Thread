package ThreadMethond;
/**
 * thread的常用方法
 * @author 七星
 *
 */
public class SomeMethond {
	public static void main(String[] args) {
		A a=new A();
		a.setName("A");//线程名字
		a.setPriority(Thread.MIN_PRIORITY);//设置优先级
		B b=new B();
		b.setPriority(Thread.MAX_PRIORITY);
		a.start();
		
		//a.interrupt();//停止阻塞状态，进入等待状态，在这就把sleep中断了
		b.start();
		a.join();//a.join(4000);当前线程强制运行完或设置运行多少（毫秒）
		a.yield();//sleep 方法使当前运行中的线程睡眠一段时间，进入不可以运行状态，这段时间的长短是由程序设定的，
		//yield方法使当前线程让出CPU占有权，但让出的时间是不可设定的
		a.setDaemon(true);//后台线程，默认是前台线程。当前台线程去全部运行完之后后台 线程都会终止
		Thread currentThread=Thread.currentThread();//当前线程
		System.out.println(currentThread.getName());//
		System.out.println(a.getName());
		System.out.println(a.isAlive());//线程是否活着
	}
}
