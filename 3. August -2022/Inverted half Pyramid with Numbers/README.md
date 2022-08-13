# 7.Inverted half Pyramid with Numbers



## Exercise
Print the pattern using for loop



<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/7p.png?raw=true"/>
        </p>

## Approach:

<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/7p1.png?raw=true"/>
        </p>



## Solution

### Java :

```java

public class CodeXam {
    public static void main(String[] args) {
        for (int i = 5 ; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}


public class CodeXam {
    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            int num = 1;
            for (int j = 1; j <= i ; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

}




public class CodeXam {
    public static void main(String[] args) {
     for (int i = 5; i > 0; i--) {
         int num = 1;
         for (int j = i + 1; j > 1; j--) {
             System.out.print(num + " ");
             num++;
         }
         System.out.println(" ");
     }
    }

}


```

### C++

```cpp

#include <iostream>
using namespace std;
 int main()
 {
     for (int i = 5 ; i >= 1; i--)
     {
         for (int j = 1; j <= i; j++)
         {
             cout << j;
         }
         cout << endl;
     }
     return 0;
 }

```



### Python :


```python

for i in range(5, 0, -1):
    num = 1
    for j in range(i + 1, 1, -1):
        print(num, end=" ")
        num += 1
 
    print(" ")

```