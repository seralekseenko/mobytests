package seralekseenko.experiments;

import java.util.OptionalInt;


public class Finder {

  public static OptionalInt findIndex(int[] sortedArray, int target) {

    for (var index = 0; index < sortedArray.length; index++) {
      if (target == sortedArray[index]) {
        return OptionalInt.of(index);
      }
    }

    return OptionalInt.empty();


  }


}
