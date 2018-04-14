import java.util.ArrayList;

public class Cinema {
    public String nameCinema;
    public String addressCinema;
    public String phoneCinema;
    public String voteCinema;
    public Film[] films = new Film [100];

    public Cinema(String nameCinema, String addressCinema, String phoneCinema, String voteCinema){
        this.nameCinema = nameCinema;
        this.addressCinema = addressCinema;
        this.phoneCinema = phoneCinema;
        this.voteCinema = voteCinema;
    }
}
