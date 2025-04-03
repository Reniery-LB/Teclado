package teclado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Teclado {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado window = new Teclado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teclado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tecladito Mamalon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel norte = new JPanel();
		norte.setBackground(new Color(50, 205, 50));
		frame.getContentPane().add(norte, BorderLayout.NORTH);
		norte.setLayout(null);
		norte.setLayout(new BorderLayout(0, 0));
		
		JLabel esperando = new JLabel("Esperando");
		norte.add(esperando);
		
		
		JPanel teclados = new JPanel();
		teclados.setBackground(new Color(245, 255, 250));
		frame.getContentPane().add(teclados, BorderLayout.CENTER);
		teclados.setLayout(new GridLayout(3, 0, 3, 9));
		
		JLabel tecla_q = new JLabel("Q");
		tecla_q.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_q);
		
		JLabel tecla_w = new JLabel("W");
		tecla_w.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_w);
		
		JLabel tecla_e = new JLabel("E");
		tecla_e.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_e);
		
		JLabel tecla_r = new JLabel("R");
		tecla_r.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_r);
		
		JLabel tecla_t = new JLabel("T");
		tecla_t.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_t);
		
		JLabel tecla_y = new JLabel("Y");
		tecla_y.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_y);
		
		JLabel tecla_u = new JLabel("U");
		tecla_u.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_u);
		
		JLabel tecla_i = new JLabel("I");
		tecla_i.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_i);
		
		JLabel tecla_o = new JLabel("O");
		tecla_o.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_o);
		
		JLabel tecla_p = new JLabel("P");
		tecla_p.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_p);
		
		JLabel tecla_a = new JLabel("A");
		tecla_a.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_a);
		
		JLabel tecla_s = new JLabel("S");
		tecla_s.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_s);
		
		JLabel tecla_d = new JLabel("D");
		tecla_d.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_d);
		
		JLabel tecla_f = new JLabel("F");
		tecla_f.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_f);
		
		JLabel tecla_g = new JLabel("G");
		tecla_g.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_g);
		
		JLabel tecla_h = new JLabel("H");
		tecla_h.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_h);
		
		JLabel tecla_j = new JLabel("J");
		tecla_j.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_j);
		
		JLabel tecla_k = new JLabel("K");
		tecla_k.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_k);
		
		JLabel tecla_l = new JLabel("L");
		tecla_l.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_l);
		
		JLabel tecla_ñ = new JLabel("Ñ");
		tecla_ñ.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_ñ);
		
		JLabel tecla_z = new JLabel("Z");
		tecla_z.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_z);
		
		JLabel tecla_x = new JLabel("X");
		tecla_x.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_x);
		
		JLabel tecla_c = new JLabel("C");
		tecla_c.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_c);
		
		JLabel tecla_v = new JLabel("V");
		tecla_v.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_v);
		
		JLabel tecla_b = new JLabel("B");
		tecla_b.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_b);
		
		JLabel tecla_n = new JLabel("N");
		tecla_n.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_n);
		
		JLabel tecla_m = new JLabel("M");
		tecla_m.setHorizontalAlignment(JLabel.CENTER);
		teclados.add(tecla_m);
		
		JPanel sur = new JPanel();
		sur.setBackground(new Color(240, 255, 255));
		frame.getContentPane().add(sur, BorderLayout.SOUTH);
		sur.setLayout(new BorderLayout(0, 0));
		
		JLabel borrando = new JLabel("BORRANDO");
		sur.add(borrando);
		
		JLabel espacio = new JLabel("ESPACIO");
		sur.add(espacio);
	}

}
