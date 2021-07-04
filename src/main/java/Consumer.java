import java.util.ArrayList;

public class Consumer implements ConsumerMethods {

    private ManufacturerAllFixed manufacturerAllFixed;
    private ManufacturerRandomGood manufacturerRandomGood;
    private ManufacturerAllRandom manufacturerAllRandom;

    int quantity = 8; // quantity of buying goods

    Thread thread;

    double profitablePrice = 101;

    private ManufacturerMethods profitableManufacturer;

    public Consumer(ManufacturerAllFixed manufacturerAllFixed, ManufacturerRandomGood manufacturerRandomGood, ManufacturerAllRandom manufacturerAllRandom) {
        this.manufacturerAllFixed = manufacturerAllFixed;
        this.manufacturerRandomGood = manufacturerRandomGood;
        this.manufacturerAllRandom = manufacturerAllRandom;

//        ArrayList<Object> consumerList = new ArrayList<>();
//        consumerList.add(manufacturerAllFixed);
//        consumerList.add(manufacturerRandomGood);
//        consumerList.add(manufacturerAllRandom);

    }

    @Override
    public void init() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                ArrayList<ManufacturerMethods> consumerList = new ArrayList<>();
                consumerList.add(manufacturerAllFixed);
                consumerList.add(manufacturerRandomGood);
                consumerList.add(manufacturerAllRandom);

                while (true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (ManufacturerMethods ob: consumerList){

                     if (ob.getPrice() < profitablePrice){
                        profitablePrice = ob.getPrice();
                        profitableManufacturer = ob;
                    }
                }

                if(profitableManufacturer.getStorage() < quantity) {
                    System.out.println("The most profitable manufacturer has not enough goods for buying.");}
                else {
                    profitableManufacturer.selling(quantity);
                    System.out.println("Goods were bought from " + profitableManufacturer.getClass().getName() + " at the price " + profitablePrice + " per unit.");
                    System.out.println("Current storage value is " + profitableManufacturer.getStorage());
                }

            }
            }
        });


    }
    @Override
    public void start() {
        thread.start();
    }
}
