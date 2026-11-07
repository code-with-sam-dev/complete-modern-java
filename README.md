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

## Episode 13: Methods (Java and TypeScript)

The same separator printed twice (`Dup.java`) means two places to change. A method gives the instructions a name.

| Shape | Java | Prints |
|---|---|---|
| no input, no result | `void printLine()` in `Lines.java` | `----------`, `Sarah's groceries`, `----------` |
| input, no result | `void printCustomLine(String symbol)` in `Custom.java` | `==========`, `**********` |
| inputs and a result | `int lineTotal(int quantity, int priceCents)` in `Totals.java` | `300`, then `399` |

When Java reaches a call, it runs that method's instructions, then carries on in main right after the call.
`void` means the method gives nothing back to its caller. `main` is a method too: where this program starts. The
names in a method's brackets are parameters; the values in a call are arguments. `return` sends a value back, and
the type before the name says what kind. In TypeScript (`receipt.ts`) these are functions, and the return type goes
after the brackets: `function lineTotal(quantity: number, priceCents: number): number`.

### The challenge

Predict what `java/ep13/challenge/Predict.java` prints, then run it. The answer: `648`.

## Episode 14: Arrays (Java and TypeScript)

An array keeps several values of the same type under one name: `int[] prices = {150, 99, 250};`. Indexes start at
0: `prices[0]` is `150`, `prices[2]` is `250`, and `prices.length` is `3`, so the valid indexes are 0, 1 and 2.
`prices[1] = 120;` changes one box. A Java array has a fixed length.

`Bounds.java` asks for `prices[3]` and stops with `ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`:
the last index is always `length - 1`. `Show.java` prints an array directly (a code such as `[I@768b970c`, different
each run) and then with `Arrays.toString(prices)`: `[150, 120, 250]`. In TypeScript, `prices.ts` reads `prices[3]` as
`undefined` with no error, and JavaScript arrays can grow.

### The challenge

Predict the two lines `java/ep14/challenge/Predict.java` prints, then run it. The answers: `300` and `4`.

## Episode 15: Loop Over an Array (Java and TypeScript)

`java/ep15/Basket.java` adds up every price with one loop: `for (int i = 0; i < prices.length; i++)` with
`total += prices[i];` prints `499`, and the enhanced for, `for (int price : prices)`, prints `499` too. Read it as
"for each price in prices": no index, so no boundary to get wrong. Use the loop with the index when you need the
position.

Change `<` to `<=` and Java stops with `ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`: the
condition lets `i` reach 3, and the body reads `prices[3]`. With `int[] prices = {};` both loops run zero times and
print `0`. In TypeScript, `typescript/ep15/basket.ts` uses `for` with `let i` and `for...of`; the same `<=` mistake
prints `NaN` with no error, because `prices[3]` is `undefined`.

`java/ep15/Twice.java`: reassigning `price` inside a for-each over an `int[]` leaves the array as
`[150, 99, 250]`; `prices[i] = prices[i] * 2` gives `[300, 198, 500]`.

### The challenge

Predict what `java/ep15/challenge/Predict.java` prints, 1000 or 900, then run it. The answer: `900`, because the
loop starts at index 1 and skips the first price.

## Episode 16: Classes and Objects (Java and TypeScript)

A class describes a kind of thing; `new` makes an object from it. `java/ep16/Fields.java` declares
`class Product { String name; int priceCents; }` in the same file as `main`, makes `new Product()`, and prints its
fields before setting them: `null` and `0`, the defaults Java gives fields. `null` means the name does not refer to
any text yet. A local variable gets no default: `java/ep16/Local.java` stops with
`variable count might not have been initialized`.

`java/ep16/Shop.java` adds a constructor, so `new Product("Bread", 150)` is one line (`this.name` is the field,
`name` the value passed in), and a method, `label()`, which prints `Bread: 150 cents` and `Milk: 99 cents`: one class,
two objects, each with its own values. An array of products and a for-each loop add up `249`. The fields are left
open on purpose; Episode 17 protects them. In TypeScript, `typescript/ep16/shop.ts` has the same shape; inside a
method every field needs `this.`.

