package edu.nyu.cs9053.homework4.hierarchy;

public abstract class IceSkater extends WinterSportPlayer {

    private final int skateSize;

    protected IceSkater(String name, int age, int skateSize) {
        super(name, age);
        this.skateSize = skateSize;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        IceSkater that = (IceSkater) obj;

        return that.skateSize == skateSize;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + skateSize;
    }

}
