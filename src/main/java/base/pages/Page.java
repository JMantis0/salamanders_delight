package base.pages;

import java.util.Map;

public interface Page {
    abstract Page doPage(Map<String, Object> context);
}
