package pager.example.com.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by wahaba on 21/08/2018.
 */
public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public String[] slider_headings = {
            "Accomplished Tasks",
            "Like Tasks",
            "Rate UI/UX"
    };

    public int[] slider_image = {
            R.drawable.test_icon1,
            R.drawable.test_icon2,
            R.drawable.test_icon3
    };

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        TextView title = (TextView) view.findViewById(R.id.slider_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);


        imageView.setImageResource(slider_image[position]);
        title.setText(slider_headings[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
