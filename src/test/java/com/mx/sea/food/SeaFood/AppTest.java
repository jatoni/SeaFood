package com.mx.sea.food.SeaFood;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mx.sea.food.controllers.RegisterController;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */

	private RegisterController registerController;

	@Test
	public void shouldAnswerWithTrue() {
		registerController = new RegisterController();
		System.out.println(registerController.getRoleList());
	}
}
