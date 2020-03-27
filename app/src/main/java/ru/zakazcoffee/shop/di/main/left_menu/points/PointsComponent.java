package ru.zakazcoffee.shop.di.main.left_menu.points;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = PointsModule.class)
public interface PointsComponent {
    void inject(AboutUsPresenter presenter);
}
