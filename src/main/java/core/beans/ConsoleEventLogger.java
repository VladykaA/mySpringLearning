package core.beans;

import core.beans.interfaces.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
