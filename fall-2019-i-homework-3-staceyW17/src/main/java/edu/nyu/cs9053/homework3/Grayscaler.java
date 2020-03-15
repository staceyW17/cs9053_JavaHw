package edu.nyu.cs9053.homework3;

/**
 * User: blangel
 */
public class Grayscaler {

    /**
     * Turns {@code pixel} into gray-scale
     * @implNote {@code pixel} is an RGB value where blue is the first 8 bits, green is the second 8 bits and red is the third 8 bits
     * @implNote to gray-scale an RGB use this formula {@literal 0.21 * red + 0.72 * green + 0.07 * blue}
     * @param pixel to gray-scale
     * @return the gray-scaled value
     */
    public double grayScale(int pixel) {
	final int r = (pixel & 0xff0000) >> 16;
        final int g = (pixel & 0xff00) >> 8;
        final int b = pixel & 0xff;
        final double grayScale = 0.21d * r + 0.72d * g + 0.07d * b;
        // TODO - implement this
        return grayScale;
    }

}
