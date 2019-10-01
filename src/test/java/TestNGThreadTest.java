import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.AssertJUnit.assertEquals;

public class TestNGThreadTest
{
	public int count = 0;

	@Test
	public void test1() throws InterruptedException
	{
		count++;
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() +  "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(Thread.currentThread().getThreadGroup() + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		System.out.println("count = " + count);
		assertEquals(count, 1);
	}

	@Test
	public void test2() throws InterruptedException
	{
		Thread.sleep(1000);
		count++;
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() +  "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(Thread.currentThread().getThreadGroup() + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		System.out.println("count = " + count);
		assertEquals(count, 1);
	}
}
