package com.inventory.notifier;

import com.inventory.logging.CustomLogger;

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        CustomLogger.info("EmailNotifier", "[EMAIL] Notification sent: " + message);
    }
}
