package com.sample.pablo.breadcrumbs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sample.pablo.breadcrumbs.adapter.SamplePageAdapter;

public class MainActivity extends AppCompatActivity {

    private SamplePageAdapter mAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.vpPager);
        setupViewPager();

        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        setupTabLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuAdd) {
            mAdapter.addItem("Teste " + (mAdapter.getCount() + 1), new BlankFragment());
            mViewPager.setCurrentItem(mAdapter.getCount());
        }
        return true;
    }

    private void setupTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            boolean isTabUpdating;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (!isTabUpdating) {
                    isTabUpdating = true;
                    final int pos = tab.getPosition();
                    mViewPager.setCurrentItem(pos);


                    mTabLayout.setupWithViewPager(mViewPager);
                    invalidateTabs(pos);
                }
            }

            private void invalidateTabs(int position) {
                for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                    TabLayout.Tab tab = mTabLayout.getTabAt(i);
                    if (tab != null) {
                        tab.setCustomView(mAdapter.getTabView(MainActivity.this, i, position));
                    }
                }
                isTabUpdating = false;

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager() {
        mViewPager.setClipToPadding(false);
        mViewPager.setPageMargin(12);

        mAdapter = new SamplePageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }
}
