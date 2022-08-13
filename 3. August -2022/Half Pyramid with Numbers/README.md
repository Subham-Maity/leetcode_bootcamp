# 6.Half Pyramid with Numbers


## Exercise
Print the pattern using for loop


<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/6p.png?raw=true"/>
        </p>

## Approach:

<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/6p1.png?raw=true"/>
        </p>

## Solution

### Java :

```java
public class code_xam {
    public static void main(String[] args) {
        int n = 5;
 
        //For "Row"
        for (int i = 1; i <= n; i++) {
 
            //For "Column"
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);}
            System.out.println();
 
            }
            System.out.println();
        }
    }

```


### Python :


```python
for i in range(0, 5):
    num = 1
    for j in range(0, i+1):
        print(num, end=" ")
        num += 1
 
    print(" ")
```