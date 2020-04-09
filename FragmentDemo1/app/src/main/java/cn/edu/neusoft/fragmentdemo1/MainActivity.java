package cn.edu.neusoft.fragmentdemo1;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private BottomNavigationView navigationView;
    private List<Fragment> fragmentList;

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

    }

    private void initViewPager() {
        //实例化viewpager
        viewPager = findViewById(R.id.viewpager);
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
                switch (position) {
                    case 0:
                        navigationView.setSelectedItemId(R.id.shouye);
                        break;
                    case 1:
                        navigationView.setSelectedItemId(R.id.shoucang);
                        break;
                    case 2:
                        navigationView.setSelectedItemId(R.id.sousuo);
                        break;
                    case 3:
                        navigationView.setSelectedItemId(R.id.my);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initBottomNV() {
        //实例化BottomNavigationView
        navigationView = findViewById(R.id.bottomnv);
        //设置BottomNavigationView切换事件
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = 0;
                switch (item.getItemId()) {
                    case R.id.shouye:
                        id = 0;
                        break;
                    case R.id.shoucang:
                        id = 1;
                        break;
                    case R.id.sousuo:
                        id = 2;
                        break;
                    case R.id.my:
                        id = 3;
                        break;
                }
                viewPager.setCurrentItem(id);
                return true;
            }
        });
    }


}
