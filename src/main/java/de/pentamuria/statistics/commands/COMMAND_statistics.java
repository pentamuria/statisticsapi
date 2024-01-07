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
                p.openInventory(plugin.stats.getMainStatisticsInv(p, plugin.stats.getPlayerStats(p.getUniqueId().toString())));
            } else if(args.length==1) {
                String mat = args[0].toUpperCase();
                if(mat.equalsIgnoreCase("help") || mat.equalsIgnoreCase("hilfe")) {
                    p.sendMessage("§8--------§7[§eStats§7]§8--------");
                    p.sendMessage("§e/stats §7Öffne das Stats-Menü");
                    p.sendMessage("§e/stats <MAT> §7Sehe Statistik eines abgebauten Blocks");
                    return true;
                }
                Material material = Material.getMaterial(mat);
                if(material == null) {
                    p.sendMessage("§4[Fehler] §8- §cDieses Material gibt es nicht!");
                    return true;
                }
                int count = plugin.stats.getPlayerStats(p.getUniqueId().toString()).getBlocks(material);
                p.sendMessage("§eStats §7für §a" + mat + "§7: §b" + count);
            } else {
                p.sendMessage("§8--------§7[§eStats§7]§8--------");
                p.sendMessage("§e/stats §7Öffne das Stats-Menü");
                p.sendMessage("§e/stats <MAT> §7Sehe Statistik eines abgebauten Blocks");
            }
        }

        return true;
    }
}
