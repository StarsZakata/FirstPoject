import java.util.Random;

public class ManufacturerAllRandom implements ManufacturerMethods {

    Thread thread;

    private double currentPrice;

    int storageManufacturerAllRandom = 0;

    @Override
    public void init() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int delay;
                int plusGoodManufacturerAllRandom;
                Random random = new Random();

                while (true){

                    delay = random.nextInt(2000) + 2000; // Create a random delay
                    plusGoodManufacturerAllRandom = random.nextInt(4) + 3;
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if ((maxStorage - storageManufacturerAllRandom) <= plusGoodManufacturerAllRandom) // adds goods to the storage
                        storageManufacturerAllRandom = maxStorage;
                    else if ((maxStorage - storageManufacturerAllRandom) > plusGoodManufacturerAllRandom)
                        storageManufacturerAllRandom += plusGoodManufacturerAllRandom;

                    // finds a current price of a one good due to the number of goods in the storage
                    currentPrice = -0.8 * storageManufacturerAllRandom + 100;

                    System.out.println("AR: Storage - " + storageManufacturerAllRandom + " Price - " + currentPrice);// Test


                }
            }
        });
    }



    @Override
    public void start() {
        thread.start();
    }

    @Override
    public double getPrice() {
        return currentPrice;
    }

    @Override
    public int getStorage() {
        return storageManufacturerAllRandom;
    }

    @Override
    public void selling(int quantity) {
        storageManufacturerAllRandom -= quantity;



    }
}
