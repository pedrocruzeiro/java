package com.pedro.cruzeiro.dev.multithreading;

import com.pedro.cruzeiro.dev.multithreading.process.ParallelStreamProcess;
import com.pedro.cruzeiro.dev.multithreading.process.SequentialProcess;
import com.pedro.cruzeiro.dev.multithreading.process.ThreadProcess;
import com.pedro.cruzeiro.dev.multithreading.thread.ThreadLineProcessor;
import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MultiThreading {

    public static void main(String[] args) throws InterruptedException {

        Map<Long, String> lineMap = new HashMap<>();

        InputStream is = MultiThreading.class.getClassLoader().getResourceAsStream("input.csv");

        BufferedReader reader;

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        try {
            long lineNumber = 0;
            reader = new BufferedReader(new InputStreamReader(
                    is));
            String line;

            while ((line = reader.readLine()) != null) {
                // read next line
                lineMap.put(lineNumber,line);
                lineNumber++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stopWatch.stop();

        System.out.println("Reading file time: " + stopWatch.getTime());


        ThreadProcess threadProcess = new ThreadProcess();

        threadProcess.process(lineMap);

        ParallelStreamProcess parallelStreamProcess = new ParallelStreamProcess();
        parallelStreamProcess.process(lineMap);

        SequentialProcess sequentialProcess = new SequentialProcess();
        sequentialProcess.process(lineMap);

    }
}
