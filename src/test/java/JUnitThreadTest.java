import org.junit.Test;

public class JUnitThreadTest
{
	public int count = 0;

	@Test
	public void test1() throws InterruptedException
	{
		count++;
		Thread.sleep(1000);
		System.out.println(count + " " + Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + Thread.currentThread().getId());
	}

	@Test
	public void test2() throws InterruptedException
	{
		count++;
		Thread.sleep(1000);
		System.out.println(count + " " + Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + Thread.currentThread().getId());
	}
}
