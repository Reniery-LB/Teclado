package teclado;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Font;

public class Teclado implements KeyListener{

	private JFrame frame;
	private JLabel[] teclas;
	private char[] letras = {
			'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
	        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Ñ',
	        'Z', 'X', 'C', 'V', 'B', 'N', 'M'
	};
	private JLabel teclaActual = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado window = new Teclado();
					window.frame.setVisible(true);
					window.frame.addKeyListener(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Teclado() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tecladito Mamalon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl_norte = new JPanel();
		pnl_norte.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(pnl_norte, BorderLayout.NORTH);
		pnl_norte.setLayout(null);
		pnl_norte.setLayout(new GridLayout(2, 1, 0, 0));
		pnl_norte.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		JLabel esperando = new JLabel("Esperando");
		esperando.setFont(new Font("Dialog", Font.BOLD, 18));
		esperando.setForeground(new Color(255, 255, 255));
		pnl_norte.add(esperando);
		
		JLabel escribir = new JLabel("Palabra a escribir");
		escribir.setForeground(new Color(255, 255, 255));
		escribir.setFont(new Font("Dialog", Font.PLAIN, 14));
		pnl_norte.add(escribir);
		
		JPanel pnl_teclado = new JPanel();
		pnl_teclado.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(pnl_teclado, BorderLayout.CENTER);
		pnl_teclado.setLayout(new GridLayout(3, 9, 0, 0));
		
		teclas = new JLabel[letras.length];
		
		for (int i = 0; i < letras.length; i++) {
			teclas[i] = new JLabel(String.valueOf(letras[i]));
			teclas[i].setHorizontalAlignment(JLabel.CENTER);
            teclas[i].setOpaque(true);
            teclas[i].setBackground(new Color(192,192,192));
            teclas[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            pnl_teclado.add(teclas[i]);
		}
		
//		JLabel tecla_q = new JLabel("Q");
//		tecla_q.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_q);
//		
//		JLabel tecla_w = new JLabel("W");
//		tecla_w.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_w);
//		
//		JLabel tecla_e = new JLabel("E");
//		tecla_e.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_e);
//		
//		JLabel tecla_r = new JLabel("R");
//		tecla_r.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_r);
//		
//		JLabel tecla_t = new JLabel("T");
//		tecla_t.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_t);
//		
//		JLabel tecla_y = new JLabel("Y");
//		tecla_y.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_y);
//		
//		JLabel tecla_u = new JLabel("U");
//		tecla_u.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_u);
//		
//		JLabel tecla_i = new JLabel("I");
//		tecla_i.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_i);
//		
//		JLabel tecla_o = new JLabel("O");
//		tecla_o.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_o);
//		
//		JLabel tecla_p = new JLabel("P");
//		tecla_p.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_p);
//		
//		JLabel tecla_a = new JLabel("A");
//		tecla_a.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_a);
//		
//		JLabel tecla_s = new JLabel("S");
//		tecla_s.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_s);
//		
//		JLabel tecla_d = new JLabel("D");
//		tecla_d.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_d);
//		
//		JLabel tecla_f = new JLabel("F");
//		tecla_f.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_f);
//		
//		JLabel tecla_g = new JLabel("G");
//		tecla_g.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_g);
//		
//		JLabel tecla_h = new JLabel("H");
//		tecla_h.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_h);
//		
//		JLabel tecla_j = new JLabel("J");
//		tecla_j.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_j);
//		
//		JLabel tecla_k = new JLabel("K");
//		tecla_k.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_k);
//		
//		JLabel tecla_l = new JLabel("L");
//		tecla_l.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_l);
//		
//		JLabel tecla_ñ = new JLabel("Ñ");
//		tecla_ñ.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_ñ);
//		
//		JLabel tecla_z = new JLabel("Z");
//		tecla_z.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_z);
//		
//		JLabel tecla_x = new JLabel("X");
//		tecla_x.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_x);
//		
//		JLabel tecla_c = new JLabel("C");
//		tecla_c.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_c);
//		
//		JLabel tecla_v = new JLabel("V");
//		tecla_v.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_v);
//		
//		JLabel tecla_b = new JLabel("B");
//		tecla_b.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_b);
//		
//		JLabel tecla_n = new JLabel("N");
//		tecla_n.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_n);
//		
//		JLabel tecla_m = new JLabel("M");
//		tecla_m.setHorizontalAlignment(JLabel.CENTER);
//		pnl_teclado.add(tecla_m);
		
		JPanel pnl_sur = new JPanel();
		pnl_sur.setBackground(new Color(0, 0, 160));
		frame.getContentPane().add(pnl_sur, BorderLayout.SOUTH);
		pnl_sur.setLayout(new GridLayout(1, 2, 20, 20));
		pnl_sur.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		JLabel borrando = new JLabel("BORRANDO");
		borrando.setForeground(new Color(255, 255, 255));
		borrando.setFont(new Font("Dialog", Font.BOLD, 18));
		borrando.setHorizontalAlignment(JLabel.CENTER);
		pnl_sur.add(borrando);
		
		JLabel espacio = new JLabel("ESPACIO");
		espacio.setForeground(new Color(255, 255, 255));
		espacio.setFont(new Font("Dialog", Font.BOLD, 18));
		espacio.setHorizontalAlignment(JLabel.CENTER);
		pnl_sur.add(espacio);
	}
	
	private Color color_rand() {
		Random rand = new Random();
		return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 char teclaPresionada = Character.toUpperCase(e.getKeyChar());
		 
	       for (int i = 0; i < letras.length; i++) {
	            if (letras[i] == teclaPresionada) {
	                if (teclaActual != null) {
	                    teclaActual.setBackground(new Color(192,192,192));
	                }
	      
	                teclaActual = teclas[i];
	                teclaActual.setBackground(color_rand());
	                break;
	            }
	        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
