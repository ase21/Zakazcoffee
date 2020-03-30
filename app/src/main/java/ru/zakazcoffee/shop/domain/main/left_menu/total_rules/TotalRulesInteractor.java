package ru.zakazcoffee.shop.domain.main.left_menu.total_rules;

import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.Rules;

public interface TotalRulesInteractor {

    Single<Rules> getTotalRules();
}
