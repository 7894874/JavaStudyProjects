public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {

        /// Возведение в степень числа radius с показателем 2 (квадрат)
        int b1 = 2;
        return Math.PI * Math.pow(radius, b1);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {

        int b1 = 3;
        if (radius < 0) {
            return -4 * (Math.PI * Math.pow(radius, b1)) / 3;
        } else {
            return 4 * (Math.PI * Math.pow(radius, b1)) / 3;
        }

    }

    public static boolean isTrianglePossible(double a, double b, double c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        if (a > 10 || b > 10 || c > 10) {
            return false;
        } else {
            return true;
        }

    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {

        boolean yaTriangleIsPossible = isTrianglePossible(a, b, c);

        if (yaTriangleIsPossible) {

            double p = (a + b + c) / 2;
            double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));

            return S;

        } else {
            return -1.0;
        }
    }
}
