# Adapter
A quick adapter library for ListView , GridView , RecyclerView, ViewPager and ExpandableListView on android. 
<p>[中文教程](http://www.jianshu.com/p/f18f77255952)
<p>
[ ![Download](https://api.bintray.com/packages/thepacific/maven/adapter/images/download.svg) ](https://bintray.com/thepacific/maven/adapter/_latestVersion)
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/example.gif)
# Features
* Based on template type
* Simple and clean api
* Super esay to use and Much less code

## BaseAdapterHelper

* ```setText()``` Calls ```setText(String)``` on any TextView.
* ```setAlpha()``` Calls ```setAlpha(float)``` on any View.
* ```setVisible()``` Calls ```setVisibility(int)``` on any View.
* ```linkify()``` Calls ```Linkify.addLinks(view, ALL)``` on any TextView.
* ```setTypeface()``` Calls ```setTypeface(Typeface)``` on any TextView.
* ```setProgress()``` Calls ```setProgress(int)``` on any ProgressBar.
* ```setMax()``` Calls ```setMax(int)``` on any ProgressBar.
* ```setRating()``` Calls ```setRating(int)``` on any RatingBar.
* ```setImageResource()``` Calls ```setImageResource(int)``` on any ImageView.
* ```setImageDrawable()``` Calls ```setImageDrawable(Drawable)``` on any ImageView.
* ```setImageBitmap()``` Calls ```setImageBitmap(Bitmap)``` on any ImageView.
* ```setImageUrl()``` Uses [Glide](https://github.com/bumptech/glide) to download the image and put it in an ImageView.
* ```setOnClickListener()```
* ```setOnTouchListener()```
* ```setOnLongClickListener()```
* ```setOnCheckedChangeListener()```
* ```setTag()```
* ```setChecked()```
* ```setAdapter()```

# Gradle
```groovy
compile 'com.github.thepacific:adapter:1.0.3'
```

# RecyclerView , ListView , GrideView ,ViewPager
* RecyclerAdapterHelper and RecyclerAdapter for RecyclerView
* AdapterHelper and Adapter for ListView and GridView
* ViewPagerAdapter ,FragmentPagerAdapter2 and FragmentStatePagerAdapter2 for ViewPager
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/grid.PNG)  
For more features , you can extend their Base**Adapter

# ExpandableListView
* ExpandableAdapterHelper and ExpandableAdapter for ExpandableListView
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/expandable.PNG)  
For more features , you can extend its Base**Adapter

# Limit
* Currently, don't do getItemView().setTag() ,because ItemView tag has be set to retain Helper object .

# Dependencies
```groovy
compile 'com.github.bumptech.glide:glide:3.7.0'
```

#Thanks
* Inspired by JoanZapata's base-adapter-helper (https://github.com/JoanZapata/base-adapter-helper) .
* Thanks JoaZapata(https://github.com/JoanZapata) for his great job .
