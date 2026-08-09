package DSA.A_Recursion.G_Mathematical_Number_Recursion;

/*
 * =========================================================
 * G67 — Tower of Hanoi
 * Pattern : Mathematical / Multiple Recursion
 * =========================================================
 *
 * PROBLEM:
 *
 * Move all disks from FROM rod to TO rod
 * using HELPER rod.
 *
 * Rules:
 *
 * 1. Move only one disk at a time.
 * 2. Only the top disk can be moved.
 * 3. Bigger disk cannot be placed on a smaller disk.
 *
 *
 * =========================================================
 * KISS IDEA
 * =========================================================
 *
 * To move N disks:
 *
 *     1. Move N-1 disks
 *            FROM → HELPER
 *
 *     2. Move current/largest disk
 *            FROM → TO
 *
 *     3. Move N-1 disks
 *            HELPER → TO
 *
 *
 * MEMORY:
 *
 *     N-1 → 1 → N-1
 *
 *
 * WHY N-1?
 *
 * Example:
 *
 *       1
 *      2
 *     3
 *
 * To move disk 3:
 *
 *     Disk 1 and Disk 2 are above it.
 *
 * So first move:
 *
 *     3 - 1 = 2 disks
 *
 * Therefore:
 *
 *     N-1 = smaller disks
 *
 * =========================================================
 */

public class G67TowerOfHanoi {

    /*
     * Returns the minimum number of moves.
     *
     * diskCount = number of disks
     * fromRod   = starting rod
     * toRod     = destination rod
     * helperRod = helper rod
     */
    public static int towerOfHanoi(
            int diskCount,
            int fromRod,
            int toRod,
            int helperRod) {

        // =================================================
        // BASE CASE
        // =================================================
        //
        // If there is only 1 disk:
        //
        //     It needs exactly 1 move.
        //
        if (diskCount <= 1) {
            return diskCount;
        }

        // =================================================
        // STEP 1 — FIRST RECURSIVE CALL
        // =================================================
        //
        // Move N-1 smaller disks:
        //
        //     FROM → HELPER
        //
        // IMPORTANT:
        //
        // Java goes inside this recursive call FIRST.
        //
        // The code below this call does NOT execute yet.
        //
        int firstMoves = towerOfHanoi(
                diskCount - 1,
                fromRod,
                helperRod,
                toRod
        );

        // =================================================
        // STEP 2 — CURRENT DISK
        // =================================================
        //
        // The first recursive call has now returned.
        //
        // So the smaller disks are out of the way.
        //
        // Now move the current/largest disk:
        //
        //     FROM → TO
        //
        // Exactly ONE move.
        //
        // IMPORTANT:
        //
        // currentMove = 1 does NOT physically move a disk.
        //
        // It simply COUNTS the current disk's one move.
        //
        int currentMove = 1;

        // =================================================
        // STEP 3 — SECOND RECURSIVE CALL
        // =================================================
        //
        // Now move the N-1 smaller disks:
        //
        //     HELPER → TO
        //
        int secondMoves = towerOfHanoi(
                diskCount - 1,
                helperRod,
                toRod,
                fromRod
        );

        // =================================================
        // TOTAL
        // =================================================
        //
        // First N-1 moves
        // + current disk = 1 move
        // + second N-1 moves
        //
        return firstMoves + currentMove + secondMoves;
    }

    /*
     * =====================================================
     * MAIN
     * =====================================================
     */
    public static void main(String[] args) {

        int diskCount = 3;

        int fromRod = 1;
        int toRod = 2;
        int helperRod = 3;

        int totalMoves = towerOfHanoi(
                diskCount,
                fromRod,
                toRod,
                helperRod
        );

        System.out.println("Minimum moves = " + totalMoves);
    }
}


