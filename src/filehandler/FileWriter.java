package filehandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileWriter {
    public static void write(File file) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter what you want to write to file: " + file.getName());
        String input = scan.nextLine();
        try(java.io.FileWriter writer = new java.io.FileWriter(file);) {
            writer.write(input);
        }
    }
}
