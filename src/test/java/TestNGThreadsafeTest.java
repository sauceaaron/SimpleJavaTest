import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGThreadsafeTest
{
	public ThreadLocal<Integer> count;

	@BeforeMethod
	public void setup()
	{
		count = new ThreadLocal<Integer>();
		count.set(0);
	}

	@Test
	public void test1() throws InterruptedException
	{
		int temp = count.get();
		count.set(temp+1);
		Thread.sleep(1000);
		System.out.println(count.get() + " " + Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + Thread.currentThread().getId());
	}

	@Test
	public void test2() throws InterruptedException
	{
		Thread.sleep(1000);
		int temp = count.get();
		count.set(temp+1);
		System.out.println(count.get() + " " + Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + Thread.currentThread().getId());
	}
}
