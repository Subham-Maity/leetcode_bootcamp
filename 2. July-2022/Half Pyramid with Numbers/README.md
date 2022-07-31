# Half Pyramid



## Exercise
Print the pattern using for loop

<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/3p.png?raw=true"/>
        </p>

## Approach:

<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/3pa.png?raw=true"/>
        </p>

## Solution

### Java :

```java
public class code_xam {
    public static void main(String[] args) {
 
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
 
            System.out.println();
        }
    }
}



```


### Python :

```python
for i in range(0, 5):
    for j in range(0, i + 1):
        print("*", end=" ")
 
    print(" ")
```
