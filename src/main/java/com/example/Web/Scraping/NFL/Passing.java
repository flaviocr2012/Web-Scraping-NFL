package com.example.Web.Scraping.NFL;

// Classe usada pra converter os dados em json
public class Passing {

    private String player;
    private String passYds;
    private String YdsAtt;
    private String Att;

    public Passing(String player, String passYds, String ydsAtt, String att) {
        this.player = player;
        this.passYds = passYds;
        YdsAtt = ydsAtt;
        Att = att;
    }

    public Passing(){

    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPassYds() {
        return passYds;
    }

    public void setPassYds(String passYds) {
        this.passYds = passYds;
    }

    public String getYdsAtt() {
        return YdsAtt;
    }

    public void setYdsAtt(String ydsAtt) {
        YdsAtt = ydsAtt;
    }

    public String getAtt() {
        return Att;
    }

    public void setAtt(String att) {
        Att = att;
    }
}
