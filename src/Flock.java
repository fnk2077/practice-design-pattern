import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();
    boolean leader = true;

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
            if(leader){
                quacker.quack();
                quacker.quack();
                leader = false;
            }
        }
    }
}
