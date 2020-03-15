package edu.nyu.cs9053.homework4.hierarchy;

public class SpeedSkater extends IceSkater {
    private final int distance;

    protected SpeedSkater(String name, int age, int skateSize, int distance) {
        super(name, age, skateSize);
        this.distance = distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        if (!super.equals(obj)) return false;

        SpeedSkater that = (SpeedSkater) obj;

        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + distance;
    }

}
