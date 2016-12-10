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

public class Game {

    @SerializedName("fellowPlayers")
    @Expose
    private List<FellowPlayer> fellowPlayers = null;
    @SerializedName("gameType")
    @Expose
    private String gameType;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("gameId")
    @Expose
    private Integer gameId;
    @SerializedName("ipEarned")
    @Expose
    private Integer ipEarned;
    @SerializedName("spell1")
    @Expose
    private Integer spell1;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("spell2")
    @Expose
    private Integer spell2;
    @SerializedName("gameMode")
    @Expose
    private String gameMode;
    @SerializedName("mapId")
    @Expose
    private Integer mapId;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("invalid")
    @Expose
    private Boolean invalid;
    @SerializedName("subType")
    @Expose
    private String subType;
    @SerializedName("createDate")
    @Expose
    private Long createDate;
    @SerializedName("championId")
    @Expose
    private Integer championId;

    /**
     *
     * @return The fellowPlayers
     */
    public List<FellowPlayer> getFellowPlayers() {
        return fellowPlayers;
    }

    /**
     *
     * @param fellowPlayers The fellowPlayers
     */
    public void setFellowPlayers(List<FellowPlayer> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    /**
     *
     * @return The gameType
     */
    public String getGameType() {
        return gameType;
    }

    /**
     *
     * @param gameType The gameType
     */
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    /**
     *
     * @return The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     *
     * @param stats The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     *
     * @return The gameId
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId The gameId
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return The ipEarned
     */
    public Integer getIpEarned() {
        return ipEarned;
    }

    /**
     *
     * @param ipEarned The ipEarned
     */
    public void setIpEarned(Integer ipEarned) {
        this.ipEarned = ipEarned;
    }

    /**
     *
     * @return The spell1
     */
    public Integer getSpell1() {
        return spell1;
    }

    /**
     *
     * @param spell1 The spell1
     */
    public void setSpell1(Integer spell1) {
        this.spell1 = spell1;
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
     * @return The spell2
     */
    public Integer getSpell2() {
        return spell2;
    }

    /**
     *
     * @param spell2 The spell2
     */
    public void setSpell2(Integer spell2) {
        this.spell2 = spell2;
    }

    /**
     *
     * @return The gameMode
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     *
     * @param gameMode The gameMode
     */
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    /**
     *
     * @return The mapId
     */
    public Integer getMapId() {
        return mapId;
    }

    /**
     *
     * @param mapId The mapId
     */
    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    /**
     *
     * @return The level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     *
     * @param level The level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     *
     * @return The invalid
     */
    public Boolean getInvalid() {
        return invalid;
    }

    /**
     *
     * @param invalid The invalid
     */
    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    /**
     *
     * @return The subType
     */
    public String getSubType() {
        return subType;
    }

    /**
     *
     * @param subType The subType
     */
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     *
     * @return The createDate
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate The createDate
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

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

}
