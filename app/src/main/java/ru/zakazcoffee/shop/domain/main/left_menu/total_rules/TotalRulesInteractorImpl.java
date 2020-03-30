package ru.zakazcoffee.shop.domain.main.left_menu.total_rules;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.Rules;
import ru.zakazcoffee.shop.data.network.NetworkRepository;
import ru.zakazcoffee.shop.data.shared_prefs.PrefsHelper;

public class TotalRulesInteractorImpl implements TotalRulesInteractor {

    private final NetworkRepository networkRepository;
    private final PrefsHelper prefsHelper;

    @Inject
    public TotalRulesInteractorImpl(NetworkRepository networkRepository, PrefsHelper prefsHelper) {
        this.networkRepository = networkRepository;
        this.prefsHelper = prefsHelper;
    }

    @Override
    public Single<Rules> getTotalRules() {
        return networkRepository.getTotalRules("rules.get", prefsHelper.getToken(), "v5ZCatrRSa3F0Mto3RppmcDBaQnIxS3REpomJuZlZkbUl6", "czZCatrRSa3F0Mzo3RmpmcDBaQnIxS3REUmJuZlZkbUl6");
    }
}
