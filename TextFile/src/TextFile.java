import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class TextFile extends File {
    private String path = "C:\\Users\\danpe\\IdeaProjects\\TextFile";
    private String string;

    TextFile(String parent, String child) {
        super(parent, child);
    }

    void read() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(getAbsolutePath()));
        while ((string = in.readLine()) != null) {
            System.out.println(string);
        }
        in.close();
    }

    boolean add() throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(getAbsolutePath()));
        while ((string = in.readLine()) != null) {
            arrayList.add(string);
        }
        in.close();
        System.out.println("Write the text to add:");
        while ((string = new Scanner(System.in).nextLine()) != null && string.length() >= 1) {
            arrayList.add(string);
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(getAbsolutePath()));
        for (String s : arrayList) {
            out.write(s + "\n");
        }
        out.close();
        return true;
    }
}
