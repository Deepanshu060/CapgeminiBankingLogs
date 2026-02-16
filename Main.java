package BankingLogs;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LogManager manager = new LogManager();

        while (true) {
            System.out.println("\n1.Add Log");
            System.out.println("2.Get Logs by Account");
            System.out.println("3.Get Recent Logs");
            System.out.println("4.Detect Suspicious");
            System.out.println("5.Search by Action");
            System.out.println("6.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Account Number: ");
                    String acc = sc.next();

                    System.out.print("Action (DEPOSIT/WITHDRAW/TRANSFER/LOGIN/FAILED_LOGIN): ");
                    ActionType type = ActionType.valueOf(sc.next().toUpperCase());

                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    System.out.print("Status (SUCCESS/FAILED): ");
                    Status status = Status.valueOf(sc.next().toUpperCase());

                    manager.addLog(new LogEntry(acc, type, amt, status));
                    System.out.println("Log Added!");
                    break;
                case 2:
                    System.out.print("Account Number: ");
                    System.out.println(manager.getLogsByAccount(sc.next()));
                    break;

                case 3:
                    System.out.print("Enter N: ");
                    System.out.println(manager.getRecentLogs(sc.nextInt()));
                    break;

                case 4:
                    System.out.println(manager.detectSuspicious());
                    break;

                case 5:
                    System.out.print("Action Type: ");
                    ActionType at = ActionType.valueOf(sc.next().toUpperCase());
                    System.out.println(manager.searchByAction(at));
                    break;

                case 6:
                    return;
            }
        }
    }
}

