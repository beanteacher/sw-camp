//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int count = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());

            int max = num;
            int min = num;

            for(int i = 0; i < count - 1; i++) {
                num = Integer.parseInt(br.readLine());
                if(num < min) {
                    min = num;
                }
                if(num > max) {
                    max = num;
                }
            }
            System.out.println(min + " " + max);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}