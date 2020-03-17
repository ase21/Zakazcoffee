package ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import ru.zakazcoffee.shop.data.models.Coffee;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private List<Coffee> coffees = new ArrayList<>();

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee, parent, false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        holder.bind(coffees.get(position));
    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    public void setCoffee(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.coffeeImageView)
        ImageView coffeeImageView;
        @BindView(R.id.nameTextView)
        TextView nameTextView;
        @BindView(R.id.weightTextView)
        TextView weightTextView;
        @BindView(R.id.compoundTextView)
        TextView compoundTextView;
        @BindView(R.id.priceTextView)
        TextView priceTextView;
        @BindView(R.id.addToBasketImageButton)
        ImageView addToBasketImageButton;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Coffee coffee) {
            Glide.with(itemView)
                    .load(coffee.getCoffeeImageUrl())
//                    .apply(RequestOptions.centerCropTransform())
//                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .into(coffeeImageView);
            nameTextView.setText(coffee.getCoffeeName());
            compoundTextView.setText(coffee.getCoffeeConsist());
            weightTextView.setText(coffee.getCoffeeWeight());
            priceTextView.setText(coffee.getCoffeePrice());
            //listener
        }
    }
}
