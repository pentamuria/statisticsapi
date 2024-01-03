package de.pentamuria.statistics.commands;

import de.pentamuria.statistics.statisticsapi.StatisticsAPI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_allStatistics implements CommandExecutor {
    private final StatisticsAPI plugin;

    public COMMAND_allStatistics(StatisticsAPI statisticsAPI) {
        this.plugin = statisticsAPI;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(args.length==0) {
                p.openInventory(plugin.stats.getMainStatisticsInv(p,
                        plugin.stats.getAllStats()));
            } else {
                p.sendMessage("§8--------§7[§eStats§7]§8--------");
                p.sendMessage("§e/allsstats §7Öffnet das Stats-Menü");
            }
        }

        return true;
    }
}
