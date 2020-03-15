package edu.nyu.cs9053.homework4.hierarchy;

public abstract class Sledder extends WinterSportPlayer {
    private final String sledColor;


    protected Sledder(String name, int age, String sledColor) {
        super(name, age);
        this.sledColor = sledColor;
    }

    public String getSledColor() {
        return sledColor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Sledder sledder = (Sledder) obj;

        return sledColor != null ? sledColor.equals(sledder.sledColor) : sledder.sledColor == null;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + (sledColor != null ? sledColor.hashCode() : 0);
    }
}
