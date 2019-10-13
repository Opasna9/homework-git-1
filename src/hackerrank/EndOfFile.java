package hackerrank;

import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        /*Read some unknown  lines of input from stdin(System.in) until you reach EOF;
        each line of input contains a non-empty String.
        Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int i = 1;
        while(in.hasNext()){
            System.out.println(i + " " + in.nextLine());
            i++;
        }
        // ctrl+D -- EOF(end of file)
        // Когда вы читаете stdin, это будет либо при отправке символа EOF (обычно ^ d в Unix), либо в конце файла, если вы используете <перенаправление стилей.
        // http://qaru.site/questions/16631239/how-to-finish-program-with-scannerhasnext-in-java
    }
}
