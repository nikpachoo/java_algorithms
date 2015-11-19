package chapter1.partial2;

import libs.StdDraw;

import java.util.Comparator;

/**
 * Point 2D
 */
public final class Point2D implements Comparable<Point2D> {
    private final double x;
    private final double y;

    /**
     * Compares two points by x-coordinate.
     */
    public static final Comparator<Point2D> X_ORDER = new XOrder();

    /**
     * Compares two points by y-coordinate.
     */
    public static final Comparator<Point2D> Y_ORDER = new YOrder();


    public Point2D (double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    /**
     * Вычисление растояния r, полярной координаты для точки
     * (расстояние от полюса до точки в системе поляных координат)
     * @return
     */
    public double r() {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Вычисление полярного угла
     * @return
     */
    public double theta() {
        return Math.atan2(y, x);
    }

    /**
     * Returns the Euclidean distance between this point and that point.
     * @param that
     * @return
     */
    public double distTo(Point2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * Draw point
     */
    public void draw() {
        StdDraw.point(x, y);
    }

    public int compareTo(Point2D that) {
        if (this.y > that.y) return +1;
        if (this.y < that.y) return -1;
        if (this.x > that.x) return +1;
        if (this.x < that.x) return -1;
        return 0;
    }

    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x > q.x) return 1;
            if (p.x == q.x) return 0;
            return -1;
        }
    }

    private static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.y > q.y) return 1;
            if (p.y == q.y) return 0;
            else return -1;
        }
    }
}
