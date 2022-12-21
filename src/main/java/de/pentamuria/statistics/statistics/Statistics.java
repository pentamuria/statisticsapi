package de.pentamuria.statistics.statistics;

public class Statistics {

    private int deaths;
    private int kills;
    private int breakedBlocks;
    private int placedBlocks;
    private OnlineTime onlineTime;


    public Statistics(int deaths, int kills, int breakedBlocks, int placedBlocks) {
        this.deaths = deaths;
        this.kills = kills;
        this.breakedBlocks = breakedBlocks;
        this.placedBlocks = placedBlocks;
    }

    public Statistics() {
        this.deaths = 0;
        this.kills = 0;
        this.breakedBlocks = 0;
        this.placedBlocks = 0;
        this.onlineTime = new OnlineTime();
    }

    public int getDeaths() {
        return deaths;
    }

    public void addDeath() {
        deaths+=1;
    }

    public int getKills() {
        return kills;
    }
    public void addKill() {
        kills+=1;
    }

    public int getBreakedBlocks() {
        return breakedBlocks;
    }

    public void addBreakedBlocks() {
        breakedBlocks+=1;
    }

    public int getPlacedBlocks() {
        return placedBlocks;
    }
    public void addPlacedBlocks() {
        placedBlocks+=1;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setBreakedBlocks(int breakedBlocks) {
        this.breakedBlocks = breakedBlocks;
    }

    public void setPlacedBlocks(int placedBlocks) {
        this.placedBlocks = placedBlocks;
    }

    public OnlineTime getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(OnlineTime onlineTime) {
        this.onlineTime = onlineTime;
    }
}
