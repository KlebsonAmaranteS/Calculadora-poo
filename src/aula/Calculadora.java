import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    JTextField resultado = new JTextField();
    double numero1 = 0;
    double numero2 = 0;
    String operacao = "";

    public Calculadora() {

        setTitle("Calculadora");
        setSize(300, 300);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        resultado.setFont(new Font("Arial", Font.PLAIN, 36));
        resultado.setHorizontalAlignment(JTextField.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        add(resultado, gbc);
        JButton botaoAC = criarBotao("AC", Color.WHITE, Color.BLACK);
        botaoAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
                operacao = "";
                numero1 = 0.0;
                numero2 = 0.0;
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(botaoAC, gbc);

        JButton botaoInverterSinal = criarBotao("+/-", Color.WHITE, Color.BLACK);
        botaoInverterSinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!resultado.getText().isEmpty()) {
                    double numero = Double.parseDouble(resultado.getText());
                    numero = -numero;
                    resultado.setText(String.valueOf(numero));
                }
            }
        });
        gbc.gridx = 1;
        add(botaoInverterSinal, gbc);

        JButton botaoPorcentagem = criarBotao("%", Color.WHITE, Color.BLACK);
        botaoPorcentagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!resultado.getText().isEmpty()) {
                    double numero = Double.parseDouble(resultado.getText());
                    double resultadoPorcentagem = numero / 100;
                    resultado.setText(String.valueOf(resultadoPorcentagem));
                }
            }
        });
        gbc.gridx = 2;
        add(botaoPorcentagem, gbc);

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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String botaoTexto = ((JButton) e.getSource()).getText();
                if (botaoTexto.matches("[0-9]")) {
                    resultado.setText(resultado.getText() + botaoTexto);
                } else if (botaoTexto.equals(".")) {
                    if (!resultado.getText().contains(".")) {
                        resultado.setText(resultado.getText() + ".");
                    }
                } else if (botaoTexto.matches("[+\\-x÷]")) {
                    numero1 = Double.parseDouble(resultado.getText());
                    operacao = botaoTexto;
                    resultado.setText("");
                } else if (botaoTexto.equals("=")) {
                    if (!operacao.isEmpty()) {
                        numero2 = Double.parseDouble(resultado.getText());
                        double resultadoOperacao = realizarOperacao(numero1, numero2, operacao);
                        resultado.setText(String.valueOf(resultadoOperacao));
                        operacao = "";
                    }
                }
            }
        });


        return button;
    }

    public double realizarOperacao(double num1, double num2, String operacao) {
        switch (operacao) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            case "÷":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN;
                }
            default:
                return num2;
        }
    }


    public static void main(String[] args) {
        new Calculadora();
    }
}


