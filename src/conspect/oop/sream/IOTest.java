package conspect.oop.sream;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {

        InputStream is = null;
        OutputStream os = null;
        FileReader fr = null;
        FileWriter fw = null;
        PrintWriter pw = null;

        try {

            File file = new File("text.txt");// и с дерикториямии с файлами
            File fileOut = new File("textOut.txt");
            fileOut.createNewFile();

            if (file.exists()) {
                System.out.println(file.getName());
            } else {
                file.createNewFile();
            }
            System.out.println("file.isDirectory() = " + file.isDirectory());
            //file.mkdir();// создает директорию
            //file.list();// у директории возвращает массив файлов + директории . и ..

            is = new FileInputStream(file);
            os = new FileOutputStream(fileOut);

//            int b = 0;

//            while (b != -1){
//                b = is.read();
//                os.write(b);
//            }

//            while ((b = is.read()) != -1) {
//                os.write(b);
//            }

            IOUtils.copy(is, os);

            //String strpath="text.txt";
            System.out.println("FileReader");
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String ch;
            StringBuffer sb = new StringBuffer();




            while ((ch = br.readLine()) != null) {
                sb.append(ch);
            }

            System.out.println(sb);
            System.out.println(sb.reverse());

            fw = new FileWriter("textWriter.txt");


            fw.write(sb.toString());


            pw = new PrintWriter("textPrintWriter2.txt");
            pw.format("Курс валют: %-4s%-8.4f  %-4s%-8.4f","USD", 58.4643, "EUR", 63.3695);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
