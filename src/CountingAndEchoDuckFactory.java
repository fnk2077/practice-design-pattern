public class CountingAndEchoDuckFactory extends AbstractDuckFactory{

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new QuackEcho(new RubberDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new QuackEcho(new DuckCall()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new QuackEcho(new RedheadDuck()));
    }

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new QuackEcho(new MallardDuck()));
    }
}
