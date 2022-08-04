# 4.(Inverted half Pyramid )

# 1 to 9 all Pattern Quality Loss canvas Download [here](https://raw.githubusercontent.com/Subham-Maity/java-python-problem-solving-series/master/Image(ignore)/Total%209%20pattern%20problem%20in%201%20canvas%20.svg)
# 9 to 19 all Pattern Quality Loss canvas Download [here](https://raw.githubusercontent.com/Subham-Maity/java-python-problem-solving-series/master/Image(ignore)/9-19%20all%20pattern%20canvas%20.svg)


## Exercise
Print the pattern using for loop


<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/4p.png?raw=true"/>
        </p>

## Approach:

<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/4p1.png?raw=true"/>
        </p>

## Solution

### Java :

```java
public class CodeXam {
    public static void main(String[] args) {
        for(int i=1; i<=4; i++ ){
            for(int j=4; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

public class CodeXam {
    public static void main(String[] args) {
        for (int i = 4 ; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

public class CodeXam {
    public static void main(String[] args) {
       for (int i = 4; i >= 1; i--) {
            for (int j = i ; j >= 1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}


```


### Python :


```python
for i in range(4, 0, -1):
    for j in range(i + 1, 1, -1):
        print("* ", end="")
 
    print(" ")

```
