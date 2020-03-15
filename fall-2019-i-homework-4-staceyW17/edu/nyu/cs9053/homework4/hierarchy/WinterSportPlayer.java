package edu.nyu.cs9053.homework4.hierarchy;

public abstract class WinterSportPlayer {
    private final String name;
    private final int age;

    protected WinterSportPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        WinterSportPlayer that = (WinterSportPlayer) obj;
        return (name == null ? that.name == null : name.equals(that.name))
                && age == that.age;

    }

    @Override
    public int hashCode() {
        int hash = (name == null ? 0 : name.hashCode());
        return 31 * hash + (Double.valueOf(age).hashCode());
    }
}
