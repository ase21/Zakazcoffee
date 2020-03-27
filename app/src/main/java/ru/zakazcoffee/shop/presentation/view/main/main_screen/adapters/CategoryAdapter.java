package ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.CoffeeCategory;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<CoffeeCategory> categories = new ArrayList<>();

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<CoffeeCategory> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.categoryImageView)
        ImageView categoryImageView;
        @BindView(R.id.categoryNameTextView)
        TextView categoryNameTextView;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(CoffeeCategory coffeeCategory) {
            categoryNameTextView.setText(Html.fromHtml(coffeeCategory.getCategoryName()));
            Glide.with(itemView)
                    .load(coffeeCategory.getCategoryImageUrl())
//                    .apply(RequestOptions.centerCropTransform())
                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .into(categoryImageView);
        }
    }
}
