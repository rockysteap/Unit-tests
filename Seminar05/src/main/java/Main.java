import number.MaxNumberModule;
import number.RandomNumberModule;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {



        RandomNumberModule randModule = new RandomNumberModule();
        List<Integer> result = randModule.generate(6);

        MaxNumberModule maxValModule = new MaxNumberModule();
        Integer maxValue = maxValModule.findMax(result);

        System.out.println(result);
        System.out.println(maxValue);

    }

}
