package muditse.eventbus;

public abstract class Observer {

    protected Subject subject;

    abstract protected void update(Object obj);
}
