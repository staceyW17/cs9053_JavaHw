package edu.nyu.cs9053.homework4.hierarchy;

public class FigureSkater extends IceSkater {

    private final String shortProgram;
    private final String longProgram;

    public FigureSkater(String name, int age, int skateSize, String shortProgram, String longProgram) {
        super(name, age, skateSize);
        this.shortProgram = shortProgram;
        this.longProgram = longProgram;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        if (!super.equals(obj)) return false;

        FigureSkater that = (FigureSkater) obj;

        return (shortProgram == null ? that.shortProgram == null : shortProgram.equals(that.shortProgram)
                && longProgram == null ? that.longProgram == null : longProgram.equals(that.longProgram)) ;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (shortProgram != null ? shortProgram.hashCode() : 0);
        return 31 * hash + (longProgram != null ? longProgram.hashCode() : 0);
    }

}
