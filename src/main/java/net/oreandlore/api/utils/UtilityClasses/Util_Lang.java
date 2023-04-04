package net.oreandlore.api.utils.UtilityClasses;

import net.oreandlore.api.OreNLore;
import net.oreandlore.api.utils.HexColors;
import org.bukkit.entity.Player;

public class Util_Lang {
    public String prefix() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("prefix"));
    }
    public String noPerm() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("no-perm"));
    }
    public String invalidUsage() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("invalid-usage"));
    }
    public String errorMsg() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("error-msg"));
    }
    public String errorCmdMsg() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("error-cmd-msg"));
    }
    public String mustBeNumber(int num) {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("must-be-number").replace("{num}", String.valueOf(num)));
    }
    public String mustBeString(String string) {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("must-be-string").replace("{string}", string));
    }
    public String minLength(int min) {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("min-length").replace("{min}", String.valueOf(min)));
    }
    public String maxLength(int max) {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("max-length").replace("{max}", String.valueOf(max)));
    }
    public String notAllowedOnConsole() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("not-allowed-on-console"));
    }
    public String onlyAllowedOnConsole() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("only-allowed-on-console"));
    }
    public String couldNotFindPlayer(String player) {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("could-not-find-player").replace("{player}", player));
    }
    public String noCmdMatched() {
        return HexColors.translateHexCodes(OreNLore.getInstance().getLang().getString("no-command-matched"));
    }
}
