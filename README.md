# Adapter
A quick adapter library for ListView , GridView , RecyclerView, ViewPager and ExpandableListView on android. Multiple view type is supported for ListView 、GrideView 、RecyclerView.
<p>[中文教程](http://www.jianshu.com/p/f18f77255952)
<p>
[ ![Download](https://api.bintray.com/packages/thepacific/maven/adapter/images/download.svg) ](https://bintray.com/thepacific/maven/adapter/_latestVersion)
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/example.gif)
# Features
* Based on template type
* Simple and clean api
* Super esay to use and Much less code
* Multiple view type support for ListView 、GrideView 、RecyclerView

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
compile 'com.github.thepacific:adapter:{lastest version}'
```

# RecyclerView , ListView , GrideView
* RecyclerAdapterHelper and RecyclerAdapter for RecyclerView
* AdapterHelper and Adapter for ListView and GridView

#### Single Layout
```java
adapter = new Adapter<ExploreBean>(getContext(), R.layout.item) {
            @Override
            protected void convert(final AdapterHelper helper, ExploreBean exploreBean) {
                final int position = helper.getPosition();
                helper
                        .setText(R.id.tv_explore_name, "__Index: " + String.valueOf(position))
                        .setText(R.id.tv_explore_desc, exploreBean.getDescription())
                        .getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickSnack(position);
                    }
                });
            }
        };      
```

#### Multiple Layout
```java
adapter = new Adapter<ExploreBean>(getContext(), R.layout.item) {
            @Override
            protected void convert(final AdapterHelper helper, ExploreBean exploreBean) {
                final int position = helper.getPosition();
                if (position % 3 == 0) {
                    helper.setText(R.id.tv_explore_name, "__Index: " + String.valueOf(position));
                } else if (position % 3 == 1) {
                    helper.setImageResource(R.id.img_explore_icon, exploreBean.getIconResId());
                } else {
                    helper.getItemView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clickSnack(position);
                        }
                    });
                }
            }

            /**
             * Must be overridden , when you have more than one item layout.
             * No need to be overridden , when you only have one item layout.
             */
            @Override
            public int getItemViewType(int position) {
                if (position % 3 == 0) {
                    return 0;
                } else if (position % 3 == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }

            /**
             * Get layoutResId from view type  @see #getItemViewType(int position) return value.
             * Must be overridden , when you have more than one item layout.
             * No need to be overridden , when you only have one item layout.
             */
            @Override
            public int getLayoutResId(int viewType) {
                if (viewType == 0) {
                    return R.layout.item;
                } else if (viewType == 1) {
                    return R.layout.item0;
                } else {
                    return R.layout.item1;
                }
            }
        };
```
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/grid.PNG)  
for more features , you can extend their Base Adapter

# ExpandableListView
* ExpandableAdapterHelper and ExpandableAdapter for ExpandableListView
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/expandable.PNG)  
for more features , you can extend its Base Adapter

# ViewPager
* ViewPagerAdapter ,FragmentPagerAdapter2 and FragmentStatePagerAdapter2 for ViewPager
```java
/***************************With Item Layout***************************************/
        adapter = new ViewPagerAdapter<String>(context,R.layout.view_pager_view) {
            @Override
            protected void convert(PagerAdapterHelper helper, String item) {
                helper.setBackgroundRes(R.id.img_view, R.drawable.exa);
            }
        };

/******************Without Item Layout and create view from java code*****************/
        adapter = new ViewPagerAdapter<String>(context) {
            @Override
            protected void convert(PagerAdapterHelper helper, String item) {
                helper.setBackgroundRes(R.id.img_view, R.drawable.exa);
            }

            // just override createView()
            @Override
            protected View createView(ViewGroup container, int position) {
                FrameLayout fl = new FrameLayout(context);
                ImageView imageView = new ImageView(context);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(480, 480, Gravity.CENTER);
                imageView.setId(R.id.img_view);
                fl.addView(imageView);
                imageView.setLayoutParams(lp);
                return fl;
            }
        };
```
<p>
![](https://github.com/ThePacific/QuickAdapter/blob/master/art/expandable.PNG)  
for more features , you can extend its Base Adapter

# Dependencies
```groovy
compile 'com.github.bumptech.glide:glide:3.7.0'
```

#Thanks
* Inspired by JoanZapata's base-adapter-helper (https://github.com/JoanZapata/base-adapter-helper) .
* Thanks JoaZapata(https://github.com/JoanZapata) for his great job .
