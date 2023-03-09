package com.pedro.cruzeiro.dev.multithreading.process;

import com.pedro.cruzeiro.dev.multithreading.thread.ThreadLineProcessor;
import org.apache.commons.lang3.time.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

public class SequentialProcess {

    Map<Long, List<String>> rowFields;

    public SequentialProcess(){
        this.rowFields = new HashMap<>();
    }

    public void process(Map<Long, String> linesMap) {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        rowFields = linesMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Arrays.asList(e.getValue().split(","))
                ));

        stopWatch.stop();

        System.out.println("SequentialProcess time: " + stopWatch.getTime());

    }

}
