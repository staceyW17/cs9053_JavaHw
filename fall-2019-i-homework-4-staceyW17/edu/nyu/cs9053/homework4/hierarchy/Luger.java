package edu.nyu.cs9053.homework4.hierarchy;

public class Luger extends Sledder {
    //无舵雪橇 平底雪橇
    private final float length;

    protected Luger(String name, int age, String sledColor, float length) {
        super(name, age, sledColor);
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Luger that = (Luger) obj;

        return length == that.length;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + Float.valueOf(length).hashCode();
    }
}
