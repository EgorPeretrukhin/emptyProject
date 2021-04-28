package ru.friden.com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import ru.friden.com.R;
import ru.friden.com.database.WarehouseViewModel;
import ru.friden.com.entity.Warehouse;

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
        View view = LayoutInflater.from(context).inflate(R.layout.item_for_front_fragment, parent, false);
        return new WarehouseVh(view);
    }


    @Override
    public void onBindViewHolder(@NonNull WarehouseVh holder, final int position) {
        holder.tvModel.setText(warehouseList.get(position).getName());
        holder.tvPrice.setText(warehouseList.get(position).getPriceToString());
        holder.tvQuantity.setText(warehouseList.get(position).getQuantityToString());
        Button buttonBuy = holder.itemView.findViewById(R.id.btn_buy);
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Warehouse warehouse = warehouseList.get(position);
                Toast.makeText(context, "Purchase", Toast.LENGTH_SHORT).show();
            }
        });

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
