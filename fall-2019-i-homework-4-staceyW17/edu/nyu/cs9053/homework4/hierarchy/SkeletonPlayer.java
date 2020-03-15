package edu.nyu.cs9053.homework4.hierarchy;

public class SkeletonPlayer extends Sledder {
    private final String helmetColor;

    protected SkeletonPlayer(String name, int age, String sledColor, String helmetColor) {
        super(name, age, sledColor);
        this.helmetColor = helmetColor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        SkeletonPlayer that = (SkeletonPlayer) obj;

        return helmetColor == null ? that.helmetColor == null : helmetColor.equals(that.helmetColor);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + (helmetColor != null ? helmetColor.hashCode() : 0);
    }
}
