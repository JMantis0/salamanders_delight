package base.utils;

import java.util.Map;
/**
 * <h1>ContextClearer Utility</h1>
 * <h2>Object for clearing particular context elements</h2>
 * <p>Makes clearing contexts simple.</p>
 * <p>Used when a user 'quit's during runtime</p>
 *
 */
public class ContextClearer {

    public void clearTempContexts(Map<String, Object> context) {
        context.remove("CurrentUser");
        context.remove("CurrentEmp");
        context.remove("CurrentAccount");
        context.remove("InvalidUser");
        context.remove("CurrentEmp");
        context.remove("InvalidAccount");
        context.remove("CurrentUserAccounts");
    }
}
