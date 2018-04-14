import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String domain = "https://kinoafisha.ua";

        Document doc_listCinemas = Jsoup.connect("https://kinoafisha.ua/cinema/").get();
        Elements elems_listCinemas = doc_listCinemas.select("div.item");

        for(Element elem_listCinemas: elems_listCinemas){
            String cinema_href = elem_listCinemas.select("div.text > h3 > a").attr("href");

            if(cinema_href.contains("cinema")){
                System.out.println(domain + cinema_href);

                Document doc_cinema = Jsoup.connect(domain + cinema_href).get();
                Element elem_nameCinema = doc_cinema.select("div.content > h1 > span.fn").first();
                Element elem_addressCinema = doc_cinema.select("div.text > p > a.on-map").first();
                Element elem_phoneCinema = doc_cinema.select("div.text > p > span").first();
                Element elem_voteCinema = doc_cinema.select("div.rating > span.value-votes").first();

                Cinema cinema = new Cinema(elem_nameCinema.text(), elem_addressCinema.text(),
                        elem_phoneCinema.text(), elem_voteCinema.text());

                Elements elems_listFilms = doc_cinema.select("td.cinema-room > a");

                for(Element elem_film : elems_listFilms){
                    String film_href = elem_film.attr("href");

                    if(film_href.contains("films")){
                        Document doc_film = Jsoup.connect(domain + film_href).get();
                        Element elem_nameRUS = doc_film.select("h1.margin-left > span.fn").first();
                        Element elem_nameENG = doc_film.select("h1.margin-left > span.alt-name").first();

                        Elements elems_mainInfo = doc_film.select("div.text");

                        for(Element elem_mainInfo : elems_mainInfo){
                            Elements new_elem = elem_mainInfo.select("p");

                            String tmp_mainInfo = "";
                            for(Element el : new_elem){
                                tmp_mainInfo = el.select("span").text();
                                break;
                            }

                            int i = 0;
                            String tmp_genre = "";
                            for(Element el : new_elem){
                                tmp_genre = el.select("a").text();
                                if (i==1){
                                    break;
                                }
                                i++;
                            }

                            i = 0;
                            String tmp_premiere = "";
                            for(Element el : new_elem){
                                tmp_premiere = el.select("span").text();
                                if (i==6){
                                    break;
                                }
                                i++;
                            }

                            Elements elem_voteFilm = elem_mainInfo.select("span.value-votes");

                            Film film = new Film(elem_nameRUS.text(), elem_nameENG.text(), tmp_mainInfo,
                                    tmp_genre, tmp_premiere, elem_voteFilm.text());

                            for(int k=0; k<cinema.films.length; k++){
                                if(cinema.films[k] == null){
                                    cinema.films[k] = film;
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    public static void kinoafisha_parcer(){

    }


    public static void json_serialization(Cinema cinemas){


    }


}
