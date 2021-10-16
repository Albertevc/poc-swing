package br.com.aevc.pocswing.view.component;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.io.File;

public class JFileChooserJPanel extends JPanel {

    private final JFileChooser jFileChooser;

    public JFileChooserJPanel(String label) {
        super(new MigLayout("wrap 3"));

        this.jFileChooser = new JFileChooser();

        JLabel jLabel = new JLabel(label);
        add(jLabel);
        JTextField jTextField = new JTextField(20);
        jTextField.setEnabled(false);
        jLabel.setLabelFor(jTextField);
        add(jTextField);

        JButton selectJButton = new JButton("Selecionar");
        selectJButton.addActionListener(actionEvent -> {
            int returnValue = JFileChooserJPanel.this
                    .jFileChooser
                    .showOpenDialog(JFileChooserJPanel.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                jTextField.setText(
                        jFileChooser.getSelectedFile()
                                .getName()
                );
            }
        });
        add(selectJButton);
    }

    public File getSelectedFile() {
        return this.jFileChooser
                .getSelectedFile();
    }

}
