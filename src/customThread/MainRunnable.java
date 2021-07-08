package customThread;

import java.util.Scanner;

public class MainRunnable implements Runnable {
    public static void setAction(String action) {
        MainRunnable.action = action;
    }

    private static String action="";
    private static boolean isEndProgram = false;

    public static boolean isEndProgram() {
        return isEndProgram;
    }

    public String getAction() {
        return action;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isStopProgram = false;
        System.out.println("---Main Menu---");
        while (!isStopProgram) {
            switch (scanner.nextLine().toLowerCase()) {
                case "1":
                    isStopProgram = true;
                    action = "1";
                    break;
                case "2":
                    isStopProgram = true;
                    action = "2";
                    break;
                case "3":
                    isStopProgram = true;
                    action = "3";
                    break;
                case "4":
                    isStopProgram = true;
                    action = "4";
                    break;
                case "5":
                    isStopProgram = true;
                    action = "5";
                    break;
                case "6":
                    isStopProgram = true;
                    action = "6";
                    break;
                case "7":
                    isStopProgram = true;
                    action = "7";
                    break;
                case "quit":
                    isEndProgram = true;
                    isStopProgram = true;
                    break;
                case "help":
                    System.out.println("1     - to add a new list");
                    System.out.println("2     - to add a new production");
                    System.out.println("3     - to show list production sold");
                    System.out.println("4     - to show list production not sold");
                    System.out.println("5     - to show list production expired");
                    System.out.println("6     - to show list production expired soon");
                    System.out.println("7     - to search production by name");
                    System.out.println("quit  - to quit");
                    break;
                default:
                    System.out.println("Unknown command, type \"help\" to more detail");
            }
        }
    }
}
