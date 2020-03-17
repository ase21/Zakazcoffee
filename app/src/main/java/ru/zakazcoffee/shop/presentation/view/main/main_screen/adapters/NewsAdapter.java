package ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> news = new ArrayList<>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(news.get(position));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.newsTitleTextView)
        TextView newsTitleTextView;
        @BindView(R.id.newsTextView)
        TextView newsTextView;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(News news) {
            newsTitleTextView.setText(news.getNewsTitle());
            newsTextView.setText(news.getNewsBody());
        }
    }
}
