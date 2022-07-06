package me.awmeister.projectcore.items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;


public class SpecialItemManager {

    public static ItemStack flashbow;
    public static ItemStack xraybow;
    public static ItemStack withergun;
    public static ItemStack dragongun;
    public static ItemStack fireballgun;
    public static ItemStack grapplinghook;
    public static ItemStack thorhammer;
    public static ItemStack teleportbow;
    public static ItemStack teleportshard;
    public static ItemStack shuriken;
    public static ItemStack crown;
    public static ItemStack hat;
    public static ItemStack necromanceregg;
    public static ItemStack airstrikebow;
    public static ItemStack infopaper;
    public static ItemStack superpickaxe;
    public static ItemStack debug;
    public static ItemStack laser;
    public static ItemStack freezer;
    public static ItemStack undead;
    public static ItemStack knockShield;
    public static ItemStack shockwaveSnowball;

    public static ItemStack christmashat;
    public static ItemStack santaclaushat;

    public static void init() {
        createFlashBow();
        createWitherGun();
        createDragonGun();
        createFireballGun();
        createXrayBow();
        createGrapplingHook();
        createThorHammer();
        createTeleportShard();
        createTeleportBow();
        createShuriken();
        createCrown();
        createHat();
        createNecromancerEgg();
        createAirstrikeBow();
        createInfoPaper();
        createSuperPickaxe();
        createDebugItem();
        createLaserItem();
        createFreezerItem();
        createUndeadWand();
        createKnockShield();
        createShockwaveSnowball();

        createChristmasHat();
        createSantaClausHat();
    }


