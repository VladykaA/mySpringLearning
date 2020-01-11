package core;

import core.beans.Client;
import core.beans.ConsoleEventLogger;
import core.beans.Event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public App() {
    }

    public App(Client client, ConsoleEventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    private void logEvent(Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        consoleEventLogger.logEvent(event);
    }


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(event,"Some event from user 1");
    }

}
