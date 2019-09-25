package hackerrank;

import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        for(int i = 1; in.hasNext()== true; i++){
            System.out.println(i + " " + in.nextLine());
        }
        // ctrl+D -- EOF(end of file)
        //Когда вы читаете stdin, это будет либо при отправке символа EOF (обычно ^ d в Unix), либо в конце файла, если вы используете <перенаправление стилей.
    }
}
