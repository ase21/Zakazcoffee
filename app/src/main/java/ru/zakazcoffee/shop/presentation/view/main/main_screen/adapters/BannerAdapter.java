package ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.Banner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private List<Banner> banners = new ArrayList<>();

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bind(banners.get(position));
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        BannerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Banner banner) {

        }
    }
}
