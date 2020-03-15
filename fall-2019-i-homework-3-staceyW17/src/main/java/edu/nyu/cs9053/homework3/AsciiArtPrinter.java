package edu.nyu.cs9053.homework3;

/**
 * User: blangel
 */
public class AsciiArtPrinter {

    /**
     * @implNote should only print values within {@code asciiArt} and nothing else within this method
     * @param asciiArt to print
     */
    public void print(char[][] asciiArt) {
           for(int j=0;j<asciiArt.length;j++){
            for (int i=0;i<asciiArt[0].length;i++){
                System.out.print(asciiArt[j][i]+"");
            }
            System.out.println();
        }
        // TODO - implement this
    }

    protected void clearScreen() {
        System.out.printf("\u001B[51;1H");
    }

}
