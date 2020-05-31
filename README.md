# ColorfulTextView
A simple library to create colorful TextViews

![Image of Yaktocat](https://github.com/masoud1993/ColorfulTextView/raw/master/shot.PNG)

## Usage
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  Step 2. Add the dependency in app level build.gradle
  
 Latest version is
 [![](https://jitpack.io/v/masoud1993/ColorfulTextView.svg)](https://jitpack.io/#masoud1993/ColorfulTextView)
  ```
  dependencies {
	        implementation 'com.github.masoud1993:ColorfulTextView:VERSION'
	}
  ```
  
  Step 3. Add ColorfulTextView in layout
  
```
      <com.masa.colorfultextview.ColorfulTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="test @{Hello,#000000,200,N} @{My,#FF5722,100,I} @{World,#000fff,55,B}" />
 ```
