Pretty Toast
============

![Logo](http://i.imgur.com/40mG7Lj.png)

This is quite simple toast library, that make it easier to show and create custom toast.

This library provides following features :

 * Bunch of predefined static methods for frequently used messages `Error`, `Info`,`Warning` ...
 * Flexible `Builder` class, so you construct almost any kind of toast message
 * Main class extends native `Toast` class
 * Support starting from `Android 2.1` (`API 7`)


Download and Installation 
-------------------------

Download [the latest AAR][1] or grab via Maven:
```xml
<dependency>
    <groupId>ua.com.crosp.solutions.library</groupId>
    <artifactId>pretty-toast</artifactId>
    <version>0.1.0</version>
</dependency>
```
or Gradle:
```groovy
compile 'ua.com.crosp.solutions.library:pretty-toast:0.1.0''
```


Usage
-----

Predefined static methods

```java
 PrettyToast.showWarning(getApplicationContext(), "WARNING");
 PrettyToast.showInfo(getApplicationContext(), "INFO");
 PrettyToast.showSuccess(getApplicationContext(), "SUCCESS");
 PrettyToast.showError(getApplicationContext(), "ERROR");
 PrettyToast.showDim(getApplicationContext(), "DIM");
```

Using `Builder` class

```java
   new PrettyToast.Builder(getApplicationContext())
                        .withRightIcon("mdi-earth")
                        .withMessage("Custom toast")
                        .withLeftIcon("mdi-stackoverflow")
                        .withDuration(Toast.LENGTH_SHORT)
                        .withLeftIconColor(R.color.firebrick)
                        .withBackgroundResource(R.drawable.background_custom)
                        .withGravity(new PrettyToast.Gravity(Gravity.START, 15, 0))
                        .withTextSize(24)
                        .withRightIconColor(R.color.blueviolet)
                        .withTextColor(R.color.blue)
                        .build()
                        .show();
```

Using completely custom view

```java
 new PrettyToast.Builder(getApplicationContext())
                        .withCustomView(LayoutInflater.from(MainActivity.this).inflate(R.layout.toast_custom, null, false))
                        .build()
                        .show();
```

You can use any icon provided by [Android-Iconify](https://github.com/JoanZapata/android-iconify) library

#Credits
- [Joan Zapata](https://github.com/JoanZapata)  The creator of [Android-Iconify](https://github.com/JoanZapata/android-iconify)
- [Pierry Borges](https://github.com/Pierry/SimpleToast) Thanks for the idea

License
-------

    Copyright 2016 Oleksandr Molochko

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [1]: http://repo1.maven.org/maven2/ua/com/crosp/solutions/library/pretty-toast/0.1.0/pretty-toast-0.1.0.aar

