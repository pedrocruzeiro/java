package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        InventoryCounter.Inventory inventory = new InventoryCounter.Inventory();

        InventoryCounter.IncrementCounterThread incrementCounterThread = new InventoryCounter.IncrementCounterThread(inventory);
        InventoryCounter.DecrementCounterThread decrementCounterThread = new InventoryCounter.DecrementCounterThread(inventory);
        InventoryCounter.IncrementCounterThread incrementCounterThreadConcurrent = new InventoryCounter.IncrementCounterThread(inventory);
        InventoryCounter.DecrementCounterThread decrementCounterThreadConcurrent = new InventoryCounter.DecrementCounterThread(inventory);

        incrementCounterThread.start();

        incrementCounterThread.join();

        decrementCounterThread.start();

        decrementCounterThread.join();

        System.out.println("We currently have " + inventory.getItems() + " items.");

        incrementCounterThreadConcurrent.start();

        decrementCounterThreadConcurrent.start();


        incrementCounterThreadConcurrent.join();
        decrementCounterThreadConcurrent.join();

        System.out.println("We currently have " + inventory.getItems() + " items.");


        SynchronizedInventoryCounter.SynchronizedInventory synchronizedInventory = new SynchronizedInventoryCounter.SynchronizedInventory();

        SynchronizedInventoryCounter.IncrementCounterThread synchronizedIncrementCounterThread = new SynchronizedInventoryCounter.IncrementCounterThread(synchronizedInventory);
        SynchronizedInventoryCounter.DecrementCounterThread synchronizedDecrementCounterThread = new SynchronizedInventoryCounter.DecrementCounterThread(synchronizedInventory);
        SynchronizedInventoryCounter.IncrementCounterThread synchronizedIncrementCounterThreadConcurrent = new SynchronizedInventoryCounter.IncrementCounterThread(synchronizedInventory);
        SynchronizedInventoryCounter.DecrementCounterThread synchronizedDecrementCounterThreadConcurrent = new SynchronizedInventoryCounter.DecrementCounterThread(synchronizedInventory);

        synchronizedIncrementCounterThread.start();

        synchronizedIncrementCounterThread.join();

        synchronizedDecrementCounterThread.start();

        synchronizedDecrementCounterThread.join();

        System.out.println("We currently have " + synchronizedInventory.getItems() + " items.");

        synchronizedIncrementCounterThreadConcurrent.start();

        synchronizedDecrementCounterThreadConcurrent.start();


        synchronizedIncrementCounterThreadConcurrent.join();
        synchronizedDecrementCounterThreadConcurrent.join();

        System.out.println("We currently have " + synchronizedInventory.getItems() + " items.");

    }

}