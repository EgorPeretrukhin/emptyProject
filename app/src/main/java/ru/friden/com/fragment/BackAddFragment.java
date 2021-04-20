package ru.friden.com.fragment;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import ru.friden.com.R;
import ru.friden.com.Warehouse;
import ru.friden.com.adapter.WareHouseBackAdapter;

import java.util.List;

public class BackAddFragment extends Fragment {
    private List<Warehouse> warehouseList;

    public BackAddFragment(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.back_toolbar_menu,menu);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //setHasOptionsMenu(true);
        return inflater.inflate(R.layout.back_add_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
//        recyclerView.setAdapter(new WareHouseBackAdapter(getContext(), warehouseList));
    }


}
