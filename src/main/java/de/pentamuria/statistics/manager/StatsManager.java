package de.pentamuria.statistics.manager;

import de.pentamuria.statistics.statistics.Statistics;
import de.pentamuria.statistics.statisticsapi.StatisticsAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatsManager {


    private final StatisticsAPI plugin;
    private HashMap<String, Statistics> playerStats;

    public StatsManager(StatisticsAPI statisticsAPI) {
        this.plugin = statisticsAPI;
        playerStats = new HashMap<>();
        loadPlayerStats();
    }

    /**
     * Load all Player stats
     */
    public void loadPlayerStats() {
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(!playerStats.containsKey(all.getUniqueId().toString())) {
                playerStats.put(all.getUniqueId().toString(), loadStats(all.getUniqueId().toString()));
            }
        }
        Bukkit.getConsoleSender().sendMessage(plugin.pr + "Die Statistiken von §b" + Bukkit.getOnlinePlayers().size() + " Spielern §7wurden §ageladen");
    }

    /**
     * Load Stats of a Player
     * @param uuid
     */
    public void loadPlayerStats(String uuid) {
        if(!playerStats.containsKey(uuid)) {
            playerStats.put(uuid, loadStats(uuid));
            Bukkit.getConsoleSender().sendMessage(plugin.pr + "Die Statistiken von §b" + uuid + " §7wurden §ageladen");
        }
    }

    /**
     * Get statistics of a player
     * @param uuid
     * @return
     */
    public Statistics getPlayerStats(String uuid) {
        if(playerStats.containsKey(uuid)) {
            return playerStats.get(uuid);
        } else {
            Statistics stats = loadStats(uuid);
            playerStats.put(uuid, stats);
            return stats;
        }
    }

    public void uploadStats() {
        // Iterating HashMap through for loop
        for (Map.Entry<String, Statistics> set :
                playerStats.entrySet()) {
            updateStats(set.getKey(), set.getValue());
        }
    }

    private void updateStats(String uuid, Statistics stats) {
        File file = new File("plugins/playerdata/" + uuid, "stats.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set("Tode", stats.getDeaths());
        cfg.set("Kills", stats.getKills());
        cfg.set("BreakedBlocks", stats.getBreakedBlocks());
        cfg.set("PlacedBlocks", stats.getPlacedBlocks());
        cfg.set("OnlineTime.Minutes", stats.getOnlineTime().getMinutes());
        cfg.set("OnlineTime.Hours", stats.getOnlineTime().getHours());
        cfg.set("OnlineTime.Days", stats.getOnlineTime().getDays());

        try {
            cfg.save(file);
            Bukkit.getConsoleSender().sendMessage(plugin.pr + "Die Statistiken von §b" + uuid + " §7wurden §ehochgeladen!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Statistics loadStats(String uuid) {
        File file = new File("plugins/playerdata/" + uuid, "stats.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if(file.exists()) {
            Statistics stats = new Statistics();
            if(cfg.contains("Tode"))stats.setDeaths(cfg.getInt("Tode"));
            if(cfg.contains("Kills"))stats.setKills(cfg.getInt("Kills"));
            if(cfg.contains("BreakedBlocks"))stats.setBreakedBlocks(cfg.getInt("BreakedBlocks"));
            if(cfg.contains("PlacedBlocks"))stats.setPlacedBlocks(cfg.getInt("PlacedBlocks"));
            // OnlineTime
            if(cfg.contains("OnlineTime.Minutes"))stats.getOnlineTime().setMinutes(cfg.getInt("OnlineTime.Minutes"));
            if(cfg.contains("OnlineTime.Hours"))stats.getOnlineTime().setHours(cfg.getInt("OnlineTime.Hours"));
            if(cfg.contains("OnlineTime.Days"))stats.getOnlineTime().setDays(cfg.getInt("OnlineTime.Days"));
            return stats;
        } else {
            return new Statistics();
        }
    }

}
