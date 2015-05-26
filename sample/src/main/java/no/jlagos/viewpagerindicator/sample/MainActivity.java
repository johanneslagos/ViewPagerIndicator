package no.jlagos.viewpagerindicator.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import no.jlagos.viewpagerindicator.PageIndicator;


public class MainActivity extends FragmentActivity {
    private static final String[] CONTENT = new String[] { "Recent", "Artists", "Albums", "Songs", "Playlists", "Genres" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter adapter = new PagerAdapter() {

            @Override
            public int getCount() {
                return CONTENT.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position){
                TextView textView = new TextView(container.getContext());
                ViewGroup.LayoutParams params = new FrameLayout.LayoutParams(-1,-1);
                textView.setLayoutParams(params);
                textView.setText(CONTENT[position]);
                textView.setGravity(Gravity.CENTER);
                container.addView(textView);
                return textView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object){
                  container.removeView((TextView)object);
            }
        };
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        PageIndicator indicator = (PageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
