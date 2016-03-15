# Adapter
A quick adapter library for ListView , GridView , RecyclerView and ExpandableListView on android. 
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/example.gif)
# Features
* Based on template type
* Simple and clean api
* Super esay to use and Much less code

# Gradle
* compile 'com.github.thepacific:adapter:1.0.0'

# RecyclerView , ListView , GrideView
* RecyclerAdapterHelper and RecyclerAdapter for RecyclerView
* AdapterHelper and Adapter for ListView and GridView
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/grid.PNG)

# ExpandableListView
* ExpandableAdapterHelper and ExpandableAdapter for ExpandableListView
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/expandable.PNG)

# Limit
* Currently, don't do getItemView().setTag() ,because ItemView tag has be set to retain Helper object .

# Dependencies
* compile 'com.github.bumptech.glide:glide:3.7.0'  
  =====of course you can replace it with other image loading library======

#Thanks
* Inspired by JoanZapata's base-adapter-helper (https://github.com/JoanZapata/base-adapter-helper) .
* Thanks JoaZapata(https://github.com/JoanZapata) for his great job .
