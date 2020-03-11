package ru.zakazcoffee.shop.presentation.view.main.main_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.relex.circleindicator.CircleIndicator3;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.zakazcoffee.shop.R;
import ru.zakazcoffee.shop.data.models.Banner;
import ru.zakazcoffee.shop.data.models.Coffee;
import ru.zakazcoffee.shop.data.models.CoffeeCategory;
import ru.zakazcoffee.shop.data.models.News;
import ru.zakazcoffee.shop.presentation.presenter.main.main_screen.MainScreenPresenter;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters.BannerAdapter;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters.CategoryAdapter;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters.CoffeeAdapter;
import ru.zakazcoffee.shop.presentation.view.main.main_screen.adapters.NewsAdapter;

public class MainScreenFragment extends MvpAppCompatFragment implements MainScreenView {

    @BindView(R.id.viewPager)
    ViewPager2 viewPager;
    @BindView(R.id.indicator)
    CircleIndicator3 indicator;
    @BindView(R.id.categoryRecyclerView)
    RecyclerView categoryRecyclerView;
    @BindView(R.id.topCoffeeRecyclerView)
    RecyclerView topCoffeeRecyclerView;
    @BindView(R.id.newsRecyclerView)
    RecyclerView newsRecyclerView;
    @BindView(R.id.recentlyWatchedRecyclerView)
    RecyclerView recentlyWatchedRecyclerView;

    @InjectPresenter
    MainScreenPresenter presenter;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private BannerAdapter bannerAdapter;
    private CategoryAdapter categoryAdapter;
    private CoffeeAdapter topCoffeeAdapter;
    private CoffeeAdapter recentlyWatchedCoffeeAdapter;
    private NewsAdapter newsAdapter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        initUi(view);

        presenter.getInformation();

        return view;
    }

    private void initUi(View view) {
        bannerAdapter = new BannerAdapter();
        viewPager.setAdapter(bannerAdapter);
        indicator.setViewPager(viewPager);
        unbinder = ButterKnife.bind(this, view);

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        categoryAdapter = new CategoryAdapter();
        categoryRecyclerView.setAdapter(categoryAdapter);

        topCoffeeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        topCoffeeAdapter = new CoffeeAdapter();
        topCoffeeRecyclerView.setAdapter(topCoffeeAdapter);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter();
        newsRecyclerView.setAdapter(newsAdapter);

        recentlyWatchedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recentlyWatchedCoffeeAdapter = new CoffeeAdapter();
        recentlyWatchedRecyclerView.setAdapter(topCoffeeAdapter);

    }

    @Override
    public void setBanners(List<Banner> banners) {
        bannerAdapter.setBanners(banners);
    }

    @Override
    public void setCoffeeCategories(List<CoffeeCategory> categories) {
        categoryAdapter.setCategories(categories);
    }

    @Override
    public void setTopCoffee(List<Coffee> topCoffees) {
        topCoffeeAdapter.setCoffee(topCoffees);
    }

    @Override
    public void setNews(List<News> news) {
        newsAdapter.setNews(news);
    }

    @Override
    public void setRecentlyWatched(List<Coffee> recentlyWatchedCoffees) {
        recentlyWatchedCoffeeAdapter.setCoffee(recentlyWatchedCoffees);
    }

    @Override
    public void showMessage(String messageText) {
        Toast.makeText(getContext(), messageText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
