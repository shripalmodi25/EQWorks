# Work Sample for Mobile Aspect, Kotlin Variant

//CREATE MODULE AND CONVERT IN LIBRARY
1. Add this library as a module in your project
1.1 File -> New -> New Module
1.2 In Create New Module -> Select Android Library -> Next
1.3 Give library name , select minimum sdk version -> Finish

2.Check in build.gradle of library module first line will be apply plugin "com.android.library"
if not then replace "com.android.application" to "com.android.library" and sync gradle.

3. Make AAR file by following
select library module-> Build-> Build apk
it will build AAR file instead of APK


//IF YOU HAVE ALREADY AAR FILE THEN FOLLOW BELOW STEPS
1. Add library to your project
1.1 File-> New -> New Module
1.2 Import .AAR package-> Next
1.3 Enter the location of AAR file-> finish.


//HOW TO USE LIBRARY
1. After addind library as above call log function from Library.kt
2. Please call log function using coroutine for smooth experience.
3. Before calling the log function implement the dynamic permission request from the user.
[What is this for?](https://github.com/EQWorks/work-samples#what-is-this)
