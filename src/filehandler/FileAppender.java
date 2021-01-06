package filehandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppender {
    public static void append(File file) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter what you want to append to file: ");
        String input = scan.nextLine();
        try(java.io.FileWriter writer = new java.io.FileWriter(file, true);) {
            writer.append(input);
        }
    }
}
