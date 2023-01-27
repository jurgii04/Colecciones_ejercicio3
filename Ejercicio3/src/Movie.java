public class Movie {

    private String titulo;
    private int duracion;
    private int año;

    Movie (String titulo, int duracion, int año) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getAño() {
        return año;
    }

    public String toString() {
        return "Titulo: '" + titulo + "'" + ", duración: " + duracion + " min, año: " + año;
    }

    public boolean isEqual(Movie movie2) {
        if (this.titulo.equalsIgnoreCase(movie2.titulo) && this.año == movie2.año && Math.abs(this.duracion - movie2.duracion) <=5) {
            return true;
        } else {
            return false;
        }
    }
}
