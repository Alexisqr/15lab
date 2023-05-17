import java.io.File;
import java.util.Scanner;

public class DeleteFiles {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ви не надали назву каталогу");
            return;
        }

        String directory1 = args[0];
        File directory2 = new File(directory1);

        if (!directory2.isDirectory()) {
            System.out.println(directory1 + " такої деректорії нема");
            return;
        }

        File[] files = directory2.listFiles();

        if (files == null || files.length == 0) {
            System.out.println(directory1 + " пуста.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Чи бажайте ви видалити " + files.length + " файлів в " + directory1 + "? (Y/N): ");
        String answer = scanner.nextLine();
        //Метод equalsIgnoreCase()порівнює два рядки, ігноруючи відмінності у нижньому та верхньому регістрах.
        if (!answer.equalsIgnoreCase("Y")) {
            System.out.println("видалення припинене.");
            return;
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            file.delete();
        }
        System.out.println(files.length + " файлів видаленно.");
    }
}