/*
 * =========================================================
 * DRY RUN — N = 2
 * =========================================================
 *
 * Start:
 *
 *     towerOfHanoi(2, A, C, B)
 *
 * Meaning:
 *
 *     2 disks
 *     A = FROM
 *     C = TO
 *     B = HELPER
 *
 *
 * ---------------------------------------------------------
 * STEP 1
 * ---------------------------------------------------------
 *
 * Code:
 *
 *     firstMoves = towerOfHanoi(
 *         diskCount - 1,
 *         fromRod,
 *         helperRod,
 *         toRod
 *     );
 *
 *
 * Replace:
 *
 *     diskCount = 2
 *     fromRod   = A
 *     toRod     = C
 *     helperRod = B
 *
 *
 * So Java calls:
 *
 *     towerOfHanoi(1, A, B, C)
 *
 *
 * Meaning:
 *
 *     Move 1 disk:
 *
 *         A → B
 *
 *
 * Since diskCount = 1:
 *
 *     return 1
 *
 *
 * Therefore:
 *
 *     firstMoves = 1
 *
 *
 * IMPORTANT:
 *
 * Java now comes BACK to:
 *
 *     towerOfHanoi(2, A, C, B)
 *
 *
 * ---------------------------------------------------------
 * STEP 2
 * ---------------------------------------------------------
 *
 * Code:
 *
 *     int currentMove = 1;
 *
 *
 * The first recursive call is finished.
 *
 * Now the smaller disk is out of the way.
 *
 * Current disk = Disk 2
 *
 * Therefore:
 *
 *     Disk 2: A → C
 *
 *
 * currentMove = 1
 *
 *
 * ---------------------------------------------------------
 * STEP 3
 * ---------------------------------------------------------
 *
 * Code:
 *
 *     secondMoves = towerOfHanoi(
 *         diskCount - 1,
 *         helperRod,
 *         toRod,
 *         fromRod
 *     );
 *
 *
 * Replace:
 *
 *     diskCount = 2
 *     helperRod = B
 *     toRod     = C
 *     fromRod   = A
 *
 *
 * So Java calls:
 *
 *     towerOfHanoi(1, B, C, A)
 *
 *
 * Meaning:
 *
 *     Move 1 disk:
 *
 *         B → C
 *
 *
 * Base case:
 *
 *     return 1
 *
 *
 * Therefore:
 *
 *     secondMoves = 1
 *
 *
 * ---------------------------------------------------------
 * FINAL
 * ---------------------------------------------------------
 *
 *     firstMoves  = 1
 *     currentMove = 1
 *     secondMoves = 1
 *
 *
 *     return 1 + 1 + 1
 *
 *     = 3
 *
 *
 * Therefore:
 *
 *     2 disks = 3 moves
 *
 *
 * =========================================================
 * VISUAL — N = 2
 * =========================================================
 *
 *
 * START:
 *
 *     A          B          C
 *
 *     2
 *     1
 *
 *
 * FIRST RECURSIVE CALL:
 *
 *     towerOfHanoi(1, A, B, C)
 *
 *              ↓
 *
 *     Disk 1: A → B
 *
 *
 *     A          B          C
 *
 *     2          1
 *
 *
 * CURRENT MOVE:
 *
 *     currentMove = 1
 *
 *              ↓
 *
 *     Disk 2: A → C
 *
 *
 *     A          B          C
 *
 *                1          2
 *
 *
 * SECOND RECURSIVE CALL:
 *
 *     towerOfHanoi(1, B, C, A)
 *
 *              ↓
 *
 *     Disk 1: B → C
 *
 *
 *     A          B          C
 *
 *                           2
 *                           1
 *
 *
 * FINAL:
 *
 *     3 moves
 *
 *
 * =========================================================
 * DRY RUN — N = 3
 * =========================================================
 *
 * Start:
 *
 *     towerOfHanoi(3, A, C, B)
 *
 *
 * Think:
 *
 *     3 disks
 *
 *       ↓
 *
 *     Move 2 disks A → B
 *
 *       ↓
 *
 *     Move Disk 3 A → C
 *
 *       ↓
 *
 *     Move 2 disks B → C
 *
 *
 * We already know:
 *
 *     2 disks = 3 moves
 *
 *
 * Therefore:
 *
 *     3 + 1 + 3
 *
 *     = 7 moves
 *
 *
 * =========================================================
 * RECURSION TREE — N = 3
 * =========================================================
 *
 *
 *                    Hanoi(3, A, C, B)
 *                             |
 *                             |
 *                       FIRST CALL
 *                             |
 *                             ↓
 *                    Hanoi(2, A, B, C)
 *                             |
 *                    ┌────────┴────────┐
 *                    ↓                 ↓
 *             Hanoi(1,A,C,B)     Hanoi(1,C,B,A)
 *
 *
 * IMPORTANT:
 *
 * The CURRENT MOVE happens BETWEEN
 * these two recursive calls.
 *
 *
 * So Hanoi(2, A, B, C) works like:
 *
 *
 *     FIRST CALL
 *          ↓
 *     Hanoi(1,A,C,B)
 *          ↓
 *       return 1
 *          ↓
 *     CURRENT MOVE
 *          ↓
 *     Disk 2: A → B
 *          ↓
 *     SECOND CALL
 *          ↓
 *     Hanoi(1,C,B,A)
 *          ↓
 *       return 1
 *
 *
 * Therefore:
 *
 *     1 + 1 + 1
 *     = 3
 *
 *
 * =========================================================
 * FULL N = 3 FLOW
 * =========================================================
 *
 *
 *                 Hanoi(3, A, C, B)
 *                          |
 *                          ↓
 *              FIRST: Hanoi(2, A, B, C)
 *                          |
 *                          ↓
 *                 FIRST: Hanoi(1, A, C, B)
 *                          |
 *                          ↓
 *                       return 1
 *                          |
 *                          ↑
 *                 BACK TO Hanoi(2)
 *                          |
 *                          ↓
 *                 currentMove = 1
 *                          |
 *                          ↓
 *                    Disk 2: A → B
 *                          |
 *                          ↓
 *              SECOND: Hanoi(1, C, B, A)
 *                          |
 *                          ↓
 *                       return 1
 *                          |
 *                          ↑
 *                 Hanoi(2) returns 3
 *                          |
 *                          ↑
 *                BACK TO Hanoi(3)
 *                          |
 *                          ↓
 *                   currentMove = 1
 *                          |
 *                          ↓
 *                    Disk 3: A → C
 *                          |
 *                          ↓
 *              SECOND: Hanoi(2, B, C, A)
 *                          |
 *                    ┌─────┴─────┐
 *                    ↓           ↓
 *              Hanoi(1,B,A,C)  Hanoi(1,A,C,B)
 *                    ↓           ↓
 *                 return 1    return 1
 *                          |
 *                          ↓
 *                    Disk 2: B → C
 *                          |
 *                          ↓
 *                    Hanoi(2) returns 3
 *                          |
 *                          ↓
 *                    Hanoi(3) returns 7
 *
 *
 * =========================================================
 * VERY IMPORTANT — HOW RECURSION WORKS
 * =========================================================
 *
 * When Java sees:
 *
 *     firstMoves = towerOfHanoi(...);
 *
 * Java says:
 *
 *     "I cannot calculate firstMoves yet.
 *      I must first finish this recursive call."
 *
 *
 * So:
 *
 *     FIRST CALL
 *          ↓
 *       GO DOWN
 *          ↓
 *     BASE CASE
 *          ↓
 *       RETURN
 *          ↓
 *     COME BACK
 *          ↓
 *     currentMove
 *          ↓
 *     SECOND CALL
 *          ↓
 *       GO DOWN
 *          ↓
 *     BASE CASE
 *          ↓
 *       RETURN
 *          ↓
 *     FINAL RETURN
 *
 *
 * =========================================================
 * ACTUAL MOVES — N = 3
 * =========================================================
 *
 * 1. Disk 1: A → B
 *
 * 2. Disk 2: A → C
 *
 * 3. Disk 1: B → C
 *
 * 4. Disk 3: A → C
 *
 * 5. Disk 1: B → A
 *
 * 6. Disk 2: B → C
 *
 * 7. Disk 1: A → C
 *
 *
 * =========================================================
 * PARAMETER MOVEMENT
 * =========================================================
 *
 * FIRST CALL:
 *
 *     towerOfHanoi(
 *         diskCount - 1,
 *         fromRod,
 *         helperRod,
 *         toRod
 *     );
 *
 *
 * Means:
 *
 *     N-1 disks
 *
 *     FROM → HELPER
 *
 *
 * CURRENT MOVE:
 *
 *     FROM → TO
 *
 *
 * SECOND CALL:
 *
 *     towerOfHanoi(
 *         diskCount - 1,
 *         helperRod,
 *         toRod,
 *         fromRod
 *     );
 *
 *
 * Means:
 *
 *     N-1 disks
 *
 *     HELPER → TO
 *
 *
 * =========================================================
 * REVISION CARD
 * =========================================================
 *
 * G67 — Tower of Hanoi
 *
 *
 * Core:
 *
 *     N-1 → 1 → N-1
 *
 *
 * First:
 *
 *     FROM → HELPER
 *
 *
 * Current:
 *
 *     FROM → TO
 *
 *
 * Second:
 *
 *     HELPER → TO
 *
 *
 * For N = 3:
 *
 *     2 disks → Disk 3 → 2 disks
 *
 *     3 moves → 1 move → 3 moves
 *
 *     = 7 moves
 *
 *
 * =========================================================
 * ONE-LINE MEMORY
 * =========================================================
 *
 *     Move smaller away
 *            ↓
 *     Move biggest
 *            ↓
 *     Move smaller onto it
 *
 *
 * =========================================================
 */
 /* =========================================================
 * REVISION CARD
 * =========================================================
 *
 * G67 — Tower of Hanoi
 *
 * Think:
 *
 *     "Move smaller disks away,
 *      move biggest disk,
 *      move smaller disks back."
 *
 *
 * Core:
 *
 *     N-1 → 1 → N-1
 *
 *
 * Movement:
 *
 *     FROM → AUX
 *     FROM → TO
 *     AUX  → TO
 *
 *
 * Number of moves:
 *      N = totDisk
 *     (2^N) - 1
 *     Disk {(2^totDisk) - 1} → Moves
 *
 * Examples:
 *
 *    Disk {(2^totDisk) - 1} → Moves
 *    Disk {(2^1) - 1} → 1 Move  = 1 disk → 1 move
 *    Disk {(2^2) - 1} → 2 Move  = 2 disks → 3 moves
 *    Disk {(2^3) - 1} → 3 Move  = 3 disks → 7 moves
 *    Disk {(2^4) - 1} → 4 Move  = 4 disks → 15 moves
 *
 *
 * =========================================================
 * WHAT YOU NEED TO REMEMBER
 * =========================================================
 *
 * Do NOT memorize every recursive call.
 *
 * Remember:
 *
 *     N-1 → 1 → N-1
 *
 * And:
 *
 *     FROM → AUX
 *     FROM → TO
 *     AUX  → TO
 *
 * If you understand those two things,
 * you can recreate the code.
 *
 * =========================================================
 */