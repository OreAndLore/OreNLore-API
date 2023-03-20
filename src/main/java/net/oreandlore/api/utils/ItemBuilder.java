package net.oreandlore.api.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ItemBuilder {
    private static final Material[] LEATHER_ARMOUR;
    private final Material material;
    private final ArrayList<Integer> LeatherAmourRGB = new ArrayList();
    private byte Durability = 0;
    private String DisplayName = "";
    private ArrayList<String> Lore = new ArrayList();
    private int Amount = 1;
    private boolean NotStackable = false;
    private boolean GUIBound = false;
    private boolean GUIClickable = false;

    public ItemBuilder(Material material) {
        this.material = material;
    }

    public ItemBuilder(ItemStack itemStack) {
        this.material = itemStack.getType();
        this.Amount = itemStack.getAmount();
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta instanceof Damageable) {
                Damageable damageable = (Damageable)itemMeta;
                this.Durability = (byte)damageable.getDamage();
            }

            if (itemMeta.hasLore()) {
                this.Lore = (ArrayList)itemMeta.getLore();
            }

            if (itemMeta.hasDisplayName()) {
                this.DisplayName = itemMeta.getDisplayName();
            }
        }

    }

    public static ItemBuilder I(Material material) {
        return new ItemBuilder(material);
    }

    public static ItemBuilder I(ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material, this.Amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (this.NotStackable) {
            this.Lore.add(Util.STRING.toInvisible(Util.RAND_CHANCE.randInt(0, 999999999)));
        }

        itemMeta.setLore(Util.STRING.FStringList(this.Lore));
        if (this.GUIBound) {
            this.DisplayName = net.oreandlore.api.utils.HiddenStringTags.GuiBoundItem.Add(this.DisplayName);
        }

        if (this.GUIClickable) {
            this.DisplayName = net.oreandlore.api.utils.HiddenStringTags.ClickableGuiItem.Add(this.DisplayName);
        }

        itemMeta.setDisplayName(Util.STRING.FString(this.DisplayName));
        if (this.Durability > 0 && itemMeta instanceof Damageable) {
            Damageable damageable = (Damageable)itemMeta;
            damageable.setDamage(this.Durability);
        }

        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(itemMeta);
        if (this.LeatherAmourRGB.size() == 3 && Arrays.asList(LEATHER_ARMOUR).contains(this.material)) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
            leatherArmorMeta.setColor(Color.fromRGB((Integer)this.LeatherAmourRGB.get(0), (Integer)this.LeatherAmourRGB.get(1), (Integer)this.LeatherAmourRGB.get(2)));
            itemStack.setItemMeta(leatherArmorMeta);
        }

        return itemStack;
    }

    public ItemBuilder setDurability(int Durability) {
        this.Durability = (byte)Durability;
        return this;
    }

    public ItemBuilder setDisplayname(String DisplayName) {
        this.DisplayName = DisplayName;
        return this;
    }

    public ItemBuilder setLore(ArrayList<String> lore) {
        this.Lore = lore;
        return this;
    }

    public ItemBuilder setLore(String[] Lore) {
        this.Lore = new ArrayList(Arrays.asList(Lore));
        return this;
    }

    public ItemBuilder addLore(String Line) {
        this.Lore.add(Line);
        return this;
    }

    public ItemBuilder addLore(String... Lines) {
        Collections.addAll(this.Lore, Lines);
        return this;
    }

    public ItemBuilder addLore(ArrayList<String> Lines) {
        this.Lore.addAll(Lines);
        return this;
    }

    public ItemBuilder insertLore(ArrayList<String> Lines, int FromIndex) {
        this.Lore.addAll(FromIndex, Lines);
        return this;
    }

    public ItemBuilder insertLore(String[] Lines, int FromIndex) {
        this.Lore.addAll(FromIndex, Arrays.asList(Lines));
        return this;
    }

    public ItemBuilder removeLore(int Index) {
        if (this.Lore.size() - 1 >= Index) {
            this.Lore.remove(Index);
        }

        return this;
    }

    public ItemBuilder removeLore(int[] Indexs) {
        int[] var2 = Indexs;
        int var3 = Indexs.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int index = var2[var4];
            this.removeLore(index);
        }

        return this;
    }

    public ItemBuilder setAmount(int Amount) {
        this.Amount = Amount;
        return this;
    }

    public ItemBuilder setNotStackable() {
        this.NotStackable = true;
        return this;
    }

    public ItemBuilder setGUIBound() {
        this.GUIBound = true;
        return this;
    }

    public ItemBuilder setGUIClickable() {
        this.GUIClickable = true;
        return this;
    }

    public ItemBuilder setLeatherArmorColor_RGB(int R, int G, int B) {
        this.LeatherAmourRGB.clear();
        this.LeatherAmourRGB.add(R);
        this.LeatherAmourRGB.add(G);
        this.LeatherAmourRGB.add(B);
        return this;
    }

    public ItemBuilder setLeatherArmorColor_Color(Color color) {
        this.setLeatherArmorColor_RGB(color.getRed(), color.getGreen(), color.getBlue());
        return this;
    }

    static {
        LEATHER_ARMOUR = new Material[]{Material.LEATHER_BOOTS, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_HELMET};
    }
}
