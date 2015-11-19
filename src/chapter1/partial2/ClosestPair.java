package chapter1.partial2;

import libs.StdDraw;
import libs.StdOut;
import libs.StdRandom;

import java.util.Arrays;

/**
 * Client for Point2D
 * Draw N points and find a closets pair
 * http://www.cs.ucsb.edu/~suri/cs235/ClosestPair.pdf
 */
public class ClosestPair {
    private Point2D best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;

    public ClosestPair(Point2D[] points) {
        int size = points.length;

        if (size <= 1) {
            return;
        }

        // points [{5, 6}, {1, 10}, {1, 2}, {3, 4}]
        Point2D[] pointsByX = new Point2D[size];

        for (int i = 0; i < size; i++) {
            pointsByX[i] = points[i];
        }

        /**
         * Sort array by X coordinate
         * O = n lg(n)
         */
        Arrays.sort(pointsByX, Point2D.X_ORDER);

        // poinsByX = [{1, 10}, {1, 2}, {3, 4}, {5, 6}]

        /**
         * Check for coincident points
         */
        for (int i = 0; i < size - 1; i++) {
            if (points[i].equals(points[i + 1])) {
                bestDistance = 0.0;
                best1 = points[i];
                best2 = points[i + 1];
            }
        }

        /**
         * make array sorted by Y coordinate
         * (but not yet sorted)
         */
        Point2D pointsByY[] = new Point2D[size];

        for (int i = 0; i < size; i++) {
            pointsByY[i] = pointsByX[i];
        }

        // pointsByY = [{1, 10}, {1, 2}, {3, 4}, {5, 6}]

        /**
         * auxiliary array
         */
        Point2D aux[] = new Point2D[size];

        closest(pointsByX, pointsByY, aux, 0, size - 1);
    }

    /**
     * find closest pair of points in pointsByX[lo..hi]
     * precondition:  pointsByX[lo..hi] and pointsByY[lo..hi] are the same sequence of points
     * precondition:  pointsByX[lo..hi] sorted by x-coordinate
     * postcondition: pointsByY[lo..hi] sorted by y-coordinate
     * @param pointsByX
     * @param pointsByY
     * @param aux
     * @param lo
     * @param hi
     */
    private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int lo, int hi) {
        /**
         * 1 recursive
         * pointsByX , pointsByY = [{1, 10}, {1, 2}, {3, 4}, {5, 6}],
         * aux = [], lo = 0, hi = 3
         *
         * 2 recursive call
         * pointsByX , pointsByY = [{1, 10}, {1, 2}, {3, 4}, {5, 6}],
         * aux = [], lo = 0, hi = 1
         *
         * 3 recursive call
         *
         */

        if (hi <= lo) return Double.POSITIVE_INFINITY;

        /**
         * middle of array
         */
        int mid = (hi - lo) / 2 + lo;
        // 1 recursive: mid = 1;
        // 2 recursive: mid = 0;

        Point2D median = pointsByX[mid];
        // 1 recursive: median {1, 2}
        // 2 recursive: median {1, 10}

        // compute closest pair with both endpoints in left subarray or both in right subarray
        double delta1 = closest(pointsByX, pointsByY, aux, lo, mid);
        // 2 recursive: delta1 INFINITY

        double delta2 = closest(pointsByX, pointsByY, aux, mid + 1, hi);
        // 2 recursive: delta2 INFINITY

        double delta = Math.min(delta1, delta2);
        // 2 recursive: delta INFINITY

        // merge back so that pointsByY[lo..hi] are sorted by y-coordinate
        merge(pointsByY, aux, lo, mid, hi);
        // 2 recursive: pre: pointsByY = [{1, 10}, {1, 2}, {3, 4}, {5, 6}], aux = 0, lo = 0, mid = 0, hi = 1
        //              post: pointsByY = [{1, 2}, {1, 10}, {3, 4}, {5, 6}]

        // 1 recursive: post pointsByY = [{1, 2}, {3, 4}, {5, 6}, {1, 10}],

        // aux[0..M-1] = sequence of points closer than delta, sorted by y-coordinate
        int M = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pointsByY[i].x() - median.x()) < delta)
                aux[M++] = pointsByY[i];
        }
        /**
         * 2 recursive: aux = [{1, 2}, {1, 10}, null, null]
         * M = 2
         */

        // compare each point to its neighbors with y-coordinate closer than delta
        for (int i = 0; i < M; i++) {
            /**
             * 2 recursive:
             * i = 0, M = 2, j = 1,
             */
            // a geometric packing argument shows that this loop iterates at most 7 times
            for (int j = i + 1; (j < M) && (aux[j].y() - aux[i].y() < delta); j++) {
                double distance = aux[i].distTo(aux[j]);

                if (distance < delta) {
                    delta = distance;

                    if (distance < bestDistance) {
                        bestDistance = distance;
                        best1 = aux[i];
                        best2 = aux[j];
                    }
                }
            }
        }

        return delta;
    }

    /**
     * stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
     * precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Point2D[] a, Point2D[] aux, int lo, int mid, int hi) {
        /**
         * 1 call from 2 recursive
         * a - [{1, 10}, {1, 2}, {3, 4}, {5, 6}], aux - [], lo - 0, mid - 0, hi - 1
         */


        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        /**
         * 1 call from 2 recursive
         * [{1, 10}, {1, 2}, null, null]
         */

        // merge back to a[]
        int i = lo, j = mid + 1;
        // i = 0
        // j = 1

        for (int k = lo; k <=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
            // 1 iteration a = [{1, 2}, {1, 2}, {3, 4}, {5, 6}], i = 0, mid = 0, hi = 1, k = 1, j = 2;
            // 2 iteration a = [{1, 2}, {1, 10}, {3, 4}, {5, 6}] end

            // for [{5, 6}, {1, 10}, {1, 2}, {3, 4}]
            // 1 iteration a = [{1, 2}, {1, 10}, {1, 2}, {3, 4}], i = 0, mid = 1, hi = 3, k = 1, j = 3;
            // 2 iteration a = [{1, 2}, {3, 4}, {1, 2}, {3, 4}] i = 0, mid = 1, hi = 3, k = 2, j = 4;
            // 3 iteration a = [{1, 2}, {3, 4}, {5, 6}, {3, 4}] i = 1, mid = 1, hi = 3, k = 3, j = 4;
            // 4 iteration a = [{1, 2}, {3, 4}, {5, 6}, {1, 10}] i = 2, mid = 1, hi = 3, k = 4, j = 4;
        }
    }

    /**
     * is v less w ?
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Point2D v, Point2D w) {
        // {3, 4} - {1, 2}
        return v.compareTo(w) < 0;
    }

    public Point2D either() {
        return best1;
    }

    public Point2D other() {
        return best2;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] arr = new Point2D[N];

        for (int i = 0; i < N; i++) {
            Point2D point = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            arr[i] = point;
        }

        ClosestPair closest = new ClosestPair(arr);

        for (int i = 0; i < arr.length; i++) {
            StdDraw.setPenRadius(0.010);

            if (arr[i].equals(closest.either()) || arr[i].equals(closest.other())) {
                StdDraw.setPenRadius(0.020);
            }

            StdOut.println(arr[i].x() + "  " + arr[i].y());
            StdDraw.point(arr[i].x(), arr[i].y());
        }
    }
}
