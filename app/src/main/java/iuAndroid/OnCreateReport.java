package iuAndroid;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import timetracker.iuandroid.R;

/**
 * Created by Judit on 10/01/2016.
 */
public class OnCreateReport extends Activity {

    private int layoutID = R.layout.createreport;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createreport);
    }
}