package doublepointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublePointerTemplate {

    public static void main(String[] args) throws IOException {
        //输入一个字符串，输出单词。
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        for (int i = 0; i < str.length(); i++) {
            int j = i;
            while (j < str.length() && str.charAt(j) != ' ') j++;
            System.out.println(str.substring(i, j));
            i = j;
        }
    }
}
