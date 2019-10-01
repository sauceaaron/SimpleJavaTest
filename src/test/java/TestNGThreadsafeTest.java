import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

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
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() +  "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(Thread.currentThread().getThreadGroup() + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		System.out.println("count = " + count.get());
		assertEquals(count.get().intValue(), 1);
	}

	@Test
	public void test2() throws InterruptedException
	{
		Thread.sleep(1000);
		int temp = count.get();
		count.set(temp+1);
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() +  "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(Thread.currentThread().getThreadGroup() + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		System.out.println("count = " + count.get());
		assertEquals(count.get().intValue(), 1);

	}
}
