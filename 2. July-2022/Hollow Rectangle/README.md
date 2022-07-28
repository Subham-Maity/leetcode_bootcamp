# Hollow Rectangle


## Exercise
Print the pattern using for loop
<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/2p.png?raw=true"/>
        </p>

## Approach:
<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/2pa.png?raw=true"/>
        </p>

## Solution

### Java :

```java
public class code_xam {
    public static void main(String[] args) {
 
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=5; j++) {
                if(i == 1 || i == 4 || j == 1 || j == 5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}



```


### Python :

```python
for i in range(1, 5):
    for j in range(1, 6):
        if (i == 1 or i == 4 or
                j == 1 or j == 5):
            print("*", end=" ")
        else:
            print(" ", end=" ")
 
    print()
 

```