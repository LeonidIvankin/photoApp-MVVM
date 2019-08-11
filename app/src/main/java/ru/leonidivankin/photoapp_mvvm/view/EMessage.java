package ru.leonidivankin.photoapp_mvvm.view;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import ru.leonidivankin.photoapp_mvvm.R;

@Retention(RetentionPolicy.SOURCE)
@IntDef({EMessage.NETWORK_IS_NOT_AVAILABLE})
public @interface EMessage {
    int NETWORK_IS_NOT_AVAILABLE = R.string.network_is_not_available;
}
