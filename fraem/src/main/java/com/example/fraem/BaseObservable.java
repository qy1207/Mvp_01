package com.example.fraem;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObservable implements Observer {

    private Disposable disposable;

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(Object o) {
        Success(o);
        disposable();
    }

    @Override
    public void onError(Throwable e) {
        Failed(e);
        disposable();
    }

    @Override
    public void onComplete() {
        disposable();
    }

    public abstract void Success(Object o);

    public abstract void Failed(Throwable e);

    public void disposable() {
        disposable.dispose();
    }
}
