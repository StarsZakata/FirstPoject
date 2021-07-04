import java.lang.reflect.Array;
import java.util.*;

public class Laba1 {
    public static void main(String[] args) {

        ManufacturerAllFixed manufacturerAllFixed = new ManufacturerAllFixed();
        ManufacturerRandomGood manufacturerRandomGood = new ManufacturerRandomGood();
        ManufacturerAllRandom manufacturerAllRandom = new ManufacturerAllRandom();

        Consumer consumer = new Consumer(manufacturerAllFixed, manufacturerRandomGood, manufacturerAllRandom);

        ConsumerMethods[]  startConsumption = new ConsumerMethods[]{consumer};
        for (ConsumerMethods ob: startConsumption) {
            ob.init();
            ob.start();
        }

        ManufacturerMethods[] startManufacture = new ManufacturerMethods[]{manufacturerAllFixed, manufacturerRandomGood, manufacturerAllRandom};
        for (ManufacturerMethods ob: startManufacture) {
            ob.init();
            ob.start();
        }


//        ManufacturerMethods[] startManufactureTest = new ManufacturerMethods[]{manufacturerAllFixed};
//        for (ManufacturerMethods ob: startManufactureTest) {
//            ob.init();
//            ob.start();
//        }






//        Пример лямбда-функции
//        ArrayList<ManufacturerMethods> newList = new ArrayList<ManufacturerMethods>();
//        newList.add(manufacturerAllFixed);
//        newList.add(manufacturerRandomGood);
//        newList.add(manufacturerAllRandom);
//
//        newList.forEach(element -> element.init());










    }



}


