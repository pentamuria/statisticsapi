package de.pentamuria.statistics.commands;

import de.pentamuria.statistics.statistics.Statistics;
import de.pentamuria.statistics.statisticsapi.StatisticsAPI;
import de.pentamuria.statistics.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class COMMAND_statistics implements CommandExecutor {
    private final StatisticsAPI plugin;

    public COMMAND_statistics(StatisticsAPI statisticsAPI) {
        this.plugin = statisticsAPI;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(args.length==0) {
                Inventory inv = Bukkit.createInventory(null, 9*5, "§aDeine Statistiken");

                Statistics stats = plugin.stats.getPlayerStats(p.getUniqueId().toString());

                inv.setItem(22, new ItemBuilder(Material.CLOCK, 1).setName("§aOnline seit")
                        .addLoreLine("§7")
                        .addLoreLine("§7↣ " + plugin.stats.getPlayerStats(p.getUniqueId().toString()).getOnlineTime().format()).toItemStack());

                inv.setItem(10, new ItemBuilder(Material.SKELETON_SKULL, 1).setName("§cDeine Tode")
                        .addLoreLine("").addLoreLine("§7↣ §b" + stats.getDeaths()).toItemStack());

                inv.setItem(16, new ItemBuilder(Material.SKELETON_SKULL, 1).setName("§cDeine Kills")
                        .addLoreLine("").addLoreLine("§7↣ §b" + stats.getKills()).toItemStack());

                inv.setItem(28, new ItemBuilder(Material.NETHERITE_AXE, 1).setName("§aAbgebaute Blöcke")
                        .addLoreLine("").addLoreLine("§7↣ §b" + stats.getBreakedBlocks()).toItemStack());

                inv.setItem(34, new ItemBuilder(Material.GRASS_BLOCK, 1).setName("§ePlatzierte Blöcke")
                        .addLoreLine("").addLoreLine("§7↣ §b" + stats.getPlacedBlocks()).toItemStack());

                for(int i = 0; i<inv.getSize();i++) {
                    if(inv.getItem(i)==null) {
                        inv.setItem(i, new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§a").toItemStack());
                    }
                }
                p.openInventory(inv);
            }
        }

        return true;
    }
}
