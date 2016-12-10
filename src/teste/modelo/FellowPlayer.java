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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FellowPlayer {

    @SerializedName("championId")
    @Expose
    private Integer championId;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("summonerId")
    @Expose
    private Long summonerId;

    /**
     *
     * @return The championId
     */
    public Integer getChampionId() {
        return championId;
    }

    /**
     *
     * @param championId The championId
     */
    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    /**
     *
     * @return The teamId
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId The teamId
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return The summonerId
     */
    public Long getSummonerId() {
        return summonerId;
    }

    /**
     *
     * @param summonerId The summonerId
     */
    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

}
