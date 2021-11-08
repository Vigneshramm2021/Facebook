package org.Test;

import org.testng.annotations.Test;

public class ParallelExecution {
	@Test
	private void tc0() {
		System.out.println("test case 0");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc1() {
		System.out.println("test case 1");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc2() {
		System.out.println("test case 2");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc3() {
		System.out.println("test case 3");
		System.out.println(Thread.currentThread().getId());
	}
}
