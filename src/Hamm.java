import java.util.Scanner;
public class Hamm {

    // print elements of array
    static void print(int ar[]) {
        for (int i = 1; i < ar.length; i++) {
            System.out.print(ar[i]);
        }
        System.out.println();
    }

    // calculating value of redundant bits
    static int[] calculationEven(int[] ar, int r) {
        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            for (int j = 1; j < ar.length; j++) {
                if (((j >> i) & 1) == 1) {
                    if (x != j)
                        ar[x] = ar[x] ^ ar[j];
                }
            }
            System.out.println("r" + x + " = "
                    + ar[x]);
        }

        return ar;
    }

    static int[] calculationOdd(int[] ar, int r) {
        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            ar[x] = ar[x] ^ 1;
            System.out.println("r" + x + " = "
                    + ar[x]);
        }


        return ar;
    }

    static int[] generateCode(String str, int M, int r) {
        int[] ar = new int[r + M + 1];
        int j = 0;
        for (int i = 1; i < ar.length; i++) {
            if ((Math.ceil(Math.log(i) / Math.log(2))
                    - Math.floor(Math.log(i) / Math.log(2)))
                    == 0) {
                ar[i] = 0;
            } else {
                ar[i] =  (str.charAt(j) - '0');
                j++;
            }
        }
        return ar;
    }

    static void checkEven(String str1,  int r ){
        int p = str1.length();
        int[] ar = new int[p+1];
        int[] arc = new int[p+1];
        for (int i = 1; i < arc.length; i++){
            arc[i] = (int)(str1.charAt(i-1) - '0');
        }

        for (int i = 1; i < ar.length; i++){
            ar[i] = (int)(str1.charAt(i-1) - '0');
        }
            for(int l = 1; l <= r; l++) {
            int x = (int) Math.pow(2, l-1);
            ar[x] = 0;
        }

        for (int i = 0; i < r; i++) {
                int x = (int) Math.pow(2, i);
                for (int j = 1; j < ar.length; j++) {
                    if (((j >> i) & 1) == 1) {
                        if (x != j)
                            ar[x] = ar[x] ^ ar[j];
                    }
                }
        }
        int y = 0;
        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            if(ar[x] != arc[x]){
                y += (int) Math.pow(2, i);
            }

        }
        if(y == (int) Math.pow(2, r) -1){
            y = 0;
        }
        if(y == (int) Math.pow(2, r-1) ){
            y = (int) Math.pow(2, r-1)-1;
        }
            ar[y] = ar[y] ^ 1;

            for (int l = 1; l <= r; l++) {
                int x = (int) Math.pow(2, l - 1);
                ar[x] = 0;
            }

            for (int i = 0; i < r; i++) {
                int x = (int) Math.pow(2, i);
                for (int j = 1; j < ar.length; j++) {
                    if (((j >> i) & 1) == 1) {
                        if (x != j)
                            ar[x] = ar[x] ^ ar[j];
                    }
                }
            }
            System.out.println("\nnumber " + y + " error, the true humming code is:");
            print(ar);
            int m = 0;
            int mf = 4;
            int mp = p - r - 1;
            for (int l = 3; l <= p; l++) {
                if (l == mf) {
                    mf *= 2;
                } else {
                    m += (int) (Math.pow(2, mp)) * ar[l];
                    mp = mp - 1;
                }
            }
            System.out.println("\nthe true number is:" + m);
        }



    static void checkOdd(String str1,  int r ){

            int p = str1.length();
            int[] ar = new int[p+1];
            int[] arc = new int[p+1];
            for (int i = 1; i < arc.length; i++){
                arc[i] = (int)(str1.charAt(i-1) - '0');
            }

            for (int i = 1; i < ar.length; i++){
                ar[i] = (int)(str1.charAt(i-1) - '0');
            }

            for(int l = 1; l <= r; l++) {
                int x = (int) Math.pow(2, l-1);
                ar[x] = 0;
            }

        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            arc[x] = arc[x] ^ 1;
        }

          for (int i = 0; i < r; i++) {
                int x = (int) Math.pow(2, i);
                for (int j = 1; j < ar.length; j++) {
                   if (((j >> i) & 1) == 1) {
                        if (x != j)
                            ar[x] = ar[x] ^ ar[j]^1;
                    }
                }
            }
        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            ar[x] = ar[x] ^ 1;
        }
        //    print(ar);
            int y = 0;

            for (int i = 0; i < r; i++) {
                int x = (int) Math.pow(2, i);
                if(ar[x] != arc[x]){
                    y += (int) Math.pow(2, i);
                }

            }
        if(y == (int) Math.pow(2, r) -1){
            y = 0;
        }
        if(y == (int) Math.pow(2, r-1) ){
            y = (int) Math.pow(2, r-1)-1;
        }
                ar[y] = ar[y] ^ 1;

                for (int l = 1; l <= r; l++) {
                    int x = (int) Math.pow(2, l - 1);
                    ar[x] = 0;
                }

                for (int i = 0; i < r; i++) {
                    int x = (int) Math.pow(2, i);
                    for (int j = 1; j < ar.length; j++) {
                        if (((j >> i) & 1) == 1) {
                            if (x != j)
                                ar[x] = ar[x] ^ ar[j];
                        }
                    }
                }
                for (int i = 0; i < r; i++) {
                    int x = (int) Math.pow(2, i);
                    ar[x] = ar[x] ^ 1;
                }
                System.out.println("\nnumber " + y + " error, the true humming code is:");
                print(ar);
                int m = 0;
                int mf = 4;
                int mp = p - r - 1;
                for (int l = 3; l <= p; l++) {
                    if (l == mf) {
                        mf *= 2;
                    } else {
                        m += (int) (Math.pow(2, mp)) * ar[l];
                        mp = mp - 1;
                    }
                }
                System.out.println("\nthe true number is:" + m);
            }



    // Driver code
    public static void main(String[] args) {

        //  message
        System.out.println("plz enter a number then will output its hamming code\n");
        String str  ;
        String oo;
        Scanner scn = new Scanner(System.in);
        oo = scn.next();

        str = Integer.toBinaryString(Integer.parseInt(oo));


        int M = str.length();
        int r = 1;

        while (Math.pow(2, r) < (M + r + 1)) {
            // r is number of redundant bits
            r++;
        }

        int[] ar = generateCode(str, M, r);

        System.out.println("Hamming code(even) ");
        int[] are = calculationEven(ar, r);

        print(are);

        System.out.println("\nHamming code(odd) ");
        int[] aro = calculationOdd(ar, r);
        print(aro);

        System.out.println("now enter a humming code, we will parity it ");
        Scanner scn1 = new Scanner(System.in);
        String str1 = scn1.next();
        int p = str1.length();
        int k = 0;
        while(p > 0 ){
            p = p/2;
            k++;
        }
        System.out.println("\nues even parity\n" );
        checkEven(str1,k);
        System.out.println("\nues odd parity\n" );
        checkOdd(str1,k);
    }
}