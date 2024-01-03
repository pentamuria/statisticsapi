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
    private double damage;
    private double mobDamage;
    private int mobKills;
    private double damageTaken;


    public Statistics(int deaths, int kills, int breakedBlocks, int placedBlocks, HashMap<Material, Integer> blocks,
                      double damage, double mobDamage, int mobKills) {
        this.deaths = deaths;
        this.kills = kills;
        this.breakedBlocks = breakedBlocks;
        this.placedBlocks = placedBlocks;
        this.blocks = blocks;
        this.damage = damage;
        this.mobDamage = mobDamage;
        this.mobKills = mobKills;
    }

    public Statistics() {
        this.deaths = 0;
        this.kills = 0;
        this.breakedBlocks = 0;
        this.placedBlocks = 0;
        this.onlineTime = new OnlineTime();
        this.blocks = new HashMap<>();
        this.damage = 0.0;
        this.mobDamage = 0.0;
        this.mobKills = 0;
        this.damageTaken = 0.0;
    }

    public int getDeaths() {
        return deaths;
    }

    public void addDeath() {
        deaths+=1;
    }

    public void addDeath(int deaths) {
        this.deaths+=deaths;
    }

    public int getKills() {
        return kills;
    }
    public void addKill() {
        kills+=1;
    }

    public void addKill(int kills) {
        this.kills+=kills;
    }

    public int getBreakedBlocks() {
        return breakedBlocks;
    }

    public void addBreakedBlocks() {
        breakedBlocks+=1;
    }

    public void addBreakedBlocks(int blocks) {
        breakedBlocks+=blocks;
    }

    public int getPlacedBlocks() {
        return placedBlocks;
    }
    public void addPlacedBlocks() {
        placedBlocks+=1;
    }

    public void addPlacedBlocks(int blocks) {
        placedBlocks+=blocks;
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

    private void addOnlineTime(OnlineTime onlineTime) {
        long allMinutes = this.onlineTime.getAllTimeInMinutes() + onlineTime.getAllTimeInMinutes();
        this.onlineTime = new OnlineTime(allMinutes);
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

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void addDamage(double damage) {
        this.damage+=damage;
    }

    public double getMobDamage() {
        return mobDamage;
    }

    public void setMobDamage(double mobDamage) {
        this.mobDamage = mobDamage;
    }

    public void addMobDamage(double mobDamage) {
        this.mobDamage+=mobDamage;
    }

    public int getMobKills() {
        return mobKills;
    }

    public void setMobKills(int mobKills) {
        this.mobKills = mobKills;
    }

    public void addMobKill() {
        this.mobKills+=1;
    }

    public void addMobKill(int kills) {
        this.mobKills+=kills;
    }

    public double getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(double damageTaken) {
        this.damageTaken = damageTaken;
    }

    public void addDamageTaken(double damageTaken) {
        this.damageTaken+=damageTaken;
    }

    /**
     * Addiert mehrere Statistiken zusammen und aktualisiert die aktuelle Instanz.
     * Diese Methode hat keinen Rückgabewert und verarbeitet alle Statistiken, außer der HashMap "blocks", die auf Null
     * gesetzt wird.
     *
     * @param statistics - Die Statistiken, die addiert werden sollen.
     */
    public void add(Statistics statistics) {
        this.addDeath(statistics.deaths);
        this.addKill(statistics.kills);
        this.addBreakedBlocks(statistics.breakedBlocks);
        this.addPlacedBlocks(statistics.placedBlocks);
        this.addOnlineTime(statistics.onlineTime);
        this.addDamage(statistics.damage);
        this.addMobDamage(statistics.mobDamage);
        this.addMobKill(statistics.mobKills);
        this.addDamageTaken(statistics.damageTaken);

        this.blocks = null;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "deaths=" + deaths +
                ", kills=" + kills +
                ", breakedBlocks=" + breakedBlocks +
                ", placedBlocks=" + placedBlocks +
                ", onlineTime=" + onlineTime +
                ", blocks=" + blocks +
                ", damage=" + damage +
                ", mobDamage=" + mobDamage +
                ", mobKills=" + mobKills +
                ", damageTaken=" + damageTaken +
                '}';
    }
}
