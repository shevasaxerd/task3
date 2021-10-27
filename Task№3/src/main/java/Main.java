import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {

        Func func = new Func();
        KeyAndHMAC keyAndHMAC = new KeyAndHMAC();
        Table table = new Table();
        Scanner in = new Scanner(System.in);
        int N = args.length;

        System.out.println("Arguments:");
        for (int i = 0; i < N; i++) {
            System.out.println(i + 1 + " - " + args[i]);
        }
        System.out.println(N + 1 + " - " + "?");
        System.out.println("0" + " - " + "Exit");
        while (true) {
        while (true) {



            if (N == 0 || N == 1 || N % 2 == 0) {
                System.out.println("Invalid number of arguments. Example: rock paper scissors");
                return;
            }
                for (int i = 0; i < args.length; i++){
                    for (int j = i+1; j < args.length; j++){
                        if (args[i].equals(args[j])) {
                            System.out.println("Arguments must not be repeated!");
                            return;
                        }
                    }



            }
            System.out.println("Your choice:");
            int n = in.nextInt();
            if (n > N + 1) {
                System.out.println("Invalid argument selected, enter from 1 to " + (N + 1));
                break;

            }
            if (n == N + 1) {
                table.createTable(args);
                break;

            }
            if (n == 0) {
                System.out.println("Exit...");
                return;
            }

            SecureRandom random = new SecureRandom();
            int rand = random.nextInt(args.length);
            if (rand == 0) {rand = 1;}

            byte[] seed = keyAndHMAC.generateKeyAndHMAC(args, rand);
            System.out.println("Computer choice:");
            //int m = in.nextInt();
            System.out.println(rand);
            System.out.println("HMAC key:" + HexBin.encode(seed));

            int g = func.func(n, rand, N);
            result(n, rand, g);


        }
    }
    }




    public static void result (int n, int m, int k){
        if ( n != m) {
            if (k == 0) {
                System.out.println("Computer won!");
            } else {
                System.out.println("You won!");
            }
        }
        else {
            System.out.println("Draw");

        }
    }

}
