import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class FindText {
    private static Pattern pattern;
    private static Matcher m;

    public static void main(String[] args) {
        // Имя файла
        String fileName = "gettys.html";


//         <h4>
         pattern = Pattern.compile("<h4>");

//        "to"
        // pattern = Pattern.compile("\\bto\\b");

//        4 пробела
        // pattern = Pattern.compile("^\\s{4}");

//        начинающихся с "<p" или "<d"
        // pattern = Pattern.compile("^<(p|d)");

//        содержащих только закрывающие HTML теги
//        pattern = Pattern.compile("^</.*?>$");

        try {
            // Чтение файла построчно
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                m = pattern.matcher(line);

                if (m.find()) {
                    System.out.println(" " + lineNumber + " " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
