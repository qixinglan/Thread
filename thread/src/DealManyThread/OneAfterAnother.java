package DealManyThread;
/**
 * ����2
 * �����̻߳��⣬���Ⱥ�
 * ��������ȴ���ȡ
 * �����ٳԷ�
 * ��  wait  notify  notifyAll
 * һ����synchronized ͬ���������ʹ�� wait()��notify/notifyAll() ������
 * @author ����
 *
 */
	
public class OneAfterAnother {
   public static void main(String[] args) {
	final Thread t1=new Thread(new Runnable() {
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("��");
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
			System.out.println("�Է�");
		}
	});
	t2.start();
	t1.start();
   }
}
