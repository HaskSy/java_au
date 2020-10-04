#!/bin/bash
cd src || exit
javac SolutionLeetcode.java ReadWriteFileUtils.java Main.java
echo 'Main-Class: Main' > manifest.txt
jar cfm GenerateMD.jar manifest.txt Main.class SolutionLeetcode.class ReadWriteFileUtils.class
rm -rf manifest.txt Main.class SolutionLeetcode.class ReadWriteFileUtils.class
cd ..
mv src/GenerateMD.jar leetcode
echo "GenerateMD.jar file was successfully compiled and moved to leetcode folder"
