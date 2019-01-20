import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class JoshepusProblem 
{
    public static void runMe() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter writer = new PrintWriter("./res/joshepus/output.csv");

        System.out.print("Joshepus Problem, enter maximum n (integer) for the probem: ");
        int until = sc.nextInt();
        System.out.println();
        System.out.println("Starting Calculation...");

        double past = System.currentTimeMillis();

        for (int i = 1; i <= until; i++)
        {
            int pred = (2 * (i % ((int) (Math.log(i) / 0.693147) + 3)));
            int calc = new Circle(i).getLastAlive();

            writer.write(i + " " + pred);
            writer.write(", " + calc);
            writer.write(", " + (pred - calc) + "\n");
        }
        
        writer.close();
        System.out.println("\nCalculation completed in " + (int) (System.currentTimeMillis() - past) + "ms! See the output.csv file located on res/josephine folder.");
    }
}

class Circle 
{
    // true if person is alive, false if dead
    private boolean[] people;
    private int n;

    // k is, how many people killed by a person
    private int k;

    Circle(int n, int k)
    {
        people = new boolean[n];
        Arrays.fill(people, true);
        this.n = n;
        this.k = k;
    }

    Circle(int n)
    {
        this(n, 1);
    }

    int getLastAlive() // O(n*n) complexity??
    {
        int deaths = 0;
        int index = 0;

        while (deaths < n - 1)
        {
            while(!people[index])
                index = (index + 1) % n;
            
            for (int i = 0; i < k; i++)
            {
                index = (index + 1) % n;

                while(!people[index])
                    index = (index + 1) % n;
                
                people[index] = false;
                deaths++;
            }
        }

        while (!people[index])
            index = (index + 1) % n;
        
        index = (index + (n + 1)) % n;

        return index == 0 ? n : index;
    }
}