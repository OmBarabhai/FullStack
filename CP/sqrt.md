# LC 69 — Sqrt(x)

## Type

Binary Search on Values

---

## Pattern Clue

* Square Root
* Search on numbers
* Largest valid value

---

## Main Idea

Find largest value where:

mid^2 \le x

If exact root not possible:

* return closest smaller integer

---

## Search Space

```java id="’wini171"
st = 1
en = x
```

Special Case:

```java id="’wini172"
if(x <= 1) return x;
```

---

## Important Observation

Avoid:

```java id="’wini173"
mid * mid
```

Reason:
Overflow possible.

Use:

```java id="’wini174"
mid == x / mid
mid < x / mid
```

Safe approach.

---

## Movement Logic

### Exact Root

```java id="’wini175"
mid == x / mid
```

Return mid.

---

### Valid Answer

```java id="’wini176"
mid < x / mid
```

```java id="’wini177"
ans = mid
st = mid + 1
```

Reason:
Try bigger valid value.

---

### Too Large

```java id="’wini178"
mid > x / mid
```

```java id="’wini179"
en = mid - 1
```

Reason:
Square exceeded x.

---

## Potential Answer Concept

Store closest smaller valid value.

Example:

```text id="’wini17a"
x = 56
```

```text id="’wini17b"
7 * 7 = 49
8 * 8 = 64
```

Answer:

```text id="’wini17c"
7
```

---

# Decimal Precision (CP Approach)

## Main Idea

After integer square root:
improve answer digit by digit.

Example:

```text id="’wini17d"
7
7.1
7.2
7.3
...
7.48
7.483
```

---

## Precision Logic

Use factor:

```text id="’wini17e"
1
0.1
0.01
0.001
```

Each round:

* increases one decimal place

---

## Precision Template

```java id="’wini17f"
double factor = 1;

for(int round = 1; round <= precision; round++){

    factor = factor / 10;

    for(int i = 1; i <= 10; i++){

        double newAns = ans + factor;

        if(newAns * newAns < x){
            ans = newAns;
        }
        else{
            break;
        }
    }
}
```

---

## Epsilon Concept

Epsilon:

```text id="’wini17g"
very small acceptable error
```

Example:

```text id="’wini17h"
0.000001
```

Used for:

```text id="’wini17i"
double comparison
```

Example:

```java id="’wini17j"
Math.abs(a - b) < epsilon
```

---

## Important Observation

For normal CP precision approach:

```text id="’wini17k"
epsilon usually NOT needed
```

Because:

* precision is manually controlled
* factor already limits decimal places

---

## Complexity

```text id="’wini17l"
Time  : O(log x)
Space : O(1)
```

---

## Final Revision Lines

```text id="’wini17m"
Find largest value where:
mid * mid <= x
```

```text id="’wini17n"
Use x / mid to avoid overflow
```

```text id="’wini17o"
Store potential answer when value is valid
```

```text id="’wini17p"
Use factor method for decimal precision
```
