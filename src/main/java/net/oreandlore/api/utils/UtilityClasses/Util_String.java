package net.oreandlore.api.utils.UtilityClasses;

import net.oreandlore.api.utils.HexColors;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class Util_String {
    public Util_String() {
    }

    public String TrueFalse_YesNo(boolean Value, boolean Prefix_RedYes_GreenNo, boolean Prefix_RedNo_GreenYes) {
        if (Value) {
            if (Prefix_RedYes_GreenNo) {
                return "&cYes";
            } else {
                return Prefix_RedNo_GreenYes ? "&aYes" : "Yes";
            }
        } else if (Prefix_RedYes_GreenNo) {
            return "&aNo";
        } else {
            return Prefix_RedNo_GreenYes ? "&cNo" : "No";
        }
    }

    public String toInvisible(String original) {
        StringBuilder hiddenText = new StringBuilder();
        char[] var3 = original.toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char c = var3[var5];
            hiddenText.append('§');
            hiddenText.append(c);
        }

        return hiddenText.toString();
    }

    public String toInvisible(Integer original) {
        return this.toInvisible(String.valueOf(original));
    }

    public <E extends Enum<E>> String enumValuesToString(Class<E> enumClass) {
        StringBuilder list = new StringBuilder();
        EnumSet.allOf(enumClass).forEach((E) -> {
            list.append("&2").append(E).append("&c/");
        });
        return list.toString();
    }

    public <E extends Enum<E>> ArrayList<String> enumValuesToStringList(Class<E> enumClass) {
        ArrayList<String> Values = new ArrayList();
        EnumSet.allOf(enumClass).forEach((E) -> {
            Values.add(E.name().toLowerCase());
        });
        return Values;
    }

    public String fromInvisible(String orginal) {
        return orginal.replaceAll("§", "");
    }

    public String FString(String Message) {
        return HexColors.translateHexCodes(Message);
    }

    public String centerTitleInGui(String title) {
        StringBuilder result = new StringBuilder();
        int spaces = 24 - ChatColor.stripColor(title).length();

        for(int i = 0; i < spaces; ++i) {
            result.append(" ");
        }

        return result.append(title).toString();
    }

    public ArrayList<String> FStringList(ArrayList<String> Stringlist) {
        ArrayList<String> Formatted = new ArrayList();
        Iterator var3 = Stringlist.iterator();

        while(var3.hasNext()) {
            String messages = (String)var3.next();
            Formatted.add(this.FString(messages));
        }

        return Formatted;
    }

    public String CString(String Message) {
        return ChatColor.stripColor(Message);
    }

    public String LocationXYZToString(Location location) {
        return location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ();
    }

    public String GetProgressBar(int Lenght, int Postion, String Segment, String ColorLoading, String ColorRest) {
        StringBuilder Bar = new StringBuilder();

        for(int i = 0; i < Lenght; ++i) {
            Bar.append(Segment);
        }

        if (Postion >= Lenght) {
            return ColorLoading + Bar;
        } else {
            String FullBar = Bar.toString();
            FullBar = ColorLoading + FullBar.substring(0, Postion) + ColorRest + FullBar.substring(Postion - 1, FullBar.length() - 1);
            return this.FString(FullBar);
        }
    }

    public String RemoveEndChars(String s, int AmountToRemove) {
        return s != null && s.length() != 0 ? s.substring(0, s.length() - AmountToRemove) : s;
    }

    public String MillsToSecondsOneDecimalPlace(Long Mills) {
        double doubleVal = (double)Mills / 1000.0D;
        String doubleString = String.valueOf(doubleVal);
        String[] Parts = doubleString.split("\\.");
        int WholeSize = Parts[0].length();
        int DecimalSize = Parts[1].length();
        if (DecimalSize <= 1) {
            return doubleString + "s";
        } else {
            doubleString = doubleString.substring(0, WholeSize + 2);
            return doubleString + "s";
        }
    }
    public boolean isBoolean(String parameter) {
        if ( String.valueOf(parameter).equalsIgnoreCase("true") || String.valueOf(parameter).equalsIgnoreCase("false") ) {
            return true;
        }
        return false;
    }
}
