package filehandler;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import filehandler.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static private ArrayList<File> files;
    static private Scanner scan;

    public static void main(String[] args) throws IOException {
        files = new ArrayList<File>();
        scan = new Scanner(System.in);
        File currentFile = null;
        boolean exit = false;
        do {
            if (files.isEmpty()) {
                currentFile = createFile();
            } else {
                currentFile = selectFile();
            }
            menu(currentFile);
            exit = exitOrContinue();
        } while (!exit);
    }
    public static boolean exitOrContinue() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do modify more files (y/n)? ");
        char input = scan.nextLine().charAt(0);
        if(input == 'y') {
            return false;
        } else if (input == 'n') {
            return true;
        }
        else {
            return exitOrContinue();
        }
    }
    public static File selectFile() throws InputMismatchException, IOException {
        System.out.println("-----Files-----");
        for (int i = 0; i < files.size(); i++) {
            System.out.println(i+1 + ": " + files.get(i).getName());
        }
        System.out.println(files.size()+1 + ": Create new file" );
        int selected;
        do {
            System.out.println("Enter number to select file or create new: ");
            selected = scan.nextInt();
        } while(selected > files.size()+1 || selected < 1);
        if (selected == files.size()+1) {
            return createFile();
        } else {
            return files.get(selected - 1);
        }
    }

    public static void menu(File file) throws InputMismatchException, IOException {
        boolean exit = false;
        do {
            scan = new Scanner(System.in);
            System.out.println("-----Options-----\n" +
                    "1: Write to file\n" +
                    "2: Read file\n" +
                    "3: Append to file\n" +
                    "4: Exit\n" +
                    "Enter 1, 2, 3, or 4: ");
            int option = scan.nextInt();
            switch (option) {
                case 1: FileWriter.write(file);
                    break;
                case 2: FileReader.read(file);
                    break;
                case 3: FileAppender.append(file);
                    break;
                case 4: exit = true;
                    break;
                default:
                    break;
            }
        } while (!exit);
    }

    public static File createFile() throws IOException {
        System.out.println("Enter name for file: ");
        scan = new Scanner(System.in);
        String fileName = scan.nextLine();

        File file  = new File(Constants.filePath + fileName + ".txt");
        if (file.createNewFile()) {
            System.out.println("Created File: " + file.getName());
            files.add(file);
        } else {
            System.out.println("Existing File: " + file.getName());
        }

        return file;
    }

}
