package com.aula.java;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculadoraView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton button11;
	private JButton buttonIgual;
	private JButton buttonSoma;
	private JButton buttonSubtracao;
	private JButton buttonMultipli;
	private JButton buttonDivisao;
	private JButton buttonRaiz;
	private JTextField texField_insertDados;
	private JButton buttonlimpar;
	private JLabel label_mostraValores_Acima;

	String memoria1 = "";
	String memoria2 = "";
	String sinal = "";
	String mostra_resultado;
	float resultadoSoma = 0;
	float resultadoSub = 0;
	float resultadoMultiplicacao = 0;
	float resultadoDivisao = 0;
	float resultadoRaiz = 0;
	float numero1 = 0;
	float numero2 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraView frame = new CalculadoraView();
					frame.setVisible(true);
					frame.setEnabled(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 318);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		texField_insertDados = new JTextField();
		texField_insertDados.setEditable(false);
		texField_insertDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		texField_insertDados.setForeground(Color.BLACK);

		texField_insertDados.setHorizontalAlignment(SwingConstants.CENTER);
		texField_insertDados.setColumns(10);
		texField_insertDados.setBounds(58, 43, 280, 34);
		contentPane.add(texField_insertDados);

		button1 = new JButton("1");
		button1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button1.addActionListener(this);
		button1.setBounds(58, 99, 62, 23);
		contentPane.add(button1);

		button2 = new JButton("2");
		button2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button2.addActionListener(this);
		button2.setBounds(132, 99, 62, 23);
		contentPane.add(button2);

		button3 = new JButton("3");
		button3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button3.addActionListener(this);
		button3.setBounds(204, 99, 62, 23);
		contentPane.add(button3);

		button4 = new JButton("4");
		button4.setFont(new Font("Tahoma", Font.BOLD, 13));
		button4.addActionListener(this);
		button4.setBounds(58, 133, 62, 23);
		contentPane.add(button4);

		button5 = new JButton("5");
		button5.setFont(new Font("Tahoma", Font.BOLD, 13));
		button5.addActionListener(this);
		button5.setBounds(132, 133, 62, 23);
		contentPane.add(button5);

		button6 = new JButton("6");
		button6.setFont(new Font("Tahoma", Font.BOLD, 13));
		button6.addActionListener(this);
		button6.setBounds(204, 133, 62, 23);
		contentPane.add(button6);

		button7 = new JButton("7");
		button7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button7.addActionListener(this);
		button7.setBounds(58, 167, 62, 23);
		contentPane.add(button7);

		button8 = new JButton("8");
		button8.setFont(new Font("Tahoma", Font.BOLD, 13));
		button8.addActionListener(this);
		button8.setBounds(132, 167, 62, 23);
		contentPane.add(button8);

		button9 = new JButton("9");
		button9.setFont(new Font("Tahoma", Font.BOLD, 13));
		button9.addActionListener(this);
		button9.setBounds(204, 167, 62, 23);
		contentPane.add(button9);

		button10 = new JButton("0");
		button10.setFont(new Font("Tahoma", Font.BOLD, 13));
		button10.addActionListener(this);
		button10.setBounds(58, 201, 62, 23);
		contentPane.add(button10);

		button11 = new JButton(".");
		button11.setFont(new Font("Tahoma", Font.BOLD, 14));
		button11.setBounds(132, 201, 62, 23);
		button11.addActionListener(this);
		contentPane.add(button11);

		buttonlimpar = new JButton("C");
		buttonlimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonlimpar.addActionListener(this);
		buttonlimpar.setBounds(204, 201, 62, 23);
		contentPane.add(buttonlimpar);

		buttonIgual = new JButton("=");
		buttonIgual.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonIgual.addActionListener(this);
		buttonIgual.setBounds(58, 235, 208, 23);
		contentPane.add(buttonIgual);

		buttonSoma = new JButton("+");
		buttonSoma.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonSoma.addActionListener(this);
		buttonSoma.setBounds(276, 99, 62, 23);
		contentPane.add(buttonSoma);

		buttonSubtracao = new JButton("-");
		buttonSubtracao.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonSubtracao.addActionListener(this);
		buttonSubtracao.setBounds(276, 133, 62, 23);
		contentPane.add(buttonSubtracao);

		buttonMultipli = new JButton("x");
		buttonMultipli.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonMultipli.addActionListener(this);
		buttonMultipli.setBounds(276, 167, 62, 23);
		contentPane.add(buttonMultipli);

		buttonDivisao = new JButton("\u00F7");
		buttonDivisao.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonDivisao.addActionListener(this);
		buttonDivisao.setBounds(276, 201, 62, 23);
		contentPane.add(buttonDivisao);

		buttonRaiz = new JButton("\u221A");
		buttonRaiz.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonRaiz.addActionListener(this);
		buttonRaiz.setBounds(276, 235, 62, 23);
		contentPane.add(buttonRaiz);

		label_mostraValores_Acima = new JLabel("");
		label_mostraValores_Acima.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_mostraValores_Acima.setHorizontalAlignment(SwingConstants.RIGHT);

		label_mostraValores_Acima.setBounds(48, 18, 259, 14);
		contentPane.add(label_mostraValores_Acima);

	}

	public void actionPerformed(ActionEvent e) {

		if (((JButton) e.getSource()).equals(button1)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "1");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}

		if (((JButton) e.getSource()).equals(button2)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "2");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button3)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "3");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}

		if (((JButton) e.getSource()).equals(button4)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "4");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button5)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "5");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button6)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "6");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button7)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "7");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button8)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "8");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button9)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "9");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button10)) {
			texField_insertDados.setText("" + texField_insertDados.getText() + "0");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

		}
		if (((JButton) e.getSource()).equals(button11) && button11 != null) {
			texField_insertDados.setText("" + texField_insertDados.getText() + ".");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());
			button11.setEnabled(false);
		}

		if (((JButton) e.getSource()).equals(buttonSoma)) {
			if (texField_insertDados.getText().equals("")) {

				System.runFinalization();
				texField_insertDados.setText("");

			} else {

				sinal = "Soma";
				memoria1 = texField_insertDados.getText();
				numero1 = Float.parseFloat(memoria1);
				label_mostraValores_Acima.setText("" + texField_insertDados.getText() + " +");
				texField_insertDados.setText("");
				button11.setEnabled(true);

			}
		}

		if (((JButton) e.getSource()).equals(buttonSubtracao)) {
			if (texField_insertDados.getText().equals("")) {

				System.runFinalization();
				texField_insertDados.setText("");

			} else {

				sinal = "Subtracao";
				label_mostraValores_Acima.setText("" + texField_insertDados.getText() + "-");
				memoria1 = texField_insertDados.getText();
				numero1 = Float.parseFloat(memoria1);
				texField_insertDados.setText("");
				button11.setEnabled(true);

			}
		}

		if (((JButton) e.getSource()).equals(buttonMultipli)) {
			if (texField_insertDados.getText().equals("")) {

				System.runFinalization();
				texField_insertDados.setText("");

			} else {

				sinal = "Multiplicacao";
				label_mostraValores_Acima.setText("" + texField_insertDados.getText() + " x");
				memoria1 = texField_insertDados.getText();
				numero1 = Float.parseFloat(memoria1);
				texField_insertDados.setText("");

				button11.setEnabled(true);

			}
		}
		if (((JButton) e.getSource()).equals(buttonDivisao)) {
			if (texField_insertDados.getText().equals("")) {

				System.runFinalization();
				texField_insertDados.setText("");

			} else {

				sinal = "Divisao";
				label_mostraValores_Acima.setText("" + texField_insertDados.getText() + " /");
				memoria1 = texField_insertDados.getText();
				numero1 = Float.parseFloat(memoria1);
				texField_insertDados.setText("");

				button11.setEnabled(true);

			}
		}

		if (((JButton) e.getSource()).equals(buttonRaiz)) {
			if (texField_insertDados.getText().equals("")) {

				System.runFinalization();
				texField_insertDados.setText("");

			} else {

				sinal = "Raiz";
				label_mostraValores_Acima.setText("" + texField_insertDados.getText() + " \u221A");
				memoria1 = texField_insertDados.getText();
				numero1 = Float.parseFloat(memoria1);
				texField_insertDados.setText("");

				button11.setEnabled(true);

			}
		}

		if (((JButton) e.getSource()).equals(buttonIgual)) {

			operacao();

			texField_insertDados.setText(mostra_resultado);

			label_mostraValores_Acima.setText("" + texField_insertDados.getText());

			sinal = "Soma";

			numero1 = 0;
			numero2 = 0;

			button11.setEnabled(true);
		}
		if (((JButton) e.getSource()).equals(buttonlimpar)) {

			texField_insertDados.setText("");
			label_mostraValores_Acima.setText("" + texField_insertDados.getText());
		}

	}

	public void operacao() {

	

		

		if (sinal == "Soma") {
			memoria2 = texField_insertDados.getText();
			numero2 = Float.parseFloat(memoria2);
			resultadoSoma = numero1 + numero2;
			mostra_resultado = Float.toString(resultadoSoma);
			texField_insertDados.setText(mostra_resultado);
			
			FileWriter arquivo;
			try {
				arquivo = new FileWriter("C:\\Soma.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				gravarArquivo.printf(numero1 +" + "+numero2 +" = "+resultadoSoma+"%n");
				
				arquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (sinal == "Subtracao") {

			memoria2 = texField_insertDados.getText();
			numero2 = Float.parseFloat(memoria2);
			resultadoSub = numero1 - numero2;
			mostra_resultado = Float.toString(resultadoSub);
			texField_insertDados.setText(mostra_resultado);
			
			FileWriter arquivo;
			try {
				arquivo = new FileWriter("C:\\Subtracao.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				gravarArquivo.printf(numero1 +" - "+numero2 +" = "+resultadoSub+"%n");
				
				arquivo.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (sinal == "Multiplicacao") {

			memoria2 = texField_insertDados.getText();
			numero2 = Float.parseFloat(memoria2);
			resultadoMultiplicacao = numero1 * numero2;
			mostra_resultado = Float.toString(resultadoMultiplicacao);
			texField_insertDados.setText(mostra_resultado);
			
			FileWriter arquivo;
			try {
				arquivo = new FileWriter("C:\\Multiplicacao.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				gravarArquivo.printf(numero1 +" * "+numero2 +" = "+resultadoMultiplicacao+"%n");
				
				arquivo.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (sinal == "Divisao") {

			memoria2 = texField_insertDados.getText();
			numero2 = Float.parseFloat(memoria2);
			resultadoDivisao = numero1 / numero2;
			mostra_resultado = Float.toString(resultadoDivisao);
			texField_insertDados.setText(mostra_resultado);
			
			FileWriter arquivo;
			try {
				arquivo = new FileWriter("C:\\Divisao.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				gravarArquivo.printf(numero1 +" / "+numero2 +" = "+resultadoDivisao+"%n");
				
				arquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (sinal == "Raiz") {
			// memoria2 = texFieldmostrar.getText();
			// numero2=Float.parseFloat(memoria2);
			resultadoRaiz = (float) (Math.sqrt(numero1));
			mostra_resultado = Float.toString(resultadoRaiz);
			texField_insertDados.setText(mostra_resultado);
			
			FileWriter arquivo;
			try {
				arquivo = new FileWriter("C:\\Raiz.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				gravarArquivo.printf(numero1 +" (√) "+resultadoRaiz+"%n");
				
				arquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
