package org.Test;

import org.testng.annotations.Test;

public class ParallelExecution1 {
	@Test
	private void tc4() {
		System.out.println("test case 4");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc5() {
		System.out.println("test case 5");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc6() {
		System.out.println("test case 6");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc7() {
		System.out.println("test case 7");
		System.out.println(Thread.currentThread().getId());
}

}