# QuickAdapter
A quick adapter library for ListView , GridView , RecyclerView and ExpandableListView on android.

# RecyclerView , ListView , GrideView
* Generate map objects(tables and data views) from an existing sqlite file
* Generate API to read/write sqlite (insert,update,delete,query and so on)
* API based on SQLiteOpenHelper and 100% support any SQL statement
* API is super light , expandable and pluggable
* Code quantity is less 60% than GreedDao

# ExpandableListView
* Clone the whole project from github
* Import the project into IntelliJ (Optionally, you can copy the sources to eclipse IDE)
* Set your own models package, api package ,table name format,and the target directory
* Run the project, and you will see the whole generated codes in the target directory

# Limit
* Currently, don't do getItemView().setTag() ,because ItemView tag has be set to retain Helper object .

# Dependencies
* Glide-3.7.0.jar == for load url image , of course you can replace it with other image load library .

#Thanks
* This repository is inspired by Joan Zapata's base-adapter-helper (https://github.com/JoanZapata/base-adapter-helper)
* Thanks Joan Zapata for his greate job .
