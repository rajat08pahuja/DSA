import java.util.*;

public class questions {

    // Print Decreasing
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printDecreasing(n - 1);
    }

    // Print Increasing
    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }

        printIncreasing(n - 1);
        System.out.println(n);
    }

    // Print Decreasing Increasing
    public static void pdi(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }

    // Factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int factNM1 = factorial(n - 1);
        int factN = factNM1 * n;
        return factN;
    }

    // Power Linear
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xNm1 = power(x, n - 1);
        return xNm1 * x;
    }

    // Power Logarithmic
    public static int power2(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xNby2 = power2(x, n / 2);
        int xN = xNby2 * xNby2;
        if (n % 2 != 0) {
            xN *= x;
        }

        return xN;
    }

    // Print ZigZag
    public static void pzz(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
    }

    // Tower of Hanoi
    public static void toh(int n, int t1, int t2, int t3) {
        if (n == 0) {
            return;
        }

        toh(n - 1, t1, t3, t2);
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        toh(n - 1, t3, t2, t1);
    }

    // Display Array
    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }

        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }

    // Display Array in Reverse
    public static void displayArrReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }

        displayArrReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    // Max of an Array
    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int maxSoFar = maxOfArray(arr, idx + 1);
        int cmax = Math.max(maxSoFar, arr[idx]);
        return cmax;
    }

    // First Index
    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == x) {
            return idx;
        }

        return firstIndex(arr, idx + 1, x);
    }

    // Last Index
    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int lidx = lastIndex(arr, idx + 1, x);
        if (lidx == -1) {
            if (arr[idx] == x) {
                return idx;
            }
        }

        return lidx;
    }

    // All Indices in Array
    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            int[] base = new int[fsf];
            return base;
        }

        int[] asf;
        if (arr[idx] == x) {
            asf = allIndices(arr, x, idx + 1, fsf + 1);
            asf[fsf] = idx;
        } else {
            asf = allIndices(arr, x, idx + 1, fsf);
        }

        return asf;
    }

    // Get Subsequence
    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = gss(ros);

        ArrayList<String> res = new ArrayList<>();

        for (String s : rres) {
            res.add(s);
        }

        for (String s : rres) {
            res.add(ch + s);
        }

        return res;
    }

    // Get Keypad Combination
    static String[] map = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int num = str.charAt(0) - '0';
        String mapping = map[num];
        String ros = str.substring(1);

        ArrayList<String> rres = getKPC(ros);

        ArrayList<String> mres = new ArrayList<>();

        for (int i = 0; i < mapping.length(); i++) {
            char ch = mapping.charAt(i);
            for (String s : rres) {
                mres.add(ch + s);
            }
        }

        return mres;
    }

    // Get Stair Paths
    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> mres = new ArrayList<>();
        if (n >= 1) {
            ArrayList<String> rres = getStairPaths(n - 1);
            for (String s : rres) {
                mres.add(1 + s);
            }
        }

        if (n >= 2) {
            ArrayList<String> rres = getStairPaths(n - 2);
            for (String s : rres) {
                mres.add(2 + s);
            }
        }

        if (n >= 3) {
            ArrayList<String> rres = getStairPaths(n - 3);
            for (String s : rres) {
                mres.add(3 + s);
            }
        }

        return mres;
    }

    // Get Maze Paths
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> hres = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> vres = getMazePaths(sr + 1, sc, dr, dc);

        ArrayList<String> res = new ArrayList<>();

        for (String s : hres) {
            res.add('h' + s);
        }

        for (String s : vres) {
            res.add('v' + s);
        }

        return res;
    }

    // Get Maze Paths with Jump
    public static ArrayList<String> getMazePathsWithJump(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= dc - sc; i++) {
            ArrayList<String> rres = getMazePathsWithJump(sr, sc + i, dr, dc);
            for (String s : rres) {
                res.add("h" + i + s);
            }
        }

        for (int i = 1; i <= dr - sr; i++) {
            ArrayList<String> rres = getMazePathsWithJump(sr + i, sc, dr, dc);
            for (String s : rres) {
                res.add("v" + i + s);
            }
        }

        for (int i = 1; i <= Math.min(dr - sr, dc - sc); i++) {
            ArrayList<String> rres = getMazePathsWithJump(sr + i, sc + i, dr, dc);
            for (String s : rres) {
                res.add("d" + i + s);
            }
        }

        return res;
    }

    // Print Subsequence
    public static void printSS(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSS(ros, ans + ch);
        printSS(ros, ans);
    }

    // Print KeyPad Combination
    public static void printKPC(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int num = str.charAt(0) - '0';
        String mapping = map[num];
        String ros = str.substring(1);

        for (int i = 0; i < mapping.length(); i++) {
            printKPC(ros, asf + mapping.charAt(i));
        }
    }

    // Print Stair Paths
    public static void printStairPaths(int n, String path) {
        if (n < 0) {
            return;
        }

        if (n == 0) {
            System.out.println(path);
            return;
        }

        printStairPaths(n - 1, path + 1);
        printStairPaths(n - 2, path + 2);
        printStairPaths(n - 3, path + 3);
    }

    // Print Maze Paths
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        }

        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }

    // Print Maze Paths with Jump
    public static void printMazePathsWithJump(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        for (int i = 1; i <= dc - sc; i++) {
            printMazePathsWithJump(sr, sc + i, dr, dc, psf + "h" + i);
        }

        for (int i = 1; i <= dr - sr; i++) {
            printMazePathsWithJump(sr + i, sc, dr, dc, psf + "v" + i);
        }

        for (int i = 1; i <= Math.min(dr - sr, dc - sc); i++) {
            printMazePathsWithJump(sr + i, sc + i, dr, dc, psf + "d" + i);
        }
    }

    // Print Permutations
    public static void printPermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutations(ros, asf + ch);
        }
    }

    // Print Encodings
    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int num1 = Integer.parseInt(str.substring(0, 1));
        String ros1 = str.substring(1);

        if (num1 != 0) {
            printEncodings(ros1, asf + (char) ('a' + num1 - 1));
        }

        if (str.length() >= 2) {
            String numStr = str.substring(0, 2);
            int num2 = Integer.parseInt(numStr);
            if (numStr.charAt(0) != '0' && num2 >= 1 && num2 <= 26) {
                String ros2 = str.substring(2);
                printEncodings(ros2, asf + (char) ('a' + num2 - 1));
            }
        }
    }

    // Target Sum Subsets
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if (idx == arr.length) {
            if (tar == sos) {
                System.out.println(set + ".");
            }
            return;
        }

        if (sos <= tar) {
            printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        }
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }

    public static void main(String[] args) {

    }
}