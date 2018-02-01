package za.co.riggaroo.guide.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;
import za.co.riggaroo.guide.GuideFragment;


public class GuideAdapter extends FragmentPagerAdapter {
    private List<GuideFragment> fragments;
    public GuideAdapter(FragmentManager fm, List<GuideFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
