import java.util.Random;

public class ManufacturerRandomGood implements ManufacturerMethods {

    int storageManufacturerRandomGood = 0;

    private Thread thread;

    Random random = new Random();
    private double currentPrice;

    @Override
    public void init() { // Creates a method "thread"
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int plusGoodManufacturerRandomGood;
                while (true) { // infinite cycle
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    plusGoodManufacturerRandomGood = random.nextInt(4) + 2; // Creates a value of adding goods
                    if ((maxStorage - storageManufacturerRandomGood) > plusGoodManufacturerRandomGood) // adds good to the storage
                        storageManufacturerRandomGood += plusGoodManufacturerRandomGood;
                    else if ((maxStorage - storageManufacturerRandomGood) <= plusGoodManufacturerRandomGood)
                        storageManufacturerRandomGood = maxStorage;



                    // finds a current price of a one good due to the number of goods in the storage
                    currentPrice = -0.8 * storageManufacturerRandomGood +100;

                    System.out.println("RG: Storage - " + storageManufacturerRandomGood + " Price - " + currentPrice);// Test


                }
            }
        });
    }

    @Override
    public void start() {
        thread.start(); // Starts a method "thread"
    }

    @Override
    public double getPrice() {
        return currentPrice;
    }

    @Override
    public int getStorage() {
        return storageManufacturerRandomGood;
    }

    @Override
    public void selling(int quantity) {
        storageManufacturerRandomGood -= quantity;
    }
}

