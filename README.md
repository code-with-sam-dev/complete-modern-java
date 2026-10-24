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
| Node.js | 24.22.1 LTS (through nvm 0.40.8) | `.nvmrc` |
| TypeScript | 7.0.2 | `typescript/package.json` |

Installing Java is Episode 2. Installing Node and TypeScript is Episode 3.

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

## Episode 2: Install Java 25 and IntelliJ IDEA on a Mac

1. Download IntelliJ IDEA from jetbrains.com (one download; core Java is free, no sign in).
2. New Project: name `GroceryReceipt`, build system IntelliJ, untick "Add sample code".
3. JDK: Download JDK, version 25, vendor Eclipse Temurin. Note the location it shows.
4. Right click `src`, New, Java Compact File, name it `GroceryReceipt`, type the program from Episode 1,
   and press the green arrow.

Then check the terminal. If `java -version` shows an older Java, point this one window at the new JDK
(use the location from step 3; nothing here is permanent):

```sh
java -version
type -a java
export JAVA_HOME=$HOME/Library/Java/JavaVirtualMachines/temurin-25.0.4.1/Contents/Home
export PATH="$JAVA_HOME/bin:$PATH"
java -version
java src/GroceryReceipt.java
```

Windows gets its own episode.

## Episode 3: Install Node.js and TypeScript on a Mac

No admin password is needed: nvm installs Node inside your home folder. Apple's command line
tools are a separate prerequisite; if `xcode-select -p` prints an error, `xcode-select --install`
is Apple's installer, and it may ask for an administrator password.

The commands come from nodejs.org, Download, macOS, nvm. Take them from there, not from here.

```sh
node -v                    # zsh: command not found: node
xcode-select -p            # prints a folder: Apple's tools are installed
ls ~/.zshrc                # a new Mac has none, and nvm needs it
touch ~/.zshrc
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.8/install.sh | bash
```

Open a new terminal tab, then:

```sh
command -v nvm             # nvm
nvm install 24
node -v                    # v24.22.1 at the time of recording
npm -v                     # 11.19.1
which node                 # ~/.nvm/versions/node/v24.22.1/bin/node
```

A TypeScript project, with TypeScript installed in the project rather than for the whole Mac:

```sh
npm init -y
npm install --save-dev typescript
npx tsc -v                 # Version 7.0.2
```

Then type `groceryReceipt.ts` (the same receipt, in `typescript/ep03`) and run it:

```sh
npx tsc groceryReceipt.ts  # no output means no errors; writes groceryReceipt.js
node groceryReceipt.js
node groceryReceipt.ts     # Node removes the types and runs it, without checking them
```

### Running is not checking

Change `milk` to the text `"2"`:

- `node groceryReceipt.ts` still runs: `Items: 22` (`+` joins text) and `Total: $4.98` (`*` turns the
  text back into a number, so the total looks right).
- `npx tsc --noEmit groceryReceipt.ts` refuses: `TS2322: Type 'string' is not assignable to type
  'number'`, and writes nothing.

### If your screen does not match

- `nvm: command not found`: there was no `~/.zshrc` when the installer ran. `touch ~/.zshrc`, run the
  installer again, open a new tab.
- `tsc: command not found`: tsc lives in the project. Use `npx tsc`, from the project folder.
- IntelliJ says "Node.js is required": Settings, Languages & Frameworks, JavaScript Runtime, and choose
  the Node in `~/.nvm`.

### The challenge

Set `bread` to `3`. Predict both lines, then run it: `Items: 4`, `Total: $5.49`.

## Episode 4: Read Your First Errors (Java and TypeScript)

Four kinds of error, each broken on purpose, read, fixed and run again. Run every Java file from
the folder that holds it with `java File.java`, and check every TypeScript file with
`npx tsc --noEmit file.ts` before running it with `node file.ts`.

| Kind | Java | TypeScript |
|---|---|---|
| Syntax | `';' expected`, `1 error`, `compilation failed` | `TS1005: ')' expected.`; Node refuses too: `SyntaxError` |
| Compile | `cannot find symbol`, then `symbol:` and `location:` | `TS2551 ... Did you mean 'toUpperCase'?`, yet `node` runs it and crashes: `TypeError ... is not a function` |
| Runtime | `NumberFormatException: For input string: "one"` and a stack trace | no crash: `Milk: NaN` |
| Logic | `+` for `*`: `Total: $4.99`, no message | the same, and `tsc` is quiet |

The files in `java/ep04` and `typescript/ep04` are as typed in the video, mistakes included:
`Typo.java` and `typo.ts` call `toUppercase` (capital C fixes them), `Runtime.java` and `nan.ts`
are given the word `"one"` (the digit `"1"` fixes them).

