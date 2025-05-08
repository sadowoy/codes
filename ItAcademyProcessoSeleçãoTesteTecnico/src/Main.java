import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        //INSTANCIAÇÃO DOS OBJETOS PARA TER ACESSO A ELES EM TODO O CÓDIGO
        Jogadores jogadores = new Jogadores();
        Torneio torneio = new Torneio();
        Administrador administrador = new Administrador();
        jogadores.setTorneio(torneio);
        torneio.setJogadores(jogadores);
        administrador.setJogadores(jogadores);
        administrador.setTorneio(torneio);
        torneio.setAdministrador(administrador);

        torneio.menuTorneio();





    }




}

