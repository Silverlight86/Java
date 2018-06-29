package Misc;

import java.util.LinkedList;
import java.util.List;

/*
 * A TrainComposition is built by attaching and detaching wagons from the left and the right sides.

  For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13, again from the left, we get a composition of two wagons (13 and 7 from left to right). Now the first wagon that can be detached from the right is 7 and the first that can be detached from the left is 13.
  
  Implement a TrainComposition that models this problem.
 */

public class TrainComposition {
  List<Integer> wagon = new LinkedList<>();

  public void attachWagonFromLeft(int wagonId) {
    this.wagon.add(0, wagonId);
  }

  public void attachWagonFromRight(int wagonId) {
    this.wagon.add(wagonId);
  }

  public int detachWagonFromLeft() {
    int wagon = this.wagon.get(0);
    this.wagon.remove(0);
    return wagon;
  }

  public int detachWagonFromRight() {
    int wagon = this.wagon.get(this.wagon.size() - 1);
    this.wagon.remove(this.wagon.size() - 1);
    return wagon;
  }

  public static void main(String[] args) {
    TrainComposition tree = new TrainComposition();
    tree.attachWagonFromLeft(7);
    tree.attachWagonFromLeft(13);
    System.out.println(tree.detachWagonFromRight()); // 7 
    System.out.println(tree.detachWagonFromLeft()); // 13
  }
}
