package org.example;

public class InventoryCounter {

    public static class DecrementCounterThread extends Thread{

        Inventory inventoryCounter;

        DecrementCounterThread(Inventory inventoryCounter){
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

        Inventory inventoryCounter;

        IncrementCounterThread(Inventory inventoryCounter){
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    public static class Inventory {

        private int items = 0;

        public void increment(){
            items++;
        }

        public void decrement(){
            items--;
        }

        public int getItems(){
            return items;
        }

    }

}
