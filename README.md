# ViewPagerIndicator
A lightweight View Pager Indicator for Android.
This library will make it easy for you to create a page indicator for each page in your view pager.
You will need to include your viewpager inside a FrameLayout on your xml file. And include the tag with the
library, i.e:

    <no.jlagos.viewpageindicator.PageIndicator
            android:id="@+id/indicator"
            android:layout_width="wrap_content"
            android:layout_height="36dp"
            android:layout_gravity="center_horizontal|bottom"
            android:layout_marginBottom="20dp"
            android:orientation="horizontal" />

Then you will need to instantiate the Page Indicator and include your viewpager:

      PageIndicator indicator = (PageIndicator)findViewById(R.id.indicator);
                indicator.setViewPager(pager);


# TODO: publish to Maven Central.
