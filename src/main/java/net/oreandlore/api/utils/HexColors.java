package net.oreandlore.api.utils;

import net.md_5.bungee.api.ChatColor;
import net.oreandlore.api.OreNLore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColors {
    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
    private static final char COLOR_CHAR = '§';


    public static String translateHexCodes(String message) {
        return translate(HEX_PATTERN, message, OreNLore.getInstance());
    }

    public static String translateHexCodes(String startTag, String endTag, String message, Essential plugin) {
        Pattern hexPattern = Pattern.compile(startTag + "([a-f0-9]{6})" + endTag);
        return translate(hexPattern, message, plugin);
    }

    private static String translate(Pattern hex, String message, OreNLore plugin) {
        if (plugin.getServerVersion().getVersionInt() < 16) {
            return ChatColor.translateAlternateColorCodes('&', message);
        } else {
            Matcher matcher = hex.matcher(message);
            StringBuffer buffer = new StringBuffer(message.length() + 32);

            while(matcher.find()) {
                String group = matcher.group(1);
                char var10002 = group.charAt(0);
                matcher.appendReplacement(buffer, "§x§" + var10002 + "§" + group.charAt(1) + "§" + group.charAt(2) + "§" + group.charAt(3) + "§" + group.charAt(4) + "§" + group.charAt(5));
            }

            return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
        }
    }
}
