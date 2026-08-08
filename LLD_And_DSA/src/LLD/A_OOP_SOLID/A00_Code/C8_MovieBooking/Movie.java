package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;
public class Movie {
    String movieName;
    String duration;
    String language;
    double rating;
    Movie(){
        this("Unknown","Unknown","Unknown",0.0);
    }
    Movie(String movieName,String duration,String language,double rating){
        this.movieName = movieName;
        this.duration = duration;
        this.language = language;
        this.rating = rating;
    }
}
