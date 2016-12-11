/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.modelo;

/**
 *
 * @author Marcos Paulo
 */
public class SummonerDto {
    private Summoner Summoner;
    
    public SummonerDto(){
        Summoner = new Summoner();
    }
    
    public Summoner getSummoner() {
        return Summoner;
    }

    public void setSummoner(Summoner Summoner) {
        this.Summoner = Summoner;
    }
}
