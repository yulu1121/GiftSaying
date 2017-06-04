package com.example.fragmentnew;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RadioGroup myRadioGroup;
    private Fragment mCurrentFragment;
    private FragmentManager fragmentManager;
    private FragOne fragOne;
    private FragTwo fragTwo;
    private FragThree fragThree;
    private FragFour fragFour;
    private List<Fragment> fragmentList;
    private RadioButton home;
    private RadioButton search;
    private RadioButton select;
    private RadioButton profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragments();
        initClick();
        initListener();
    }

    private void initClick() {
        fragmentManager.beginTransaction().add(R.id.frag_frame,fragOne).commit();
        home.setTextColor(Color.RED);
        home.setChecked(true);
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        fragOne = FragOne.getInstance();
        fragTwo = FragTwo.getInstance();
        fragThree = FragThree.getInstance();
        fragFour = FragFour.getInstance();
        fragmentList.add(fragOne);
        fragmentList.add(fragTwo);
        fragmentList.add(fragThree);
        fragmentList.add(fragFour);
        mCurrentFragment  = fragOne;
    }
    private void initListener(){
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.my_home:
                        setFragment(fragOne);
                        home.setTextColor(Color.RED);
                        break;
                    case R.id.my_profile:
                        setFragment(fragTwo);
                        profile.setTextColor(Color.RED);
                        break;
                    case R.id.my_search:
                        setFragment(fragThree);
                        search.setTextColor(Color.RED);
                        break;
                    case R.id.my_select:
                        setFragment(fragFour);
                        select.setTextColor(Color.RED);
                        break;
                }
            }
        });
    }
    private void initView() {
        myRadioGroup = (RadioGroup) findViewById(R.id.my_radio);
        home = (RadioButton) findViewById(R.id.my_home);
        search = (RadioButton) findViewById(R.id.my_search);
        select = (RadioButton) findViewById(R.id.my_select);
        profile = (RadioButton) findViewById(R.id.my_profile);
    }

    private void setFragment(Fragment fragment){
        if(!fragment.isAdded()){
            fragmentManager.beginTransaction().hide(mCurrentFragment).add(R.id.frag_frame,fragment).commit();
        }else{
            fragmentManager.beginTransaction().hide(mCurrentFragment).show(fragment).commit();
        }
        mCurrentFragment = fragment;
    }

}
