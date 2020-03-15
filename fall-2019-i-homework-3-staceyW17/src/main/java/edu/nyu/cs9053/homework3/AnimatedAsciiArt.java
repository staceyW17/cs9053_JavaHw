package edu.nyu.cs9053.homework3;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * User: blangel
 */
public class AnimatedAsciiArt {


    public static void main(String[] args) {
        String[] files= new String[9];
        for (int i=0;i<9;i++){
            files[i] = "/Users/wangjiahui/Desktop/NYU/Tue_CS9053JAVA/fall-2019-i-homework-3-staceyW17/src/main/resources/simpsons/" + i +".gif";
        }
        AnimatedAsciiArt animatedAsciiArt = new AnimatedAsciiArt(files);
        animatedAsciiArt.play();
    }

    /**
     * @implNote input must not be null or empty if so {@code throw new IllegalArgumentException();}
     * @implNote use the {@linkplain #convert(String)}
     * @param files to convert into {@linkplain ImageInfoProvider[]}
     * @return converted {@linkplain ImageInfoProvider[]}
     */
    protected static ImageInfoProvider[] convert(String[] files) {
        ImageInfoProvider[] imageInfoProviders = new ImageInfoProvider[files.length];
        if (files != null && files.length != 0){
            for (int i = 0; i < files.length; i++){
                imageInfoProviders[i] = convert(files[i]);
            }
        }else throw new IllegalArgumentException();
        // TODO - implement
        return imageInfoProviders;
    }

    protected static ImageInfoProvider convert(String file) {
        try {
            return new ImageInfoProvider(ImageIO.read(new File(file)));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private final ImageInfoProvider[] providers;

    private final AsciiArtConverter converter;

    private final AsciiArtPrinter printer;

    public AnimatedAsciiArt(String[] files) {
        this(convert(files), new AsciiArtConverter(), new AsciiArtPrinter());
    }

    public AnimatedAsciiArt(ImageInfoProvider[] providers, AsciiArtConverter converter, AsciiArtPrinter printer) {
        if ((providers == null) || (converter == null) || (printer == null)) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
        this.converter = converter;
        this.printer = printer;
    }

    /**
     * Converts the image data from {@linkplain #providers} into {@literal ASCII} art and prints.
     * @implNote before each print of art ensure the screen is cleared
     * @implNote after each print invoke {@linkplain #sleep()}
     */
    public void play() {
        for (int i = 0;i<providers.length;i++){
            printer.clearScreen();
            printer.print(converter.convert(providers[i]));
            sleep();

         }

        // TODO - implement
    }

    protected void sleep() {
        try {
            Thread.sleep(400L);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }
}