### Reading a stack trace

Read the top line first: the exception and its message. Then go down to the first line from your
own code, here `at Runtime.main(Runtime.java:3)`, and open that line. The lines above it are
Java's own code, the path the problem took, not separate errors.

### One habit for every error

1. Read the main message.
2. Find the location: the file and line; in a stack trace, the first line from your own code.
3. Open that line, and the line above it.
4. Change one thing, and run it again.

The location is where the compiler noticed the problem, not always where it was made: a missing
bracket at the end of a line is often reported on the next line.

### The challenge

`java/ep04/challenge/BrokenReceipt.java` and `typescript/ep04/challenge/brokenReceipt.ts` each
have three mistakes: a syntax error, a misspelled method and a `+` where there should be a `*`.
Fix one at a time, running after every fix, until both print:

```text
Sarah's groceries
Items: 3
Total: $3.99
```

## Episode 5: Use the Debugger (Java and TypeScript)

The receipt from Episode 4 with `milk + milkPrice` instead of `milk * milkPrice` prints `Total: $4.99`
and no error. A debugger finds where the wrong value is made.

**Java, in IntelliJ IDEA.** Click the line number of the `total` line: a red dot, a breakpoint. **Run**
ignores it. **Debug** (the bug icon, or the menu beside `void main()`) stops on that line, before it
runs: Variables shows `bread = 2`, `milk = 1`, `breadPrice = 1.5`, `milkPrice = 0.99`, and no `total`
yet. **Step Over** runs the line: `total = 4.99`. In the Evaluate box, `milk * milkPrice` is `0.99` and
`milk + milkPrice` is `1.99`. **Resume** runs to the next breakpoint or the end; **Stop** ends it.

**TypeScript, free.** The free IntelliJ IDEA does not debug TypeScript, so use Node's inspector and Chrome:

```sh
node --inspect-brk groceryReceipt.ts   # pauses before the first line and waits
```

Open `chrome://inspect` in Chrome, click **inspect** under Remote Target. In Sources, click line 6 for a
breakpoint, Resume, read Scope, Step over: `total: 4.99`. DevTools shows your file with the types
replaced by spaces, which is what Node runs. Close DevTools to let Node exit.

A debugger shows what your program does. You still need to know what it should do: predict first.

### The challenge

`java/ep05/challenge/ItemsReceipt.java` and `typescript/ep05/challenge/itemsReceipt.ts` print
`Items: 4`, but Sarah bought three things. Use a breakpoint to find the line that makes 4, and fix
the reason, not the number.

## Episode 6: Values and Types (Java and TypeScript)

Two loaves and one milk printed `Items: 21`. The values were right; the types decided what `+` did.

In `int bread = 2;`, `2` is the value (written in the code, a literal), `bread` is the variable,
`int` is the type, and `=` is assignment: it puts 2 into bread.

| Java | TypeScript | Holds | Printed |
|---|---|---|---|
| `int quantity = 3;` | `let quantity: number = 3;` | whole numbers | `3` |
| `double price = 4.99;` | `let price: number = 4.99;` | numbers with a decimal point | `4.99` |
| `boolean paid = false;` | `let paid: boolean = false;` | true or false | `false` |
| `String product = "Milk";` | `let product: string = "Milk";` | text | `Milk` |
| `char grade = 'A';` | (no char type) | one character, single quotes | `A` |

The files in `java/ep06` and `typescript/ep06` are as typed in the video:

- `Items.java`: `"Items: " + bread + milk` prints `Items: 21` (left to right, a String joins);
  `"Items: " + (bread + milk)` prints `Items: 3` (brackets first, the numbers add).
- `Types.java`: the five types, then `double whole = 4;` prints `4.0` and `quantity = 4;` prints `4`.
- `Price.java`: `double price = 1.5;` prints `1.5`. Change `double` to `int` and Java refuses:
  `incompatible types: possible lossy conversion from double to int`.
- `types.ts`: `npx tsc --noEmit types.ts` is quiet and `node types.ts` prints `3 4.99 false Milk 3`.
  Add `quantity = "three";` or `inferred = "three";` and the check fails with `TS2322`: inferred
  types are checked too.

### The challenge

Predict the three lines `java/ep06/challenge/Predict.java` and `typescript/ep06/challenge/predict.ts`
print, then run them. The answers:

```text
3
Total: 4.99
false
```

## Episode 7: Expressions and Operators (Java and TypeScript)

Four friends split a $10 bill. `int total = 10; int people = 4;` and `total / people` prints `2`. Java has
not lost any money: we divided two ints, and it kept the whole part.

