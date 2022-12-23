package de.pentamuria.statistics.statistics;

import org.bukkit.Material;

import java.util.HashMap;

public class Statistics {

    private int deaths;
    private int kills;
    private int breakedBlocks;
    private int placedBlocks;
    private OnlineTime onlineTime;
    private HashMap<Material, Integer> blocks;


    public Statistics(int deaths, int kills, int breakedBlocks, int placedBlocks, HashMap<Material, Integer> blocks) {
        this.deaths = deaths;
        this.kills = kills;
        this.breakedBlocks = breakedBlocks;
        this.placedBlocks = placedBlocks;
        this.blocks = blocks;
    }

    public Statistics() {
        this.deaths = 0;
        this.kills = 0;
        this.breakedBlocks = 0;
        this.placedBlocks = 0;
        this.onlineTime = new OnlineTime();
        this.blocks = new HashMap<>();
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

    public HashMap<Material, Integer> getBlocks() {
        return blocks;
    }

    public void setBlocks(HashMap<Material, Integer> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(Material matx) {
        Material mat = clearedMaterial(matx);
        if(blocks.containsKey(mat)) {
            blocks.put(mat, blocks.get(mat)+1);
        } else {
            blocks.put(mat, 1);
        }
    }

    public int getBlocks(Material mat) {
        if(blocks.containsKey(mat)) {
            return blocks.get(mat);
        } else {
            return 0;
        }
    }

    public Material clearedMaterial(Material mat) {
        if(mat.toString().contains("DEEPSLATE") && mat.toString()!="DEEPSLATE") {
            return Material.getMaterial(mat.toString().replace("DEEPSLATE_", ""));
        }
        return mat;
    }
}
