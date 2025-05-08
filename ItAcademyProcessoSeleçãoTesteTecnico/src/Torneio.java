import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Torneio
{
    int batalhaEscolhida;

    //variavel para controlar quando uma nova fase começa
    boolean chaveamentoFeito = false;

    //setters para poder acessar objetos de outras classes
    private Jogadores jogadores;
    private Administrador administrador;
    public void setJogadores(Jogadores jogadores) {
        this.jogadores = jogadores;
    }
    public void setAdministrador(Administrador administrador)
    {
        this.administrador = administrador;
    }

    //criando a lis de jogadores classificados fora do método para conseguir acessa-lo de outros métodos
    List<Jogadores> jogadoresClassificados = new ArrayList<>();

    //VARIAVEL GLOBAL PARA IDENTIFICAR QUANDO O TORNEIO COMEÇA
    private boolean torneioEmAndamento = false;
    public boolean isTorneioEmAndamento() {
        return torneioEmAndamento;
    }

    public void setTorneioEmAndamento(boolean torneioEmAndamento) {
        this.torneioEmAndamento = torneioEmAndamento;
    }


    public void menuTorneio()
    {
        Scanner entrada = new Scanner(System.in);
        byte escolha;
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Cadastrar jogadores \n" +
                "2 - Administrar batalhas individualemente \n" +
                "3 - lista de jogadores e ponstuações \n"
                +"4 - Sair do programa");
        escolha = entrada.nextByte();

        switch (escolha)
        {
            case 1:
            {
                if (isTorneioEmAndamento())
                {
                    System.out.println("A rodada está em andamento, você não pode cadastrar jogadores após o inicio do torneio!");
                    menuTorneio();
                }
                else
                {
                    jogadores.cadastroParticipantes();
                }
                break;
            }

            case 2:
            {
                if(jogadoresClassificados.size() == 2 && jogadores.jogadoresEliminados.size() == jogadores.listaJogadores.size() - 2)
                {
                    administrador.finalTorneio();
                }

                else if (jogadores.jogadoresEliminados.size() == jogadores.duelos.size()/2)
                {
                    //CHAMO O METODO PARA CIRAR  CHAVEAMENTO DA PROXIMA FASE QUANDO ACABAR A FASE ATUAL
                    if(!chaveamentoFeito)
                    {
                        criaChaveamentoProximaFase();
                    }

                    System.out.println("escolha uma partida para administrar: ");
                    imprimeDuelos();
                    batalhaEscolhida = entrada.nextInt();
                    administrador.administrarBatalha(batalhaEscolhida - 1);
                }
                else
                {
                    //CHAMO O METODO PARA CIRAR  CHAVEAMENTO DA PROXIMA FASE QUANDO ACABAR A FASE ATUAL
                    if(!chaveamentoFeito)
                    {
                        criaChaveamento();
                    }

                    System.out.println("escolha uma partida para administrar: ");
                    imprimeDuelos();
                    batalhaEscolhida = entrada.nextInt();
                    setTorneioEmAndamento(true);//para marcar o inicio do torneio
                    administrador.administrarBatalha(batalhaEscolhida - 1);
                }
                break;

            }

            case 3:
            {
                imprimeTabela();
                System.out.println("\n");
                menuTorneio();
                break;
            }

            case 4:
            {
                break;
            }

            default:
            {
                System.out.println("Opção invalida!");
                menuTorneio();
            }


        }
    }


    // METODO PARA EVITAR QUE JOGADOR E CHAVEAMENTOS SEJAM FEITOS DURANTE A RODADA
    public boolean podeCadastrarNovosJogadores(boolean estado)
    {
        return !estado;
    }




    public void criaChaveamento()
    {
        int aleatorio;
        Random random = new Random();

        jogadoresClassificados.addAll(jogadores.listaJogadores);
        jogadores.duelos.clear();


        while (!jogadoresClassificados.isEmpty())
        {
            aleatorio = random.nextInt(jogadoresClassificados.size());
            jogadores.duelos.add(jogadoresClassificados.get(aleatorio));
            jogadoresClassificados.remove(aleatorio);
        }
        chaveamentoFeito = true;

    }

    public void criaChaveamentoProximaFase()
    {
        int aleatorio;
        Random random = new Random();
        jogadores.duelos.clear();

        //zerando os pontos da partida ao iniciar nova fase
        for (Jogadores jogadoresClassificado : jogadoresClassificados)
        {
            jogadoresClassificado.pontosPartida = 0;
        }

        while (!jogadoresClassificados.isEmpty())
        {
            aleatorio = random.nextInt(jogadoresClassificados.size());
            jogadores.duelos.add(jogadoresClassificados.get(aleatorio));
            jogadoresClassificados.remove(aleatorio);
        }

        chaveamentoFeito = true;

    }


    public void imprimeDuelos()
    {

        int j = 1, d = 1;
        System.out.println("lista de duelos: ");
        for (int i = 0; i < jogadores.duelos.size(); i++ )
        {
            System.out.println("Duelo "+ d + " - " + jogadores.duelos.get(i).nome + " X " + jogadores.duelos.get(j).nome);
            j = j + 2;
            i++;
            d++;
        }
    }


    public void imprimeTabela()
    {
        System.out.println("*****LISTA DE JOGADORES*****");
        for (int i = 0; i < jogadores.listaJogadores.size(); i++)
        {
            System.out.println("Nome: " +jogadores.listaJogadores.get(i).nome);
            System.out.println("Nickname: "+ jogadores.listaJogadores.get(i).nickname );
            System.out.println("Pontos: "+ jogadores.listaJogadores.get(i).pontos);
            System.out.println("");
        }
    }


    public String imprimeNomes()
    {
        for (int i = 0; i < jogadores.listaJogadores.size(); i++)
        {
            System.out.println("Jogador: " +jogadores.listaJogadores.get(i).nome);
        }

        return "";
    }

    public int blitzMatch(int j1, int j2)
    {
        Random random = new Random();
        int aleatorio = random.nextInt(j1,j2);

        return aleatorio;
    }

    public void imprimeVencedor(String jogador)
    {
        System.out.println("O jogador: " + jogador + " é o vencedor do torneio!!!!");
        imprimeEstatisticas();
    }

    public void imprimeEstatisticas()
    {
        System.out.println("Nosso torneio chegou ao fim! Porém, não pode acabar assim,então aqui estão algumas estatíscas: ");
        System.out.println("Os jogadores aparecerão em ordem decrescente de acordo com a pontuação final");
        for(int i = jogadores.jogadoresEliminados.size() ; i > 0; i--)
        {
            System.out.println("**************************************************************");
            System.out.println("Nome do jogador: " + jogadores.jogadoresEliminados.get(i).nome);
            System.out.println("Nickname do jogador: " +jogadores.jogadoresEliminados.get(i).nickname);
            System.out.println("Pontos do jogador: " +jogadores.jogadoresEliminados.get(i).pontos);
            System.out.println("Jogadas originais de "+ jogadores.jogadoresEliminados.get(i).nickname + ": "+ jogadores.jogadoresEliminados.get(i).jogadaOriginal);
            System.out.println("Gafes de "+ jogadores.jogadoresEliminados.get(i).nickname + ": "+jogadores.jogadoresEliminados.get(i).gafe);
            System.out.println("Posicionamentos vantajosos de "+ jogadores.jogadoresEliminados.get(i).nickname + ": "+jogadores.jogadoresEliminados.get(i).posicionamentoVantajoso);
            System.out.println("Desrespeitos aos adversários de "+ jogadores.jogadoresEliminados.get(i).nickname + ": "+jogadores.jogadoresEliminados.get(i).trashTalk);
            System.out.println("Ataques de fúria de "+ jogadores.jogadoresEliminados.get(i).nickname + ": "+jogadores.jogadoresEliminados.get(i).ataqueDeFuria);
            System.out.println("**************************************************************");
            System.out.println("");
        }

        int i = 0;
        System.out.println("Por fim, os dados do grande vencedor!!!!");
        System.out.println("**************************************************************");
        System.out.println("Nome do jogador: " + jogadoresClassificados.get(i).nome);
        System.out.println("Nickname do jogador: " +jogadoresClassificados.get(i).nickname);
        System.out.println("Pontos do jogador: " +jogadoresClassificados.get(i).pontos);
        System.out.println("Jogadas originais de "+ jogadoresClassificados.get(i).nickname + ": "+ jogadoresClassificados.get(i).jogadaOriginal);
        System.out.println("Gafes de "+ jogadoresClassificados.get(i).nickname + ": "+jogadoresClassificados.get(i).gafe);
        System.out.println("Posicionamentos vantajosos de "+ jogadoresClassificados.get(i).nickname + ": "+jogadoresClassificados.get(i).posicionamentoVantajoso);
        System.out.println("Desrespeitos aos adversários de "+ jogadoresClassificados.get(i).nickname + ": "+jogadoresClassificados.get(i).trashTalk);
        System.out.println("Ataques de fúria de "+ jogadoresClassificados.get(i).nickname + ": "+jogadoresClassificados.get(i).ataqueDeFuria);
        System.out.println("**************************************************************");

        imprimePremios();

    }


    //imprime os as categorias dos jogadores, tendo como desempate caso haja a dois com a mesma quantiadade, o com mais pontos ganha
    public void imprimePremios()
    {
        jogadores.listaJogadores.addAll(jogadores.jogadoresEliminados);
        jogadores.listaJogadores.addAll(jogadoresClassificados);
        System.out.println("");
        System.out.println("****** TORNEIO AWARDS ******");
        getTiltadinho();
        System.out.println("");
        getPinadaGafe();
        System.out.println("");
        getTrashTalk();
        System.out.println("");
        saiDoFakeMagnusCarlsen();

    }

    public void getTrashTalk()
    {
        int trashtalk = 0;
        String trashtalNome = null;
        for (int i = 0; i < jogadores.listaJogadores.size(); i++)
        {
            if(jogadores.listaJogadores.get(i).trashTalk > trashtalk)
            {
                trashtalk = jogadores.listaJogadores.get(i).trashTalk;
                trashtalNome = jogadores.listaJogadores.get(i).nome;
            }
            else
            {
                continue;
            }
        }
        System.out.println(trashtalNome + " ganhou o prêmio 'rei do trash talk' por ser o jogador com mais desrespeitos ao adversário!");
        System.out.println("Foram: " +trashtalk +" no total!");
    }

    public void getPinadaGafe()
    {
        int pinadas = 0;
        String pinadasNome = null;
        for (int i = 0; i < jogadores.listaJogadores.size(); i++)
        {
            if(jogadores.listaJogadores.get(i).gafe > pinadas)
            {
                pinadas = jogadores.listaJogadores.get(i).gafe;
                pinadasNome = jogadores.listaJogadores.get(i).nome;
            }
            else
            {
                continue;
            }
        }
        System.out.println(pinadasNome + " ganhou o prêmio 'pinou no xadrez' por ser o jogador com mais gafes!");
        System.out.println("Foram: " +pinadas +" no total!");
    }

    public  void getTiltadinho()
    {
        int tiltadinho = 0;
        String tiltadinhoNome = null;
        for (int i = 0; i < jogadores.listaJogadores.size(); i++)
        {
            if(jogadores.listaJogadores.get(i).ataqueDeFuria > tiltadinho)
            {
                tiltadinho = jogadores.listaJogadores.get(i).ataqueDeFuria;
                tiltadinhoNome = jogadores.listaJogadores.get(i).nome;
            }
            else
            {
                continue;
            }
        }
        System.out.println(tiltadinhoNome + " ganhou o prêmio 'tiltadinho' por ser o jogador com mais ataques de furia!");
        System.out.println("Foram: " +tiltadinho +" no total!");

    }

    public void saiDoFakeMagnusCarlsen()
    {
        int magnusCarlsen = 0;
        String magnusCarlsenNome = null;
        for (int i = 0; i < jogadores.listaJogadores.size(); i++)
        {
            if(jogadores.listaJogadores.get(i).jogadaOriginal > magnusCarlsen)
            {
                magnusCarlsen = jogadores.listaJogadores.get(i).jogadaOriginal;
                magnusCarlsenNome = jogadores.listaJogadores.get(i).nome;
            }
            else
            {
                continue;
            }
        }
        System.out.println(magnusCarlsenNome + " ganhou o prêmio 'sai do fake Magnus Carlsen' por ser o jogador com mais jogadas originais!");
        System.out.println("Foram: " +magnusCarlsen +" no total!");
    }




}


