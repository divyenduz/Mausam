package in.zoid.mausam.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.zoid.mausam.R;
import in.zoid.mausam.adapters.WeatherReportAdapter;
import in.zoid.mausam.pojo.WeatherDataComplex;

public class NowFragment extends Fragment {

    @Bind(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;

    public static NowFragment newInstance(WeatherDataComplex data) {
        NowFragment fragment = new NowFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", Parcels.wrap(data));
        fragment.setArguments(bundle);
        return fragment;
    }

    public NowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now, container, false);
        ButterKnife.bind(this, view);

        WeatherDataComplex data = Parcels.unwrap(getArguments().getParcelable("data"));

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        WeatherReportAdapter adapter = new WeatherReportAdapter(data);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
