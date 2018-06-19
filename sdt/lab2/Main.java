package lab2;

public class Main {

    public static void main(String[] args) {
        String[] films = new String[]{
                "Three Billboards Outside Ebbing, Missouri",
                "Avengers: Infinity War",
                "Paddington 2",
                "Coco",
                "Ready Player One",
                "Blade Runner 2049",
                "Deadpool 2e",
                "Wind River",
                "Kimi no na wa",
                "Dead Man",
                "It",
                "Thor: Ragnarok",
                "I, Tonya",
                "The Shape of Water",
                "Spider-Man: Homecoming"
        };

        System.out.println("Initial array:\n");
        arr_print(films);

        System.out.println("\nThe array has been sorted in ascending order:\n");
        sort_selection(films, true);
        arr_print(films);

        System.out.println("\nThe array has been sorted in descending order:\n");
        sort_selection(films, false);
        arr_print(films);
    }

    static void sort_selection(String[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (asc) {
                    if (arr[j].compareTo(arr[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                else {
                    if (arr[j].compareTo(arr[minIndex]) > 0) {
                        minIndex = j;
                    }
                }
            }

            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    static void arr_print(String arr[]) {
        int i = 0;
        for(String str: arr) {
            System.out.println(++i + ". " + str);

        }
    }
}