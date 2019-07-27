package dev.idee.rxjavacoroutines

import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class BlankViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    private val observer = object: DisposableSingleObserver<List<JobModel>>() {
        override fun onSuccess(t: List<JobModel>) {}
        override fun onError(e: Throwable) {}
    }

    init {

        fetchWebJobs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith<DisposableSingleObserver<List<JobModel>>>(observer)
            .addTo(disposables)

    }

    private fun fetchWebJobs(): Single<List<JobModel>> {

        return ApiClient.client.getWebJobs(1)
//        return ApiClient.client.getWebJobs(1).flatMap { list ->
//            return@flatMap Single.just(list)
//        }

    }


}
