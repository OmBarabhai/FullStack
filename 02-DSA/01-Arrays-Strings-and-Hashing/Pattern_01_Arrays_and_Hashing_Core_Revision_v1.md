# Pattern 01 — Arrays, Strings, and Hashing

> **Goal:** Build reliable array/string reasoning and recognise when a HashSet, HashMap, frequency table or sort-based key removes repeated work.
>
> **Language:** Java. Keep one pattern revision file; add studied problems here instead of creating one Markdown file per problem.

## 1. What this pattern covers

- Detect whether a value has appeared before.
- Count frequency or compare multisets.
- Group values by a canonical key.
- Remember the first/last position of a value.
- Compare sequences without repeatedly scanning them.
- Use prefix/suffix summaries to avoid recomputing a range.

## 2. Recognition cues

| Prompt wording | First idea to test | Ask yourself |
|---|---|---|
| duplicate / repeated / unique | HashSet or frequency map | Membership only, or counts? |
| anagram / same characters | Frequency array or map | Is order irrelevant but multiplicity important? |
| group equivalent structures | Canonical key + HashMap | What key makes two items equivalent? |
| first/last occurrence | Value-to-index map | Earliest or latest index? |
| top frequent | Frequency map + heap/bucket | Ordered output or just top K? |
| product/range excluding current | Prefix/suffix contribution | Can division be avoided, including zeroes? |

A keyword is not proof. Explain what the data structure stores and why it is sufficient.

## 3. Java building blocks

```java
Map<Integer, Integer> frequency = new HashMap<>();
frequency.put(value, frequency.getOrDefault(value, 0) + 1);

Set<Integer> seen = new HashSet<>();
if (!seen.add(value)) {
    // value was already present
}
```

For a bounded alphabet such as lowercase English letters:

```java
int[] frequency = new int[26];
frequency[ch - 'a']++;
```

Do not assume lowercase input unless constraints say so. Choose a map or code-point handling for a larger alphabet.

## 4. Reasoning checklist

1. What information must be remembered from earlier elements?
2. Is membership enough, or do I need a count, index or grouped list?
3. Can two distinct inputs accidentally produce the same key?
4. What about duplicates, empty input, negative values or case differences?
5. Does output require original order or only a set/count?
6. Would sorting be simpler, and what would sorting do to indices/order?

## 5. Selected interview problem sequence

| Order | Problem | Platform | Difficulty | Main learning | Existing status |
|---:|---|---|---|---|---|
| 1 | [Contains Duplicate — LC 217](https://leetcode.com/problems/contains-duplicate/) | LeetCode | Easy | Set membership; expected O(n) scan | Diagnostic; not found in supplied solved list |
| 2 | [Two Sum — LC 1](https://leetcode.com/problems/two-sum/) | LeetCode | Easy | Complement lookup; map vs brute force | Verify independently before counting complete |
| 3 | [Valid Anagram — LC 242](https://leetcode.com/problems/valid-anagram/) | LeetCode | Easy | Frequency / character multiset | Not recorded in supplied solved list |
| 4 | [Group Anagrams — LC 49](https://leetcode.com/problems/group-anagrams/) | LeetCode | Medium | Canonical key and grouping | Previously practised; re-solve without notes |
| 5 | [Top K Frequent Elements — LC 347](https://leetcode.com/problems/top-k-frequent-elements/) | LeetCode | Medium | Map; bridge to heap/bucket | Previously practised; verify complexity |
| 6 | [Product of Array Except Self — LC 238](https://leetcode.com/problems/product-of-array-except-self/) | LeetCode | Medium | Prefix/suffix products without division | Core target unless already mastered |
| 7 | [Longest Consecutive Sequence — LC 128](https://leetcode.com/problems/longest-consecutive-sequence/) | LeetCode | Medium | Start only at sequence beginnings | Core target |
| 8 | [Majority Element — LC 169](https://leetcode.com/problems/majority-element/) | LeetCode | Easy | Frequency map vs Boyer–Moore follow-up | Core target |
| 9 | [Valid Sudoku — LC 36](https://leetcode.com/problems/valid-sudoku/) | LeetCode | Medium | Row/column/box state encoding | Optional after core |
| 10 | [Subarray Sum Equals K — LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | LeetCode | Medium | Prefix sum + frequency map | Study in Prefix Sum; cross-link here |

Do not solve all ten mechanically when an existing tracker shows mastery. Re-test once and move on if you pass independently.

## 6. Worked memory — frequency difference

For two strings to be anagrams, each character must appear equally often.

```text
Input A: listen
Input B: silent

Counts start at 0.
Read A: add 1 for each character.
Read B: subtract 1 for each character.
All counts end at 0 → same character multiset.
```

Invariant: counts represent the difference between processed characters in A and B. At the end every count must be zero.

## 7. Common mistakes

- Using a Set when frequency counts are required.
- Forgetting duplicate multiplicity in anagrams/multisets.
- Building an ambiguous canonical key.
- Overwriting an earlier index when the earliest is required.
- Claiming strict O(1) HashMap operations; describe expected/amortised O(1).
- Sorting and then relying on original order or indices.
- Ignoring integer overflow in sums/products.

## 8. Complexity checkpoints

| Technique | Typical time | Typical extra space |
|---|---:|---:|
| One pass with HashSet/HashMap | O(n) expected | O(n) |
| Sort then scan | O(n log n) | Depends on sort/copy |
| Fixed-size frequency array | O(n + alphabet) | O(alphabet) |
| Prefix/suffix arrays | O(n) | O(n), reducible in selected cases |

## 9. Mastery gate

Mark this pattern Interview-ready only when you can explain why the data structure is sufficient, derive brute force and its bottleneck, code Java from a blank editor, handle edge cases, state complexity accurately, and solve one unseen variation without being told the pattern.

## 10. Today's session record

| Field | Record |
|---|---|
| Date | __________ |
| Problem | Contains Duplicate — LC 217 (diagnostic) |
| First approach | __________ |
| Optimised approach | __________ |
| What did the Set store? | __________ |
| Time / space | __________ |
| Independent? | Yes / No |
| Mistake to remember | __________ |
| R1 / R2 / R3 | __________ |
