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
		System.out.print(Thread.currentThread().getStackTrace()[1].getClassName() +  "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " : ");
		System.out.println(count + " " + Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + Thread.currentThread().getId());
		assertEquals(count, 1);
	}

	@Test
	public void test2() throws InterruptedException
	{
		Thread.sleep(1000);
		count++;
		System.out.print(Thread.currentThread().getStackTrace()[1].getClassName() +  "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " : ");
		System.out.println(count + " " + Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + Thread.currentThread().getId());
		assertEquals(count, 1);
	}
}
