FutureValue(n) = FutureValue(n-1) * (1 + growthRate)
public class Main {
    public static void main(String[] args) {
        double initialValue = 10000;
        double growthRate = 0.08; // 8%
        int years = 5;

        double forecast = forecastRecursive(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: ₹%.2f%n", years, forecast);
    }

    public static double forecastRecursive(double value, double rate, int years) {
        if (years == 0) return value;
        return forecastRecursive(value, rate, years - 1) * (1 + rate);
    }
}
