package org.Test;

import org.testng.annotations.Test;

public class ParallelExecution2 {
	@Test
	private void tc8() {
		System.out.println("test case 8");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc9() {
		System.out.println("test case 9");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc10() {
		System.out.println("test case 10");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void tc11() {
		System.out.println("test case 11");
		System.out.println(Thread.currentThread().getId());
}
}
