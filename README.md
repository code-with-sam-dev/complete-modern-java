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

## Shorts

`typescript/shorts/price.ts`: `tsc price.ts` reports a type error, but `node price.ts` still
runs and prints `Price: ten`, because Node removes the types without checking them.

## More

Articles and a one page sheet for each episode: https://code-with-sam-dev.github.io
