/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.modelo;

/**
 *
 * @author Lemon
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerGames {

    @SerializedName("games")
    @Expose
    private List<Game> games = null;
    @SerializedName("summonerId")
    @Expose
    private Integer summonerId;

    /**
     *
     * @return The games
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     *
     * @param games The games
     */
    public void setGames(List<Game> games) {
        this.games = games;
    }

    /**
     *
     * @return The summonerId
     */
    public Integer getSummonerId() {
        return summonerId;
    }

    /**
     *
     * @param summonerId The summonerId
     */
    public void setSummonerId(Integer summonerId) {
        this.summonerId = summonerId;
    }

}
