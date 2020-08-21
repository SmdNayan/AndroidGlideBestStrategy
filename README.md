# The best cache strategy of Glide
Glide is an open-source Image Loader Library for Android developed by bumptech. Also, the library is recommended by Google.

When a begineer implement Glide library on a project. Most of the developer don't use or don't analyis best cache strategy of
Glide library to load and cache image of the Android Application. In this implement I am trying to the best strategies to implement Glide.  
 
###### The application is the the example part of [this](https://medium.com/@SmdNayan/the-best-way-to-load-the-image-using-glide-and-cache-strategy-in-android-3032e6ef0c78) tutorial I wrote 

## Implementation
Now I show How to implement Glide with the best cache strategy. 

First add the below dependecy library on your `build.gradle(Module: app)` gradle
```
dependencies {
  implementation 'com.github.bumptech.glide:glide:4.11.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
}
```
Then sync gradle file. After that go to your Image activity and call Glide with your image link. like this
```
Glide.with(this)
    .load("http://goo.gl/gEgYUd")
    .into(imageView);
```




 