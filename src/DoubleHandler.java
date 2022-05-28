public class DoubleHandler {

    // THIS CLASS SERVE TO FIX ISSUES CAUSED BY "* 2 ^ EXP" DOUBLE REPRESENTATION:

    static double correctFloatValue(double number) {
        // USING SIMPLE MATH OPERATIONS TO EASILY FIX .0001 and .9999 ISSUES
        number=Math.round(number*100);
        number=number/100;
        return number;
    }
}
