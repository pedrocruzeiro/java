package org.example;

public class SynchronizedInventoryCounter {

    public static class DecrementCounterThread extends Thread{

        SynchronizedInventory inventoryCounter;

        DecrementCounterThread(SynchronizedInventory inventoryCounter){
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementCounterThread extends Thread{

        SynchronizedInventory inventoryCounter;

        IncrementCounterThread(SynchronizedInventory inventoryCounter){
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    public static class SynchronizedInventory {

        private int items = 0;

        public synchronized void  increment(){
            items++;
        }

        public synchronized void decrement(){
            items--;
        }

        public synchronized int getItems(){
            return items;
        }

    }

}
