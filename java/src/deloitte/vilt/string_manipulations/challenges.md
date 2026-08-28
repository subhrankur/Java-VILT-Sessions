# Java String Manipulation — 10 Coding Challenges

A collection of **10 progressively difficult Java coding challenges** focused on String manipulation.

These challenges are suitable for Java trainees who have learned:

- `String`
- `StringBuilder`
- `StringBuffer`
- arrays
- loops
- conditional statements
- methods
- collections
- basic object-oriented programming

The later challenges can also be used to introduce:

- regular expressions
- maps and sets
- functional programming
- streams
- algorithm optimization
- time and space complexity

---

# General Instructions

For every challenge:

1. Create a separate Java class.
2. Implement the solution as one or more methods.
3. Keep the `main()` method focused on demonstrating the solution.
4. Do not use external libraries unless explicitly allowed.
5. Prefer solving the problem algorithmically rather than relying on a single library method.
6. Consider edge cases carefully.
7. Test your solution with multiple inputs.

Unless a challenge explicitly permits it, avoid using a library method that directly solves the core problem.

For example, if the challenge is about reversing a String, do not simply use:

```java
new StringBuilder(input).reverse()
```

The goal is to practice the underlying logic.

---

# Challenge 01 — Reverse the Words

## Problem

Given a sentence, reverse the **order of the words** while keeping the characters inside each word unchanged.

### Example

Input:

```text
"Java makes programming fun"
```

Output:

```text
"fun programming makes Java"
```

### Requirements

- Words are separated by one or more spaces.
- Ignore leading and trailing spaces.
- Preserve the characters within each word.
- Do not reverse the characters of the words.

### Expected Method

```java
static String reverseWords(String sentence)
```

### Test Cases

```text
"Java makes programming fun"
→ "fun programming makes Java"

"Hello World"
→ "World Hello"

"   Java   is   powerful   "
→ "powerful is Java"

"Java"
→ "Java"

""
→ ""
```

### Bonus

Solve the problem without using `String.split()`.

---

# Challenge 02 — Reverse Every Word

## Problem

Given a sentence, reverse the characters of every individual word while preserving the word order.

### Example

Input:

```text
"Java is powerful"
```

Output:

```text
"avaJ si lufrewop"
```

### Requirements

- Preserve word order.
- Reverse characters inside each word.
- Handle multiple spaces.

### Expected Method

```java
static String reverseEachWord(String sentence)
```

### Test Cases

```text
"Java is fun"
→ "avaJ si nuf"

"Hello World"
→ "olleH dlroW"

"Java"
→ "avaJ"
```

### Bonus

Implement the solution using only a `StringBuilder` and character traversal.

---

# Challenge 03 — Palindrome Sentence

## Problem

Determine whether a sentence is a palindrome when:

- spaces are ignored
- punctuation is ignored
- case is ignored

### Example

```text
"Madam, I'm Adam"
```

Output:

```text
true
```

The comparison should effectively become:

```text
madamimadam
```

### Expected Method

```java
static boolean isPalindrome(String input)
```

### Test Cases

```text
"madam"
→ true

"Racecar"
→ true

"Madam, I'm Adam"
→ true

"Java"
→ false

"A man, a plan, a canal: Panama"
→ true
```

### Bonus

Solve it without creating a second cleaned String.

---

# Challenge 04 — Character Frequency

## Problem

Given a String, count how many times each character occurs.

### Example

Input:

```text
"programming"
```

Output:

```text
p = 1
r = 2
o = 1
g = 2
a = 1
m = 2
i = 1
n = 1
```

### Requirements

- Treat uppercase and lowercase letters as the same.
- Ignore spaces.
- Display characters in the order in which they first appear.

### Expected Method

```java
static Map<Character, Integer> characterFrequency(String input)
```

### Test Case

```text
"Hello World"
```

Expected logical result:

```text
h = 1
e = 1
l = 3
o = 2
w = 1
r = 1
d = 1
```

