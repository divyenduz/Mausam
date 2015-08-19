package in.zoid.mausam.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.zoid.mausam.R;
import in.zoid.mausam.adapters.WeatherReportAdapter;
import in.zoid.mausam.pojo.WeatherDataComplex;

public class NowFragment extends Fragment {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    LinearLayoutManager mLayoutManager;

    public static NowFragment newInstance(WeatherDataComplex.WeatherData data) {
        NowFragment fragment = new NowFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
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

        WeatherDataComplex.WeatherData data = getArguments().getParcelable("data");
        
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        WeatherReportAdapter adapter = new WeatherReportAdapter(data);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}