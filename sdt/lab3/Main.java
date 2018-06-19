package lab3;

public class Main {

    public static void main(String[] args) {
        //stack_demonstration();
         queue_demonstation();

        // End of program
        System.out.println("\nThe program has finished working.");
    }

    static void stack_demonstration() {
        Stack s = new Stack(5);
        String[] films = new String[] {
                "1.02.18: Spider-Man: Homecoming",
                "12.03.18: War for the Planet of the Apes",
                "21.04.18: Thor: Ragnarok",
                "11.07.18: Jumanji: Welcome to the Jungle",
                "6.11.18: Avengers: Infinity War"
        };

        for(String n: films) {
            System.out.println("Notification sent: " + n);
            s.push(n);
        }

        System.out.println();
        s.output();

        for(;s.isEmpty() != true;) {
            System.out.println("Notification received: " + s.pop());
        }
    }

    static void queue_demonstation() {
        Queue q = new Queue(10);
        String[] tasks = new String[] {
                "Spider-Man: Homecoming",
                "War for the Planet of the Apes",
                "Thor: Ragnarok",
                "Jumanji: Welcome to the Jungle",
                "Avengers: Infinity War"
        };

        for(String t: tasks) {
            System.out.println("Added: " + t);
            q.enqueue(t);
        }

        System.out.println();
        q.output();

        for(;q.isEmpty() != true;) {
            System.out.println("Coped: " + q.dequeue());
        }
    }

}