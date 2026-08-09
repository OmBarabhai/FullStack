public class R1G67TowerOfHanoi {

    public static int hanoiTower(int n, int from, int to, int dest) {

        // BASE CASE:
        // 0 disks = 0 moves
        // 1 disk  = 1 move
        if (n <= 1) {
            return n;
        }

        // Move n-1 disks:
        // from -> dest
        int start = hanoiTower(n - 1, from, dest, to);

        // Move the largest disk:
        int curr = 1;

        // Move n-1 disks:
        // dest -> to
        int end = hanoiTower(n - 1, dest, to, from);

        // Total moves
        return start + curr + end;
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println(hanoiTower(n, 1, 2, 3));
    }
}

/*
R1 QUICK REVISION

Tower of Hanoi:

1. Move n-1 disks from -> dest
2. Move largest disk from -> to
3. Move n-1 disks dest -> to

Recursion:

T(n) = T(n-1) + 1 + T(n-1)

     = 2T(n-1) + 1

Example n = 3:

hanoi(3)
   |
   +-- hanoi(2)
   |      |
   |      +-- hanoi(1) = 1
   |      +-- current  = 1
   |      +-- hanoi(1) = 1
   |
   +-- current = 1
   |
   +-- hanoi(2)
          |
          +-- hanoi(1) = 1
          +-- current  = 1
          +-- hanoi(1) = 1

Total:

3 disks
= 3 + 1 + 3
= 7 moves

Answer = 7

Pattern:

n
↓
solve n-1
↓
current move = 1
↓
solve n-1
↓
return total

Time: O(2^n)
Space: O(n)
*/