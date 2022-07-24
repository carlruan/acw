import java.io.*;

public class ACW831 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String p = reader.readLine();
        p = "!" + p;
        int m = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        s = "?" + s;
        int[] ne = new int[n + 1];
        for (int i = 2, j = 0; i < n + 1; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j + 1))
                j = ne[j];
            if (p.charAt(i) == p.charAt(j + 1))
                j++;
            ne[i] = j;
        }

        for (int i = 1, j = 0; i < m + 1; i++) {
            while (j > 0 && p.charAt(j + 1) != s.charAt(i))
                j = ne[j];

            if (p.charAt(j + 1) == s.charAt(i))
                j++;

            if (j == n) {
                writer.write(i - n + " ");
                ;
                j = ne[j];
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
