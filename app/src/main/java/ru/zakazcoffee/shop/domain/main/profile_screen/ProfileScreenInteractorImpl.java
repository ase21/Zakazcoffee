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
        return null;
    }
}
