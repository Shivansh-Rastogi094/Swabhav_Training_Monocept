package com.inventory.notifier;

import com.inventory.logging.CustomLogger;

public class SMSNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        CustomLogger.info("SMSNotifier", "[SMS] Notification sent: " + message);
    }
}
