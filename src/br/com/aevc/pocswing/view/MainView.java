package br.com.aevc.pocswing.view;

import javax.swing.*;
import java.awt.*;

import static br.com.aevc.pocswing.util.ApplicationPropertiesUtil.getProperty;

/**
 * @author alber
 *
 */
class MainView extends JFrame {

	public MainView(JPanel mainJPanel) {
		super();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        setMinimumSize(new Dimension(800, 600));
	        setLocation(150, 50);
			setIconImage(
					Toolkit.getDefaultToolkit()
							.getImage(getClass().getResource("/resources/icon/cube_molecule_view.png"))
			);
			setTitle(getProperty("label.main-view.tittle"));
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setVisible(true);

			add(mainJPanel);

			validate();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.print(getProperty("message.exception.main-view.inicializar"));
			e.printStackTrace();
		}
	}

}
