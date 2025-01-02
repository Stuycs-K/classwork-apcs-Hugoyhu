class Fib {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        fib(n);
        //System.out.println(fib(n));

        // int prev2 = 0;
        // int prev1 = 1;
        // int current = 0;
        // int counter = 0;
        // while (current >= 0) {
        //     current = (prev2 + prev1);
        //     prev2 = prev1;
        //     prev1 = current;
        //     counter++;
        // }

        // System.out.println(counter);

    }

    public static int fib (int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
}

// max in 10s: 47 (~7.4 - 7.5 s)
// max n s.t. f(n) < 2^31-1: 
// overflow after 46