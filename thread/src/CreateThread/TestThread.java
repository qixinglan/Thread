package CreateThread;

public class TestThread {
	public static void main(String[] args) {
		ThreadOne t1=new ThreadOne();
		t1.start();
		Thread t2=new Thread(new ThreadTwo());
		t2.start();
		Thread t3=new Thread(new Runnable() {
			public void run() {
				System.out.println("内部类方式");
			}
		});
		t3.start();
	}
}
