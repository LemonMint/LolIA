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
        for (Game atual : listaGames) {
            vitorias += atual.getStats().getWin() ? 1 : 0;
        }
        System.out.println("tamanhdo da lista de game: " + listaGames.size());
        System.out.println("numero de vitorias : " + vitorias / listaGames.size());
        return vitorias / listaGames.size();
    }

    public Calculos(PlayerGames games) {
        this.games = games;
    }

    public Double calcularProbabilidade() {
        List<Game> listGames = games.getGames();
        Conexao get2 = new Conexao();
        double porcentagemGames = 0.;
        for (Game gameAtual : listGames) {
            List<FellowPlayer> fellowPlayers = gameAtual.getFellowPlayers();
            System.out.println("numero de plater na lista:" + fellowPlayers.size());
            double porcentagemMedia = 0.;
            for (FellowPlayer fellowPlayer : fellowPlayers) {
                System.out.println("numero do time: " + fellowPlayer.getTeamId());
                System.out.println("Numero do time atual: " + gameAtual.getTeamId());
                if (Objects.equals(fellowPlayer.getTeamId(), gameAtual.getTeamId())) {
                    PlayerGames playerGames = get2.getPlayerGames(fellowPlayer.getSummonerId());
                    porcentagemMedia += porcentagemVitorias(playerGames.getGames());
                }
            }
            porcentagemGames += porcentagemMedia/fellowPlayers.size();
            System.out.println("porcentagemMedia: " + porcentagemMedia / 4);
        }
        porcentagemGames = porcentagemGames/listGames.size();
        return null;
    }
}
