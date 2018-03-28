import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("fedia97","Fedia", "Andrienko", "1111");
        Film film1 = new Film("Флоренция", 8.2, "г.Киев, просп. Маяковского, 31",
                "Тихоокеанский рубеж: Восстание", 6.9,
                "США, 2018 (фантастика, боевик)",
                "22.03.2018", 12);
        Film film2 = new Film("Баттерфляй Космополит", 7.6, "г. Киев, ул. Гетьмана, 6",
                "Красный воробей", 7.9,
                "США, 2018 (триллер)",
                "01.03.2018", 16);
        Film film3 = new Film("Жовтень", 8.1, "г. Киев, ул. Константиновская, 26",
                "Чёрная Пантера", 6.9,
                "США, 2017 (фантастика, экшн)",
                "15.02.2018", 12);
        Film film4 = new Film("Multiplex SkyMall", 7.3, "г. Киев, пр-т Генерала Ватутина, 2-Т",
                "Расхитительница гробниц: Лара Крофт", 7.8,
                "США, 2018 (приключения, экшн)",
                "15.03.2018", 16);
        Film film5 = new Film("Multiplex Комод", 7.1, "г. Киев, ул. Шептицкого, 4A",
                "О чём говорят мужчины. Продолжение", 5.9,
                "Россия, 2018 (комедия)",
                "01.03.2018", 16);

        while (true){
            String[] print;

            System.out.println("<<< Pls, log in >>> ");
            System.out.println("(enter \"close\" to exit the application)");

            Scanner in = new Scanner(System.in);
            System.out.print("Enter your login: ");
            String login = in.nextLine();


            if(login.compareTo("close") == 0){
                System.out.println("Bye!");
                break;
            }


            System.out.print("Enter your password: ");
            String password = in.nextLine();



            if(user1.login.compareTo(login) == 0 && user1.password.compareTo(password) == 0){
                boolean authenticated = true;
                System.out.println("Welcome to \"Kinoafisha\"");
                print = printCinemaList();
                do{
                    boolean option = true;
                    do{
                        System.out.print("Enter cinema (select number): ");
                        int cinema_num = in.nextInt();

                        switch(cinema_num){
                            case (1):
                                print_afisha(film1);
                                break;
                            case (2):
                                print_afisha(film2);
                                break;
                            case (3):
                                print_afisha(film3);
                                break;
                            case (4):
                                print_afisha(film4);
                                break;
                            case (5):
                                print_afisha(film5);
                                break;
                            case (6):
                                authenticated = false;
                                break;
                            default:
                                System.out.println("Invalid number!");
                                option = false;
                                break;
                        }
                    }while(!option);
                }while(authenticated);

            }
            else{
                System.out.println("Wrong login or password.");
            }
        }



    }

    public static String[] printCinemaList() {
        String[] options = {
                "\"Флоренция\"",
                "\"Баттерфляй Космополит\"",
                "\"Жовтень\"",
                "\"Multiplex SkyMall\"",
                "\"Multiplex Комод\"",
                "Log out"
        };
        return print(options);
    }

    private static String[] print(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        return options;
    }


    public static void print_afisha(Film film){
        System.out.println("\nName: " + film.nameFIlm +
                        "\nVote: " + film.voteFIlm +
                        "\nCountries: " + film.countriesFIlm +
                        "\nPremier: " + film.premier_uaFIlm +
                        "\nAge limit: " + film.age_limitFIlm +
                        "\n");
    }

}