    private static void createFlashBow() {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eŁuk z bombą dymną");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §5Epickie");
        lore.add(" ");
        lore.add("§7W miejscu trafienia powstaje bomba dymna zadająca obrażania");
        lore.add("§7wszystkim bytom w polu rażenia.");

        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        flashbow = item;
    }

    private static void createWitherGun() {
        ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eWitherGun");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §bRzadkie");
        lore.add("");
        lore.add("§7Zostań Witherem i używając PPM strzelaj pociskami tego bossa.");

        meta.setLore(lore);

        item.setItemMeta(meta);

        withergun = item;
    }

    private static void createDragonGun() {
        ItemStack item = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eRękawica Smoka");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §bRzadkie");
        lore.add(" ");
        lore.add("§7Zostań Smokiem Endu i używając PPM strzelaj kulami tego bossa.");

        meta.setLore(lore);

        item.setItemMeta(meta);

        dragongun = item;
    }

    private static void createFireballGun() {
        ItemStack item = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eFireballGun");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §bRzadkie");
        lore.add("");
        lore.add("§7Zostań ziewającym ogniem smokiem i używając PPM strzelaj ognistymi kulami.");

        meta.setLore(lore);

        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        fireballgun = item;
    }

    private static void createXrayBow() {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eŁuk ze strzałą zwiadowczą");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §5Epickie");
        lore.add("");
        lore.add("§7W miejscu trafiania wszystkie najbliższe byty są podświetlane na kilka sekund.");

        meta.setLore(lore);

        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        xraybow = item;
    }

    private static void createGrapplingHook() {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eWędka z kotwiczką");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add("");
        lore.add("§7Gdy wybierasz się na wyprawę konieczne weź ze sobą ten gadżet - ułatwi on Ci poruszanie się.");

        meta.setLore(lore);

        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        grapplinghook = item;
    }

    private static void createThorHammer() {
        ItemStack item = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eMłot Thora");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §5Epickie");
        lore.add("");
        lore.add("§7Zostań władcom piorunów niczym Thor i raź piorunem wszystkie uderzone byty.");

        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

       thorhammer = item;
    }

    private static void createTeleportBow() {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eŁuk teleportacji");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §5Epickie");
        lore.add("");
        lore.add("§7Po wystrzale leci Ender Perła i teleportuje w miejsce trafienia!");
        lore.add("§7Lecz uważaj zadaje ona obrażania!");
        lore.add("§c§lUWAGA: §7Ten łuk nie strzela strzałami!");

        meta.setLore(lore);

        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        teleportbow = item;
    }

    private static void createTeleportShard() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eOdłamek teleportacji");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add("");
        lore.add("§7Używaj nowej technologi szczeliny i teleportuj się w wybrane miejsce");
        lore.add("§7nie dalsze niż 8 bloków od Ciebie!");

        meta.setLore(lore);

        item.setItemMeta(meta);

        teleportshard = item;
    }

    private static void createShuriken() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eGhost Shuriken");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §eMityczne");
        lore.add("");
        lore.add("§7Bądź niczym Ninja - w każdej walcze używaj zestawu tych shurikenów,");
        lore.add("§7które potrafią przelatywać przez przeszkody!");
        lore.add("§7Ten przedmiot zawsze do Ciebie wróci po użyciu.");

        meta.setLore(lore);

        item.setItemMeta(meta);

        shuriken = item;
    }

    private static void createAirstrikeBow() {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eŁuk z nalotem");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add("");
        lore.add("§7W miejscu trafienia jest spuszczany śmiercionośny nalot!");
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setLore(lore);

        meta.setCustomModelData(4);

        item.setItemMeta(meta);

        airstrikebow = item;
    }

    private static void createSuperPickaxe() {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§eKilof 6/3/3");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add(" ");
        lore.add("§7Ten kilof ma zwiększony enchant od szybkości kopania!");
        lore.add("§7Jeżeli nie będzie można naprawić go w kowadle użyj §f/repair§7!");
        meta.addEnchant(Enchantment.DIG_SPEED, 6, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        meta.setLore(lore);

        item.setItemMeta(meta);

        superpickaxe = item;
    }

    public static void createFreezerItem() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§bZamrażacz");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add(" ");
        lore.add("§7Zamraża trafionych graczy na 5 sekund!");
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setLore(lore);

        meta.setCustomModelData(2);

        item.setItemMeta(meta);

        freezer = item;
    }

    public static void createLaserItem() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§bLaser");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §eMityczne");
        lore.add(" ");
        lore.add("§7Specjalny laser zadający obrażania trafionym bytom!");
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setLore(lore);

        meta.setCustomModelData(1);

        item.setItemMeta(meta);

        laser = item;
    }

    private static void createNecromancerEgg() {
        ItemStack item = new ItemStack(Material.SKELETON_SPAWN_EGG);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§ePrzywołaj: Necromancer");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add("");
        lore.add("§7Po użyciu tego jajka stoczysz walkę z Necromancerem!");

        meta.setLore(lore);

        item.setItemMeta(meta);

        necromanceregg = item;
    }

    private static void createUndeadWand() {
        ItemStack item = new ItemStack(Material.SUGAR);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§aRóżdżka Nieumarłych");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add("");
        lore.add("§7Ta różdżka posiada dwa tryby strzelania...");
        lore.add("§7PPM - tworzy wokół Ciebie kółko z bytów zadających obrażenia");
        lore.add("§7LPM - tworzy przed Tobą linię z bytów! Jednak odsuń się po strzale");
        lore.add("§7Może ona też zadać obrażenia Tobie!");

        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        undead = item;
    }

    private static void createKnockShield() {
        ItemStack item = new ItemStack(Material.SHIELD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§2Odpychająca tarcza");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add("");
        lore.add("§7Specjalna tarcza, która po użyciu tworzy wokół");
        lore.add("§7Ciebie specjalne odpychające pole!");

        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        knockShield = item;
    }

    private static void createShockwaveSnowball() {
        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§2Śnieżka odrzutu");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §bRzadkie");
        lore.add("");
        lore.add("§7Rzuć tą śnieżkę pod siebie lub kogoś, aby wywołać");
        lore.add("§7specjalny, wyrzucający w powietrze wybuch!");

        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);

        item.setItemMeta(meta);

        shockwaveSnowball = item;
    }

    private static void createDebugItem() {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§dPrzedmiot testowy");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §dDebugowanie");
        lore.add(" ");
        lore.add("§7Specjalny przedmiot do testowania nowych funkcji!");
        meta.addEnchant(Enchantment.DURABILITY, 10, true);

        meta.setLore(lore);

        item.setItemMeta(meta);

        debug = item;
    }

    private static void createInfoPaper() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§fInformacja dotycząca czapek...");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Czapki nie będą dostępna do wytworzenia z pomocą receptury,");
        lore.add("§7są one zarezerwowane dla bossów oraz wykorzystania w specjalnych");
        lore.add("§7wydarzeniach!");
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setLore(lore);

        item.setItemMeta(meta);

        infopaper = item;
    }

    private static void createCrown() {
        ItemStack item = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§6Korona");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add(" ");
        lore.add("§7Ten kto dzierży tą koronę otrzyma specjalny efekt, gdy ma ją na głowie!");

        meta.setLore(lore);

        meta.setCustomModelData(1);

        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        crown = item;
    }

    private static void createHat() {
        ItemStack item = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§6Czapka z daszkiem");

        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Klasa rzadkości: §6Legendarne");
        lore.add(" ");
        lore.add("§7Ten kto ma tą czapkę na głowie otrzyma specjalny efekt Haste!");

        meta.setLore(lore);

        meta.setCustomModelData(2);

        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        hat = item;
    }


    private static void createChristmasHat() {
        ItemStack item = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§cCzapka Mikołaja");

        meta.setCustomModelData(3);

        item.setItemMeta(meta);

        christmashat = item;
    }

    private static void createSantaClausHat() {
        ItemStack item = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§cCzapka Sierżanta Zimy");

        meta.setCustomModelData(6);

        item.setItemMeta(meta);

        santaclaushat = item;
    }
}
