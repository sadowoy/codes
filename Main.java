package Dados;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        int entrada = 0;

        do {


            int opcao;
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a sua opção: \n" +
                    "1 - adição\n" +
                    "2 - subtração\n" +
                    "3 - multipicação\n" +
                    "4 - divisão\n" +
                    "5 - sair"));

            switch (opcao) {
                case 1:
                    modAdicao();
                    break;

                case 2:
                    modSubtracao();
                    break;

                case 3:
                    modMultiplicacao();
                    break;

                case 4:
                    modDivisao();
                    break;

                case 5:
                    entrada = 1;
                    break;
            }

        }

        while (entrada == 0);
    }

    static void modAdicao()
    {
        double v1;
        double v2;
        double res;

        v1 = Double.parseDouble(JOptionPane.showInputDialog("digite o primeiro valor"));
        v2 = Double.parseDouble(JOptionPane.showInputDialog("digite o segundo valor"));

        res = v1 + v2;
        JOptionPane.showMessageDialog( null, "soma = " + res);

    }

    static void modMultiplicacao()
    {
        double v1;
        double v2;
        double res;

        v1 = Double.parseDouble(JOptionPane.showInputDialog("digite o primeiro valor"));
        v2 = Double.parseDouble(JOptionPane.showInputDialog("digite o segundo valor"));

        res = v1 * v2;
        JOptionPane.showMessageDialog( null, "multiplicação = " + res);

    }

    static void modSubtracao()
    {
        double v1;
        double v2;
        double res;

        v1 = Double.parseDouble(JOptionPane.showInputDialog("digite o primeiro valor"));
        v2 = Double.parseDouble(JOptionPane.showInputDialog("digite o segundo valor"));

        res = v1 - v2;
        JOptionPane.showMessageDialog( null, "subtração = " + res);
    }

    static void modDivisao()
    {
        double v1;
        double v2;
        double res;

        v1 = Double.parseDouble(JOptionPane.showInputDialog("digite o primeiro valor"));
        v2 = Double.parseDouble(JOptionPane.showInputDialog("digite o segundo valor"));

        res = v1 / v2;
        JOptionPane.showMessageDialog( null, "divisão = " + res);

    }

}
