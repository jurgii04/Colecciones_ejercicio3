import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    private String nombre_cine;
    private ArrayList<Movie> movies;
    private Movie busyRooms[];

    Cinema (String nombre, int numeroDeSalas) {
        this.nombre_cine = nombre;
        this.movies = new ArrayList<>();
        this.busyRooms = new Movie[numeroDeSalas];
        for (int i = 0; i < numeroDeSalas; i++) {
            this.busyRooms[i] = null;
        }
    }

    public String getNombre_cine() {
        return nombre_cine;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public Movie[] getBusyRooms() {
        return busyRooms;
    }

    public int roomOfMovie (String nombre, int duracion, int año) {
        Movie peli = new Movie (nombre, duracion, año);
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i].isEqual(peli)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void addMovie(Movie movie) {

        if (movies.isEmpty() == true) {
            movies.add(movie);
            busyRooms[0] = movie;
            System.out.println("'" + movie.getTitulo() + "' añadida");
            return;
        }

        for (int j = 0; j < movies.size(); j++) {
            if (movies.get(j).getTitulo().equals(movie.getTitulo())) {
                System.out.println("La pelicula '" + movie.getTitulo() + "' ya se encuentra en el cine");
                return;
            } else {
                for (int i = 1; i < busyRooms.length; i++) {
                    if (busyRooms[i] == null) {
                        busyRooms[i] = movie;
                        movies.add(movie);
                        System.out.println("'" + movie.getTitulo() + "' añadida");
                        return;
                    }
                }
            }
        }
    }

    public void addMovie(Movie movie, int numeroSala) {

        if (movies.isEmpty() == true) {
            movies.add(movie);
            busyRooms[numeroSala - 1] = movie;
            System.out.println("'" + movie.getTitulo() + "' añadida");
            return;
        }
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).isEqual(movie)) {
                System.out.println("Esta pelicula ya esta en el cine");
            } else {
                if (numeroSala <= 0 || numeroSala > busyRooms.length) {
                    System.out.println("Número de sala no válido");
                    return;
                } else if (busyRooms[numeroSala - 1] != null) {
                    System.out.println("La sala introducia para la pelicula '" + movie.getTitulo() + "' ya esta asignada");
                    return;
                } else if (busyRooms[numeroSala - 1] == null) {
                    busyRooms[numeroSala - 1] = movie;
                    System.out.println("'" + movie.getTitulo() + "' añadida");
                    return;
                }
            }
        }
    }

    public void mostrar() {
        System.out.println("Nombre del cine: " + nombre_cine);
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i] != null) {
                System.out.println(busyRooms[i].getTitulo() + " - Sala " + (i + 1));
            }
        }
    }

    public void removeMovie(String cadena) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitulo().startsWith(cadena) == true) {
                movies.remove(i);
            }
            if (busyRooms[i].getTitulo().startsWith(cadena)) {
                busyRooms[i] = null;
            }
        }
    }

    public void freeRoms() {
        System.out.println("Salas vacias: ");
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i] == null ) {
                System.out.println("Sala " + (i +1));
            }
        }
    }

    public void changeRoom(Movie movie) {
        int salaAhora = roomOfMovie(movie.getTitulo(), movie.getDuracion(), movie.getAño());

        System.out.println("'" + movie.getTitulo() + "' se encuentra en la sala " + (salaAhora));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("¿A que sala deseas cambiar la pelicula? ");
            int salaNueva = sc.nextInt() - 1;
            if (salaNueva >= 0 && salaNueva < busyRooms.length && busyRooms[salaNueva] == null) {
                busyRooms[salaNueva] = movie;
                busyRooms[salaAhora - 1] = null;
                System.out.println("'" + movie.getTitulo() + "' se ha movido a la sala " + (salaNueva + 1));
                return;
            } else {
                if (salaNueva < 0 || salaNueva > busyRooms.length - 1) {
                    System.out.println("La sala introducida no existe, introduce una entre el 1 y el " + busyRooms.length);
                } else if (salaNueva == salaAhora - 1) {
                    System.out.println("Esta pelicula ya se encuentra en la sala " + (salaAhora) + ", selecciona otra");
                }else {
                    System.out.println("La sala esta ocupada, introduce una libre");
                    System.out.println("Visualizacion de salas vacias a continuacion:");
                    System.out.println("======================================");
                    freeRoms();
                }
            }
        }
    }


    public void resetCinema() {
        for (int i = 0; i < movies.size(); i++) {
            busyRooms[i] = null;
        }
        movies.clear();
        System.out.println("El cine ha sido reiniciado");
    }

    public void moviesShorterThan(int minutos) {
        ArrayList<String> masCortas = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getDuracion() < minutos) {
                masCortas.add(movies.get(i).getTitulo());
            }
        }
        System.out.println("Las peliculas más cortas de " + minutos + " minutos son:");
        System.out.println(masCortas);
    }

    public void moviesShorterThan2(int horas, int minutos) {
        ArrayList<String> masCortas = new ArrayList<>();
        int minutosTotal = (horas * 60) + minutos;
        System.out.println(minutosTotal);
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getDuracion() < minutosTotal) {
                masCortas.add(movies.get(i).getTitulo());
            }
        }
        System.out.println("Las peliculas más cortas de " + horas + " horas " + minutos + " minutos son:");
        System.out.println(masCortas);
    }

}











