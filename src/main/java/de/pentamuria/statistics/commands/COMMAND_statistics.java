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
                p.openInventory(plugin.stats.getMainStatisticsInv(p));
            }
        }

        return true;
    }
}
