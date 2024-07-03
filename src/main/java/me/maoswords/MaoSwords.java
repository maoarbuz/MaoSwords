package me.maoswords;

import me.maoswords.cmd.SwordCommand;
import me.maoswords.recipes.FireSword;
import me.maoswords.recipes.ThunderSword;
import me.maoswords.recipes.IceSword;
import me.maoswords.swords.FireSwordSkills;
import me.maoswords.swords.ThunderSwordSkills;
import me.maoswords.swords.IceSwordSkills;
import org.bukkit.plugin.java.JavaPlugin;

public class MaoSwords extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("█───█─████─████─███─█───█─████─████─████──███\n" +
                                "██─██─█──█─█──█─█───█───█─█──█─█──█─█──██─█──\n" +
                                "█─█─█─████─█──█─███─█─█─█─█──█─████─█──██─███\n" +
                                "█───█─█──█─█──█───█─█████─█──█─█─█──█──██───█\n" +
                                "█───█─█──█─████─███──█─█──████─█─█──████──███\n");
        FireSword recipeFireSword = new FireSword(this);
        recipeFireSword.registerRecipes();
        ThunderSword recipeThunderSword = new ThunderSword(this);
        recipeThunderSword.registerRecipes();
        IceSword recipeIceSword = new IceSword(this);
        recipeIceSword.registerRecipes();
        getServer().getPluginManager().registerEvents(new FireSwordSkills(), this);
        getServer().getPluginManager().registerEvents(new ThunderSwordSkills(), this);
        getServer().getPluginManager().registerEvents(new IceSwordSkills(this), this);
        this.getCommand("mcs").setExecutor(new SwordCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("MaoSwords disabled!");
    }
}
