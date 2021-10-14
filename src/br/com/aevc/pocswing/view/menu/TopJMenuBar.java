package br.com.aevc.pocswing.view.menu;

import javax.swing.*;
import java.util.stream.Stream;

/**
 * @author alber
 *
 */
public class TopJMenuBar extends JMenuBar {

	TopJMenuBar(
			JMenu... jMenus
	) {
		super();
		Stream.of(jMenus).forEach(jMenu ->
				add(jMenu)
		);
	}

}
