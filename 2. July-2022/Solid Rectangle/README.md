# 1.(Solid Rectangle)

## Exercise
Print the pattern using for loop

<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/1%20p.png?raw=true"/>
        </p>

## Approach:
```javascript
So here we did like this
Row range:0-4 
Column range:0-5
```
<p align="center">
        <img src="https://github.com/Subham-Maity/java-python-problem-solving-series/blob/master/Image(ignore)/1pa.png?raw=true"/>
        </p>

## Solution

### Java :

```java

public class code_xam {
    public static void main(String[] args) {
        for (int i = 1 ; i <=4 ; i++){
            for (int j = 1; j <=5 ; j++){
                System.out.print("*");}
                System.out.println();
            }
        }
    }


```


### Python :

```python
for i in range(1, 5):
    for j in range(1, 6):
        print("*", end=" ")
    print()
```