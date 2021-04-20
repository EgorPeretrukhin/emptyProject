package ru.friden.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import ru.friden.com.R;
import ru.friden.com.Warehouse;
import ru.friden.com.fragment.BackAddFragment;
import ru.friden.com.fragment.BackFragment;

import java.util.List;

public class WareHouseBackAdapter extends RecyclerView.Adapter<WareHouseBackAdapter.WarehouseVh> {
    private Context context;
    private List<Warehouse> warehouseList;
    private FragmentManager fragmentManager;

    public WareHouseBackAdapter(Context context, List<Warehouse> warehouseList, FragmentManager fragmentManager) {
        this.warehouseList = warehouseList;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public WarehouseVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new WarehouseVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WarehouseVh holder, int position) {
        holder.tvModel.setText(warehouseList.get(position).getName());
        holder.tvQuantity.setText(warehouseList.get(position).getQuantity());
        final Warehouse warehouse = warehouseList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new BackAddFragment(warehouseList, warehouse))
                        .commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return warehouseList.size();
    }

    public class WarehouseVh extends RecyclerView.ViewHolder {
        private TextView tvModel;
        private TextView tvQuantity;

        public WarehouseVh(@NonNull View itemView) {
            super(itemView);
            tvModel = itemView.findViewById(R.id.tv_item_model);
            tvQuantity = itemView.findViewById(R.id.tv_item_quantity);
        }
    }
}
