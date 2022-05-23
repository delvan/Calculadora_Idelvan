package com.aula.java;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class HistoricoView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoView frame = new HistoricoView();
					frame.setVisible(true);
					frame.setEnabled(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public HistoricoView(){
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 318);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		try {
			leitura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void leitura() throws IOException {
		 FileInputStream stream = new FileInputStream("c:\\soma.txt");
	        InputStreamReader reader = new InputStreamReader(stream);
	        BufferedReader br = new BufferedReader(reader);
	        String linha = br.readLine();
	        
	        while(linha != null) {
	            System.out.println(linha);
	            linha = br.readLine();
	        }
	}


}
