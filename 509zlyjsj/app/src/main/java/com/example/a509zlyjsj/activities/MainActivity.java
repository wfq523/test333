package com.example.a509zlyjsj.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.a509zlyjsj.R;
import com.example.a509zlyjsj.fragments.BaseFragment;
import com.example.a509zlyjsj.fragments.Fragment1;
import com.example.a509zlyjsj.fragments.Fragment2;
import com.example.a509zlyjsj.fragments.Fragment3;
import com.example.a509zlyjsj.fragments.Fragment4;
import com.example.a509zlyjsj.fragments.Fragment5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private String sessionID = "";

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private BottomNavigationView bnv;
    private List<BaseFragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragmentList();//初始化FragmentList
        initViewPager();//初始化ViewPager
        initBottomNV();//初始化BottomNavigationView

    }

    private void initFragmentList() {
        // 将fragment加载到list中
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        fragmentList.add(new Fragment5());
    }

    private void initViewPager() {
        //实例化viewpager
        viewPager = findViewById(R.id.viewPager);
        //实例化FragmentPagerAdapter
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        //设置viewpager的适配器
        viewPager.setAdapter(fragmentPagerAdapter);
        //设置viewpager的页面切换事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("---position=" + position);
                switch (position) {
                    case 0:
                        bnv.setSelectedItemId(R.id.blog);
                        break;
                    case 1:
                        bnv.setSelectedItemId(R.id.keynote);
                        break;
                    case 2:
                        bnv.setSelectedItemId(R.id.video);
                        break;
                    case 3:
                        bnv.setSelectedItemId(R.id.sample);
                        break;
                    case 4:
                        bnv.setSelectedItemId(R.id.my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    private void initBottomNV() {
        //实例化BottomNavigationView
        bnv = findViewById(R.id.bottomnv);
        //设置BottomNavigationView切换事件
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = 0;
                switch (item.getItemId()) {
                    case R.id.blog:
                        id = 0;
                        break;
                    case R.id.keynote:
                        id = 1;
                        break;
                    case R.id.video:
                        id = 2;
                        break;
                    case R.id.sample:
                        id = 3;
                        break;
                    case R.id.my:
                        id = 4;
                        break;
                }
                System.out.println("---id=" + id);
                viewPager.setCurrentItem(id);
                return true;
            }
        });
    }
}
