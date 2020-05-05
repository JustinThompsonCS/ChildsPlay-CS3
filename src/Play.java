import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Play {
    static ArrayList<Domino> dominos;
    static HashSet<Integer> checked;
    public static void main(String[] args)throws IOException {
        File file = new File("play2.dat");
        Scanner scanner = new Scanner(file);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < cases; z++) {
            int num = 0;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int l = scanner.nextInt();
            scanner.nextLine();
            dominos = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dominos.add(new Domino(i));
            }

            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                scanner.nextLine();
                if(x != y) {
                    dominos.get(x).neighbors.add(y);
                }


            }
            checked = new HashSet<>();
            for (int i = 0; i < l; i++) {
                int x = scanner.nextInt() - 1;
                scanner.nextLine();
                num += recursion(x);
            }
            System.out.println(num);
        }
    }


    public static int recursion(int x){
        if(checked.contains(x)){
            return 0;
        }
        int num = 1;
        checked.add(x);
        for (int i = 0; i < dominos.get(x).neighbors.size(); i++) {

            num += recursion(dominos.get(x).neighbors.get(i));

        }
        return num;

    }


    private static class Domino{
        int value;
        ArrayList<Integer> neighbors;
        public Domino(int value){
            this.value = value;
            neighbors = new ArrayList<>();
        }
    }
}
