import java.util.Scanner;

public class Administrador
{

    private Jogadores jogadores;
    public void setJogadores(Jogadores jogadores)
    {
        this.jogadores = jogadores;
    }
    private Torneio torneio;

    public void setTorneio(Torneio torneio)
    {
        this.torneio = torneio;
    }



    //MÉTODO QUE PERMITE ADMINISTRAR DUELOS INDIVIDUALMENTE
    public void administrarBatalha(int batalhaEscolhida)
    {

        int j1;
        int j2;
        switch (batalhaEscolhida)
        {
            case 0:
            {
                 j1 = 0;
                 j2 = 1;
                 if(jogadores.duelos.get(j1).pontosPartida >= 30 || jogadores.duelos.get(j2).pontosPartida >= 30)
                 {
                     System.out.println("Esse duelo ja acabou! Escolha outro!");
                     torneio.menuTorneio();
                     break;
                 }
                 else {
                     do
                     {

                         System.out.println("Administrando o duelo 1!");
                         imprimirDados(j1, j2);
                         escolherEvento(j1, j2);
                     } while (jogadores.duelos.get(j1).pontosPartida < 30 && jogadores.duelos.get(j2).pontosPartida < 30);
                     validaVencedorPartida(j1, j2);
                     break;
                 }
            }
            case 1:
            {
                j1 = 2;
                j2 = 3;
                if(jogadores.duelos.get(j1).pontosPartida >= 30 || jogadores.duelos.get(j2).pontosPartida >= 30)
                {
                    System.out.println("Esse duelo ja acabou! Escolha outro!");
                    torneio.menuTorneio();
                    break;
                }
                else {
                    do
                    {

                        System.out.println("Administrando o duelo 2!");
                        System.out.println("\n");
                        imprimirDados(j1, j2);
                        escolherEvento(j1, j2);
                    } while (jogadores.duelos.get(j1).pontosPartida < 30 && jogadores.duelos.get(j2).pontosPartida < 30);
                    validaVencedorPartida(j1, j2);
                    break;
                }
            }
            case 2:
                j1 = 4;
                j2 = 5;
                if(jogadores.duelos.get(j1).pontosPartida >= 30 || jogadores.duelos.get(j2).pontosPartida >= 30)
                {
                    System.out.println("Esse duelo ja acabou! Escolha outro!");
                    torneio.menuTorneio();
                    break;
                }
                else {
                    {
                        do
                        {

                            System.out.println("Administrando o duelo 3!");
                            imprimirDados(j1, j2);
                            escolherEvento(j1, j2);
                        } while (jogadores.duelos.get(j1).pontosPartida < 30 && jogadores.duelos.get(j2).pontosPartida < 30);
                        validaVencedorPartida(j1, j2);
                        break;
                    }
            }
            case 3:
            {
                j1 = 6;
                j2 = 7;
                if(jogadores.duelos.get(j1).pontosPartida >= 30 || jogadores.duelos.get(j2).pontosPartida >= 30)
                {
                    System.out.println("Esse duelo ja acabou! Escolha outro!");
                    torneio.menuTorneio();
                    break;
                }
                else {
                do
                {

                    System.out.println("Administrando o duelo 4!");
                    imprimirDados(j1, j2);
                    escolherEvento(j1, j2);
                } while (jogadores.duelos.get(j1).pontosPartida < 30 && jogadores.duelos.get(j2).pontosPartida < 30);
                validaVencedorPartida(j1,j2);
                break;
                }
            }
        }

    }

    public void finalTorneio()
    {
        int j1 = 0, j2 = 1;
        jogadores.duelos.get(0).pontosPartida = 0;
        jogadores.duelos.get(1).pontosPartida = 0;
        do
        {
            System.out.println("Administrando o duelo final do torneio!");
            imprimirDados(j1, j2);
            escolherEvento(j1, j2);
        }while (jogadores.duelos.get(j1).pontosPartida < 30 && jogadores.duelos.get(j2).pontosPartida < 30);
        validaVencedorTorneio(j1,j2);
    }


    //MÉTODO QUE IMPRIME DADOS DOS JOGADORES EM DUELO
    public void imprimirDados(int j1, int j2)
    {
        int jogador1 = j1, jogador2 = j2;

        System.out.println("jogador "+(jogador1 + 1)+": ");

        System.out.println("Nome: " +jogadores.duelos.get(j1).nome);
        System.out.println("Nickname: "+ jogadores.duelos.get(j1).nickname );
        System.out.println("Pontos no campeonato: "+ jogadores.duelos.get(j1).pontos);
        System.out.println("Pontos na partida: "+ jogadores.duelos.get(j1).pontosPartida);

        System.out.println("");
        System.out.println("Jogador "+(jogador2 + 1)+ ":");

        System.out.println("Nome: " +jogadores.duelos.get(j2).nome);
        System.out.println("Nickname: "+ jogadores.duelos.get(j2).nickname );
        System.out.println("Pontos: "+ jogadores.duelos.get(j2).pontos);
        System.out.println("Pontos na partida: "+ jogadores.duelos.get(j2).pontosPartida);
        System.out.println("\n");
    }


