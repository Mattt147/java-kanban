package Tests;

import managers.Managers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagersTest {
    Managers manager = new Managers();
    @Test
    void returninitialization() {
        Assertions.assertNotNull(manager.getDefault());
        Assertions.assertNotNull(manager.getDefaultHistory());
    }
}
