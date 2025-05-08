import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogadores
{
     String nome, nickname;
     int pontos , jogadaOriginal = 0, gafe = 0, posicionamentoVantajoso = 0, trashTalk = 0, ataqueDeFuria = 0, pontosPartida = 0;

     List<Jogadores> listaJogadores = new ArrayList<>();
     List<Jogadores> duelos = new ArrayList<>();
     List<Jogadores> jogadoresEliminados = new ArrayList<>();

    //setters e construtores para poder acessar objetos de outras classes
    private Torneio torneio;
    public void setTorneio(Torneio torneio)
    {
        this.torneio = torneio;
    }


    public Jogadores()
    {
        this.nome = null;
        this.nickname = null;
        this.pontos = 0;
    }

    public Jogadores(String nome, String nickname, int pontos)
    {
        this.nome = nome;
        this.nickname = nickname;
        this.pontos = pontos;


    }


    public void cadastroParticipantes()
    {
        if (listaJogadores.size() == 8)
        {
            System.out.println("O máximo de jogares ja foram cadstrados!");
            torneio.menuTorneio();
        } else {

            String continuar;
            do {
                Scanner entrada = new Scanner(System.in);

                System.out.println("escreva o nome do jogador: ");
                nome = entrada.nextLine();
                System.out.println("escreva o nickname do jogador: ");
                nickname = entrada.nextLine();
                pontos = 70;

                Jogadores jogador = new Jogadores(nome, nickname, pontos);
                listaJogadores.add(new Jogadores(nome, nickname, pontos));


                System.out.println(listaJogadores.size() + " jogadores cadastrados até o momento!");
                System.out.println("Deseja cadastrar mais jogadores? (sim ou não)");
                continuar = entrada.next();

                if(listaJogadores.size() == 8)
                {
                    continuar = "sim";
                    System.out.println("O máximo de jogares ja foram cadstrados!");
                }


            } while (continuar.equals("sim") && listaJogadores.size() < 8);

            validaParticipantes();
            torneio.menuTorneio();
        }
    }



    public void validaParticipantes()
    {
       if(listaJogadores.size() != 8 && listaJogadores.size() != 4)
       {
           System.out.println("Número de participantes invalido!");
           System.out.println("O número de participantes devará ser 4 ou 8!");
           cadastroParticipantes();
       }
       else
       {
         System.out.println("Os seguintes participantes foram cadastrados: ");
         torneio.imprimeNomes();
         boolean estado = false;
         torneio.criaChaveamento();

       }

    }


}
