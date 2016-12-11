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

    private double porcentagemVitorias(List<Game> listaGames) {
        double vitorias = 0.;
        double totalWards = 0.;
        double total = 0.;
        double temp = 0;
        for (Game atual : listaGames) {
            if (atual.getSubType().matches("(RANKED_SOLO_5x5)|(NORMAL)|(RANKED_FLEX_SR)")) {
                if (atual.getStats().getWardPlaced() != null) {
                    total++;
                    System.out.println("wardplaced: " + atual.getStats().getWardPlaced());
                    vitorias += atual.getStats().getWin() ? 1 : 0;
                    totalWards += atual.getStats().getWardPlaced();
                }
            }
        }
        wardPlaced = wardPlaced + (totalWards / total);
        System.out.println("TEMP      : " + wardPlaced);

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
                System.out.println("-------------------------------------------------------------------------------");
                for (FellowPlayer fellowPlayer : fellowPlayers) {
                    if (Objects.equals(fellowPlayer.getTeamId(), gameAtual.getTeamId())) {
                        contador++;
                        PlayerGames playerGames = get2.getPlayerGames(fellowPlayer.getSummonerId());
                        porcentagemMedia += porcentagemVitorias(playerGames.getGames());
                    }
                }
                porcentagemWards += wardPlaced / contador;
                porcentagemGames += porcentagemMedia / contador;
                System.out.println("PORCENTAGEM DO JOGO ATUAL : " + porcentagemMedia / contador);
                System.out.println("PORCENTAGEM DE WARDS DO JOGO ATUAL : " + wardPlaced / contador);
            }
        }
        porcentagemTotal = porcentagemGames / totalListGames;
        porcentagemTotalWards = porcentagemWards / totalListGames;
        System.out.println("PORCENTAGEM TOTAL : " + porcentagemTotal);
        System.out.println("PORCENTAGEM TOTAL WARDS: " + porcentagemTotalWards);
        System.out.println("**********************************************************************************");
        return null;
    }
}
