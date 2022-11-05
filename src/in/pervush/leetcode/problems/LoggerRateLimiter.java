package in.pervush.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 */
public class LoggerRateLimiter {

    public class Logger {

        private final Map<String, Integer> logs = new HashMap<>(); // message -> lastTimestamp

        public boolean shouldPrintMessage(final int timestamp, final String message) {
            final var prevTimestamp = logs.get(message);
            if (prevTimestamp == null || timestamp - prevTimestamp >= 10) {
                logs.put(message, timestamp);
                return true;
            }
            return false;
        }

    }

    public static void main(final String[] args) {

    }
}
