package com.mozz.htmlnative.common;

import android.graphics.Color;
import android.util.TypedValue;

import junit.framework.Assert;

import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Yang Tao, 17/3/13.
 */
public class ParametersUtilsTest {
    @Test
    public void closeQuitely() throws Exception {
        Closeable closeable = null;
        IOUtils.closeQuietly(closeable);

        closeable = new Closeable() {
            @Override
            public void close() throws IOException {

            }
        };

        IOUtils.closeQuietly(closeable);
    }

    @Test
    public void color() throws Exception {
        String color1 = "#ff0000";
        Assert.assertTrue(ParametersUtils.color(color1) == Color.RED);

        String color2 = "#f00";
        Assert.assertTrue(ParametersUtils.color(color2) == Color.RED);

        String color3 = "#ffff0000";
        Assert.assertTrue(ParametersUtils.color(color3) == Color.RED);
    }

    @Test
    public void toInt() throws Exception {

    }

    @Test
    public void toFloat() throws Exception {

    }

    @Test
    public void px() throws Exception {

    }

    @Test
    public void toBoolean() throws Exception {

    }

    @Test
    public void toPixel() throws Exception {
        String a = "1px";
        PixelValue p = ParametersUtils.toPixel(a);

        org.junit.Assert.assertTrue(p.getUnit() == TypedValue.COMPLEX_UNIT_PX);
        org.junit.Assert.assertTrue(p.getValue() == 23);

        a = "123.5dp";
        p = ParametersUtils.toPixel(a);

        org.junit.Assert.assertTrue(p.getUnit() == TypedValue.COMPLEX_UNIT_DIP);
        org.junit.Assert.assertTrue(p.getValue() == 123.5);

        a = "123.5";
        p = ParametersUtils.toPixel(a);

        org.junit.Assert.assertTrue(p.getUnit() == TypedValue.COMPLEX_UNIT_PX);
        org.junit.Assert.assertTrue(p.getValue() == 123.5);
    }

}