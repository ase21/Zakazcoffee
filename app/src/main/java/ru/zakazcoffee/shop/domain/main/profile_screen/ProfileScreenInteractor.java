package ru.zakazcoffee.shop.domain.main.profile_screen;

import io.reactivex.Completable;
import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.User;

public interface ProfileScreenInteractor {
    Completable clearInformation();

    Single<User> getInformation();
}
