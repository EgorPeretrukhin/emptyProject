package ru.friden.com.fragment;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.friden.com.R;
import ru.friden.com.entity.Warehouse;

import java.util.List;

public class BackAddFragment extends Fragment {
    private List<Warehouse> warehouseList;
    private Warehouse warehouse;

    public BackAddFragment(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public BackAddFragment(List<Warehouse> warehouseList, Warehouse warehouse) {
        this.warehouseList = warehouseList;
        this.warehouse = warehouse;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.back_add_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (warehouse != null) {
            TextView textViewModel = view.findViewById(R.id.text_input_model);
            textViewModel.setText(warehouse.getName());
            TextView textViewPrice = view.findViewById(R.id.text_input_price);
            textViewPrice.setText(warehouse.getPriceToString());
            TextView textViewQuantity = view.findViewById(R.id.text_input_quantity);
            textViewQuantity.setText(warehouse.getQuantityToString());
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.back_add_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cancel_button:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, new BackFragment(warehouseList))
                        .commit();
                break;
            case R.id.save_button:
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
