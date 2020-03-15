package edu.nyu.cs9053.homework4.hierarchy;

public class Curler extends WinterSportPlayer {
    private final int playerNumber;


    protected Curler(String name, int age, int playerNumber) {
        super(name, age);
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Curler that = (Curler) obj;

        return that.playerNumber == playerNumber;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 31 * hash + playerNumber;
    }

}
