//"Dadas as temperaturas que foram registradas, diariamente, durante uma semana,
// deseja-se determinar em quantos dias desta semana a temperatura esteve acima da média.
// A solução para este problema envolve os seguintes passos:

       // a) Obter os valores das temperaturas.
       // b) Calcular a média desses valores.
       // c) Verificar quantos deles são maiores que a média."



import javax.swing.*;
import java.util.Scanner;
public class ExDoisPagNoveOito {


    public static void main(String[] args)
    {
       float []temperaturas;
       float soma = 0;
       temperaturas = new float[7];

       for (int cont = 0; cont < temperaturas.length; cont++ )
       {
           String entrada;

           switch (cont) {
               case 0:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de domingo: ");
                   temperaturas[0] = Float.parseFloat(entrada);
                   break;

               case 1:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de segunda: ");
                   temperaturas[1] = Float.parseFloat(entrada);
                   break;

               case 2:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de terça: ");
                   temperaturas[2] = Float.parseFloat(entrada);
                   break;

               case 3:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de quarta: ");
                   temperaturas[3] = Float.parseFloat(entrada);
                   break;

               case 4:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de quinta: ");
                   temperaturas[4] = Float.parseFloat(entrada);
                   break;

               case 5:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de sexta: ");
                   temperaturas[5] = Float.parseFloat(entrada);
                   break;

               case 6:
                   entrada = JOptionPane.showInputDialog("Digite a temperatura de sábado: ");
                   temperaturas[6] = Float.parseFloat(entrada);
                   break;
           }
       }

       for (int contt = 0; contt < temperaturas.length; contt++)
       {
           soma = soma + temperaturas[contt];
       }

       float media = soma / temperaturas.length;
       int quantidade = 0;

       for (int cont = 0; cont < temperaturas.length; cont++)
       {
           if (temperaturas[cont] > media)
           {
               cont++;
               quantidade++;
           }
           else
           {
               cont++;
           }
       }

       JOptionPane.showMessageDialog(null, "A média de temperatura é: " + media + "\n " +
               "E a temperatura foi maior que a média " + quantidade + " vezes.");

















        }
    }
