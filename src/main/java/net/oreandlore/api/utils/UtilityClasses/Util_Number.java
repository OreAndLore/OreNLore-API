package net.oreandlore.api.utils.UtilityClasses;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Util_Number {
    public Util_Number() {
    }

    public int CalculatePercent(int Percent, int Value) {
        return Value / 100 * Percent;
    }

    public int AddPercent(int ToAddTo, int Percent) {
        return ToAddTo / 100 * Percent + ToAddTo;
    }

    public double RoundDouble(double Value, int DecimalPlaces) {
        if (DecimalPlaces <= 0) {
            DecimalPlaces = 1;
        }

        StringBuilder Format = new StringBuilder();
        Format.append("#.");

        for(int i = 0; i < DecimalPlaces; ++i) {
            Format.append("#");
        }

        DecimalFormat df = new DecimalFormat(Format.toString());
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(Value));
    }

    public boolean IsNotInt(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException var3) {
            return true;
        }
    }

    public int GetDifferance(int i1, int i2) {
        return i1 >= i2 ? i1 - i2 : i2 - i1;
    }

    public double GetDifferance(double i1, double i2) {
        return i1 >= i2 ? i1 - i2 : i2 - i1;
    }

    public boolean isNotDouble(String s) {
        try {
            Double.parseDouble(s);
            return false;
        } catch (NumberFormatException var3) {
            return true;
        }
    }

    public float toDegree(double angle) {
        return (float)Math.toDegrees(angle);
    }

    public boolean IsWithin(int NumberCheaking, int Num1, int Num2, Boolean IncludingNum1Num2) {
        int Min = Num1 < Num2 ? Num1 : Num2;
        int Max = Num1 > Num2 ? Num1 : Num2;
        if (IncludingNum1Num2) {
            return NumberCheaking <= Max && NumberCheaking >= Min;
        } else {
            return NumberCheaking < Max && NumberCheaking > Min;
        }
    }

    public boolean IsWithin(double NumberCheaking, double Num1, double Num2, Boolean IncludingNum1Num2) {
        double Min = Num1 < Num2 ? Num1 : Num2;
        double Max = Num1 > Num2 ? Num1 : Num2;
        if (IncludingNum1Num2) {
            return NumberCheaking <= Max && NumberCheaking >= Min;
        } else {
            return NumberCheaking < Max && NumberCheaking > Min;
        }
    }
}