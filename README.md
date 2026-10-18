# Complete Modern Java

The code for the Complete Modern Java course: Java from your very first program to writing,
testing and shipping real Java, with a TypeScript companion for every lesson.

Every program here is typed and run in the videos. Every output in a video can be reproduced
with the commands below.

## Versions used

At the time of recording:

| Tool | Version | Pinned in |
|---|---|---|
| Java | 25 LTS (Amazon Corretto 25.0.4) | `.sdkmanrc` |
| Node.js | 24.22.0 LTS | `.nvmrc` |
| TypeScript | 7.0.2 | `typescript/package.json` |

Installing all three, step by step, is Episode 2.

## Episode 1: Your First Java Program, Explained

Sarah buys two loaves of bread and one carton of milk. The same receipt program, in Java and in
TypeScript.

### Java

```sh
cd java/ep01
javac GroceryReceipt.java
java GroceryReceipt
```

```
Sarah's groceries
Items: 3
Total: $3.99
```

`GroceryReceipt.java` is a Java 25 compact source file: `void main()` with no class around it.
`java GroceryReceipt.java` compiles and runs it in one step.

### TypeScript

```sh
cd typescript
npm install
cd ep01
npx tsc groceryReceipt.ts
node groceryReceipt.js
```

The output is the same receipt.

### The mistake

Change `milk` to the word `"one"` in both files.

- Java: `javac` refuses with `incompatible types: String cannot be converted to int`, and no
  `.class` file is written.
- TypeScript: `tsc` reports `TS2322: Type 'string' is not assignable to type 'number'`, but with
  default settings it still writes `groceryReceipt.js`. `node groceryReceipt.js` prints
  `Items: 2one` and `Total: $NaN`.

To make `tsc` write nothing when there is an error, add `--noEmitOnError`. The course covers it
in the episode on errors.

### The challenge

Set `milk` to `2` in both files and run them again: `Items: 4`, `Total: $4.98`.

## Shorts

`typescript/shorts/price.ts`: `tsc price.ts` reports a type error, but `node price.ts` still
runs and prints `Price: ten`, because Node removes the types without checking them.

## More

Articles and a one page sheet for each episode: https://code-with-sam-dev.github.io
