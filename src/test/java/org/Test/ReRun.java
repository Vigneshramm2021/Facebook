package org.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReRun {

	@Test
	private void tc0() {
		System.out.println("Method1");
	}
	@Test
	private void tc1() {
		Assert.assertTrue(false);
		System.out.println("Method2");
	}
	@Test
	private void tc2() {
		Assert.assertTrue(false);
		System.out.println("Method3");
	}
}
