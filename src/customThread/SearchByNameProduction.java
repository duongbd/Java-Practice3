package customThread;

import ListProduc.Production;
import com.company.Main;

import java.util.Scanner;

public class SearchByNameProduction implements Runnable {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Search product by name---");
        System.out.print("Name product: ");
        String nameProduct = scanner.nextLine();
        for (Production production : Main.productions) {
            if (production.getName().equals(nameProduct))
                production.show();
        }
    }
}
