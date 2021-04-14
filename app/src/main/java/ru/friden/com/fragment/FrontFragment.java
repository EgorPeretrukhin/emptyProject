package ru.friden.com.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.friden.com.R;
import ru.friden.com.Warehouse;

public class FrontFragment extends Fragment {
    public FrontFragment() {}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Warehouse warehouse = new Warehouse("Samsung", 10.0,3);

        View view = inflater.inflate(R.layout.front_fragment, container, false);
        TextView textView = view.findViewById(R.id.tv_model);
        textView.setText(warehouse.getName());
        TextView textView1 = view.findViewById(R.id.tv_price);
        textView1.setText(warehouse.getPrice());
        TextView textView2 = view.findViewById(R.id.tv_quantity);
        textView2.setText(warehouse.getQuantity());
        return view;
    }
}
