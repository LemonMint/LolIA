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

    private double porcentagemVitorias(List<Game> listaGames) {
        double vitorias = 0.;
        double total = listaGames.size();
        for (Game atual : listaGames) {
            vitorias += atual.getStats().getWin() ? 1 : 0;
        }
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
        double totalListGames = listGames.size();
        for (Game gameAtual : listGames) {
            List<FellowPlayer> fellowPlayers = gameAtual.getFellowPlayers();
            double totalFellowPlayer = fellowPlayers.size();
            double porcentagemMedia = 0.;
            double contador = 0;
            System.out.println("-------------------------------------------------------------------------------");
            for (FellowPlayer fellowPlayer : fellowPlayers) {
                if (Objects.equals(fellowPlayer.getTeamId(), gameAtual.getTeamId())) {
                    contador++;
                    PlayerGames playerGames = get2.getPlayerGames(fellowPlayer.getSummonerId());
                    porcentagemMedia += porcentagemVitorias(playerGames.getGames());
                }
            }
            porcentagemGames += porcentagemMedia / contador;
            System.out.println("PORCENTAGEM DO JOGO ATUAL : " + porcentagemMedia/contador);
        }
        porcentagemTotal = porcentagemGames / totalListGames;
        System.out.println("PORCENTAGEM TOTAL : " + porcentagemTotal);
        System.out.println("**********************************************************************************");
        return null;
    }
}