    public void escolherEvento(int j1, int j2)
    {
        Scanner entrada = new Scanner(System.in);
        int evento;

        System.out.println("Escolha uma evento: \n" +
                "1- Jogada original (+5 pontos)\n" +
                "2- Gafe (-3 pontos)\n" +
                "3- Posionamento vantajoso (+2 pontos)\n" +
                "4- Desrespeito ao adversário (-5 pontos)\n" +
                "5- Ataque de fúria (-7 pontos)");
        evento = entrada.nextInt();

        System.out.println("Escolha o jogador que você quer atribuir este evento: ");
        System.out.println("Jogador "+ (j1+1) +" - (" + jogadores.duelos.get(j1).nickname + ")");
        System.out.println("Jogador "+ (j2+1) +" - (" + jogadores.duelos.get(j2).nickname + ")");
        int jogador = entrada.nextInt() - 1;

        if(jogador != j1 && jogador != j2)
        {
            System.out.println("Esse jogador não está no duelo, tente novamente!");
            escolherEvento(j1, j2);
        }
        else {
            System.out.println("\n");

            switch (evento) {
                case 1: {
                    jogadaOriginal(jogador);
                    break;
                }

                case 2: {
                    gafe(jogador);
                    break;
                }

                case 3: {
                    posicionamentoVantajoso(jogador);
                    break;
                }

                case 4: {
                    desrespeitoAdversario(jogador);
                    break;
                }

                case 5: {
                    ataqueDeFuria(jogador);
                    break;
                }

                default:
                    System.out.println("Opção invalida! tente novamente!");
            }
        }


    }


    //MÉTODOS PARA ESPECIFICAR O QUE CADA EVENTO DEVE FAZER
    //também marca a quantidade de cada evento por jogador para adicionar nas estatísticas
    public void ataqueDeFuria(int jogador)
    {
        jogadores.duelos.get(jogador).pontosPartida -= 7;
        jogadores.duelos.get(jogador).ataqueDeFuria += 1;
        System.out.println("");

        System.out.println("O jogador " + jogadores.duelos.get(jogador).nickname + " foi penalizado com 7 pontos a menos por um ataque de fúria!");
    }

    public void desrespeitoAdversario(int jogador)
    {
        jogadores.duelos.get(jogador).pontosPartida -= 5;
        jogadores.duelos.get(jogador).trashTalk += 1;
        System.out.println("");

        System.out.println("O jogogador " + jogadores.duelos.get(jogador).nickname + " foi penalizado com 5 pontos a menos por desrespeitar o adversário!");
    }

    public void posicionamentoVantajoso(int jogador)
    {
        jogadores.duelos.get(jogador).pontosPartida += 2;
        jogadores.duelos.get(jogador).posicionamentoVantajoso += 1;
        System.out.println("");

        System.out.println("O jogador "+ jogadores.duelos.get(jogador).nickname + " recebeu 2 pontos por realizar um posicionamento vantajoso perante o adversário!");
    }

    public void gafe(int jogador)
    {
        jogadores.duelos.get(jogador).pontosPartida -= 3;
        jogadores.duelos.get(jogador).gafe += 1;
        System.out.println("");

        System.out.println("O jogador " + jogadores.duelos.get(jogador).nickname + " foi penalizado com 3 pontos a menos por cometer uma gafe!");
    }

    public void jogadaOriginal(int jogador)
    {
        jogadores.duelos.get(jogador).pontosPartida += 5;
        jogadores.duelos.get(jogador).jogadaOriginal += 1;
        System.out.println("");

        System.out.println("O jogador " + jogadores.duelos.get(jogador).nickname + " recebeu 5 pontos por realizar uma jogada original!");
    }




