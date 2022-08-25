package ru.example.backend.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketApplication {

    public static void main(String[] args) {
        String[] myArgs = new String[args.length + 1];
        myArgs[myArgs.length - 1] = " --spring.config.location=config/local/local.yml";
        SpringApplication.run(TicketApplication.class, myArgs);
    }

}
