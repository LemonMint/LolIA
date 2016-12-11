/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.calculo;

import java.util.List;
import java.util.Objects;
import conexao.Conexao;
import teste.modelo.FellowPlayer;
import teste.modelo.Game;
import teste.modelo.PlayerGames;

/**
 *
 * @author Lemon
 */
public class Calculos {

    private PlayerGames games;
    public double wardPlaced;
    public double crowdControlDealt;
    public double wardLossPlaced;
    public double wardWinPlaced;
    public double contadorVitorias10, contadorVitorias9, contadorDerrotas10, contadorDerrotas9;
    public double totalPartidas;
    public double porcentagemVitoria, vitoria10, vitoria9;
    public double porcentagemDerrota, derrota10, derrota9;
    public double wardMaior, wardMenor;
    public double posterioreMaiorVitoria, posterioreMaiorDerrota;
    public double posterioreMenorVitoria, posterioreMenorDerrota;

    private double porcentagemVitorias(List<Game> listaGames, List<FellowPlayer> jogador) {
        double vitorias = 0.;
        double totalWards = 0.;
        double totalCrowdControl = 0.;
        double total = 0.;
        double total2 = 0;
        double contadorVitoriaWard = 0, contadorDerrotaWard = 0;
        double wardVitoriaPlaced = 0, wardDerrotaPlaced = 0;
        double contadorVitoria10 = 0, contadorVitoria9 = 0;
        double contadorDerrota10 = 0, contadorDerrota9 = 0;
        for (Game atual : listaGames) {
            if (atual.getSubType().matches("(RANKED_SOLO_5x5)|(NORMAL)|(RANKED_FLEX_SR)")) {
                if (atual.getStats().getWardPlaced() != null) {
                    total++;
                    System.out.println("wardplaced: " + atual.getStats().getWardPlaced());
                    vitorias += atual.getStats().getWin() ? 1 : 0;

                    if (atual.getStats().getWin()) {
                        contadorVitoriaWard++;
                        wardVitoriaPlaced += atual.getStats().getWardPlaced();
                        if (atual.getStats().getWardPlaced() >= 10) {
                            contadorVitoria10++;
                        } else {
                            contadorVitoria9++;
                        }
                    } else {
                        contadorDerrotaWard++;
                        wardDerrotaPlaced += atual.getStats().getWardPlaced();
                        if (atual.getStats().getWardPlaced() >= 10) {
                            contadorDerrota10++;
                        } else {
                            contadorDerrota9++;
                        }
                    }
                    totalWards += atual.getStats().getWardPlaced();
                    if (atual.getStats().getTotalTimeCrowdControlDealt() != null) {

                        total2++;
                        totalCrowdControl += atual.getStats().getTotalTimeCrowdControlDealt();
                    }
                }
            }
        }
        contadorVitorias10 += contadorVitoria10;
        contadorVitorias9 += contadorVitoria9;
        contadorDerrotas10 += contadorDerrota10;
        contadorDerrotas9 += contadorDerrota9;
        crowdControlDealt += (totalCrowdControl / total);
        wardPlaced += (totalWards / total);
        wardWinPlaced += (wardVitoriaPlaced / contadorVitoriaWard);
        wardLossPlaced += (wardDerrotaPlaced / contadorDerrotaWard);
        System.out.println("----------------------Media de JOGOS------------------------");
        System.out.println("VITORIA 10 : " + contadorVitoria10);
        System.out.println("VITORIA 9 : " + contadorVitoria9);
        System.out.println("DERROTA 10 : " + contadorDerrota10);
        System.out.println("DERROTA 9 : " + contadorDerrota9);
        System.out.println("WARD WIN           : " + wardVitoriaPlaced / contadorVitoriaWard);
        System.out.println("WARD LOSS          : " + wardDerrotaPlaced / contadorDerrotaWard);
        System.out.println("WARDS TOTAL        : " + totalWards / total);
        System.out.println("CONTROL            : " + totalCrowdControl / total);
        System.out.println("numero de vitorias : " + vitorias / total);
        return vitorias / total;
    }

    public Calculos(PlayerGames games) {
        this.games = games;
    }

