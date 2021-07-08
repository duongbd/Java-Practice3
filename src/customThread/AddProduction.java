package customThread;

import ListProduc.Production;
import com.company.Main;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddProduction implements Runnable {
    final static String REGEX_DATE="([0-9]{2})/([0-9]{2})/([0-9]{4})";

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("---Add a production---");
            System.out.print("Id list production: ");
            String idList = scanner.nextLine();
            System.out.print("Name production   : ");
            String nameProduction = scanner.nextLine();
            System.out.print("Price             : ");
            String price = scanner.nextLine();
            System.out.print("Date in           : ");
            String dateIn = scanner.nextLine();
            if (!dateIn.matches(REGEX_DATE)) throw new InputMismatchException();
            System.out.print("Date out          : ");
            String dateOut = scanner.nextLine();
            if (!dateOut.matches(REGEX_DATE)) throw new InputMismatchException();
            System.out.print("Date expiry       : ");
            String dateExpiry = scanner.nextLine();
            if (!dateExpiry.matches(REGEX_DATE)) throw new InputMismatchException();
            System.out.print("Description       : ");
            String description = scanner.nextLine();
            Main.productions.add(new Production(Integer.parseInt(idList), nameProduction, Integer.parseInt(price), dateIn, dateOut, dateExpiry, description));
            Production production = Main.productions.get(Main.productions.size() - 1);
            File file;
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                cal.setTime(sdf.parse(production.getExpiryDate()));// all done
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (!production.getDateOut().equals(""))
                file = new File(Main.PATH_PRODUCTION_SOLD);
            else if (cal.before(Calendar.getInstance()))
                file = new File(Main.PATH_PRODUCTION_EXPIRED);
            else file = new File(Main.PATH_PRODUCTION_N_SOLD_N_EXPIRED);
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                production.show();
                printWriter.println(production.getId() + "-" + production.getIdListProduc() + "-" + production.getName() + "-" + production.getPrice() + "-" + production.getDateIn() + "-" + production.getDateOut() + "-" + production.getExpiryDate() + "-" + production.getDescription());
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException e) {
                System.out.println("Input wrong type");
        }
    }
}
