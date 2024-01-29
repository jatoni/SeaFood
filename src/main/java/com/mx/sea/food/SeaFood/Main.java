package com.mx.sea.food.SeaFood;

import javax.swing.SwingUtilities;

import com.mx.sea.food.views.Login;
/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
	}
}
