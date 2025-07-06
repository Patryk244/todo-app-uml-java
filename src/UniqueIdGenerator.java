import java.util.HashSet;
import java.util.Random;


public class UniqueIdGenerator {
    private HashSet<Integer> usedIds;
    private  Random random;

    public UniqueIdGenerator() {
        this.usedIds = new HashSet<>();
        this.random = new Random();
    }

    public int generate() {
        boolean exist = true;
        int drawNumber = 0;

        while (exist) {
            drawNumber = random.nextInt(10000);
            System.out.println(drawNumber);

            if (!usedIds.contains(drawNumber)) {
                usedIds.add(drawNumber);
                exist = false;
            } else {
                System.out.println("Drawing new number again!");
            }
        }
        return drawNumber;
    }
    public void release(int number) {
        boolean isRemoved = usedIds.remove(number);
        if (isRemoved) {
            System.out.println("Removing successful");
        } else {
            System.out.println("Element doesn't exist.");
        }
    }
}