    public Double calcularProbabilidade() {
        List<Game> listGames = games.getGames();
        Conexao get2 = new Conexao();
        double porcentagemGames = 0.;
        double porcentagemTotal = 0.;
        double porcentagemWards = 0;
        double porcentagemTotalWards = 0;
        double porcentagemCrowdControl = 0;
        double porcentagemTotalCrowdControl = 0;
        double porcentagemWardVitoria = 0, porcentagemWardDerrota = 0;
        double porcentagemWardVitoriaTotal = 0, porcentagemWardDerrotaTotal = 0;
        double totalListGames = 0;
        for (Game gameAtual : listGames) {
            if (gameAtual.getSubType().matches("(RANKED_SOLO_5x5)|(NORMAL)|(RANKED_FLEX_SR)")) {
                totalListGames++;
                System.out.println("Tipo de JOGO: " + gameAtual.getSubType());
                List<FellowPlayer> fellowPlayers = gameAtual.getFellowPlayers();
                double totalFellowPlayer = fellowPlayers.size();
                double porcentagemMedia = 0.;
                double contador = 0;
                wardPlaced = 0;
                wardWinPlaced = 0;
                wardLossPlaced = 0;
                crowdControlDealt = 0;
                System.out.println("-------------------------------------------------------------------------------");
                for (FellowPlayer fellowPlayer : fellowPlayers) {
                    //Aqui, nós buscamos os ids dos summoners do mesmo time do game atual do player analisado.
                    if (Objects.equals(fellowPlayer.getTeamId(), gameAtual.getTeamId())) {
                        contador++;
                        PlayerGames playerGames = get2.getPlayerGames(fellowPlayer.getSummonerId());
                        porcentagemMedia += porcentagemVitorias(playerGames.getGames(), fellowPlayers);
                    }
                }
                porcentagemCrowdControl += crowdControlDealt / contador;
                porcentagemWards += wardPlaced / contador;
                porcentagemGames += porcentagemMedia / contador;
                porcentagemWardVitoria += wardWinPlaced / contador;
                porcentagemWardDerrota += wardLossPlaced / contador;

                System.out.println("SOMATORIO DOS JOGADORES              : " + porcentagemMedia / contador);
                System.out.println("SOMATORIO DE WARDS DOS JOGADORES     : " + wardPlaced / contador);
                System.out.println("SOMATORIO DE WARDS VITORIA           : " + wardWinPlaced / contador);
                System.out.println("SOMATORIO DE WARDS DERROTA           : " + wardLossPlaced / contador);
                System.out.println("SOMATORIO DE CROWDCRONTROL JOGODORES : " + crowdControlDealt / contador);
            }
        }
        porcentagemWardVitoriaTotal = porcentagemWardVitoria / totalListGames;
        porcentagemWardDerrotaTotal = porcentagemWardDerrota / totalListGames;
        porcentagemTotalCrowdControl = porcentagemCrowdControl / totalListGames;
        porcentagemTotal = porcentagemGames / totalListGames;
        porcentagemTotalWards = porcentagemWards / totalListGames;
        totalPartidas = contadorDerrotas10 + contadorDerrotas9 + contadorVitorias10 + contadorVitorias9;
        System.out.println("TOTAL DE PARTIDAS ANALISADAS : " + totalPartidas);
        System.out.println("CONTADOR VITORIA >10 : " + contadorVitorias10);
        System.out.println("CONTADOR DERROTAS >10: " + contadorDerrotas10);
        System.out.println("CONTADOR VITORIAS <9 : " + contadorVitorias9);
        System.out.println("CONTADOR DERROTAS <9 : " + contadorDerrotas9);
        System.out.println("PORCENTAGEM TOTAL            : " + porcentagemTotal);
        System.out.println("PORCENTAGEM TOTAL WARDS      : " + porcentagemTotalWards);
        System.out.println("PORCENTAGEM WARDS VITORIA    : " + porcentagemWardVitoriaTotal);
        System.out.println("PORCENTAGEM WARDS DERROTA    : " + porcentagemWardDerrotaTotal);
        System.out.println("PORCENTAGEM CROWDCONTROLDEALT: " + porcentagemTotalCrowdControl);
        System.out.println("**********************************************************************************");
        CalculoEstatistico();
        CalcularProbabilidadeMaior();
        CalcularProbabilidadeMenor();
        return null;
    }

    public void CalculoEstatistico() {

        porcentagemVitoria = (contadorVitorias10 + contadorVitorias9) / totalPartidas;
        porcentagemDerrota = (contadorDerrotas10 + contadorDerrotas9) / totalPartidas;
        vitoria10 = contadorVitorias10 / (contadorVitorias10 + contadorVitorias9);
        vitoria9 = contadorVitorias9 / (contadorVitorias10 + contadorVitorias9);
        derrota10 = contadorDerrotas10 / (contadorDerrotas10 + contadorDerrotas9);
        derrota9 = contadorDerrotas9 / (contadorDerrotas10 + contadorDerrotas9);
        System.out.println("Porcentagem Vitoria: " + porcentagemVitoria);
        System.out.println("Porcentagem Derrota: " + porcentagemDerrota);
        System.out.println("Porcentagem Vitoria ward 10: " + vitoria10);
        System.out.println("Porcentagem Vitoria ward 9: " + vitoria9);
        System.out.println("Porcentagem Derrota ward 10: " + derrota10);
        System.out.println("Porcentagem Derrota ward 9: " + derrota9);
        System.out.println("------------------------------------------------------------------");
    }

    public void CalcularProbabilidadeMaior() {

        wardMaior = (porcentagemVitoria * vitoria10) + (porcentagemDerrota * derrota10);
        //wardMenor = (porcentagemVitoria*vitoria9) + (porcentagemDerrota*derrota9);
        posterioreMaiorVitoria = (porcentagemVitoria * vitoria10) / wardMaior;
        posterioreMaiorDerrota = (porcentagemDerrota * derrota10) / wardMaior;
        System.out.println("wardMaior: " + wardMaior);
        System.out.println("posterioreMaiorVitoria: " + posterioreMaiorVitoria);
        System.out.println("posterioreMaiorDerrota: " + posterioreMaiorDerrota);
    }

    public void CalcularProbabilidadeMenor() {
        wardMenor = (porcentagemVitoria * vitoria9) + (porcentagemDerrota * derrota9);
        posterioreMenorVitoria = (porcentagemVitoria * vitoria9) / wardMenor;
        posterioreMenorDerrota = (porcentagemDerrota * derrota9) / wardMaior;
        System.out.println("wardMenor: " + wardMenor);
        System.out.println("posterioreMenorVitoria: " + posterioreMenorVitoria);
        System.out.println("posterioreMenorDerrota: " + posterioreMenorDerrota);
    }
}
