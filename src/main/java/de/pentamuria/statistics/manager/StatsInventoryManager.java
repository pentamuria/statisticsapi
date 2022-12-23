package de.pentamuria.statistics.manager;

import de.pentamuria.statistics.statistics.Statistics;
import de.pentamuria.statistics.statisticsapi.StatisticsAPI;
import de.pentamuria.statistics.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class StatsInventoryManager {

    private final StatisticsAPI plugin;

    public StatsInventoryManager(StatisticsAPI api) {
        this.plugin = api;
    }

    public Inventory getMainStatisticsInv(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9*5, "§aDeine Statistiken");

        Statistics stats = plugin.stats.getPlayerStats(p.getUniqueId().toString());

        inv.setItem(22, new ItemBuilder(Material.CLOCK, 1).setName("§aOnline seit")
                .addLoreLine("§7")
                .addLoreLine("§7↣ " + plugin.stats.getPlayerStats(p.getUniqueId().toString()).getOnlineTime().format()).toItemStack());

        inv.setItem(10, new ItemBuilder(Material.SKELETON_SKULL, 1).setName("§cDeine Tode")
                .addLoreLine("").addLoreLine("§7↣ §b" + stats.getDeaths()).toItemStack());

        inv.setItem(16, new ItemBuilder(Material.DIAMOND_SWORD, 1).setName("§cDeine Kills")
                .addLoreLine("").addLoreLine("§7↣ §b" + stats.getKills()).toItemStack());

        inv.setItem(28, new ItemBuilder(Material.NETHERITE_PICKAXE, 1).setName("§aAbgebaute Blöcke")
                .addLoreLine("").addLoreLine("§7↣ §b" + stats.getBreakedBlocks())
                .addLoreLine("").addLoreLine("§eMehr Informationen").toItemStack());

        inv.setItem(34, new ItemBuilder(Material.GRASS_BLOCK, 1).setName("§ePlatzierte Blöcke")
                .addLoreLine("").addLoreLine("§7↣ §b" + stats.getPlacedBlocks()).toItemStack());

        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§a").toItemStack());
            }
        }
        return inv;
    }

    public Inventory getBlockStatsInv(Player p, int page) {
        Inventory inv = Bukkit.createInventory(null, 9*6, "§aDeine Block-Stats");

        if(!getBlocks(page).isEmpty()) {
            for(Material mat : getBlocks(page)) {
                inv.addItem(new ItemBuilder(mat, 1).setName("§a" + mat.toString().replace("_", " "))
                        .addLoreLine("§7")
                        .addLoreLine("§7↣ §eAbgebaut: §d§l" + plugin.stats.getPlayerStats(p.getUniqueId().toString()).getBlocks(mat))
                        .toItemStack());
            }
        }


        int nextPage = page<4?page+1:1;
        int previousPage = page>1?page-1:4;
        inv.setItem(45, new ItemBuilder(Material.ARROW, 1).setName("§bZu Seite §d" + previousPage).toItemStack());
        inv.setItem(49, new ItemBuilder(Material.EMERALD, 1).setName("§bAktuelle Seite: §d" + page).toItemStack());
        inv.setItem(53, new ItemBuilder(Material.ARROW, 1).setName("§bZu Seite §d" + nextPage).toItemStack());

        for(int i = 46; i<53; i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§5").toItemStack());
            }
        }

        return inv;

    }

    public ArrayList<Material> getBlocks(int page) {
        ArrayList<Material> blocks = new ArrayList<Material>();

        if(page==1) {
            // Ores
            blocks.add(Material.COAL_ORE);
            blocks.add(Material.COPPER_ORE);
            blocks.add(Material.IRON_ORE);
            blocks.add(Material.LAPIS_ORE);
            blocks.add(Material.REDSTONE_ORE);
            blocks.add(Material.GOLD_ORE);
            blocks.add(Material.DIAMOND_ORE);
            blocks.add(Material.EMERALD_ORE);
            blocks.add(Material.NETHER_QUARTZ_ORE);
            blocks.add(Material.ANCIENT_DEBRIS);
            // Wood
            blocks.add(Material.OAK_LOG);
            blocks.add(Material.ACACIA_LOG);
            blocks.add(Material.BIRCH_LOG);
            blocks.add(Material.JUNGLE_LOG);
            blocks.add(Material.DARK_OAK_LOG);
            blocks.add(Material.MANGROVE_LOG);
            // Blocks
            blocks.add(Material.STONE);
            blocks.add(Material.GRASS_BLOCK);
            blocks.add(Material.DIRT);
            blocks.add(Material.SAND);
            blocks.add(Material.GRAVEL);
            blocks.add(Material.SPONGE);
            blocks.add(Material.GLOWSTONE);

        } else if(page==2) {
            // Farming
            blocks.add(Material.CACTUS);
            blocks.add(Material.MELON_STEM);
            blocks.add(Material.POTATOES);
            blocks.add(Material.PUMPKIN_STEM);
            blocks.add(Material.WHEAT);
            blocks.add(Material.CACTUS);
            blocks.add(Material.HAY_BLOCK);
            blocks.add(Material.SLIME_BLOCK);
            blocks.add(Material.HONEY_BLOCK);
            blocks.add(Material.HONEYCOMB_BLOCK);
            blocks.add(Material.BEEHIVE);

            // Flowers
            blocks.add(Material.BROWN_MUSHROOM);
            blocks.add(Material.RED_MUSHROOM);
            blocks.add(Material.CRIMSON_FUNGUS);
            blocks.add(Material.WARPED_FUNGUS);
            blocks.add(Material.GRASS);
            blocks.add(Material.FERN);
            blocks.add(Material.DEAD_BUSH);
            blocks.add(Material.DANDELION);
            blocks.add(Material.POPPY);
            blocks.add(Material.BLUE_ORCHID);
            blocks.add(Material.ALLIUM);
            blocks.add(Material.AZURE_BLUET);
            blocks.add(Material.RED_TULIP);
            blocks.add(Material.ORANGE_TULIP);
            blocks.add(Material.PINK_TULIP);
            blocks.add(Material.WHITE_TULIP);
            blocks.add(Material.OXEYE_DAISY);
            blocks.add(Material.CORNFLOWER);
            blocks.add(Material.LILY_OF_THE_VALLEY);
            blocks.add(Material.SPORE_BLOSSOM);
            blocks.add(Material.BAMBOO);
            blocks.add(Material.SUGAR_CANE);
            blocks.add(Material.WITHER_ROSE);
            blocks.add(Material.SUNFLOWER);
            blocks.add(Material.LILAC);
            blocks.add(Material.ROSE_BUSH);
            blocks.add(Material.PEONY);
        }

        return blocks;
    }


}
