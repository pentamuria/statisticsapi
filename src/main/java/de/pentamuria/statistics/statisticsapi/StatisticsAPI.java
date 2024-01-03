package de.pentamuria.statistics.statisticsapi;

import de.pentamuria.statistics.commands.COMMAND_allStatistics;
import de.pentamuria.statistics.commands.COMMAND_statistics;
import de.pentamuria.statistics.events.StatisticsListener;
import de.pentamuria.statistics.manager.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class StatisticsAPI extends JavaPlugin {

    String prefix = "§aStatsAPI §8- §7";
    public String pr = "§aStats §8- §7";

    public StatsManager stats;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("§7-----------§8[§aStatisticsAPI§8]§7-----------");
        stats = new StatsManager(this);
        loadCommands();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde §agestartet");
        Bukkit.getConsoleSender().sendMessage("§7---------------------------------------------------");
        startOnlineTimer();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        stats.uploadStats();
        Bukkit.getConsoleSender().sendMessage(prefix +" Das Plugin wurde §4deaktiviert");
    }

    private void loadEvents() {
        new StatisticsListener(this);
    }

    private void loadCommands() {
        COMMAND_statistics cCOMMAND_statistics = new COMMAND_statistics(this);
        COMMAND_allStatistics cCOMMAND_allStatistics = new COMMAND_allStatistics(this);

        getCommand("statistics").setExecutor(cCOMMAND_statistics);
        getCommand("allstatistics").setExecutor(cCOMMAND_allStatistics);
    }

    private void startOnlineTimer() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    stats.getPlayerStats(all.getUniqueId().toString()).getOnlineTime().addMinute();
                }
            }
        }, 20*60, 20*60);
    }
}
