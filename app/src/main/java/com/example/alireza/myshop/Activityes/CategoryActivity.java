package com.example.alireza.myshop.Activityes;
//SALM
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.alireza.myshop.CategoryTab.CategoryBehdasht;
import com.example.alireza.myshop.CategoryTab.CategoryBook;
import com.example.alireza.myshop.CategoryTab.CategoryCar;
import com.example.alireza.myshop.CategoryTab.CategoryHome;
import com.example.alireza.myshop.CategoryTab.CategoryMod;
import com.example.alireza.myshop.CategoryTab.CategoryMother;
import com.example.alireza.myshop.CategoryTab.CategorySport;
import com.example.alireza.myshop.CategoryTab.Categorydjital;
import com.example.alireza.myshop.R;

public class CategoryActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;

    Toolbar toolbar;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
//نمشتصی
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("دسته بندی محصولات");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(8);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        String id= (String) getIntent().getExtras().get("id");
        TabLayout.Tab tab = tabLayout.getTabAt(Integer.parseInt(id));
        tab.select();
        tabLayout.setTabMode(0);
    }

//    public static class PlaceholderFragment extends Fragment {
//
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//
//    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment mFragment = null;
            switch (position) {
                case 0:
                    mFragment = new CategoryCar();
                    break;
                case 1:
                    mFragment = new CategoryMother();
                    break;
                case 2:
                    mFragment = new CategorySport();
                    break;
                case 3:
                    mFragment = new CategoryBook();
                    break;
                case 4:
                    mFragment = new CategoryBehdasht();
                    break;
                case 5:
                    mFragment = new CategoryHome();
                    break;
                case 6:
                    mFragment = new CategoryMod();
                    break;
                case 7:
                    mFragment = new Categorydjital();
                    break;


            }

            return mFragment;

        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "وسایل و نقلیه";
                case 1:
                    return "مادر و کودک";
                case 2:
                    return "ورزش و سفر";
                case 3:
                    return "کتاب و فرهنگ و هنر";
                case 4:
                    return "آرایشی بهداشتی";
                case 5:
                    return "خانه و آشپزخانه و ابزار";
                case 6:
                    return "مد و پوشاک";
                case 7:
                    return "کالای دیجیتال";
            }
            return null;
        }
    }

}
