package com.company;

import ListProduc.ListProduc;
import ListProduc.Production;
import customThread.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    final public static String PATH_LIST = "..\\Java-Practice3\\src\\input\\List.txt";
    final public static String PATH_PRODUCTION_SOLD = "..\\Java-Practice3\\src\\input\\sell.txt";
    final public static String PATH_PRODUCTION_N_SOLD_N_EXPIRED = "..\\Java-Practice3\\src\\input\\product.txt";
    final public static String PATH_PRODUCTION_EXPIRED = "..\\Java-Practice3\\src\\input\\expire.txt";

    public static List<ListProduc> listProducs = new ArrayList<>();
    public static List<Production> productions = new ArrayList<>();

    static private void readProductions(String pathname) {
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

    static private void readList() {
        File file = new File(Main.PATH_LIST);
        FileReader fileReader;

        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                if ((line = bufferedReader.readLine()) != null) {
                    listProducs.add(new ListProduc(line));
                } else break;
            }
        } catch (IOException e) {
            System.out.println("Input files have unknown errors !!!");
        }
    }

    public static void main(String[] args) {
        // write your code here
        //read input
        readList();
        readProductions(PATH_PRODUCTION_EXPIRED);
        readProductions(PATH_PRODUCTION_N_SOLD_N_EXPIRED);
        readProductions(PATH_PRODUCTION_SOLD);
        //
        MainRunnable mainRunnable = new MainRunnable();
        AddList addList = new AddList();
        AddProduction addProduction = new AddProduction();

        SearchByNameProduction searchByNameProduction = new SearchByNameProduction();
        ShowRunnable showRunnable = new ShowRunnable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        var future = executorService.submit(mainRunnable);

        while (!MainRunnable.isEndProgram()) {
            if (future.isDone()) {
                switch (mainRunnable.getAction()) {
                    case "1":
                        executorService.submit(addList);
                        break;
                    case "2":
                        executorService.submit(addProduction);
                        break;
                    case "3":
                        ShowRunnable.number=3;
                        executorService.submit(showRunnable);
                        break;
                    case "4":
                        ShowRunnable.number=4;
                        executorService.submit(showRunnable);
                        break;
                    case "5":
                        ShowRunnable.number=5;
                        executorService.submit(showRunnable);
                        break;
                    case "6":
                        ShowRunnable.number=6;
                        executorService.submit(showRunnable);
                        break;
                    case "7":
                        executorService.submit(searchByNameProduction);
                        break;
                }
                future = executorService.submit(mainRunnable);
            }
        }
        executorService.shutdown();

    }
}
