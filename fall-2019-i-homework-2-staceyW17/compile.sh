#!/usr/bin/env bash
mkdir -p target
mkdir -p target/classes
javac -d target/classes src/main/java/edu/nyu/cs9053/homework2/*.java src/main/java/edu/nyu/cs9053/homework2/model/*.java
# TODO - ensure `target/classes` exists (creating it if it doesn't)
# TODO - compile all the Java files within the project and output them into `target/classes`