    //MÉTODO PAARA VALIDAR O VENCEDOR DA PARTIDA
    public void validaVencedorPartida(int j1, int j2)
    {
        //O PROGRAMA IDENTIFICA SE HOUVE EMPATE E REALIZA O BLITZMATCH (SORTEIO)
        if (jogadores.duelos.get(j1).pontosPartida == jogadores.duelos.get(j2).pontosPartida && jogadores.duelos.get(j2).pontosPartida >= 30 && jogadores.duelos.get(j1).pontosPartida >= 30 )
        {
            int sorteado = torneio.blitzMatch(j1, j2);
            jogadores.duelos.get(sorteado).pontosPartida += 2;
            System.out.println("");
            System.out.println("Devido a um empate, o blitzmatch foi realizado e o jogador sorteado foi: " +jogadores.duelos.get(sorteado).nickname);
            validaVencedorPartida(j1, j2);

        }
        else if (jogadores.duelos.get(j1).pontosPartida >= 30)
        {
            //anuncio o vencedor e avanço ele diretamente para a próxima fase
            jogadores.duelos.get(j1).pontos += jogadores.duelos.get(j1).pontosPartida;
            jogadores.duelos.get(j2).pontos += jogadores.duelos.get(j2).pontosPartida;
            System.out.println("O jogador " +(j1+1) +" é o vencedor da partida e avançou para a próxima fase!");
            imprimirDados(j1, j2);
            torneio.jogadoresClassificados.add(jogadores.duelos.get(j1));

            //aqui elimina o jogador, e evita que ele entre na lista de classificados e vá para o chaveamento novamente,
            // ao mesmo tempo armaezena os dados dele em outra lista
            jogadores.jogadoresEliminados.add(jogadores.duelos.get(j2));
            System.out.println("");
            if(torneio.jogadoresClassificados.size() == jogadores.duelos.size()/2)
            {
                torneio.chaveamentoFeito = false;
            }
            torneio.menuTorneio();

        }

        else if(jogadores.duelos.get(j2).pontosPartida >= 30)
        {
            //anuncio o vencedor e avanço ele diretamente para a próxima fase
            jogadores.duelos.get(j2).pontos += jogadores.duelos.get(j2).pontosPartida;
            jogadores.duelos.get(j1).pontos += jogadores.duelos.get(j1).pontosPartida;
            System.out.println("O jogador " +(j2+1) +" é o vencedor da partida e avançou para a próxima fase!");
            System.out.println("");
            imprimirDados(j1, j2);
            torneio.jogadoresClassificados.add(jogadores.duelos.get(j2));


            //aqui elimina o jogador, e evita que ele entre na lista de classificados e vá para o chaveamento novamente,
            // ao mesmo tempo armaezena os dados dele em outra lista
            jogadores.jogadoresEliminados.add(jogadores.duelos.get(j1));
            System.out.println("");

            if(torneio.jogadoresClassificados.size() == jogadores.duelos.size()/2)
            {
                torneio.chaveamentoFeito = false;
            }
            torneio.menuTorneio();

        }


    }

    public void validaVencedorTorneio(int j1, int j2)
    {
        //O PROGRAMA IDENTIFICA SE HOUVE EMPATE E REALIZA O BLITZMATCH (SORTEIO)
        if (jogadores.duelos.get(j1).pontosPartida == jogadores.duelos.get(j2).pontosPartida && jogadores.duelos.get(j2).pontosPartida >= 30 && jogadores.duelos.get(j1).pontosPartida >= 30 )
        {
            int sorteado = torneio.blitzMatch(j1, j2);
            jogadores.duelos.get(sorteado).pontosPartida += 2;
            System.out.println("");
            System.out.println("Devido a um empate, o blitzmatch foi realizado e o jogador sorteado foi: " +jogadores.duelos.get(sorteado).nickname);
            validaVencedorTorneio(j1, j2);
        }

        else if (jogadores.duelos.get(j1).pontosPartida >= 30)
        {
            String vencedor = jogadores.duelos.get(j1).nickname;

            //anuncio o vencedor e avanço ele para o método que anuncia o vencedor
            jogadores.duelos.get(j1).pontos += jogadores.duelos.get(j1).pontosPartida;
            jogadores.duelos.get(j2).pontos += jogadores.duelos.get(j2).pontosPartida;
            System.out.println("O jogador " + (j1 + 1) + " é o vencedor da partida e avançou para a próxima fase!");
            imprimirDados(j1, j2);
            torneio.jogadoresClassificados.add(jogadores.duelos.get(j1));

            //aqui elimina o jogador, e ao mesmo tempo armaezena os dados dele em outra lista
            jogadores.jogadoresEliminados.add(jogadores.duelos.get(j2));
            System.out.println("");
            torneio.imprimeVencedor(vencedor);
        }

        else if(jogadores.duelos.get(j2).pontosPartida >= 30)
        {
            String vencedor = jogadores.duelos.get(j2).nickname;
            //anuncio o vencedor e avanço ele para o método que anuncia o vencedor
            jogadores.duelos.get(j2).pontos += jogadores.duelos.get(j2).pontosPartida;
            jogadores.duelos.get(j1).pontos += jogadores.duelos.get(j1).pontosPartida;

            System.out.println("O jogador " +(j2+1) +" é o vencedor da partida e avançou para a próxima fase!");
            System.out.println("");
            imprimirDados(j1, j2);
            torneio.jogadoresClassificados.add(jogadores.duelos.get(j2));

            //aqui elimina o jogador, e ao mesmo tempo armaezena os dados dele em outra lista
            jogadores.jogadoresEliminados.add(jogadores.duelos.get(j1));
            System.out.println("");
            torneio.imprimeVencedor(vencedor);

        }

    }





}
