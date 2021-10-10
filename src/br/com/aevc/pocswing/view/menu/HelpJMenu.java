package br.com.aevc.pocswing.view.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * @author alber
 *
 */
class HelpJMenu extends JMenu {

	private static final long serialVersionUID = -4757532708335874622L;

	public HelpJMenu() {
		super("Ajuda");
		setMnemonic(KeyEvent.VK_N);
		add(new JMenuItem("Sobre"));
	}

}
