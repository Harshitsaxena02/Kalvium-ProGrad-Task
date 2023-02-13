import java.util.ArrayList;

public class ChangeCalculate {
  private int[] coinDenominations;
  private int[] coinCounts;

  public ChangeCalculate(int[] coinDenominations, int[] coinCounts) {
    this.coinDenominations = coinDenominations;
    this.coinCounts = coinCounts;
  }

  public int[] calculateChange(int changeAmount) {
    ArrayList<Integer> change = new ArrayList<Integer>();
    for (int i = coinDenominations.length - 1; i >= 0; i--) {
      int coinValue = coinDenominations[i];
      while (changeAmount >= coinValue && coinCounts[i] > 0) {
        changeAmount -= coinValue;
        change.add(coinValue);
        coinCounts[i]--;
      }
    }
    if (changeAmount != 0) {
      // Not enough coins to make change
      return null;
    } else {
      int[] result = new int[change.size()];
      for (int i = 0; i < result.length; i++) {
        result[i] = change.get(i);
      }
      return result;
    }
  }

  public static void main(String[] args) {
    int[] britishCoinDenominations = {1, 2, 5, 10, 20, 50};
    int[] britishCoinCounts = {10, 10, 10, 10, 10, 10};
    ChangeCalculate britishChangeCalculator = new ChangeCalculate(britishCoinDenominations, britishCoinCounts);
    int[] change = britishChangeCalculator.calculateChange(43);
    if (change != null) {
      System.out.println("Change: " + java.util.Arrays.toString(change));
    } else {
      System.out.println("Not enough coins to make change.");
    }
  }
}