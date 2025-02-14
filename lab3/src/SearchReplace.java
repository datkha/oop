import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class SearchReplace {
    public static void main(String[] args) {
        // Имя файла
        String fileName = "gettys3.html";
        String targetTag = "h4";
        String replaceTag = "h3";
        String attribute = "class";
        String value = "highlight";

        // Шаблон для поиска тегов
        Pattern pattern = Pattern.compile("(<" + targetTag + ".*?>)(.*?)(</" + targetTag + ".*?>)");


        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
            StringBuilder output = new StringBuilder();
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    String newStart = replaceTag(matcher.group(1), targetTag, replaceTag);
                    newStart = replaceAttribute(newStart, attribute, value);
                    String newEnd = replaceTag(matcher.group(3), targetTag, replaceTag);
                    String newLine = newStart + matcher.group(2) + newEnd;
                    System.out.printf("%3d %s%n", lineNumber, newLine);
                    output.append(newLine).append("\n");
                } else {
                    output.append(line).append("\n");
                }
            }
            reader.close();

            // Запись результата в файл
            Files.write(Paths.get("output.html"), output.toString().getBytes());
            System.out.println("Файл успешно обновлён.");

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для замены тега
    public static String replaceTag(String tag, String targetTag, String replaceTag) {
        return tag.replaceFirst(targetTag, replaceTag);
    }

    // Метод для замены атрибута
    public static String replaceAttribute(String tag, String attribute, String value) {
        Pattern p = Pattern.compile(attribute + "=\".*?\"");
        Matcher m = p.matcher(tag);
        if (m.find()) {
            return m.replaceFirst(attribute + "=\"" + value + "\"");
        }
        return tag;
    }
}
