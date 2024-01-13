package de.pentamuria.statistics.statistics;

import org.bukkit.Material;

import java.util.HashMap;

public class Statistics {

    /**
     * Anzahl der Tode des Spielers.
     */
    private int deaths;
    /**
     * Anzahl der Kills an anderen Spielern.
     */
    private int kills;
    /**
     * Anzahl der abgebauten Bloecke.
     */
    private int breakedBlocks;
    /**
     * Anzahl der platzierten Blöcke.
     */
    private int placedBlocks;
    /**
     * Onlinezeit Instanz.
     */
    private OnlineTime onlineTime;
    /**
     * Hashmap mit allen abgebauten Blöcken.
     */
    private HashMap<Material, Integer> blocks;
    /**
     * Verursachter Spieler-Schaden.
     */
    private double damage;
    /**
     * Verursachter Mob-Schaden.
     */
    private double mobDamage;
    /**
     * Anzahl der getöteten Mobs.
     */
    private int mobKills;
    /**
     * Erlittender Schaden.
     */
    private double damageTaken;

    /**
     * Konstruktor erstellt eine leere Statistik.
     */
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

    /**
     * Gibt die Anzahl der Tode des Spielers zurück.
     * @return Anzahl der Tode
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * Erhöht die Spieler Tode um genau 1.
     */
    public void addDeath() {
        deaths+=1;
    }

    /**
     * Erhöht die Spieler Tode um x Tode.
     * @param deaths Anzahl der neuen Tode
     */
    public void addDeath(int deaths) {
        this.deaths+=deaths;
    }


    /**
     * Gibt die Anzahl der Kills an anderen Spielern zurück.
     * @return Anzahl der Kills
     */
    public int getKills() {
        return kills;
    }

    /**
     * Erhöht die Spieler Kills um genau 1.
     */
    public void addKill() {
        kills+=1;
    }

    /**
     * Erhöht die Spieler Tode um x Kills.
     * @param kills Anzahl der neuen Kills
     */
    public void addKill(int kills) {
        this.kills+=kills;
    }

    /**
     * Gibt die Anzahl der abgebauten Blöcke des Spielers zurück.
     * @return Anzahl der abgebauten Blöcke
     */
    public int getBreakedBlocks() {
        return breakedBlocks;
    }

    /**
     * Erhöht die Blocke um genau 1.
     */
    public void addBreakedBlocks() {
        breakedBlocks+=1;
    }

    /**
     * Erhöht die abgebauten Blocke um x Blocke.
     * @param blocks Anzahl der neuen abgebauten Bloecke
     */
    public void addBreakedBlocks(int blocks) {
        breakedBlocks+=blocks;
    }

    /**
     * Gibt die Anzahl der platzierten Blöcke zurück.
     * @return Anzahl der platzierten Blöcke
     */
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

    /**
     * Gibt an, wie viel Schaden der Spieler insgesamt an andere ausgeteilt hat.
     * @return Ausgeteilder Spieler-Schaden
     */
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
