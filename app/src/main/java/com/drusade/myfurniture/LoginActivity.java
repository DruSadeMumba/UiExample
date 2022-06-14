package com.drusade.myfurniture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    FloatingActionButton mFacebook, mTwitter, mGoogle;
    ViewPager mViewPager;
    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTabLayout = findViewById(R.id.tabLayout);
        mFacebook = findViewById(R.id.facebook);
        mTwitter = findViewById(R.id.twitter);
        mGoogle = findViewById(R.id.google);
        mViewPager = findViewById(R.id.viewPager);

        TabLayout.Tab firstTab = mTabLayout.newTab();
        firstTab.setText("Login");
        mTabLayout.addTab(firstTab);

        TabLayout.Tab secondTab = mTabLayout.newTab();
        secondTab.setText("Signup");
        mTabLayout.addTab(secondTab);

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.setTranslationY(300);
        mFacebook.setTranslationY(300);
        mTwitter.setTranslationY(300);
        mGoogle.setTranslationY(300);

        mTabLayout.setAlpha(v);
        mFacebook.setAlpha(v);
        mTwitter.setAlpha(v);
        mGoogle.setAlpha(v);

        mTabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        mFacebook.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        mTwitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();
        mGoogle.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}