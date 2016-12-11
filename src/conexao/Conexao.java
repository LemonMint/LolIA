/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import teste.modelo.PlayerGames;
import java.lang.String;
import org.json.JSONObject;

/**
 *
 * @author Lemon
 */
public class Conexao {

    public PlayerGames getPlayerGames(Long summonerId) {
        PlayerGames example = null;
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "https://br.api.pvp.net/api/lol/br/v1.3/game/by-summoner/" + summonerId + "/recent?api_key=RGAPI-6b21c1fe-67a3-4222-b713-918d6609f30c");
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output = "";
            System.out.println("Output from Server .... \n");
            /*            while ((output = br.readLine()) != null) {
            System.out.println(output);
            }*/

            do {
                output += br.readLine();
            } while (br.readLine() != null);
            // System.out.println("output: " + output);
            example = new Gson().fromJson(output, PlayerGames.class);
            httpClient.getConnectionManager().shutdown();
            // System.out.println("id: " + example.getSummonerId());
        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return example;
    }

    public long getSummonerId(String summonerName) {
        long summonerId = 0;
        try {
            String output = "";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "https://br.api.pvp.net/api/lol/br/v1.4/summoner/by-name/" + summonerName + "?api_key=RGAPI-6b21c1fe-67a3-4222-b713-918d6609f30c");
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            do {
                output += br.readLine();
            } while (br.readLine() != null);

            //Primeiramente buscamos os objectos pais (nomes dos invocadores).
            JSONObject obj = new JSONObject(output);
            String[] keys = JSONObject.getNames(obj);
            if (keys != null && keys.length > 0) {
                for (String key : keys) {
                    //Após termos as keys com seus nomes, buscamos os valores 
                    //do objeto
                    JSONObject valueSummonerName = obj.getJSONObject(key);
                    String[] keysSN = JSONObject.getNames(valueSummonerName);
                    for (String keySN : keysSN) {
                        if (keySN.equalsIgnoreCase("id")) {
                            summonerId = valueSummonerName.getLong(keySN);
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return summonerId;
    }

}
