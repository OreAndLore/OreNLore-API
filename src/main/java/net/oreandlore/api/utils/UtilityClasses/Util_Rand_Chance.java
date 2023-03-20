package net.oreandlore.api.utils.UtilityClasses;

import java.util.Random;

public class Util_Rand_Chance {
    private final Random rand = new Random();
    private final String[] ColorOnlyCodes = new String[]{"&a", "&b", "&c", "&d", "&e", "&f", "&1", "&2", "&3", "&4", "&5", "&6", "&7", "&8", "&9"};

    public Util_Rand_Chance() {
    }

    public int randInt(int n1, int n2) {
        if (n1 == n2) {
            return n1;
        } else {
            int min = n1 > n2 ? n2 : n1;
            int max = n1 > n2 ? n1 : n2;
            return this.rand.nextInt(max - min + 1) + min;
        }
    }

    public int randIntRangedFromInt(int baseInt, int rangeMax) {
        int min = baseInt - rangeMax;
        int max = baseInt + rangeMax;
        return this.randInt(min, max);
    }

    public int randIntRangedFromInt(int baseInt, int rangeMax, int rangeMin) {
        int minmin = baseInt - rangeMin;
        int minmax = baseInt - rangeMax;
        int maxmin = baseInt + rangeMin;
        int maxmax = baseInt + rangeMax;
        this.randInt(minmin, minmax);
        this.randInt(maxmin, maxmax);
        return this.PercentChance(50) ? rangeMax : -rangeMin;
    }

    public double randDouble(double n1, double n2) {
        if (n1 == n2) {
            return n1;
        } else {
            double min = n1 > n2 ? n2 : n1;
            double max = n1 > n2 ? n1 : n2;
            return Math.random() * (max - min) + min;
        }
    }

    public float randFloat(float n1, float n2) {
        if (n1 == n2) {
            return n1;
        } else {
            double min = n1 > n2 ? (double)n2 : (double)n1;
            double max = n1 > n2 ? (double)n1 : (double)n2;
            return (float)(Math.random() * (max - min) + min);
        }
    }

    public boolean oneIn(int Chance) {
        return this.randInt(0, Chance) == 1;
    }

    public String randColorCode() {
        return this.ColorOnlyCodes[this.randInt(0, this.ColorOnlyCodes.length - 1)];
    }

    public boolean PercentChance(int Chance) {
        return Math.random() * 100.0D < (double)Chance;
    }

    public boolean FinePercentChance(double Chance) {
        double Result = this.randDouble(0.01D, 100.0D);
        double factor = 100.0D;
        Result = (double)Math.round(Result * 100.0D) / 100.0D;
        return Result <= Chance;
    }
}

