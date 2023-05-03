package com.pedro.cruzeiro.dev.multithreading.process;

import com.pedro.cruzeiro.dev.multithreading.thread.ThreadLineProcessor;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadProcess {

    Map<Long, List<String>> rowFields;

    public ThreadProcess(){
        this.rowFields = new HashMap<>();
    }


    public void process(Map<Long, String> linesMap) throws InterruptedException {

        List<ThreadLineProcessor> threadLineProcessorList = new ArrayList<>();

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (Map.Entry<Long, String> entry : linesMap.entrySet()) {
            Long lineNumber = entry.getKey();
            threadLineProcessorList.add(new ThreadLineProcessor("Row-"+ lineNumber,entry.getValue(), lineNumber));
        }


        for (ThreadLineProcessor threadLineProcessor : threadLineProcessorList){
            threadLineProcessor.start();
        }

        for (ThreadLineProcessor threadLineProcessor : threadLineProcessorList){
            threadLineProcessor.join();
        }



        for (ThreadLineProcessor threadLineProcessor : threadLineProcessorList){
            rowFields.put(threadLineProcessor.getLineNumber(),threadLineProcessor.getLineFields());
        }

        stopWatch.stop();

        System.out.println("ThreadProcess time: " + stopWatch.getTime());

    }


}
