package customThread;

import ListProduc.Production;
import com.company.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShowRunnable implements Runnable {
    static public int number;

    private void readInputToList(String pathname,List<Production> productions) {
        File file = new File(pathname);
        FileReader fileReader;

        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                if ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.trim().split("-");
                    productions.add(new Production(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], Integer.parseInt(parts[3]), parts[4], parts[5], parts[6], parts[7]));
                } else break;
            }
        } catch (IOException e) {
            System.out.println("Input files have unknown errors !!!");
        }
    }

    @Override
    public void run() {
        System.out.println("---Show---");
        List<Production> productions = new ArrayList<>();
        if (number == 3) {
            readInputToList(Main.PATH_PRODUCTION_SOLD,productions);
            for (Production production : productions) {
                production.show();
            }
        } else if (number == 4) {
            readInputToList(Main.PATH_PRODUCTION_N_SOLD_N_EXPIRED,productions);
            for (Production production : productions) {
                production.show();
            }
        } else if (number == 5) {
            readInputToList(Main.PATH_PRODUCTION_EXPIRED,productions);
            for (Production production : productions) {
                production.show();
            }

        } else if (number == 6) {
            readInputToList(Main.PATH_PRODUCTION_N_SOLD_N_EXPIRED,productions);
            Calendar today = Calendar.getInstance();
            today.add(Calendar.HOUR, 168);
            for (Production production : productions) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    cal.setTime(sdf.parse(production.getExpiryDate()));// all done
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (cal.getTime().before(today.getTime()))
                    production.show();
            }
        }

    }
}
