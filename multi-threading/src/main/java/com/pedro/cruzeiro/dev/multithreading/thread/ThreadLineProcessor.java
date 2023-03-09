package com.pedro.cruzeiro.dev.multithreading.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThreadLineProcessor extends Thread {

    protected List<String> lineFields;
    private String line;

    private Long lineNumber;

    private List<RuntimeException> exceptions;

    public ThreadLineProcessor(String threadName,String line,Long lineNumber) {
        this.setName(threadName);
        this.setPriority(Thread.MAX_PRIORITY);
        this.exceptions = new ArrayList<>();
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public void uncaughtException(Thread t, Throwable e) {
                exceptions.add((RuntimeException) e);
            }
        });
        this.line = line;
        this.lineNumber = lineNumber;
    }

    @Override
    public void start(){
        //System.out.println("Starting thread " + this.getName());
        super.start();
    }

    @Override
    public void run(){
        if(line.isEmpty()){
            throw new RuntimeException("Line is empty");
        }
        lineFields = Arrays.asList(line.split(","));
        // Simulating random entropy in reading
        /*Random rn = new Random();
        try {
            sleep(rn.nextInt(1000 - 1 + 1) + 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

    public List<String> getLineFields(){
        return lineFields;
    }

    public Long getLineNumber(){
        return lineNumber;
    }

    public List<RuntimeException> getExceptions(){
        return exceptions;
    }
}
