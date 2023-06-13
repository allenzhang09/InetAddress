import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskCacheTest {
    private TaskCache<String, Integer> taskCache;

    @BeforeEach
    public void setUp() {
        taskCache = new TaskCache<>(3);
    }

    @Test
    public void testPutAndGet() {
        taskCache.put("Task1", 1);
        taskCache.put("Task2", 2);

        assertEquals(1, taskCache.get("Task1"));
        assertEquals(2, taskCache.get("Task2"));
    }

    @Test
    public void testEdit() {
        taskCache.put("Task1", 1);
        taskCache.put("Task2", 2);

        taskCache.put("Task2", 3); // Edit Task2 with a new value

        assertEquals(1, taskCache.get("Task1"));
        assertEquals(3, taskCache.get("Task2"));
    }

    @Test
    public void testRemove() {
        taskCache.put("Task1", 1);
        taskCache.put("Task2", 2);
        taskCache.put("Task3", 3);

        taskCache.remove("Task2");

        assertEquals(1, taskCache.get("Task1"));
        assertNull(taskCache.get("Task2"));
        assertEquals(3, taskCache.get("Task3"));
    }

    @Test
    public void testClear() {
        taskCache.put("Task1", 1);
        taskCache.put("Task2", 2);

        taskCache.clear();

        assertEquals(0, taskCache.size());
        assertNull(taskCache.get("Task1"));
        assertNull(taskCache.get("Task2"));
    }

    @Test
    public void testEviction() {
        taskCache.put("Task1", 1);
        taskCache.put("Task2", 2);
        taskCache.put("Task3", 3);
        taskCache.put("Task4", 4); // Cache size exceeds the maximum capacity, Task1 should be evicted

        assertNull(taskCache.get("Task1")); // Task1 should be evicted
        assertEquals(2, taskCache.get("Task2"));
        assertEquals(3, taskCache.get("Task3"));
        assertEquals(4, taskCache.get("Task4"));
        assertEquals(3, taskCache.size()); // Cache size should be limited to the maximum capacity
    }
}
