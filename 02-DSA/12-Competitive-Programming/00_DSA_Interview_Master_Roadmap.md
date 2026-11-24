`# DSA Interview Master Roadmap

> **Mission:** Build durable problem-solving ability for software engineering coding interviews over three years. This is an interview-preparation system, not a competitive-programming syllabus.
>
> **Language:** Java. **Daily baseline:** One deliberate problem session of 30–60 minutes. Consistency and independent reasoning matter more than platform streaks or rankings.

## 1. Mastery over problem count

Use a curated working target of roughly **220–300 distinct interview-quality problems across all DSA topics**, including useful problems you have already studied. This is a planning range, not a quota. The remaining time is for re-solving, variations, mixed practice, mock interviews and communication.

A problem status means:
- **Seen:** read the prompt or watched an explanation.
- **Attempted:** wrote an approach/code, but did not finish independently.
- **Solved:** accepted solution, possibly with hints.
- **Independent:** solved from a blank editor without hints or copied code.
- **Interview-ready:** can explain correctness, complexity, edge cases and alternatives under time pressure.
- **Needs revision:** cannot currently reconstruct or explain it.

An accepted submission alone does not prove mastery.

## 2. Standard problem-solving protocol

1. Restate input, output and expected behaviour.
2. Clarify constraints, duplicates, empty input, negatives, ordering and assumptions.
3. Build a normal example and an edge case.
4. Describe the simplest correct brute-force approach.
5. Find the repeated work or bottleneck.
6. Propose a pattern and explain why it fits.
7. State exactly what every pointer, map, stack, queue, heap, recursive state or DP state represents.
8. Estimate time and auxiliary space.
9. Implement in Java from a blank editor.
10. Dry-run normal, boundary and failure-prone cases. For Trees, show node visit order, mark the current node, and state returned/updated values at each step.
11. Explain why the solution works and when it would not apply.
12. Schedule R1/R2/R3 revision.

If stuck for 15–20 minutes, write down the point of failure before taking a hint. After reading a hint/editorial, close it and rebuild the solution.

## 3. Revision system

| Round | When | Action |
|---|---|---|
| R0 | Same day | Explain invariant and dry-run without notes |
| R1 | 2–3 days | Rebuild the approach from memory |
| R2 | About 7 days | Re-solve/trace without notes |
| R3 | About 30 days | Timed recall; repeat only if weak |

Do not reset an entire topic because one problem was forgotten. Revise weak problems selectively.

## 4. Daily and weekly routine

### 30–60 minute session
- 5 min: recall one old pattern without notes.
- 25–35 min: attempt one new or scheduled re-solve problem.
- 10–15 min: Java implementation, dry run, complexity and edge cases.
- 5 min: update status and revision dates.

### Weekly
- 5 days: one new problem or scheduled re-solve.
- 1 day: mixed/unseen problem without a pattern label.
- 1 day: light revision, backlog recovery or rest.

## 5. Three-year progression

### Year 1 — Foundations and recognition
Reconcile existing Arrays, Sorting, Linked List, Stack, Queue, Recursion, Tree and DP work. Fill the thinner areas: Arrays/Hashing, Two Pointers, Sliding Window, Prefix Sum, Binary Search, Heap, Greedy and Graphs. Build reliable Easy/Medium solving, brute-force reasoning, dry runs and complexity analysis.

**Gate:** Solve a mixed set of unseen Easy/Medium problems across arrays, strings, maps, pointers, windows, binary search, linked lists, stacks, trees and BFS/DFS, explaining and coding independently.

### Year 2 — Medium-depth patterns and combinations
Complete core Heap, Greedy, Graph, Backtracking and DP families. Practise combinations such as sliding window + frequency map, tree DFS + returned state, BFS + visited set, or prefix sum + HashMap. Introduce timed 35–45 minute attempts and weekly mock rounds. Add selected Hard problems only when they teach reusable techniques.

**Gate:** Identify approaches without topic labels, derive invariants/states and implement common Medium problems within interview timing.

### Year 3 — Interview execution and company targeting
Re-solve weak problems after delays, complete company-specific sets for real target roles, conduct timed mock interviews, and practise follow-ups (space optimisation, changed constraints, duplicates, streaming inputs and alternate outputs). Continue applying once ready; actual interview feedback should update the plan.

**Gate:** Handle unfamiliar prompts calmly, clarify assumptions, discuss brute force and optimisation, write correct Java, test edge cases and communicate trade-offs.

## 6. What is core and what is optional?

Use `00_DSA_Pattern_Master_Index.md` for the sequence. Core patterns are expected in broad interview preparation; Important patterns follow the core; Selective topics depend on target roles; Optional advanced topics are not blockers for ordinary SDE-1 interviews.

Do not expand the syllabus merely because a problem has a DSA tag.

## 7. Deliberate exclusions

Unless a company or role requires them, do not spend the main study budget on advanced number theory/combinatorics, computational geometry, FFT, obscure string structures, digit/probability/game DP, convex hull trick, Knuth optimisation, or advanced graph research topics. These are useful fields, but not automatic requirements for every software engineering coding interview.

## 8. Company questions are a filter, not a second problem bank

1. Learn the pattern in its DSA folder.
2. Open company-tagged data for 3–5 real target employers.
3. Map a company question to its canonical problem ID and pattern.
4. Add the company as a tag; do not duplicate the problem or solution.
5. Solve once in the canonical pattern file.
6. Before interviews, combine recent tagged problems with unseen problems from the same patterns.

Company tags are dataset signals, not guarantees.

## 9. Platform policy

- **Primary:** LeetCode problem statements and judge, using Java.
- **Secondary:** Code360 (if this is the “360” platform you meant) and GeeksforGeeks for alternate formulations, explanations or missing questions.
- Record a canonical title/ID so the same question on multiple platforms is not counted as multiple new problems.
- LeetCode 75, Blind 75, NeetCode 150/250 and company CSVs are selection aids, not mandatory checklists.

## 10. Monthly review

Ask: Which patterns do I recognise without labels? Which questions can I re-solve from a blank editor? Where do I fail—understanding, pattern choice, invariant, coding, edge cases or explanation? Which two weak patterns deserve attention next month? Am I duplicating questions? Is my practice aligned with the actual job level and employers?

Change the plan only when evidence identifies a gap.

## 11. Research notes

- [NeetCode — How to Prepare for Coding Interviews](https://blog.neetcode.io/p/prepare-coding-interviews) (7 Sep 2024): pattern ordering, repetition, Big-O and core data structures.
- [LeetCode 75](https://leetcode.com/studyplan/leetcode-75/): compact interview baseline, not a three-year syllabus.
- [Developer interviewer report — 100+ SDE interviews](https://www.reddit.com/r/developersIndia/comments/1huvzao/i_have_taken_100_sde_interviews_here_is_my_take/) (Jan 2025): basic reasoning, brute-force-to-optimised explanation and understanding underlying data structures.
- [Interview experience — Sliding Window and Word Break](https://www.reddit.com/r/developersIndia/comments/1icqm93/my_experience_of_taking_an_interview_today_first/): candidate report showing the importance of deriving DP recurrence.
- [Interview fundamentals discussion](https://www.reddit.com/r/developersIndia/comments/1vgvat6/unpopular_opinion_most_software_engineers_suck/): individual interviewer perspective on logic, assumptions and communication.

Community posts are anecdotes, not statistical guarantees. The interpretation for this roadmap is to prioritise fundamentals, reasoning, implementation and explanation over raw volume.