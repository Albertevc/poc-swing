package br.com.aevc.pocswing.view;

import javax.swing.JFrame;

/**
 * @author alber
 *
 */
public class ViewLoader {

	private static JFrame mainView;

	public static JFrame load() {
		if (mainView == null) {
			mainView = new MainView(new MainPanel());
		}
		return mainView;
	}

}
