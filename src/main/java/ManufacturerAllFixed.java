public class ManufacturerAllFixed implements ManufacturerMethods {

    private double currentPrice;

    int storageManufacturerAllFixed = 0;

    Thread thread;

    @Override
    public void init() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int plusGoodManufacturerAllFixed = 5;
                while (true){ // infinite cycle
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // adds goods to the storage
                    if ((maxStorage - storageManufacturerAllFixed) <= plusGoodManufacturerAllFixed )
                        storageManufacturerAllFixed = maxStorage;
                    else if ((maxStorage - storageManufacturerAllFixed) > plusGoodManufacturerAllFixed)
                        storageManufacturerAllFixed += plusGoodManufacturerAllFixed;


                    // finds a current price of a one good due to the number of goods in the storage
                    currentPrice = -0.8 * storageManufacturerAllFixed + 100;

                    System.out.println("AF: Storage - " + storageManufacturerAllFixed + " Price - " + currentPrice);


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
    public int getStorage() { return storageManufacturerAllFixed; }

    @Override
    public void selling(int quantity) { storageManufacturerAllFixed -= quantity; }

}