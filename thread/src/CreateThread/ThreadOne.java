package CreateThread;
/**
 * 
 * 类继承Thread方法创建线程
 * 重写run方法
 * 
 * @author 七星
 *
 */
public class ThreadOne extends Thread{
	public void run(){
		System.out.println("类继承Thread方法创建线程");
	}
	
}
