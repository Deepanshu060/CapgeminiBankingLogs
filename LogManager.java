package BankingLogs;

import java.util.*;

class LogManager {

    private List<LogEntry> allLogs = new ArrayList<>();
    private Map<String, List<LogEntry>> accountLogs = new HashMap<>();
    private Map<ActionType, List<LogEntry>> actionLogs = new HashMap<>();
    private Deque<LogEntry> logStack = new LinkedList<>();
    private SuspiciousDetector detector = new BasicSuspiciousDetector();
    public void addLog(LogEntry log) {
        allLogs.add(log);
        accountLogs.putIfAbsent(log.getAccountNumber(), new ArrayList<>());
        accountLogs.get(log.getAccountNumber()).add(log);
        actionLogs.putIfAbsent(log.getActionType(), new ArrayList<>());
        actionLogs.get(log.getActionType()).add(log);
        logStack.push(log);
    }

    public List<LogEntry> getLogsByAccount(String accountNumber) {
        return accountLogs.getOrDefault(accountNumber, new ArrayList<>());
    }
    public List<LogEntry> getRecentLogs(int n) {
        List<LogEntry> result = new ArrayList<>();
        Iterator<LogEntry> it = logStack.iterator();

        while (it.hasNext() && n > 0) {
            result.add(it.next());
            n--;
        }
        return result;
    }
    public List<LogEntry> detectSuspicious() {
        return detector.detect(allLogs);
    }
    public List<LogEntry> searchByAction(ActionType type) {
        return actionLogs.getOrDefault(type, new ArrayList<>());
    }
}