### The challenge

Predict the two lines `java/ep16/challenge/Predict.java` prints, then run it. The answers: `Toast: 150 cents` and
`Milk: 99 cents`, because changing one object does not change the other.

## Episode 17: Encapsulation, Protect Your Object's Data (Java and TypeScript)

With Episode 16's open fields, `bread.priceCents = -5;` runs and prints `-5`. Here `Product` gets its own file,
`java/ep17/Product.java`, and its fields are `private`: from `Store.java`, the same line is a compile error,
`priceCents has private access in Product`. Getters, `getName()` and `getPriceCents()`, let other code read the
values. A setter, `setPriceCents`, changes the price, and it checks first: a negative price throws
`IllegalArgumentException: price cannot be negative`. The constructor calls the same setter, so the rule lives in
one place: `java src/Store.java` (from `java/ep17`, `java Store.java`) prints `Bread`, `150`, `200`, then stops at
`new Product("Eggs", -5)`. The name has no setter, so it cannot change after construction.

`java/ep17/same-file/Same.java` shows why `Product` moved: declared in the same compact file as `main`, it is nested
inside the file's own class, and Java's access rules let that class reach its private members, so the file prints
`-5`. In TypeScript, `typescript/ep17/product.ts`: `npx tsc --noEmit` reports
`Property 'priceCents' is private and only accessible within class 'Product'`, but `node product.ts` still prints
`150` twice, because node does not check types.

### The challenge

`java/ep17/challenge/Predict.java`: which marked line compiles? Only `bread.setPriceCents(300);` (it prints `300`);
`bread.priceCents = 300;` is the private access error.

## Episode 18: Exceptions, Catch It and Keep Going (Java and TypeScript)

