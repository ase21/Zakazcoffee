package ru.zakazcoffee.shop.domain.main.main_screen;

import io.reactivex.Single;
import ru.zakazcoffee.shop.data.models.MainInformation;

public interface MainScreenInteractor {
    Single<MainInformation> getInformation();
}
