package net.oreandlore.api.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public class JsonMessageCreator {
    public JsonMessageCreator() {
    }

    public static BaseComponent getComponent(String Message, String HoverMessage) {
        TextComponent Comp = new TextComponent(ChatColor.translateAlternateColorCodes('&', Message));
        Comp.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new BaseComponent[]{new TextComponent(ChatColor.translateAlternateColorCodes('&', HoverMessage))}));
        return Comp;
    }

    public static BaseComponent getComponent(String Message, String[] HoverMessage) {
        BaseComponent[] HoverMessages = new BaseComponent[10];

        for(int i = 0; i < HoverMessage.length; ++i) {
            HoverMessages[i] = new TextComponent(ChatColor.translateAlternateColorCodes('&', HoverMessage[i]));
        }

        TextComponent Comp = new TextComponent(ChatColor.translateAlternateColorCodes('&', Message));
        Comp.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, HoverMessages));
        return Comp;
    }

    public static BaseComponent getComponent(String Message, String HoverMessage, String ClickValue, ClickEvent.Action ClickAction) {
        TextComponent Comp = new TextComponent(ChatColor.translateAlternateColorCodes('&', Message));
        Comp.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new BaseComponent[]{new TextComponent(ChatColor.translateAlternateColorCodes('&', HoverMessage))}));
        Comp.setClickEvent(new ClickEvent(ClickAction, ClickValue));
        return Comp;
    }

    public static BaseComponent getComponent(String Message, String[] HoverMessage, String ClickValue, ClickEvent.Action ClickAction) {
        BaseComponent[] HoverMessages = new BaseComponent[10];

        for(int i = 0; i < HoverMessage.length; ++i) {
            HoverMessages[i] = new TextComponent(ChatColor.translateAlternateColorCodes('&', HoverMessage[i]));
        }

        TextComponent Comp = new TextComponent(ChatColor.translateAlternateColorCodes('&', Message));
        Comp.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, HoverMessages));
        Comp.setClickEvent(new ClickEvent(ClickAction, ClickValue));
        return Comp;
    }
}
