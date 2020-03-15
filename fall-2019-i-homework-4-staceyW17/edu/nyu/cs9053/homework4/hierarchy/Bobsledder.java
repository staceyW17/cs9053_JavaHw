package edu.nyu.cs9053.homework4.hierarchy;

public class Bobsledder extends Sledder {
    private final float bobSleighHeight;

    protected Bobsledder(String name, int age, String sledColor, float bobSleighHeight) {
        super(name, age, sledColor);
        this.bobSleighHeight = bobSleighHeight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Bobsledder that = (Bobsledder) obj;

        return that.bobSleighHeight == bobSleighHeight;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + Float.valueOf(bobSleighHeight).hashCode();
    }


}
