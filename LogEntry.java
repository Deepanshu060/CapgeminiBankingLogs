package BankingLogs;

import java.time.LocalDateTime;

class LogEntry {
    private static int counter = 1;

    private int logId;
    private String accountNumber;
    private ActionType actionType;
    private double amount;
    private LocalDateTime timestamp;
    private Status status;

    public LogEntry(String accountNumber, ActionType actionType, double amount, Status status) {
        this.logId = counter++;
        this.accountNumber = accountNumber;
        this.actionType = actionType;
        this.amount = amount;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public int getLogId() {
        return logId;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public ActionType getActionType() {
        return actionType;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public Status getStatus() {
        return status;
    }
    public String toString() {
        return "LogID: " + logId +
                " | Acc: " + accountNumber +
                " | Action: " + actionType +
                " | Amount: " + amount +
                " | Status: " + status +
                " | Time: " + timestamp;
    }
}

