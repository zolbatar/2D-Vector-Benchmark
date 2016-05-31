#!/bin/sh

# Java
cd Java/2DVectorBenchmarkJavaFX/dist
echo "JavaFX"
printf "         JavaFX: " > ../../../Timings/JavaFX.txt
{ gtime -f "%E real  %U user  %S sys %M set size" java -server -Xms1024m -XX:+UseG1GC -jar 2DVectorBenchmarkJavaFX.jar ; } 2>> ../../../Timings/JavaFX.txt
cd ../..
cd 2DVectorBenchmarkJavaFX/dist
echo "JavaFX"
printf "     Java LWJGL: " > ../../../Timings/JavaLWJGL.txt
{ gtime -f "%E real  %U user  %S sys %M set size" java -server -Xms1024m -XX:+UseG1GC -Dorg.lwjgl.librarypath="../libs/native" -XstartOnFirstThread -jar 2DVectorBenchmarkLWJGL.jar ; } 2>> ../../../Timings/JavaLWJGL.txt
cd ../../..

# Python
cd Python
echo "Pythons"
printf " Python2 OpenGL: " > ../Timings/Python2.txt
{ gtime -f "%E real  %U user  %S sys %M set size" python2 2dvector.py ; } 2>> ../Timings/Python2.txt
printf " Python3 OpenGL: " > ../Timings/Python3.txt
{ gtime -f "%E real  %U user  %S sys %M set size" python3 2dvector.py ; } 2>> ../Timings/Python3.txt
printf "    Python2 SDL: " > ../Timings/Python2SDL.txt
{ gtime -f "%E real  %U user  %S sys %M set size" python2 2dvectorSDL.py ; } 2>> ../Timings/Python2SDL.txt
printf "    Python3 SDL: " > ../Timings/Python3SDL.txt
{ gtime -f "%E real  %U user  %S sys %M set size" python3 2dvectorSDL.py ; } 2>> ../Timings/Python3SDL.txt
cd ..

# Timings
cat Timings/JavaFX.txt
cat Timings/JavaLWJGL.txt
cat Timings/Python2.txt
cat Timings/Python3.txt
cat Timings/Python2SDL.txt
cat Timings/Python3SDL.txt
