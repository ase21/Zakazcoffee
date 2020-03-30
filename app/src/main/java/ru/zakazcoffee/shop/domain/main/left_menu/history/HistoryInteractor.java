package ru.zakazcoffee.shop.domain.main.left_menu.history;

import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.Rules;

public interface HistoryInteractor {

    Single<Void> getHistory();
}
