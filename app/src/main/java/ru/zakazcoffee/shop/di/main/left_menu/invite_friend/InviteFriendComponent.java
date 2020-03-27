package ru.zakazcoffee.shop.di.main.left_menu.invite_friend;

import dagger.Subcomponent;
import ru.zakazcoffee.shop.di.scopes.AppScope;
import ru.zakazcoffee.shop.presentation.presenter.main.left_menu.about.AboutUsPresenter;

@AppScope
@Subcomponent(modules = InviteFriendModule.class)
public interface InviteFriendComponent {
    void inject(AboutUsPresenter presenter);
}
