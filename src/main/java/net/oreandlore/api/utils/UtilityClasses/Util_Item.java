package net.oreandlore.api.utils.UtilityClasses;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Util_Item {
    public Util_Item() {
    }

    public boolean IsNotValidMaterial(String value) {
        try {
            Material var2 = Material.valueOf(value);
            return false;
        } catch (Exception var3) {
            return true;
        }
    }

    public int removeItem(Inventory inventory, ItemStack ItemR, int quantity) {
        int rest = quantity;

        for(int i = 0; i < inventory.getSize(); ++i) {
            ItemStack stack = inventory.getItem(i);
            if (stack != null && ItemR != null && stack.getType() == ItemR.getType() && stack.getDurability() == ItemR.getDurability() && stack.getItemMeta().equals(ItemR.getItemMeta())) {
                if (rest >= stack.getAmount()) {
                    rest -= stack.getAmount();
                    inventory.clear(i);
                } else {
                    if (rest <= 0) {
                        break;
                    }

                    stack.setAmount(stack.getAmount() - rest);
                    rest = 0;
                }
            }
        }

        return quantity - rest;
    }

    public int removeItem(Inventory inventory, Material material, int quantity) {
        int rest = quantity;

        for(int i = 0; i < inventory.getSize(); ++i) {
            ItemStack stack = inventory.getItem(i);
            if (stack != null && stack.getType() == material) {
                if (rest >= stack.getAmount()) {
                    rest -= stack.getAmount();
                    inventory.clear(i);
                } else {
                    if (rest <= 0) {
                        break;
                    }

                    stack.setAmount(stack.getAmount() - rest);
                    rest = 0;
                }
            }
        }

        return quantity - rest;
    }

    public boolean HasDisplayName(ItemStack itemStack) {
        if (itemStack != null && itemStack.getType() != Material.AIR && itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            return itemMeta.hasDisplayName();
        } else {
            return false;
        }
    }
}
