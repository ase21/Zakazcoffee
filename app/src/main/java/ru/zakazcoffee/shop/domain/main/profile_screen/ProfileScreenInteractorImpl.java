package ru.zakazcoffee.shop.domain.main.profile_screen;

import javax.inject.Inject;

import ru.zakazcoffee.shop.data.network.NetworkRepository;

public class ProfileScreenInteractorImpl implements ProfileScreenInteractor {

    private final NetworkRepository networkRepository;

    @Inject
    ProfileScreenInteractorImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }
}