An **expression** is a piece of code that produces a value: `total / people`, `7 + 2`, even `total` on its own.
`int total = 10;` is a statement: it creates a variable and stores a value.

| Java | Prints | Why |
|---|---|---|
| `7 + 2`, `7 - 2`, `7 * 2` | `9`, `5`, `14` | |
| `7 / 2` | `3` | two ints: the whole part only, never rounded |
| `7 % 2` | `1` | the remainder: seven sweets shared by two, one left over |
| `10.0 / people` | `2.5` | one double in the division: decimal division |
| `2 + 3 * 4` | `14` | `*` and `/` before `+` and `-` |
| `(2 + 3) * 4` | `20` | brackets first |
| `10 / 4 * 1.0` | `2.0` | left to right: `10 / 4` is already `2` |
| `10 * 1.0 / 4` | `2.5` | the double comes first |
| `(10 / 4)` | `2` | brackets change the order, never the types |

The files in `java/ep07` and `typescript/ep07` are as typed in the video: `Bill.java` prints `2`, `2.5`, `2.5`;
`Ops.java` prints `9 5 14 3 1`; `Order.java` prints `14 20 2.0 2.5 2`. In TypeScript, `ops.ts` prints `3.5`,
`2.5`, `14` and `2`: one number type, so `10 / 4` is `2.5`, and `Math.floor(10 / 4)` rounds down to `2`.

A double is fine for this lesson, but it is not how real systems keep money. Episode 8 shows why.

### The challenge

Predict the five lines `java/ep07/challenge/Predict.java` prints, then run it. The answers:

```text
4
1
4.5
14
2.0
```

## Episode 8: Decimals Are Not Exact (Java and TypeScript)

Bread $1.10, milk $2.20: `IO.println(1.10 + 2.20);` prints `3.3000000000000003`, and `0.1 + 0.2 == 0.3`
prints `false`. A double stores numbers in binary. In binary, one tenth repeats forever, the way one third
does in decimal, so Java stores the nearest double it can, and two tiny gaps added show in the answer.

| Line | Prints |
|---|---|
| `IO.println(0.1);` | `0.1` (the shortest decimal that identifies the stored double) |
| `IO.println(new BigDecimal(0.1));` | `0.1000000000000000055511151231257827021181583404541015625` |
| `IO.println(new BigDecimal("0.1"));` | `0.1` |
| `int totalCents = 110 + 220;` | `330` |
| `new BigDecimal("1.10").add(new BigDecimal("2.20"))` | `3.30` |

Two ways to keep money exact: whole cents in an `int`, or `BigDecimal` made from text and added with `.add`.
Make a BigDecimal from text, not from a double. In TypeScript, `number` is the same kind of double:
`money.ts` prints `0.30000000000000004`, `3.3000000000000003` and `330`.

The files in `java/ep08` and `typescript/ep08` are as typed in the video. `Money.java` starts with
`import java.math.BigDecimal;`, which tells Java where to find BigDecimal.

### The challenge

Predict the three lines `java/ep08/challenge/Predict.java` prints, then run it. The answers:

```text
0.30000000000000004
0.3
330
```

## Episode 9: Number Limits (Java and TypeScript)

`int cents = 2_000_000_000;` then `cents + cents` prints `-294967296`: negative money and no error. An `int` stores
32 bits, so it has a fixed range, -2,147,483,648 to 2,147,483,647. Past the top it wraps round to the most
negative value, like a car odometer rolling over: overflow. The underscores only make the number easier to read.

| Line | Prints |
|---|---|
| `Integer.MAX_VALUE` | `2147483647` |
| `Integer.MAX_VALUE + 1` | `-2147483648` |
| `long bigCents = 2_000_000_000L;` then `bigCents + bigCents` | `4000000000` |
| `Long.MAX_VALUE` | `9223372036854775807` |
| `Math.addExact(Integer.MAX_VALUE, 1)` | `ArithmeticException: integer overflow` |
| `7.0 / 0`, `0.0 / 0` | `Infinity`, `NaN` |
| `10 / people` with `people = 0` | `ArithmeticException: / by zero` |

The `L` marks a long literal. `Math.addExact` stops the program instead of returning a wrong number; it is in its
own file, `Exact.java`, so its exception does not stop the other lines. In TypeScript, `limits.ts` prints
`4000000000` (no wrap at two billion: numbers are doubles), then `9007199254740991` and `9007199254740992` for
`9007199254740992 + 1`: past the safe integer limit, whole numbers are not exact. `10 / 0` is `Infinity` and
`0 / 0` is `NaN`, with no error.

### The challenge

