// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package Misc;

import java.util.Arrays;

    /**
 * linearInterpolator - given a table of x and y values, will interpolate values
 * of y between known values of x using linear interpolation.
 * 
 * Usage: private double[][] data = { {1.0, 10.0}, {3.0, 31.0}, {10,100} };
 * private linearInterpolator lt = new linearInterpolator(data);
 * 
 * double y = lt.getInterpolatedValue(1.5); // returns 15.25
 */

public class LinearInterpolator {


    private double[][] table;
    private boolean initialized = false;


    /** Create LinearInterpolator class
     * @param data, a table of x -> y mappings to be interpolated */
    public LinearInterpolator (double[][] data) {
        build_table(data);
    }


    /** @param data a table of data to be interpolated */
    private void build_table (double[][] data) {
        int rows = data.length;

        if (rows < 1) {
            System.out.println("ERROR: Linear Interpolator needs at least one point");
            return;
        }
        int cols = data[0].length;

        if (cols !=2) {
            System.out.println("ERROR: Number of columns should be 2");
            return;
        }

        table = new double[rows][cols];
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[x].length; y++) {
                table[x][y] = data[x][y];
            }
        }
        Arrays.sort(table, (a, b) -> Double.compare(a[0], b[0]));
        initialized = true;
    }
        public double getInterpolatedValue (double x) {
            if (!initialized) {
                System.out.println("ERROR: Number of columns should be true");
                return 0.0;
            }
        int index = 0;
        for (index = 0; index < table.length; index++) {
            if (table[index][0] >= x) {
                break;
            }
        }

        if (index >= table.length) {
            return table[table.length -1][1];
        }

        double high_y = table[index][1];
        double high_x = table[index][0];

        if ((high_x == x) || index == 0) {
            return high_y;
        }

        double low_y = table[index - 1][1];
        double low_x = table[index - 1][0];

        return (low_y + (x - low_x) * (high_y - low_y) / (high_x - low_x));
    }
}