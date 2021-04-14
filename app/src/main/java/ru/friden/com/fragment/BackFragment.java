package ru.friden.com.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import ru.friden.com.CsvReaderAndWriter;
import ru.friden.com.R;
import ru.friden.com.Warehouse;
import ru.friden.com.adapter.WareHouseAdapter;

import java.util.List;

public class BackFragment extends Fragment {
    private List<Warehouse> warehouseList;

    public BackFragment(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.back_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new WareHouseAdapter(getContext(), warehouseList));
    }
}
