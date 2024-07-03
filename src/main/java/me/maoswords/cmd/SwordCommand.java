package me.maoswords.cmd;

import me.maoswords.cmd.give.FireSwordGive;
import me.maoswords.cmd.give.IceSwordGive;
import me.maoswords.cmd.give.ThunderSwordGive;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwordCommand implements CommandExecutor, TabCompleter {

    private final List<String> swordTypes = Arrays.asList("fire", "thunder", "ice");

    private final ThunderSwordGive thunderswordgive = new ThunderSwordGive();
    private final FireSwordGive fireswordgive = new FireSwordGive();

    private final IceSwordGive iceswordgive = new IceSwordGive();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /mcs <player> <fire|thunder>");
            return true;
        }

        String playerName = args[0];
        String swordType = args[1].toLowerCase();

        Player player = Bukkit.getPlayer(playerName);
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found: " + playerName);
            return true;
        }

        switch (swordType) {
            case "fire":
                fireswordgive.giveFireSword(player);
                sender.sendMessage(ChatColor.GOLD + "You have given " + playerName + " an " + ChatColor.RED + "Fire Sword!");
                break;
            case "thunder":
                thunderswordgive.giveThunderSword(player);
                sender.sendMessage(ChatColor.GOLD + "You have given " + playerName + " a " + ChatColor.DARK_AQUA + "Thunder Sword!");
                break;
            case "ice":
                iceswordgive.giveIceSword(player);
                sender.sendMessage(ChatColor.GOLD + "You have given " + playerName + " a " + ChatColor.AQUA + "Ice Sword!");
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Unknown sword type. Use 'fire' or 'thunder'.");
                return true;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> playerNames = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                playerNames.add(player.getName());
            }
            return playerNames;
        } else if (args.length == 2) {
            return swordTypes;
        }
        return null;
    }
}
