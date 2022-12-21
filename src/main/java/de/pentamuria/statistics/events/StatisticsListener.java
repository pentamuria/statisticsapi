package de.pentamuria.statistics.events;

import de.pentamuria.statistics.statisticsapi.StatisticsAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StatisticsListener implements Listener {


    private final StatisticsAPI plugin;

    public StatisticsListener(StatisticsAPI statisticsAPI) {
        this.plugin = statisticsAPI;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onStatsInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase("§aDeine Statistiken")) {
            e.setCancelled(true);
        }

    }
}
