package in.zoid.mausam.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.zoid.mausam.fragments.NowFragment;
import in.zoid.mausam.pojo.WeatherDataComplex;

/**
 * Created by divyendusingh on 8/2/15.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {
    WeatherDataComplex mData;

    public TabFragmentAdapter(FragmentManager fm, WeatherDataComplex data) {
        super(fm);
        this.mData = data;
    }

    @Override
    public Fragment getItem(int position) {
        return NowFragment.newInstance(mData);
    }

    @Override
    public int getCount() {
        return 1;
    }
}
