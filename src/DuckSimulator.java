public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countingAndEchoDuckFactory = new CountingAndEchoDuckFactory();
        simulator.simulate(duckFactory,countingDuckFactory,countingAndEchoDuckFactory);
    }



    void simulate(AbstractDuckFactory duckFactory,
                  AbstractDuckFactory countingDuckFactory,
                  AbstractDuckFactory countingAndEchoDuckFactory){

        System.out.println("\n1.-------------------------");
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable pigeonDuck007 = new QuackCounter(new PigeonAdapter(new Pigeon()));
        Quackable gooseDuck007 = new QuackCounter(new GooseAdapter(new Goose()));
        simulate(mallardDuck);
        simulate(pigeonDuck007);
        simulate(gooseDuck007);
        printQuackCount();

        System.out.println("\n2.-------------------------");
        QuackCounter.setNumberOfQuacks(0);
        Quackable mallardDuck1 = new QuackCounter(new QuackEcho(new MallardDuck()));
        simulate(mallardDuck1);
        printQuackCount();
        Quackable mallardDuck2 = new QuackEcho(new QuackCounter(new MallardDuck()));
        simulate(mallardDuck2);
        printQuackCount();

        System.out.println("\n3.-------------------------");
        QuackCounter.setNumberOfQuacks(0);
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable redHeadDuck3 = countingDuckFactory.createRedheadDuck();
        Quackable duckCall3 = countingAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck3 = countingAndEchoDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");

        simulate(mallardDuck3);
        simulate(redHeadDuck3);
        simulate(duckCall3);
        simulate(rubberDuck3);

        printQuackCount();

        System.out.println("\n-------------------------" +
                "\n4.Duck Simulator: With Composite - Flocks");

        Quackable redheadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        System.out.println("Duck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);
    }

    void simulate(Quackable duck){
        duck.quack();
    }
    void printQuackCount(){
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }
}
