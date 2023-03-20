package net.oreandlore.api.utils.UtilityClasses;

import net.oreandlore.api.utils.JsonMessageCreator;
import net.oreandlore.api.utils.Util;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Util_Player {
    private final boolean PrefixChat = true;
    private final String ChatPrefix = "";

    public Util_Player() {
    }

    public void sendMessage(Player p, String messageToSend) {
        p.sendMessage(Util.STRING.FString("" + messageToSend));
    }
    public void sendMessage(Player p, String... messageToSend) {
        for (String msg : messageToSend) {
            p.sendMessage(Util.STRING.FString("" + msg));
        }
    }
    public void sendMessage(CommandSender p, String messageToSend) {
        p.sendMessage(Util.STRING.FString("" + messageToSend));
    }
    public void sendMessage(CommandSender p, String... messageToSend) {
        for (String msg : messageToSend) {
            p.sendMessage(Util.STRING.FString("" + msg));
        }
    }

    public void sendMessageToOps(String message) {
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player p = (Player)var2.next();
            if (p.isOp()) {
                this.sendMessage(p, "&6[&cOp Only&6] &c" + message);
            }
        }

    }

    public void sendMessageToOps_Clean(String message) {
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player p = (Player)var2.next();
            if (p.isOp()) {
                p.sendMessage(Util.STRING.FString(message));
            }
        }

    }

    public void sendMessageWithHover(Player p, String message, String hovermessage) {
        p.spigot().sendMessage(JsonMessageCreator.getComponent("" + message, hovermessage));
    }

    public void sendMessageWithHover(Player p, String message, String[] hovermessage) {
        p.spigot().sendMessage(JsonMessageCreator.getComponent("" + message, hovermessage));
    }

    public void sendMessageWithHover(Player p, String m, String h, Action action, String actionResult) {
        p.spigot().sendMessage(JsonMessageCreator.getComponent("" + m, h, actionResult, action));
    }

    public boolean hasEmptyMainHand(Player p) {
        ItemStack Hand = p.getInventory().getItemInMainHand();
        return Hand == null || Hand.getType() == Material.AIR;
    }

    public void sendActionBar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
    }

    public void givePlayerItem(Player p, ItemStack itemStack) {
        HashMap<Integer, ItemStack> ItemsLeft = p.getInventory().addItem(new ItemStack[]{itemStack});
        if (!ItemsLeft.isEmpty()) {
            this.sendMessage(p, "&cSome items where drop on the ground. Your inventory was full");
            Iterator var4 = ItemsLeft.values().iterator();

            while(var4.hasNext()) {
                ItemStack left = (ItemStack)var4.next();
                Item item = p.getWorld().dropItem(p.getEyeLocation(), left);
                item.setVelocity(new Vector(0, 0, 0));
            }
        }

    }

    public void sendTitle(Player p, String Title, String Subtitle, int Stay) {
        p.sendTitle(Util.STRING.FString(Title), Util.STRING.FString(Subtitle), 10, Stay, 10);
    }

    public int getFreeInvSlot_upperInv(Player p) {
        for(int i = 9; i <= 35; ++i) {
            ItemStack itemStack = p.getInventory().getItem(i);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                return i;
            }
        }

        return -1;
    }

    public boolean hasClearInv(Player p) {
        return p.getInventory().getContents().length == 0;
    }

    public boolean hasClearArmour(Player p) {
        return p.getInventory().getArmorContents().length == 0;
    }

    public boolean hasClearInvAndArmor(Player p) {
        return this.hasClearInv(p) && this.hasClearArmour(p);
    }

    public boolean hasPerm(Player p, String Perm) {
        return p.isOp() || p.hasPermission("*") || p.hasPermission(Perm);
    }
    public boolean hasPerm(CommandSender p, String Perm) {
        return p.isOp() || p.hasPermission("*") || p.hasPermission(Perm);
    }

    public void clearInv(Player p) {
        if (p != null) {
            p.getInventory().clear();
            p.updateInventory();
            p.getInventory().setHelmet(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setBoots(null);
            p.updateInventory();
        }

    }

    public ArrayList<String> getPlayerNamesListForTabComplete() {
        ArrayList<String> Names = new ArrayList();
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player online = (Player)var2.next();
            Names.add(online.getName());
        }

        return Names;
    }

    public boolean isInWater(Player p) {
        Block block = p.getLocation().getBlock();
        return block.getType() == Material.WATER;
    }

    public boolean wouldBeDeadAfterDamage(Player p, double Damage) {
        return p.getHealth() - Damage <= 0.0D;
    }
}
