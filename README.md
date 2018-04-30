# What’s New in Java FX — Java 9 Updates
Gradle source code repository for the JavaFX 9 example from my blog post, http://bit.ly/JavaFX9.
As of at least (04/27/2018), this article has reached ~10K people in 209 days making it the top google search result for the query "JavaFX9" and one of the top article on JavaFX 9 on the web. This repository was built and tested using Bash/Sublime on openSUSE Tumbleweed 20180424. The intent of this repository, aside from demonstrating basic JavaFX is also to demonstrate the structure of a javafx gradle build.

![alt text](https://raw.githubusercontent.com/afinlay5/JavaFX9/master/blog.png)

# Platform 
- Any supporting a JavaFX compatible JVM for Java SE 8+.

# Requirements
- Gradle 4.7 
- Java 8 or greater.

# Gradle Tasks
- ./gradlew build - Build JavaFX Application
- ./gradlew jfxJar - Create executable JavaFX-jar
- ./gradlew jfxNative - Create native JavaFX-bundle (will run jfxJar first)
- ./gradlew jfxRun - Create the JavaFX-jar and runs it like you would do using java -jar my-project-jfx.jar
- ./gradlew jfxRunClass - Launches the JavaFX Application from the main class file
Note: All Gradle tasks with the exception of jfxRunClass is the work of FibreFox, whose plugin I utilized for this project (See https://github.com/FibreFoX/javafx-gradle-plugin, Apache 2.0 license).

# Known Problems
- gradle jfxNative failed to produce a working native executable on openSUSE (04/27/2018).
- FibreFoX/javafx-gradle-plugin may break with Java 9.0.2 and fail to build the application (04/27/2018).

# Execution Screenshot
![alt text](https://raw.githubusercontent.com/afinlay5/JavaFX9/master/gradle_jfxRun.png)
