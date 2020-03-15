package edu.nyu.cs9053.homework4;

public enum  OlympicGames {
    Game1924("France"), Game1928("Switzerland"), Game1932("United States"), Game1936("Germany"), Game1948("Switzerland"),
    Game1952("Norway"), Game1956("Italy"), Game1960("United States"), Game1964("Austria"), Game1968("France"), Game1972("Japan"),
    Game1976("Austria"), Game1980("United States"), Game1984("Yugoslavia"), Game1988("Canada"), Game1992("France"), Game1994("Norway"),
    Game1998("Japan"), Game2002("United States"), Game2006("Italy"), Game2010("Canada"), Game2014("Russia"), Game2018("South Korea");


    private final String hostCountry;

    private OlympicGames(String hostCountry){
        this.hostCountry = hostCountry;
    }

    public String getHostCountry(){
        return hostCountry;
    }

    public static void print(OlympicGames...games){
        for (OlympicGames game:games){
            System.out.printf("%s : %s%n",game,game.getHostCountry());
        }
    }
}