`java/ep18/Checkout.java` makes eggs at -5 with Episode 17's `Product`, and the program stops: `IllegalArgumentException:
price cannot be negative`, with the trace `at Product.setPriceCents(Product.java:20)`, `at Product.<init>(Product.java:7)`,
`at Checkout.main(Checkout.java:2)`. Read it from the top: where it was thrown, then how the program got there.

`java/ep18/SafeCheckout.java` wraps the risky lines in `try` and catches `IllegalArgumentException`: it prints
`Could not add eggs: price cannot be negative` and `Checkout continues`. `Added Eggs` is skipped, because Java leaves the
try block at the throw, and the program carries on after the catch, never back at the line that failed. With a
price of 30, nothing is thrown and the catch is skipped. `java/ep18/Quantity.java` catches the
`NumberFormatException` from `Integer.parseInt("two")`: `Not a number: two`; with `"2"` it prints `Quantity: 2`.

In TypeScript, `typescript/ep18/store.ts`: the caught value is `unknown` (`e.message` is error TS18046), so the catch
checks `if (e instanceof Error)` first. `typescript/ep18/parse.ts`: JavaScript's `parseInt("two")` does not throw,
it returns `NaN` (`isNaN` is `true`).

### The challenge

Predict what `java/ep18/challenge/Predict.java` prints. The answer: `One`, `Caught`, `Three`. `Two` never prints,
because the line before it threw.

## Episode 19: ArrayList, A List That Can Grow (Java and TypeScript)

`java/ep19/Full.java`: an array of three strings is full, and `basket[3]` stops with
`ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`. `java/ep19/Cart.java` uses
`ArrayList<String> basket = new ArrayList<>();` (no import is needed in a compact source file; a normal class file
needs `import java.util.ArrayList;`): `add` three items, `[Bread, Milk, Eggs]`, `size()` 3, `get(0)` Bread;
`remove("Milk")` leaves `[Bread, Eggs]`, `contains("Milk")` is `false`, and a for-each prints each item. Its last
line, `basket.get(5)`, throws `IndexOutOfBoundsException: Index 5 out of bounds for length 2`.

A list holds objects: `ArrayList<int>` does not compile (`unexpected type`), and `java/ep19/Numbers.java` uses
`ArrayList<Integer>`: `[150, 99]`. `java/ep19/Remove.java`: on a list of `Integer`, `remove(1)` removes the item at
index 1, leaving `[10, 30]`.

TypeScript arrays already grow: `typescript/ep19/cart.ts` pushes, removes by value with `indexOf` and a check for `-1`
before `splice`, and reads `basket[5]` as `undefined`. `typescript/ep19/trap.ts` shows why the check matters:
`indexOf("Rice")` is `-1`, and `splice(-1, 1)` removes the last item.

### The challenge

Predict the two lines `java/ep19/challenge/Predict.java` prints. The answers: `3` and `Eggs`, because when Milk was
removed, Eggs moved up to index 1.

## Episode 20: A List of Objects, A Shopping Cart That Adds Itself Up (Java and TypeScript)

`java/ep20/Groceries.java` keeps an `ArrayList<Product>` in `main` and adds up `getPriceCents()` with a for-each:
`499`. Then the list and the loop move into a class that owns them, `java/ep20/ShoppingCart.java`, with a private
`ArrayList<Product> items` and three methods: `add`, `count` and `totalCents`. A normal class file needs
`import java.util.ArrayList;`; the compact files so far got it without one. `Product` needs no import (our own class,
same folder), and `ShoppingCart` has no `main`. `java/ep20/Shopping.java` only asks the cart: `0`, then `3` and `499`.

`add` checks first: `cart.add(null)` throws `IllegalArgumentException: product cannot be null`. Without that check,
the null is accepted and the program fails later with a `NullPointerException` inside `totalCents`. In TypeScript,
`typescript/ep20/shoppingCart.ts` mirrors the cart (`push`, `length`, `for...of`) and prints `2` and `249`;
`cart.add(null)` there is refused by the checker: `Argument of type 'null' is not assignable to parameter of type
'Product'`.

### The challenge

`java/ep20/challenge/Predict.java` adds a fourth product at 199. The answers: `4` and `698`.

## Episode 21: Remove From the Cart, When Are Two Objects the Same? (Java and TypeScript)

`java/ep21/Returns.java` prints the cart's names (Bread, Milk, Eggs), then `cart.remove(new Product("Milk", 99))`
prints `false` and the count stays `3`. `remove` asks each item whether it is equal; `Product` has never said what
equal means, so only the very same object matches. `java/ep21/Twins.java`: two new Milks give `false` for both `==`
and `equals`, while `"Milk".equals("Milk")` is `true` (String has that rule).

Removing the object we kept, `cart.remove(milk)`, prints `true`, then `2` and `400`. `ShoppingCart.removeByName`
is the cart's own rule: a loop with an index, `equals` on the name, remove the first match and return `true`
straight away, `false` if nothing matched: Eggs `true`, Rice `false`, total `150`. In TypeScript,
`typescript/ep21/returns.ts`: `first === second` is `false`, `indexOf(second)` is `-1`, and a `removeByName` function
with `===` on the name and `splice(i, 1)` removes Milk.

### The challenge

`java/ep21/challenge/Predict.java`: Milk, Eggs, Milk, Bread, then `removeByName("Milk")` once. The answer: Eggs,
Milk, Bread. Only the first Milk goes.

## Episode 22: HashMap, Find a Product by Name (Java and TypeScript)

`java/ep22/Catalog.java` keeps products in a `HashMap<String, Product>`: the key is the name, the value the product.
`put` three, `size()` is `3`, and `catalog.get("Milk")` finds Milk (`99`) without a search loop. Putting `"Milk"`
again with 120 replaces the value (`120`, size still `3`): a key links to one value, and the key now points to a
different product. `remove("Eggs")` leaves `2`. A missing key: `containsKey("Rice")` is `false`, `get("Rice")` is
`null`, and asking that null for its price throws a `NullPointerException`. `java/ep22/Safe.java` checks
`containsKey` first and prints `Rice is not in the catalog`. A `HashMap` does not promise to keep insertion order.

In TypeScript, `typescript/ep22/catalog.ts` uses a `Map<string, Product>`: `set`, `get`, `has`, `delete`, and `size`
as a property; a missing key gives `undefined` (Java gives `null`). It prints `3`, `99`, `false`, `undefined`.

### The challenge

Add Coffee at 350, read its price by name, then look up Tea without crashing. One answer is
`java/ep22/challenge/Coffee.java`: `350`, then `Tea is not in the catalog`.

## Episode 23: Loop Through a HashMap, Keys and Values (Java and TypeScript)

`java/ep23/Menu.java` puts Bread, Milk, Eggs and Rice into a `HashMap`, in that order, and goes through it three ways.
`keySet()` gives the names; on the recording machine they came out Eggs, Bread, Milk, Rice. A `HashMap` does not promise
to keep the order you added things in, so yours may differ, and both are correct. With each name, `get` fetches the
product: `Eggs: 250` and so on. `values()` gives just the products: the loop adds up `698`. `entrySet()` gives each
key with its value (`Map.Entry`), so the name and the price come together without calling `get` again. No import is
needed in a compact source file. If order matters, Java has `LinkedHashMap`.

In TypeScript, `typescript/ep23/menu.ts` loops `for (const entry of catalog)` with `entry[0]` (the name) and `entry[1]`
(the product): Bread, Milk, Eggs, Rice, the order they were set in. A TypeScript `Map` keeps insertion order.

### The challenge

`java/ep23/challenge/Sugar.java` adds Sugar at 180. The values loop adds up to `878`.

## Episode 24: static and Constants, Values That Belong to the Class (Java and TypeScript)

`java/ep24/Product.java` gains three things that belong to the class rather than to each product. `private static int
createdCount` is one counter shared by every product; the constructor adds one after the price has been checked, and
`static int getCreatedCount()` returns it. `static final int MAX_PRICE_CENTS = 100_000` is a constant: the underscore
only makes the number easier to read. `static boolean isValidPrice(int priceCents)` uses it, and the setter now throws
`price out of range` when a price is not valid.

`java/ep24/Counter.java` asks the class, not an object: `0`, then `2` after two products, `100000`, `true` for 150 and
`false` for 150_000, and finally `Bread` from `bread.getName()`.

Two mistakes from the episode, both caught by the compiler. `Product.MAX_PRICE_CENTS = 5;` gives `cannot assign a value
to static final variable MAX_PRICE_CENTS`. `Product.getName()` gives `non-static method getName() cannot be referenced
from a static context`: a name belongs to one product, so ask an object.

In TypeScript, `typescript/ep24/counter.ts` uses `static readonly MAX_PRICE_CENTS` and a `static createdCount`: `0`,
`2`, `100000`. Adding `Product.MAX_PRICE_CENTS = 5;` makes `tsc` report TS2540, "Cannot assign to 'MAX_PRICE_CENTS'
because it is a read-only property", but `node` still runs it: readonly is a rule for the checker.

### The challenge

`java/ep24/challenge/Fail.java` makes a product at 150_000 cents inside a `try`, then prints `getCreatedCount()`. It
prints `price out of range` and then `0`: the constructor threw before the count went up.

## Episode 25: Interfaces, a Promise a Class Makes (Java and TypeScript)

`java/ep25/Discount.java` is an interface: one method, `int apply(int priceCents)`, with no body. In this example it
only declares the method, so `new Discount()` is refused: `Discount is abstract; cannot be instantiated`.

Two classes keep the promise with `implements`. `NoDiscount.java` gives the price back; `PercentOff.java` takes a
percent and returns `priceCents - priceCents * percent / 100`. These are whole numbers, so the division drops the
fraction: 499 at 10 percent is 450. Both write `public int apply`: a method like this in an interface is public
automatically, and leaving `public` out gives `attempting to assign weaker access privileges; was public`. Deleting
`apply` from a class that says `implements Discount` gives `NoDiscount is not abstract and does not override abstract
method apply(int) in Discount`.

`java/ep25/Offers.java` (run with `java Offers.java`, the other files beside it) keeps one `Discount` variable and
gives it three objects from two classes: `1000`, `900`, `500`. Then `printTotal(int priceCents, Discount discount)`
works with any of them without changing: `Total: 499`, `Total: 450`, `Total: 250`.

In TypeScript, `typescript/ep25/discount.ts` does the same with `interface Discount` and `implements`, using
`Math.floor` to keep whole cents. Remove `apply` from a class and `tsc` reports TS2420; `node` does not check
interfaces, so it starts and then fails at the call with `discount.apply is not a function`. TypeScript also accepts
a class that has the right method without saying `implements`; Java needs the word.

### The challenge

`java/ep25/challenge/FixedOff.java` implements `Discount` and removes a fixed number of cents, never going below
zero. With the same `printTotal`: `Total: 900` for 1000, and `Total: 0` for 50.

## Episode 26: Inheritance, When One Class Extends Another (Java and TypeScript)

The test first: every fresh product is a product, but not every product is a fresh product. `java/ep26/Product.java`
gains `String describe()`, which returns the name and the price in cents. `java/ep26/FreshProduct.java` says
`class FreshProduct extends Product`: it adds `daysLeft` (just a number given to the object, not an expiry system),
and its constructor calls `super(name, priceCents)` first, which runs Product's constructor and its price check.
Product has no constructor without arguments, so a child class must call one.

`java/ep26/Shelf.java` makes a fresh milk and calls `getName()` and `getPriceCents()`, which FreshProduct never wrote:
`Milk`, `99`, then `3`. The milk object holds a name and a price, but they are private to Product, so FreshProduct
uses the methods Product provides. `@Override String describe()` returns `super.describe()` plus the days left:
`Milk: 99, 3 days left`. Misspell the method under `@Override` and Java says `method does not override or implement a
method from a supertype`. In the constructor `super(...)` runs the parent's constructor; in `describe` it calls the
parent's method.

An `ArrayList<Product>` holds rice and the milk, and the same `describe()` call prints `Rice: 199` and `Milk: 99, 3
days left`: the milk really is a FreshProduct, so its own version runs. That is polymorphism.

In TypeScript, `typescript/ep26/shelf.ts` uses `extends`, `super(name, priceCents)` before `this`, and the `override`
keyword: the same two lines. Setting `this.daysLeft` before `super` makes `tsc` report TS17009, "'super' must be called
before accessing 'this' in the constructor of a derived class".

### The challenge

`java/ep26/challenge/Cheese.java` adds a FreshProduct cheese at 350 with 5 days left. Its name comes from the inherited
getter, `Cheese`, and the loop's new line is `Cheese: 350, 5 days left`.

## Episode 27: Composition or Inheritance, When Not to Use extends (Java and TypeScript)

`java/ep27/CartAsProduct.java` extends Product and calls `super("Cart", 0)`. It compiles without a complaint, yet a
shopping cart is not a kind of product: the compiler checks whether inheritance is legal, not whether the model makes
sense.

A fresh product IS a product (inheritance, Episode 26). A shopping cart HAS products: `ShoppingCart` keeps them in a
private `ArrayList` inside it. That is composition. `java/ep27/Carts.java` adds Rice and a fresh Milk to the unchanged
cart: `2` and `298`.

`java/ep27/Trolley.java` is the tempting shortcut: `class Trolley extends ArrayList<Product> {}`. It accepts
`add(null)` (size `2`) and `clear()` (size `0`): every list method became the trolley's, including ones that bypass the
cart's rule. The cart refuses: `cart.add(null)` throws `product cannot be null`, and `cart.clear()` does not compile
(`cannot find symbol`). The cart decides which operations exist. Extending a list is not always wrong; it just hands
out every operation the list has.

In TypeScript, `typescript/ep27/carts.ts` keeps `private items`. `cart.items.length = 0` makes `tsc` report TS2341,
but `node` still runs it and the count becomes `0`: TypeScript's `private` is a checker rule, not protection at run
time.

### The challenge

`java/ep27/challenge/Relationships.md`: three pairs to classify, answers included.

## Shorts

`typescript/shorts/price.ts`: `tsc price.ts` reports a type error, but `node price.ts` still
runs and prints `Price: ten`, because Node removes the types without checking them.

## More

Articles and a one page sheet for each episode: https://code-with-sam-dev.github.io
