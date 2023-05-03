package com.pedro.cruzeiro.dev.multithreading.process;

import org.apache.commons.lang3.time.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamProcess {

    Map<Long, List<String>> rowFields;

    public ParallelStreamProcess(){
        this.rowFields = new HashMap<>();
    }


    public void process(Map<Long, String> linesMap) {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        rowFields = linesMap.entrySet().parallelStream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Arrays.asList(e.getValue().split(","))
                ));

        stopWatch.stop();

        System.out.println("ParallelStreamProcess time: " + stopWatch.getTime());
    }

}
