package ru.zakazcoffee.shop.domain.main.profile_screen;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.User;
import ru.zakazcoffee.shop.data.network.NetworkRepository;
import ru.zakazcoffee.shop.data.shared_prefs.PrefsHelper;

public class ProfileScreenInteractorImpl implements ProfileScreenInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    ProfileScreenInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Completable clearInformation() {
        return Completable.fromAction(prefsHelper::clearPrefs);
    }

    @Override
    public Single<User> getInformation() {
        return Single.fromCallable(() -> new User("Name", "test@test.ru", "+10 000 000", "City, test", "https://avatars.mds.yandex.net/get-pdb/2255805/43e935b4-4338-4ef1-953c-a1f6b21be752/s1200"));
    }
}
