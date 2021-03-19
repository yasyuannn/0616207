import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {

    public static Stream<Arguments> getParameters() {
        return Stream.of(
                arguments(new int[]{1, 4, 2, 3}, new int[]{2, 2, 3, 4}),
                arguments(new int[]{5, 3, 4, 2}, new int[]{3, 3, 4, 5}),
                arguments(new int[]{1, 6, 2, 0}, new int[]{1, 1, 2, 6}),
                arguments(new int[]{7, 9, 8, 4}, new int[]{5, 7, 8, 9}),
                arguments(new int[]{0, 8, 5, 7}, new int[]{0, 5, 7, 8})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument = {0}, {1}")
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input, int[] expected) {
        PriorityQueue priorityQueueInput = new PriorityQueue();
        for (int e : input) {
            priorityQueueInput.offer(e);
        }
        for (int e : expected) {
            assertEquals(e, priorityQueueInput.poll());
        }
    }

    @Test
    public void InitialCapacityTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           new PriorityQueue(-1, null);
        });
    }

    @Test
    public void OfferTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void ForEachRemainingTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }
}
