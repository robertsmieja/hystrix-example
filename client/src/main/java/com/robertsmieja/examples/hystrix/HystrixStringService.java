package com.robertsmieja.examples.hystrix;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

import com.robertsmieja.examples.hystrix.commands.FaultyStringClientCommand;
import com.robertsmieja.examples.hystrix.commands.StringClientCommand;

@Service
@ShellComponent
public class HystrixStringService {
    @Autowired
    private final StringServiceClient stringServiceClient;

    public HystrixStringService(StringServiceClient stringServiceClient) {
        this.stringServiceClient = stringServiceClient;
    }

    @ShellMethod("Hystrix FaultyStringService")
    public String hystrixHello(@ShellOption(defaultValue = "World") String world){
        StringBuffer sb = new StringBuffer();
        StringClientCommand stringClientCommand = new StringClientCommand(stringServiceClient, world);

        Instant start = Instant.now();
        String result = stringClientCommand.execute();
        Instant end = Instant.now();
        long durationMs = ChronoUnit.MILLIS.between(start, end);

        sb.append("Result - ").append(result).append(System.lineSeparator());
        sb.append("Start - ").append(start).append(System.lineSeparator());
        sb.append("End - ").append(end).append(System.lineSeparator());
        sb.append("Duration (ms) - ").append(durationMs).append(System.lineSeparator());

        return sb.toString();
    }

    @ShellMethod("Hystrix FaultyStringService")
    public String faultyHystrixHello(@ShellOption(defaultValue = "World") String world){
        StringBuffer sb = new StringBuffer();
        FaultyStringClientCommand stringClientCommand = new FaultyStringClientCommand(stringServiceClient, world);

        Instant start = Instant.now();
        String result = stringClientCommand.execute();
        Instant end = Instant.now();
        long durationMs = ChronoUnit.MILLIS.between(start, end);

        sb.append("Result - ").append(result).append(System.lineSeparator());
        sb.append("Start - ").append(start).append(System.lineSeparator());
        sb.append("End - ").append(end).append(System.lineSeparator());
        sb.append("Duration (ms) - ").append(durationMs).append(System.lineSeparator());

        return sb.toString();
    }

}
