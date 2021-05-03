package base;

import java.util.Map;

public abstract class AbstractApp {
    protected String title;
    protected Map<String, Object> context;
    protected abstract void run(Map<String, Object> context);
}
