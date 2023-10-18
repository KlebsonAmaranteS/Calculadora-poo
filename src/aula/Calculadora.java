package aula;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    public Calculadora() {

        setTitle("aula.Calculadora");
        setSize(300, 300);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField resultado = new JTextField();
        resultado.setFont(new Font("Arial", Font.PLAIN, 36));
        resultado.setHorizontalAlignment(JTextField.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        add(resultado, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(criarBotao("AC", Color.WHITE, Color.BLACK), gbc);
        gbc.gridx = 1;
        add(criarBotao("+/-", Color.WHITE, Color.BLACK), gbc);
        gbc.gridx = 2;
        add(criarBotao("%", Color.WHITE, Color.BLACK), gbc);
        gbc.gridx = 3;
        add(criarBotao("÷", Color.ORANGE, Color.BLACK), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(criarBotao("7", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 1;
        add(criarBotao("8", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 2;
        add(criarBotao("9", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 3;
        add(criarBotao("x", Color.ORANGE, Color.BLACK), gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(criarBotao("4", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 1;
        add(criarBotao("5", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 2;
        add(criarBotao("6", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 3;
        add(criarBotao("-", Color.ORANGE, Color.BLACK), gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(criarBotao("1", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 1;
        add(criarBotao("2", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 2;
        add(criarBotao("3", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 3;
        add(criarBotao("+", Color.ORANGE, Color.BLACK), gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(criarBotao("0", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(criarBotao(".", Color.BLACK, Color.WHITE), gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(criarBotao("=", Color.yellow, Color.BLACK), gbc);

        setVisible(true);
    }

    public JButton criarBotao(String label, Color corFundo, Color corTexto) {
        JButton button = new JButton(label);
        button.setBackground(corFundo);
        button.setForeground(corTexto);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        return button;
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}


