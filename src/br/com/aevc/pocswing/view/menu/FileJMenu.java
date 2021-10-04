package br.com.aevc.pocswing.view.menu;

import br.com.aevc.pocswing.view.login.LoginPanel;
import br.com.aevc.pocswing.view.product.ProductRegistrationJPanel;
import br.com.aevc.pocswing.view.user.UserRegistrationJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import br.com.aevc.pocswing.view.product.ProductRegistrationJPanel;
//import br.com.aevc.pocswing.view.user.UserRegistrationJPanel;

/**
 * @author alber
 *
 */
class FileJMenu extends JMenu {

	private static final long serialVersionUID = -4757532708335874622L;

	public FileJMenu() {
		super("Arquivo");
		add(new JMenuItem("Configuração",
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon/gear.png")))));
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
//				LoginController.logoff();
				LoginPanel.showLoginDialog();
			}
		});
		add(sairJMenuItem);
	}

}
