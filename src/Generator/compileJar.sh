#!/bin/bash
javac -sourcepath ./src -d bin *.java
echo 'Main-Class: Generator.src.Main' > Generator/manifest.txt
jar cfm Generator/GenerateMD.jar Generator/manifest.txt Main.class SolutionLeetcode.class ReadWriteFileUtils.class
rm -rf manifest.txt Main.class SolutionLeetcode.class ReadWriteFileUtils.class
cd ..;
mv Generator/GenerateMD.jar leetcode
echo "GenerateMD.jar file was successfully compiled and moved to leetcode folder"

#### Have to be refactored (Doesn't work now )