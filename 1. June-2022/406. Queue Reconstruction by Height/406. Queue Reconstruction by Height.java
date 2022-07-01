// heights need to be sorted in descending order
// if heights are equal sort them based on their K value
// insert the sorted array on the list based on their K value


// Sort people by tallest-person-first OR least-ppl-inFront-first
People (After sorting): [7 0] [7 1] [6 1] [5 0] [5 2] [4 4] 

// List status after each insertion
List: [7 0] 
List: [7 0] [7 1] 
List: [7 0] [6 1] [7 1] 
List: [5 0] [7 0] [6 1] [7 1] 
List: [5 0] [7 0] [5 2] [6 1] [7 1] 
List: [5 0] [7 0] [5 2] [6 1] [4 4] [7 1] 

// resultant queue
Queue: [5 0] [7 0] [5 2] [6 1] [4 4] [7 1] 




class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][2]);
    }
}








// Same Code
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            if(a[0]==b[0]) 
                return a[1]-b[1];
            return b[0]-a[0];
        });
        ArrayList<int[]> res= new ArrayList<>();
        for(int[] person: people){
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][2]);
    }
}







// Same Code

class Solution {
    public int[][] reconstructQueue(int[][] ppl) {
        Arrays.sort(ppl, (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        LinkedList<int[]> ll = new LinkedList<>();
        
        for(int[] person : ppl) ll.add(person[1], person);
        
        int[][] queue = new int[ppl.length][2];
        int index = 0;
        for(int[] person : ll) queue[index++] = person;
        
        return queue;
    }
}









// [Java] simple explainable solution ( Sorting + Greedy )

/**
 * eg. [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * first simply sort using comparator i.e., check first people[i][0] (hi) then people[i][1] (ki)
 * [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
 *
 * then start placing them in list using thier people[i][1] (ki)
 * as the no of people >= to them in height so, finally
 *
 * [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 */
tc: / sc: O(n*log(n)) / O(n)

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        
        // or we can aplly directly
        // Arrays.sort(people, (a,b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        
        int n = people.length;
        List<int[]> list = new ArrayList<>();
        
        for(int[] i : people) {
            list.add(i[1], new int[] {i[0], i[1]});
        }
        
        return list.toArray(new int[n][2]);
    }