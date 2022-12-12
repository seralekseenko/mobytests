package seralekseenko.experiments;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class FinderTest {

  private final Random rnd = ThreadLocalRandom.current();

  @RepeatedTest(50)
  @DisplayName("'findIndex' method with typical arguments ...")
  public void findIndex() {
    //preparing data
    var uniqueSortedInts = rnd.ints(-50, 50)
        .distinct() // for unique numbers
        .limit(100) // breaking infinity cycle
        .sorted()
        .toArray();
    var expectedIndex = rnd.nextInt(0, 100);
    var target = uniqueSortedInts[expectedIndex];
    var message = "input array: %s%ninput target: %d".formatted(Arrays.toString(uniqueSortedInts),
        target);
    // run the action
    var result = assertDoesNotThrow(() -> Finder.findIndex(uniqueSortedInts, target).getAsInt(),
        "Unexpected exception with valid arguments!");
    // check the result
    assertWithMessage(message)
        .that(result)
        .isEqualTo(expectedIndex);
  }
}