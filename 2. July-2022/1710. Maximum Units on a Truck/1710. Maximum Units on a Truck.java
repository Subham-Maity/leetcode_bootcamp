Method 1: Sort reversely

public int maximumUnits(int[][] boxTypes, int truckSize) {
     // Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // b[1] - a[1] may cause int overflow, credit to @Zudas.
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            }else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }
        return boxes;
    }



Method 2: Counting sort

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        for (int[] box : boxTypes) {
            count[box[1]] += box[0];
        }
        int boxes = 0;
        for (int units = 1000; units > 0; --units) {
            if (count[units] > 0) {
                int fitIn = Math.min(count[units], truckSize);
                boxes += units * fitIn;
                truckSize -= fitIn;
                if (truckSize == 0) {
                    return boxes;
                }
            }
        }
        return boxes;
    }









Analysis:
Time: O(nlogn), space: O(logn) - java quicksort O(n) - both java 7+ and Python 3 use timsort for this specific case.



Q & A
Q1: What does this param mean? key=lambda x: -x[1]

A1: It is a small anonymous function, called lambda function, used to sort boxTypes.
Syntax is as follows:

lambda arguments : expression
Accordingly, x, variable representing any box type, is the only argument; -x[1] is the expression of the function.

key is from the individual items of boxTypes, x; And we sort them according to the value at index 1 of x (which is numberOfUnitsPerBoxi) reversely (-x[1]).

Q2: Why greedy algorithm works with this problem and why we don't need to use knapsack dp? how do we know when a problem is knapsack or when it is greedy?

A2: In this problem, it says "You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize." That means we do NOT need to treat the boxes of same box type as inseparable. E.g., if necessary to get optimal solution, we can choose 1, 2, ..., or i boxes from a certain type, when we put boxes onto the truck. Therefore, we should put the type of boxes with the most units in order to achieve maximum units.

If the problem changes the rule to "If you choose a box type, you must choose all of the boxes of this type", it is same as the Knapsack problem and we have to use DP to solve it.

In Knapsack problem, different items have different weights and there is a total weight limit, and we can NOT break items into
pieces to get optimal solution. Therefore, there is no way to apply greedy algorithm. Of couse, if we are allowed to break the items into arbitrary units of weight, it is same as this truck problem and we can apply greedy algorithm.

Strictly speaking, when using greedy algorithm to solve a problem, we need to justity its correctness by proving its: 1) Greedy choice property and 2)optimal substructure property. You can refer my proof in 881. Boats to Save People for reference.

Typically, Knapsack problem often arises in resource allocation where the decision makers have to choose from a set of non-divisible objects, projects or tasks under a fixed budget or time constraint, respectively.

Q3: Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); can anyone explain what this means?

@Zudas provides the following excellent answer.
A3: This means we're sorting our array boxTypes based on descending values of column 1(0 indexed).

Let boxTypes be
[[1,  4],
 [22, 9],  
 [13, 2],
 [9,  1]]
Then After sorting
[[22, 9],
 [1,  4]
 [13, 2], 
 [9,  1]]
You can Google more about Comparators or 2-D Array Sorting.
Note: It's always better to use Integer.compare(b[1], a[1]) instead of b[1] - a[1] cause latter might overflow.

End of Q & A