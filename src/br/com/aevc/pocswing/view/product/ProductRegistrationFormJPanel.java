package br.com.aevc.pocswing.view.product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ProductRegistrationFormJPanel extends JPanel {

	private static final long serialVersionUID = -8677390533585078067L;

	private JTextField productName;
	private JFormattedTextField value;
	private JFormattedTextField amount;
	private JCheckBox type;
	private JFileChooser image;

	public ProductRegistrationFormJPanel() {
		super();
		initClass();
	}

	private void initClass() {
		JPanel labels = new JPanel(new GridLayout(0, 1, 2, 7));

		labels.add(new JLabel("Nome:"));
		labels.add(new JLabel("Valor:"));
		labels.add(new JLabel("Quantidade:"));
//		labels.add(new JLabel("Tipo:"));
//		labels.add(new JLabel("Imagem:"));
		add(labels, BorderLayout.CENTER);

		JPanel textFieldsPanel = new JPanel(new GridLayout(0, 1, 2, 2 ));

		productName = new JTextField();
		productName.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(productName);


		try {
			MaskFormatter currencyNumbersMask = new MaskFormatter("R$####.##");
			currencyNumbersMask.setValidCharacters("0123456789");
			value = new JFormattedTextField(currencyNumbersMask);

		} catch (ParseException e) {
			e.printStackTrace();
			value = new JFormattedTextField();
		}

		value.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(value);


		try {
			MaskFormatter onlyNumbersMask = new MaskFormatter("#########");
			onlyNumbersMask.setValidCharacters("0123456789");
			amount = new JFormattedTextField(onlyNumbersMask);

		} catch (ParseException e) {
			e.printStackTrace();
			amount = new JFormattedTextField();
		}
		amount.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(amount);


//		type = new JPasswordField();
//		type.setPreferredSize(new Dimension(100, 20));
//		textFieldsPanel.add(type);
//
//
//		image = new JPasswordField();
//		image.setPreferredSize(new Dimension(100, 20));
//		textFieldsPanel.add(image);
//
		add(textFieldsPanel, BorderLayout.CENTER);
	}

	public JTextField getProductName() {
		return productName;
	}

	public JFormattedTextField getValue() {
		return value;
	}

	public JFormattedTextField getAmount() {
		return amount;
	}

	public JCheckBox getType() {
		return type;
	}

	public JFileChooser getImage() {
		return image;
	}

}
