package CreateThread;
/**
 * 通过Thread构造参数为实现Runnable接口的对象或单纯实现
 * runable接口的内部类
 * 实现runbale接口创建线程
 * 实现run方法
 * @author 七星
 *
 */
public class ThreadTwo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("实现runbale接口创建线程");
	}

}
