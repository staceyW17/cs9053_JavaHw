package edu.nyu.cs9053.homework4.hierarchy;

public class MogulSkier extends Skier {
    private final String skierColor;

    public MogulSkier(String name, int age, int skiLength, String skierColor) {
        super(name, age, skiLength);
        this.skierColor = skierColor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        MogulSkier that = (MogulSkier) obj;

        return skierColor != null ? skierColor.equals(that.skierColor) : that.skierColor == null;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + (skierColor != null ? skierColor.hashCode() : 0);
    }

}
