package edu.nyu.cs9053.homework4.hierarchy;

public class CrossCountrySkier extends Skier {
    private final String clothColor;

    public CrossCountrySkier(String name, int age, int skiLength, String skierColor) {
        super(name, age, skiLength);
        this.clothColor = skierColor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        CrossCountrySkier that = (CrossCountrySkier) obj;

        return clothColor != null ? clothColor.equals(that.clothColor) : that.clothColor == null;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + (clothColor != null ? clothColor.hashCode() : 0);
    }
}
