/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import com.sun.media.jfxmedia.events.PlayerEvent;
import teste.calculo.Calculos;
import teste.modelo.Game;
import teste.modelo.PlayerGames;

/**
 *
 * @author Lemon
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao pesquisar = new Conexao();
        PlayerGames example = pesquisar.getPlayerGames(444467L);
        Calculos c = new Calculos(example);
        c.calcularProbabilidade();
    }
    
}
