import java.util.ArrayList;
import java.util.List;

class Shirt {
    private String id;
    private String name;
    private String color;
    private String size;

    public Shirt(String id, String name, String color, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shirt ID: " + id + "\n" +
                "Description: " + name + "\n" +
                "Color: " + color + "\n" +
                "Size: " + size;
    }
}

public class StringSplitTest {
    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Blue Polo Shirt,Blue,L",
                "S003,Green T-Shirt,Green,M",
                "S004,White T-Shirt,White,S",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black Polo Shirt,Black,XL",
                "S007,Blue Polo Shirt,Blue,L",
                "S008,Green T-Shirt,Green,M",
                "S009,Green T-Shirt,Green,S",
                "S010,Black Polo Shirt,Black,XL",
                "S011,Black Polo Shirt,Black,XL",
        };

        List<Shirt> shirtList = new ArrayList<>();

        for (String curLine : shirts) {
            String[] e = curLine.split(",");
            shirtList.add(new Shirt(e[0], e[1], e[2], e[3]));
        }

        System.out.println("=== Shirt List ===");
        for (Shirt shirt : shirtList) {
            System.out.println(shirt);
            System.out.println();
        }
    }
}
