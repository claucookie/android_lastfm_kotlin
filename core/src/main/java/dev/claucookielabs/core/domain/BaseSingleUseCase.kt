package dev.claucookielabs.core.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


abstract class BaseSingleUseCase<T, P> {

    fun execute(param: P, onSuccess: (result: T) -> Unit, onError: () -> Unit): Disposable {
        return buildBaseUseCase(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onSuccess.invoke(it) }, { onError.invoke() })
    }

    abstract fun buildBaseUseCase(param: P): Single<T>
}