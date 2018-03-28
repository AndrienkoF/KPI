class Film extends Cinema{
    String nameFIlm;
    double voteFIlm;
    String countriesFIlm;
    String premier_uaFIlm;
    int age_limitFIlm;

    Film(String nnameCinema, double nvoteCinema, String naddressCinema, String nnameFIlm,
                double nvoteFIlm, String ncountriesFIlm, String npremier_uaFIlm, int nage_limitFIlm){
        nameCinema = nnameCinema;
        voteCinema = nvoteCinema;
        addressCinema = naddressCinema;
        nameFIlm = nnameFIlm;
        voteFIlm = nvoteFIlm;
        countriesFIlm = ncountriesFIlm;
        premier_uaFIlm = npremier_uaFIlm;
        age_limitFIlm = nage_limitFIlm;
    }
}
