package com.example.applicationbuilding;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{
    public ItemsAdapter(ArrayList<ItemDomain> items) {
        this.items = items;
        this.formatter = new DecimalFormat("###,###,###,###.##");
    }

    private ArrayList<ItemDomain> items;
    DecimalFormat formatter;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.addressView.setText(items.get(position).getAddress());
        holder.priceView.setText("$" + formatter.format(items.get(position).getPrice()));
        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPic(),
                "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pictureView);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", (CharSequence) items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView addressView;
        private TextView priceView;
        private ImageView pictureView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addressView = itemView.findViewById(R.id.address);
            priceView = itemView.findViewById(R.id.price);
            pictureView = itemView.findViewById(R.id.picture);
        }
    }
}
