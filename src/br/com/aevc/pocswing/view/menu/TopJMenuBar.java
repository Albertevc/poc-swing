package br.com.aevc.pocswing.view.menu;

import javax.swing.*;

/**
 * @author alber
 *
 */
public class TopJMenuBar extends JMenuBar {

	private static final long serialVersionUID = -4416015725560673100L;

	public TopJMenuBar() {
		super();
		add(new FileJMenu());
		add(new HelpJMenu());
	}

}
