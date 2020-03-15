package edu.nyu.cs9053.homework4.hierarchy;

public class SnowBoarder extends WinterSportPlayer{
    private final String snowBoardColor;

    protected SnowBoarder(String name, int age, String snowBoardColor){
        super(name, age);
        this.snowBoardColor = snowBoardColor;
    }

    public String getSnowBoardColor(){ return  snowBoardColor;}

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        if (!super.equals(obj)) return false;

        SnowBoarder that = (SnowBoarder) obj;

        return snowBoardColor == null ? that.snowBoardColor == null : snowBoardColor.equals(that.snowBoardColor);
    }

    @Override
    public int hashCode(){
        int hash = super.hashCode();
        return  31 * hash + (snowBoardColor != null ? snowBoardColor.hashCode() : 0);
    }
}
