public class Main {
    public static void main(String[] args) {
        Movie m = new Movie ("La bebesita bebe Lean", 23, 2002);
        Movie m2 = new Movie("Y bebe Whisky", 123, 2005);
        Movie m3 = new Movie ("Fuma marihuana", 95, 2002);
        Movie m4 = new Movie ("Y tambien se mete picky", 200, 2017);
        Cinema c = new Cinema("Pep El Gaurdiolas", 5);


        c.addMovie(m);
        c.addMovie(m2);
        c.addMovie(m3);
        c.addMovie(m4);

        c.mostrar();

        //System.out.println(c.roomOfMovie("La bebesita bebe Lean", 23, 2002));

        //c.mostrar();
        //c.removeMovie("La");
        //c.mostrar();

        //c.freeRoms();

        //c.changeRoom(m4);
        //c.mostrar();

        //c.resetCinema();
        //c.mostrar();

        //c.moviesShorterThan(30);

        //c.moviesShorterThan2(1, 30);

    }
}