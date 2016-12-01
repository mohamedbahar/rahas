package com.viwepager.mohamedbahars.viewpager;

import android.graphics.pdf.PdfDocument;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends FragmentActivity {
ViewPager viewPager;
    private int page = 0;
    MypageAdapter mypageAdapter;
    CirclePageIndicator indicator;
    Handler handler = new Handler();
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);

        mypageAdapter = new MypageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mypageAdapter);
        indicator.setViewPager(viewPager);

        runnable = new Runnable() {

            public void run() {
                if (mypageAdapter.getCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                viewPager.setCurrentItem(page, true);
                handler.postDelayed(this, 10000);
            }
        };

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                handler.removeCallbacks(runnable);

            }

            @Override
            public void onPageSelected(int position)
            {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                handler.removeCallbacks(runnable);
            }
        });



}

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 10000);
    }

    @Override
    protected void onPause () {
        super.onPause();
        handler.removeCallbacks(runnable);
    }



    public class MypageAdapter extends FragmentPagerAdapter{

        public MypageAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
switch (position) {

    case 0:
        return FragmentExample.newInstance("Hi", "How are you", "You have new 4 request");

    case 1:
        return FragmentExample1.newInstance("Hi", "How are you", "Know Click Here");

    case 2:
        return FragmentExample.newInstance("Hi", "How are you", "You have new 4 request");

    case 3:
        return FragmentExample1.newInstance("Hi", "How are you", "Know Click Here");

    default:
        return FragmentExample.newInstance("Hi", "How are you", "You have new 4 request");

}

        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
