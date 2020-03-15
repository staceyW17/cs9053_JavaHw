package edu.nyu.cs9053.homework4.hierarchy;

public abstract class Skier extends WinterSportPlayer {
    private final int skiLength;

    protected Skier(String name, int age, int skiLength) {
        super(name, age);
        this.skiLength = skiLength;
    }

    public int getSkiLength() {
        return skiLength;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Skier that = (Skier) obj;

        return that.skiLength == skiLength;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + skiLength;
    }
}
