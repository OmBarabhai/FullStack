package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Movie {
    private String movieName;
    private String duration;
    private String language;
    private double rating;

    public void setMovie(String movieName, String duration, String language, double rating) {
        this.movieName = movieName;
        this.duration = duration;
        this.language = language;
        if(0 <= rating && rating <= 5.0) {
            this.rating = rating;
        }
    }
    public String getMovieName(){
        return movieName;
    }
    public String getDuration(){
        return duration;
    }
    public String getLanguage(){
        return language;
    }
    public double getRating(){
        return rating;
    }
}
