package BankingLogs;

import java.util.*;

class BasicSuspiciousDetector implements SuspiciousDetector {
    public List<LogEntry> detect(List<LogEntry> logs) {

        List<LogEntry> suspicious = new ArrayList<>();
        Map<String, Deque<LogEntry>> recentPerAccount = new HashMap<>();

        for (LogEntry log : logs) {

            recentPerAccount.putIfAbsent(log.getAccountNumber(), new LinkedList<>());
            Deque<LogEntry> queue = recentPerAccount.get(log.getAccountNumber());

            queue.addLast(log);
            if (queue.size() > 5) {
                queue.removeFirst();
            }
            if (log.getActionType() == ActionType.WITHDRAW && log.getAmount() > 50000) {
                suspicious.add(log);
            }
            int failedCount = 0;
            for (LogEntry l : queue) {
                if (l.getActionType() == ActionType.FAILED_LOGIN) {
                    failedCount++;
                }
            }

            if (failedCount > 3) {
                suspicious.add(log);
            }
        }

        return suspicious;
    }
}

