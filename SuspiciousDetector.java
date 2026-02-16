package BankingLogs;

import java.util.List;

interface SuspiciousDetector {
    List<LogEntry> detect(List<LogEntry> logs);
}

