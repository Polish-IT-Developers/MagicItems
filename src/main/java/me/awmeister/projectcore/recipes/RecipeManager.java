package me.awmeister.projectcore.recipes;

import me.awmeister.projectcore.items.SpecialItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RecipeManager {

    public static void registerRecipes() {
        Bukkit.getConsoleSender().sendMessage("[Items] Registering recipes...");

        Bukkit.addRecipe(getShardRecipe());
        Bukkit.addRecipe(getTeleportBowRecipe());
        Bukkit.addRecipe(getSuperPickaxeRecipe());
        Bukkit.addRecipe(getLaserRecipe());
        Bukkit.addRecipe(getFreezerRecipe());
        Bukkit.addRecipe(getUndeadWandRecipe());
        Bukkit.addRecipe(getSmokeBowRecipe());
        Bukkit.addRecipe(getXrayBowRecipe());
        Bukkit.addRecipe(getWitherGunRecipe());
        Bukkit.addRecipe(getDragonGunRecipe());
        Bukkit.addRecipe(getFireballGunRecipe());
        Bukkit.addRecipe(getGrapplingHookRecipe());
        Bukkit.addRecipe(getHammerRecipe());
        Bukkit.addRecipe(getShockwaveSnowballRecipe());
        Bukkit.addRecipe(getShurikenRecipe());
        Bukkit.addRecipe(getAirstrikeBowRecipe());
        Bukkit.addRecipe(getNecromancerEggRecipe());
        Bukkit.addRecipe(getKnockShieldRecipe());

        Bukkit.getConsoleSender().sendMessage("[Items] All recipes has been successfully registered.");
    }

    public static void unregisterRecipes() {
        Bukkit.getConsoleSender().sendMessage("[Items] Unregistering recipes...");

        NamespacedKey shardKey = NamespacedKey.fromString("magicitems_teleportshard");
        NamespacedKey teleportBowKey = NamespacedKey.fromString("magicitems_teleportbow");
        NamespacedKey superPickaxeKey = NamespacedKey.fromString("magicitems_superpickaxe");
        NamespacedKey laserKey = NamespacedKey.fromString("magicitems_laser");
        NamespacedKey freezerKey = NamespacedKey.fromString("magicitems_freezer");
        NamespacedKey undeadWandKey = NamespacedKey.fromString("magicitems_undeadwand");
        NamespacedKey smokeBowKey = NamespacedKey.fromString("magicitems_smokebow");
        NamespacedKey xrayBowKey = NamespacedKey.fromString("magicitems_xraybow");
        NamespacedKey witherGunKey = NamespacedKey.fromString("magicitems_withergun");
        NamespacedKey dragonGunKey = NamespacedKey.fromString("magicitems_dragongun");
        NamespacedKey fireballGunKey = NamespacedKey.fromString("magicitems_fireballgun");
        NamespacedKey grapplingHookKey = NamespacedKey.fromString("magicitems_grapplinghook");
        NamespacedKey hammerKey = NamespacedKey.fromString("magicitems_thorhammer");
        NamespacedKey snowballKey = NamespacedKey.fromString("magicitems_shockwavesnowball");
        NamespacedKey shurikenKey = NamespacedKey.fromString("magicitems_shuriken");
        NamespacedKey airstrikeBowKey = NamespacedKey.fromString("magicitems_airstrikebow");
        NamespacedKey necromacerEggKey = NamespacedKey.fromString("magicitems_necromaceregg");
        NamespacedKey knockShieldKey = NamespacedKey.fromString("magicitems_knockshield");

        Bukkit.removeRecipe(shardKey);
        Bukkit.removeRecipe(teleportBowKey);
        Bukkit.removeRecipe(superPickaxeKey);
        Bukkit.removeRecipe(laserKey);
        Bukkit.removeRecipe(freezerKey);
        Bukkit.removeRecipe(undeadWandKey);
        Bukkit.removeRecipe(smokeBowKey);
        Bukkit.removeRecipe(xrayBowKey);
        Bukkit.removeRecipe(witherGunKey);
        Bukkit.removeRecipe(dragonGunKey);
        Bukkit.removeRecipe(fireballGunKey);
        Bukkit.removeRecipe(grapplingHookKey);
        Bukkit.removeRecipe(hammerKey);
        Bukkit.removeRecipe(snowballKey);
        Bukkit.removeRecipe(shurikenKey);
        Bukkit.removeRecipe(airstrikeBowKey);
        Bukkit.removeRecipe(necromacerEggKey);
        Bukkit.removeRecipe(knockShieldKey);

        Bukkit.getConsoleSender().sendMessage("[Items] All recipes has been successfully unregistered.");
    }

    public static ShapedRecipe getShardRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.teleportshard);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_teleportshard"), item);

        rec.shape("EPE", "PSP", "EPE");

        rec.setIngredient('E', Material.ENDER_EYE);
        rec.setIngredient('P', Material.ENDER_PEARL);
        rec.setIngredient('S', Material.AMETHYST_SHARD);

        return rec;
    }

    public static ShapedRecipe getTeleportBowRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.teleportbow);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_teleportbow"), item);

        rec.shape("APA", "PBP", "APA");

        rec.setIngredient('A', Material.ARROW);
        rec.setIngredient('P', Material.ENDER_PEARL);
        rec.setIngredient('B', Material.BOW);

        return rec;
    }

    public static ShapedRecipe getSuperPickaxeRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.superpickaxe);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_superpickaxe"), item);

        rec.shape("NIN", "IPI", "LNL");

        rec.setIngredient('N', Material.NETHERITE_INGOT);
        rec.setIngredient('I', Material.IRON_INGOT);
        rec.setIngredient('P', Material.NETHERITE_PICKAXE);
        rec.setIngredient('L', Material.LIGHTNING_ROD);

        return rec;
    }

    public static ShapedRecipe getLaserRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.laser);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_laser"), item);

        rec.shape("RHR", "ICI", "RHR");

        rec.setIngredient('H', Material.HONEYCOMB);
        rec.setIngredient('R', Material.REDSTONE);
        rec.setIngredient('I', Material.IRON_INGOT);
        rec.setIngredient('C', Material.CROSSBOW);

        return rec;
    }

    public static ShapedRecipe getFreezerRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.freezer);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_freezer"), item);

        rec.shape("PSP", "ICI", "PSP");

        rec.setIngredient('S', Material.SNOWBALL);
        rec.setIngredient('P', Material.PRISMARINE_CRYSTALS);
        rec.setIngredient('I', Material.IRON_INGOT);
        rec.setIngredient('C', Material.CROSSBOW);

        return rec;
    }

    public static ShapedRecipe getUndeadWandRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.undead);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_undeadwand"), item);

        rec.shape("CBC", "BTB", "CBC");

        rec.setIngredient('T', Material.TRIDENT);
        rec.setIngredient('B', Material.BONE);
        rec.setIngredient('C', Material.CONDUIT);

        return rec;
    }

    public static ShapedRecipe getSmokeBowRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.flashbow);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_smokebow"), item);

        rec.shape("IRI", "DBD", "IRI");

        rec.setIngredient('I', Material.INK_SAC);
        rec.setIngredient('R', Material.WITHER_ROSE);
        rec.setIngredient('B', Material.BOW);
        rec.setIngredient('D', Material.BLACK_DYE);

        return rec;
    }

    public static ShapedRecipe getXrayBowRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.xraybow);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_xraybow"), item);

        rec.shape("IAI", "ABA", "IAI");

        rec.setIngredient('A', Material.SPECTRAL_ARROW);
        rec.setIngredient('I', Material.GLOW_INK_SAC);
        rec.setIngredient('B', Material.BOW);

        return rec;
    }

    public static ShapedRecipe getWitherGunRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.withergun);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_withergun"), item);

        rec.shape("CBC", "BSB", "CBC");

        rec.setIngredient('S', Material.WITHER_SKELETON_SKULL);
        rec.setIngredient('B', Material.BONE);
        rec.setIngredient('C', Material.COAL);

        return rec;
    }

    public static ShapedRecipe getDragonGunRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.dragongun);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_dragongun"), item);

        rec.shape("BOB", "OHO", "BOB");

        rec.setIngredient('B', Material.DRAGON_BREATH);
        rec.setIngredient('O', Material.CRYING_OBSIDIAN);
        rec.setIngredient('H', Material.DRAGON_HEAD);

        return rec;
    }

    public static ShapedRecipe getFireballGunRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.fireballgun);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_fireballgun"), item);

        rec.shape("FRF", "RCR", "FRF");

        rec.setIngredient('R', Material.BLAZE_ROD);
        rec.setIngredient('F', Material.FLINT_AND_STEEL);
        rec.setIngredient('C', Material.FIRE_CHARGE);

        return rec;
    }

    public static ShapedRecipe getGrapplingHookRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.grapplinghook);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_grapplinghook"), item);

        rec.shape("CFC", "FRF", "CGC");

        rec.setIngredient('G', Material.FLINT);
        rec.setIngredient('F', Material.FIREWORK_ROCKET);
        rec.setIngredient('R', Material.FISHING_ROD);
        rec.setIngredient('C', Material.CHAIN);

        return rec;
    }

    public static ShapedRecipe getHammerRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.laser);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_thorhammer"), item);

        rec.shape("NLN", "LAL", "NLN");

        rec.setIngredient('N', Material.NETHERITE_INGOT);
        rec.setIngredient('L', Material.LIGHTNING_ROD);
        rec.setIngredient('A', Material.IRON_AXE);

        return rec;
    }

    public static ShapedRecipe getShurikenRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.shuriken);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_shuriken"), item);

        rec.shape("BIB", "IDI", "BIB");

        rec.setIngredient('B', Material.BONE);
        rec.setIngredient('D', Material.DIAMOND);
        rec.setIngredient('I', Material.IRON_INGOT);

        return rec;
    }

    public static ShapedRecipe getAirstrikeBowRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.airstrikebow);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_airstrikebow"), item);

        rec.shape("TTT", "TBT", "TDT");

        rec.setIngredient('T', Material.TNT);
        rec.setIngredient('B', Material.BOW);
        rec.setIngredient('D', Material.POINTED_DRIPSTONE);

        return rec;
    }

    public static ShapedRecipe getShockwaveSnowballRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.shockwaveSnowball);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_shockwavesnowball"), item);

        rec.shape("SSS", "SBS", "SSS");

        rec.setIngredient('S', Material.SNOWBALL);
        rec.setIngredient('B', Material.SLIME_BALL);

        return rec;
    }

    public static ShapedRecipe getKnockShieldRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.knockShield);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_knockshield"), item);

        rec.shape("SBS", "BHB", "SBS");

        rec.setIngredient('S', Material.SCUTE);
        rec.setIngredient('B', Material.SLIME_BALL);
        rec.setIngredient('H', Material.SHIELD);

        return rec;
    }

    public static ShapedRecipe getNecromancerEggRecipe() {
        ItemStack item = new ItemStack(SpecialItemManager.necromanceregg);

        ShapedRecipe rec = new ShapedRecipe(NamespacedKey.minecraft("magicitems_necromaceregg"), item);

        rec.shape("SZS", "ZEZ", "SZS");

        rec.setIngredient('S', Material.SKELETON_SKULL);
        rec.setIngredient('Z', Material.ZOMBIE_HEAD);
        rec.setIngredient('E', Material.EGG);

        return rec;
    }

}
