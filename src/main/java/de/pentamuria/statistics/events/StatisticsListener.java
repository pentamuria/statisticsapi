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
            if(e.getSlot()==28) {
                p.openInventory(plugin.stats.getBlockStatsInv(p, 1));
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§aDeine Block-Stats")) {
            e.setCancelled(true);
            if(e.getSlot()==45) {
                p.openInventory(plugin.stats.getBlockStatsInv(p, Integer.valueOf(e.getCurrentItem().getItemMeta().getDisplayName().split("§d")[1])));
            } else if(e.getSlot()==53) {
                p.openInventory(plugin.stats.getBlockStatsInv(p, Integer.valueOf(e.getCurrentItem().getItemMeta().getDisplayName().split("§d")[1])));
            }
        }

    }
}
