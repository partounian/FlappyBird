#!/bin/bash

cd C:\Users\p26208\Dropbox\FlappyBird
"C:\Program Files\Java\jdk1.7.0_67\bin\javac.exe" src/*.java
java -cp src/ App
rm src/*.class
