package ru.friden.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.friden.com.R;
import ru.friden.com.Warehouse;

import java.util.List;

public class WareHouseFrontAdapter extends RecyclerView.Adapter<WareHouseFrontAdapter.WarehouseVh> {
    private Context context;
    private List<Warehouse> warehouseList;

    public WareHouseFrontAdapter(Context context, List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
        this.context = context;
    }

    @NonNull
    @Override
    public WarehouseVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_for_front_fragment,parent,false);
        return new WarehouseVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WarehouseVh holder, int position) {
        holder.tvModel.setText(warehouseList.get(position).getName());
        holder.tvPrice.setText(warehouseList.get(position).getPrice());
        holder.tvQuantity.setText(warehouseList.get(position).getQuantity());

    }


    @Override
    public int getItemCount() {
        return warehouseList.size();
    }

    public class WarehouseVh extends RecyclerView.ViewHolder {
        private TextView tvModel;
        private TextView tvPrice;
        private TextView tvQuantity;

        public WarehouseVh(@NonNull View itemView) {
            super(itemView);
            tvModel = itemView.findViewById(R.id.tv_model);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
        }
    }
}
