package ThreadMethond;
/**
 * thread�ĳ��÷���
 * @author ����
 *
 */
public class SomeMethond {
	public static void main(String[] args) {
		A a=new A();
		a.setName("A");//�߳�����
		a.setPriority(Thread.MIN_PRIORITY);//�������ȼ�
		B b=new B();
		b.setPriority(Thread.MAX_PRIORITY);
		a.start();
		
		//a.interrupt();//ֹͣ����״̬������ȴ�״̬������Ͱ�sleep�ж���
		b.start();
		a.join();//a.join(4000);��ǰ�߳�ǿ����������������ж��٣����룩
		a.yield();//sleep ����ʹ��ǰ�����е��߳�˯��һ��ʱ�䣬���벻��������״̬�����ʱ��ĳ������ɳ����趨�ģ�
		//yield����ʹ��ǰ�߳��ó�CPUռ��Ȩ�����ó���ʱ���ǲ����趨��
		a.setDaemon(true);//��̨�̣߳�Ĭ����ǰ̨�̡߳���ǰ̨�߳�ȥȫ��������֮���̨ �̶߳�����ֹ
		Thread currentThread=Thread.currentThread();//��ǰ�߳�
		System.out.println(currentThread.getName());//
		System.out.println(a.getName());
		System.out.println(a.isAlive());//�߳��Ƿ����
	}
}
