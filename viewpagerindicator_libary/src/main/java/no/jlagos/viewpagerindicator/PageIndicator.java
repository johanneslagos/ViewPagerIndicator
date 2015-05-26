package no.jlagos.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * Created by johanneslagos on 19.05.15.
 */
public class PageIndicator extends LinearLayout implements OnPageChangeListener {

    PagerAdapter adapter;
    ViewPager pager;
    Context context;
    boolean pagerIsSet = false;

    public PageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    //Method for setting connection with the View Pager
    public  void setViewPager(ViewPager pager) {
        assert pager != null;
        if(pager.getClass().equals(ViewPager.class)){
            this.pager = pager;
            this.pager.setOnPageChangeListener(this);

            assert this.pager.getAdapter() != null;
            adapter = this.pager.getAdapter();

            pagerIsSet = true;
            setupViews();
        }
        else{
            pagerIsSet = false;
            throw new NullPointerException("Pager is not set");
        }
    }

    protected void setupViews() {
        int count = adapter.getCount();
        for(int i = 0; i < count; i++){
            View view = new View(context);
            view.setBackgroundResource(R.drawable.changingcolor);
            if (i == pager.getCurrentItem()){
                view.setActivated(true);
            }
            LayoutParams params = new LayoutParams(dpToPx(6), dpToPx(6), 1.0f);
            params.setMargins(dpToPx(8), 0, 0, 0);

            view.setLayoutParams(params);
            this.addView(view);
        }
    }

    protected void  onLayout(boolean changed, int l, int t, int r, int b){
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int count = getChildCount();
        for(int i = 0; i < count; i++){
            View  v = (View) getChildAt(i);
            v.setActivated(false);
        }
        View v = (View) getChildAt(position);
        v.setActivated(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setIndex(int position){
        for(int i = 0; i < getChildCount(); i ++){
            View v = (Button)getChildAt(i);
            v.setActivated(i == position);
        }
    }

    public int dpToPx(int dp) {

        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()) + 0.5f;

        return (int) px;
    }
}
