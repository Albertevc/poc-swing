package br.com.aevc.pocswing.view.menu;

import br.com.aevc.pocswing.controller.LoginController;
import br.com.aevc.pocswing.view.login.LoginJOptionPaneLoader;
import br.com.aevc.pocswing.view.product.ProductRegistrationJPanel;
import br.com.aevc.pocswing.view.user.UserRegistrationJPanel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author alber
 *
 */
class FileJMenu extends JMenu {

	private static final long serialVersionUID = -4757532708335874622L;

	public FileJMenu() {
		super("Arquivo");
		add(new JMenuItem("Configuração",
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/gear.png")))));
		addSeparator();

		JMenuItem addUser = new JMenuItem("Cadastro de Usuários");
		addUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserRegistrationJPanel();
			}
		});
		add(addUser);
		addSeparator();
		
		JMenuItem cadastroDeProdutos = new JMenuItem("Cadastro de Produtos");
		cadastroDeProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductRegistrationJPanel();
			}
		});
		add(cadastroDeProdutos);
		addSeparator();


		JMenuItem sairJMenuItem = new JMenuItem("Sair");
		sairJMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginController.logoff();
				LoginJOptionPaneLoader.showLoginDialog(null);
			}
		});
		add(sairJMenuItem);
	}

}