Predict the three lines `java/ep09/challenge/Predict.java` prints, then run it. The answers:

```text
-2147483648
4000000000
Infinity
```

## Episode 10: Decisions with if and else (Java and TypeScript)

Free delivery from $50, kept in whole cents: `int totalCents = 5240;`. `totalCents >= 5000` is a comparison, and it
gives a boolean: `true`.

```java
if (totalCents >= 5000) {
    IO.println("Free delivery");
} else {
    IO.println("Delivery: $4.99");
}
IO.println("Thank you, Sarah");
```

Exactly one branch runs, then the program carries on: `true`, `Free delivery`, `Thank you, Sarah`. With `4240` it
prints `false`, `Delivery: $4.99`, `Thank you, Sarah`. `>=` means exactly $50 qualifies.

| Operator | `items = 3` | Prints |
|---|---|---|
| `==` equal | `items == 3` | `true` |
| `!=` not equal | `items != 3` | `false` |
| `<` | `items < 5` | `true` |
| `>` | `items > 5` | `false` |
| `<=` | `items <= 3` | `true` |
| `>=` | `items >= 4` | `false` |

`5000 > 5000` is `false` but `5000 >= 5000` is `true`. `if (items = 5)` does not compile: `incompatible types: int
cannot be converted to boolean`. One `=` assigns, two `==` compare. In TypeScript, `delivery.ts` makes the same
decision; use `===` and `!==`, which never convert values before comparing.

### The challenge

Set `totalCents` in `java/ep10/challenge/Predict.java` to 4999, 5000 and 5001 and predict each result first. The
answers: `Delivery: $4.99`, `Free delivery`, `Free delivery`.

## Episode 11: More Than One Condition (Java and TypeScript)

The rules: a basket of $100 or more gets a free gift; $50 or more gets free delivery, members only; everyone
else pays $4.99. This picks one message, not every benefit.

| Operator | Means | `totalCents = 5240`, `member = true` |
|---|---|---|
| `&&` | both must be true | `totalCents >= 5000 && member` is `true` |
| `\|\|` | at least one is true, including both | `totalCents >= 10000 \|\| member` is `true` |
| `!` | flips a boolean | `!member` is `false` |

```java
if (totalCents >= 10000) {
    IO.println("Free gift");
} else if (totalCents >= 5000 && member) {
    IO.println("Free delivery");
} else {
    IO.println("Delivery: $4.99");
}
```

The first condition that is true decides, and the rest are not checked. 5240 and a member: `Free delivery`;
5240, not a member: `Delivery: $4.99`; 12000, either: `Free gift`. `Wrong.java` checks free delivery first, so a
member spending 12000 cents gets `Free delivery` and the gift is skipped: put the bigger reward first.

`Average.java`: with `items = 0`, `items > 0 && totalCents / items > 1000` prints `No qualifying average` and no
error, because `&&` stops at the first false and the division never runs. `&&` binds before `||`; use brackets to
show the grouping you mean. `rules.ts` makes the same choice in TypeScript.

### The challenge

Change `totalCents` and `member` in `java/ep11/challenge/Predict.java` and predict first. 12000 and a member:
`Free gift`. 6000, not a member: `Delivery: $4.99`. 6000 and a member: `Free delivery`.

## Episode 12: Loops (Java and TypeScript)

A countdown by hand (`Manual.java`) is four printlns. A loop repeats the work instead.

```java
int count = 3;
while (count > 0) {
    IO.println(count);
    count = count - 1;
}
IO.println("Go!");
```

Three parts: the start (`count = 3`), the check (`count > 0`, asked before every repetition) and the update
(`count = count - 1`). It prints `3 2 1 Go!`. If the check is false at the start, the body never runs.
`Forever.java` leaves the update out, so it never finishes: stop it with Ctrl+C in the terminal.

`for (int i = 1; i <= 3; i++)` puts the same three parts on one line and prints `Item 1 Item 2 Item 3`; `i++` adds
one after each repetition. `for (int i = 0; i < 3; i++)` prints `0 1 2`: it starts at 0, and `< 3` stops before 3.
`Loaves.java` adds 150 cents three times with `totalCents += breadPriceCents;` and prints `450`. `loops.ts` is the
same countdown and for loop in TypeScript, with `let`.

### The challenge

Predict what `java/ep12/challenge/Predict.java` prints, then run it. The answer: `2`, `4`, `6`.

## Shorts

`typescript/shorts/price.ts`: `tsc price.ts` reports a type error, but `node price.ts` still
runs and prints `Price: ten`, because Node removes the types without checking them.

## More

Articles and a one page sheet for each episode: https://code-with-sam-dev.github.io
