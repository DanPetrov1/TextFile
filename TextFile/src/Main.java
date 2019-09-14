import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String path = "C:\\Users\\danpe\\IdeaProjects\\TextFile";
    public static void main(String[] args) throws IOException {
        for (boolean running = true; running;) {
            running = menu();
        }
    }

    private static boolean menu() throws IOException {
        int variant;
        TextFile textFile;
        String lastFilename;
        System.out.println("Choose the variant:\n1. Create new file.\n2. Rename file.\n3. Read file.\n4. Add text in" +
                " file.\n5. Delete file.\n6. Exit.");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            variant = scanner.nextInt();
            switch (variant) {
                case 1:
                    System.out.print("Write the name of the file: ");
                    lastFilename = new Scanner(System.in).nextLine();
                    textFile = new TextFile(path,
                            lastFilename + ".txt");
                    if (textFile.exists()) {
                        System.out.println("There're another file with such name.");
                        break;
                    }
                    if (textFile.createNewFile()) {
                        System.out.println("The file has been created successfully.");
                    } else {
                        System.out.println("Error of the creating file with such name");
                    }
                    break;
                case 2:
                    if ((textFile = getTextFile("rename")) != null) {
                        System.out.print("Write the new name of the file: ");
                        lastFilename = new Scanner(System.in).nextLine();
                        if (textFile.renameTo(new TextFile(path, lastFilename + ".txt"))) {
                            System.out.println("The file has been renamed successfully.");
                        } else {
                            System.out.println("Error of the renaming file with such name");
                        }
                    }
                    else {
                        System.out.println("There're no file with such name.");
                    }
                    break;
                case 3:
                    if ((textFile = getTextFile("read")) == null) {
                        System.out.println("There're no file with such name.");
                        break;
                    } else {
                        textFile.read();
                    }
                    break;
                case 4:
                    if ((textFile = getTextFile("add information")) != null) {
                        if (textFile.add()) {
                            System.out.println("The file has been updated successfully.");
                        } else {
                            System.out.println("Error of the updating file with such name");
                        }
                    }
                    else {
                        System.out.println("There're no file with such name.");
                    }
                    break;
                case 5:
                    if ((textFile = getTextFile("delete")) != null) {
                        if (textFile.delete()) {
                            System.out.println("The file has been deleted successfully.");
                        } else {
                            System.out.println("Error of the deleting file with such name");
                        }
                    }
                    else {
                        System.out.println("There're no file with such name.");
                    }
                    break;
                case 6:
                    return false;
            }
            return true;
        } else {
            System.out.println("Write the number!");
            return true;
        }
    }

    private static TextFile getTextFile(String string) {
        System.out.print("Write the name of the file to " + string + ": ");
        String lastFilename = new Scanner(System.in).nextLine();
        TextFile textFile = new TextFile(path,
                lastFilename + ".txt");
        if (!textFile.exists()) {
            System.out.println("There're no file with such name.");
            return null;
        } else {
            return textFile;
        }
    }
}
