package ru.friden.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import ru.friden.com.R;
import ru.friden.com.Warehouse;

import java.util.List;

public class WareHouseBackAdapter extends RecyclerView.Adapter<WareHouseBackAdapter.WarehouseVh> {
    private Context context;
    private List<Warehouse> warehouseList;

    public WareHouseBackAdapter(Context context, List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
        this.context = context;
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fragmentTransaction;
                    Toast.makeText(v.getContext(), "1234", Toast.LENGTH_SHORT).show();
                }
            });
            tvModel = itemView.findViewById(R.id.tv_item_model);
            tvQuantity = itemView.findViewById(R.id.tv_item_quantity);
        }
    }
}
