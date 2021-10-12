package br.com.aevc.pocswing.view.menu;

import br.com.aevc.pocswing.view.SwingApplicationContext;
import br.com.aevc.pocswing.view.product.ProductJInternalFrame;
import br.com.aevc.pocswing.view.user.UserJInternalFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static br.com.aevc.pocswing.view.login.LoginJOptionPane.showLoginDialog;

/**
 * @author alber
 */
class FileJMenu extends JMenu {

    private static final long serialVersionUID = -4757532708335874622L;

    public FileJMenu() {
        super("Arquivo");
        setMnemonic(KeyEvent.VK_N);

        add(
                new JMenuItem("Configuração",
                        new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon/gear.png")))
                )
        );

        addSeparator();

        JMenuItem addUser = new JMenuItem("Cadastro de Usuários");
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingApplicationContext.getSwingApplication()
                        .addJInternalFrame(new UserJInternalFrame(1));
            }
        });
        add(addUser);

        addSeparator();

        JMenuItem cadastroDeProdutos = new JMenuItem("Cadastro de Produtos");
        cadastroDeProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingApplicationContext
                        .getSwingApplication()
                        .addJInternalFrame(new ProductJInternalFrame(2));
            }
        });
        add(cadastroDeProdutos);

        addSeparator();

        JMenuItem sairJMenuItem = new JMenuItem("Sair");
        sairJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog();
            }
        });
        add(sairJMenuItem);

    }

}
