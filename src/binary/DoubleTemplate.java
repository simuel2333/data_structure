package binary;

public class DoubleTemplate {
    boolean check(double mid) {
        return false;
    }

    double binarySearch(double p, double r) {
        double eps = 1e-8;
        while (r - p > eps) {
            double mid = (p + r) / 2;
            if(check(mid)) p = mid;
            else r = mid;
        }
        return p;
    }


}
