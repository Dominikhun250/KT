package me.dominikhun250.hu.plugin.events.helper;

public interface GameEvent {
    void endEvent(boolean timeExpired);
    long getRemainingTimeSeconds();
    String getRemainingTimeFormatted();
    String getEventName();
}

