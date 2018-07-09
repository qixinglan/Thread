package DealManyThread;
/**
 * 场景2
 * 两个线程互斥，有先后
 * 比如存现先存再取
 * 先买饭再吃饭
 * 用  wait  notify  notifyAll
 * 一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
 * @author 七星
 *
 */
	
public class OneAfterAnother {
   public static void main(String[] args) {
	final Thread t1=new Thread(new Runnable() {
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("买饭");
			synchronized (this){
				this.notify();
			}
			
		}
	});
	Thread t2=new Thread(new Runnable() {
		public void run() {
			// TODO Auto-generated method stub
			try {
				synchronized (t1){
					t1.wait();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("吃饭");
		}
	});
	t2.start();
	t1.start();
   }
}
