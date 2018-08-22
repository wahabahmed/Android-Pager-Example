package pager.example.com.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PagerActivity extends AppCompatActivity {
    ViewPager mSlidePagerLayout;
    LinearLayout mDotsLayout;
    private TextView[] mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        mSlidePagerLayout = (ViewPager) findViewById(R.id.slide_pager_layout);
        mDotsLayout = (LinearLayout) findViewById(R.id.dots_layout);


        SliderAdapter sliderAdapter = new SliderAdapter(this);
        mSlidePagerLayout.setAdapter(sliderAdapter);
        mSlidePagerLayout.addOnPageChangeListener(viewListener);
        addDots(0);
    }


    public void addDots(int position) {
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.black_overlay));

            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
