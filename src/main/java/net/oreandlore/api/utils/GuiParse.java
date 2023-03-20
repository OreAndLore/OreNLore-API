package net.oreandlore.api.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiParse {
    private final boolean IsItem;
    private final boolean IsClickableItem;
    private final String InvName;
    private final String itemClickedName;
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public GuiParse(boolean isItem, boolean isClickableItem, String invName, String itemClickedName, ItemStack itemStack, ItemMeta itemMeta) {
        this.IsItem = isItem;
        this.IsClickableItem = isClickableItem;
        this.InvName = invName;
        this.itemClickedName = itemClickedName;
        this.itemStack = itemStack;
        this.itemMeta = itemMeta;
    }

    public boolean isClickableItem() {
        return this.IsClickableItem;
    }

    public String getItemClickedName() {
        return this.itemClickedName;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public ItemMeta getItemMeta() {
        return this.itemMeta;
    }

    public String getInvName() {
        return this.InvName;
    }

    public boolean isItem() {
        return this.IsItem;
    }
}
