package customThread;

import ListProduc.ListProduc;
import com.company.Main;

import java.io.*;
import java.util.Scanner;

public class AddList implements Runnable {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Add a list---");
        System.out.print("List name: ");
        Main.listProducs.add(new ListProduc(scanner.nextLine()));
        File file = new File(Main.PATH_LIST);
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ListProduc listProduc=Main.listProducs.get(Main.listProducs.size() - 1);
            listProduc.show();
            printWriter.println(listProduc.getName());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
