package com.example.yunlongzhang.opencvtest.Helper;

/**
 * Created by yunlong.zhang on 2016/9/8.
 * workspace: javac OpenCVHelper.java
 * D:\workspace\factory\OpenCvTest\app\src\main\java>javah com.example.yunlongzhang
 * .opencvtest.Helper.OpenCVHelper
 *
 */
public class OpenCVHelper {
    static {
        System.loadLibrary("OpenCV");
    }
    public static native int[] gray(int[] buf, int w, int h);
}
