package ru.friden.com.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import ru.friden.com.R;
import ru.friden.com.Warehouse;
import ru.friden.com.adapter.WareHouseFrontAdapter;

import java.util.List;

public class FrontFragment extends Fragment {
    private List<Warehouse> warehouseList;

    public FrontFragment(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.front_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        view.findViewById(R.id.include).setVisibility(View.INVISIBLE);
        ViewPager2 viewPager2 = view.findViewById(R.id.view_pager);
        viewPager2.setAdapter(new WareHouseFrontAdapter(getContext(), warehouseList));
    }
}
