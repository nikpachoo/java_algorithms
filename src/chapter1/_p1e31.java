package chapter1;

import libs.StdDraw;
import libs.StdRandom;

/**
 * exercise 31 from chapter 1 partial 1
 */
public class _p1e31 {
    static public void randomConnectCirclePoints(int N, double p)
    {
        double[][] pointsXY = new double[N][2];
        double radius = 0.3;
        StdDraw.setPenRadius(0.02);
        double alpha = 360 / N;

        double center = 0.5;
        double x0 = center + radius;
        double y0 = center + radius;
        double c = Math.cos(Math.toRadians(alpha));
        double s = Math.sin(Math.toRadians(alpha));

        for (int i = 0; i < N; i++) {
            double rx = x0 - center;
            double ry = y0 - center;
            double x1 = center + rx * c - ry * s;
            double y1 = center + rx * s + ry * c;

            StdDraw.point(x1, y1);
            pointsXY[i][0] = x1;
            pointsXY[i][1] = y1;
            x0 = x1;
            y0 = y1;
        }

        StdDraw.setPenColor(185, 185, 185);
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < pointsXY.length; i++) {
            if (StdRandom.bernoulli(p)) {
                double nextX = i == pointsXY.length - 1 ? pointsXY[0][0] : pointsXY[i + 1][0];
                double nextY = i == pointsXY.length - 1 ? pointsXY[0][1] : pointsXY[i + 1][1];
                StdDraw.line(pointsXY[i][0], pointsXY[i][1], nextX, nextY);
            }
        }
    }
    static public void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        randomConnectCirclePoints(N, p);
    }
}