### Bonus

Solve the problem without using a `Map`.

---

# Challenge 05 — First Non-Repeating Character

## Problem

Find the first character in a String that occurs exactly once.

### Example

Input:

```text
"swiss"
```

Output:

```text
"w"
```

### Requirements

- Ignore case.
- Ignore spaces.
- Return the first non-repeating character.
- Return `null` or a suitable indication when every character repeats.

### Expected Method

```java
static Character firstNonRepeating(String input)
```

### Test Cases

```text
"swiss"
→ w

"programming"
→ p

"aabbcc"
→ none

"Java"
→ J
```

### Bonus

Find an O(n) solution.

---

# Challenge 06 — First Repeating Character

## Problem

Find the first character that appears more than once while scanning the String from left to right.

### Example

Input:

```text
"programming"
```

Output:

```text
"r"
```

### Requirements

- Ignore case.
- Ignore spaces.
- Return the first repeated character.
- Return no result when there are no repeated characters.

### Expected Method

```java
static Character firstRepeating(String input)
```

### Test Cases

```text
"abcdef"
→ none

"hello"
→ l

"programming"
→ r

"Java"
→ a
```

### Bonus

Solve it using a `Set`.

---

# Challenge 07 — Anagram Detector

## Problem

Determine whether two Strings are anagrams.

Two Strings are anagrams if they contain the same characters with the same frequencies, regardless of order.

### Example

```text
"listen"
"silent"
```

Output:

```text
true
```

### Requirements

- Ignore case.
- Ignore spaces.
- Ignore punctuation.
- Do not simply sort the Strings.

### Expected Method

```java
static boolean isAnagram(String first, String second)
```

### Test Cases

```text
"listen", "silent"
→ true

"triangle", "integral"
→ true

"hello", "world"
→ false

"Debit Card", "Bad Credit"
→ true
```

### Bonus

Implement two versions:

1. Using sorting.
2. Using character frequencies.

Compare their complexity.

---

# Challenge 08 — Longest Word

## Problem

Find the longest word in a sentence.

If multiple words have the same maximum length, return the first one.

### Example

Input:

```text
"Java programming language"
```

Output:

```text
"programming"
```

### Requirements

- Ignore punctuation attached to words.
- Handle multiple spaces.
- Return the first longest word.

### Expected Method

```java
static String longestWord(String sentence)
```

### Test Cases

```text
"Java is powerful"
→ powerful

"I love Java"
→ love

"one two six"
→ one
```

### Bonus

Return both the word and its length.

---

# Challenge 09 — Longest Palindromic Word

## Problem

Given a sentence, find the longest word that is itself a palindrome.

### Example

Input:

```text
"Java level racecar programming"
```

Output:

```text
"racecar"
```

### Requirements

- Ignore case.
- Ignore punctuation surrounding words.
- Return the first longest palindrome if there is a tie.
- Return no result if the sentence contains no palindromic word.

### Expected Method

```java
static String longestPalindromicWord(String sentence)
```

### Test Cases

```text
"madam racecar level"
→ racecar

"Java is fun"
→ none

"noon civic radar"
→ noon
```

### Bonus

Do not create a reversed String for every word.

---

# Challenge 10 — Run-Length Encoding

## Problem

Compress a String using run-length encoding.

Each consecutive group of identical characters should be represented by:

```text
character + count
```

### Example

Input:

```text
"aaabbccccd"
```

Output:

```text
"a3b2c4d1"
```

### Requirements

- Preserve character order.
- Treat uppercase and lowercase characters as different.
- Include the count even when it is `1`.

### Expected Method

```java
static String compress(String input)
```

### Test Cases

```text
"aaabbccccd"
→ a3b2c4d1

"abcd"
→ a1b1c1d1

"aaaa"
→ a4
```

### Bonus

Create a decompression method:

```java
static String decompress(String input)
```

---