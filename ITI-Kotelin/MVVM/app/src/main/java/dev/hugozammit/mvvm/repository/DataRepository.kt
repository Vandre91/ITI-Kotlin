package dev.vic.mvvm.repository

import dev.vic.mvvm.NetworkAPI
import dev.vic.mvvm.model.ProductFamily
import org.koin.core.Koin
import retrofit2.Call
import retrofit2.Response

class DataRepository (private val networkAPI: NetworkAPI) {
    fun getProducts(onProductData: OnProductData) {
        networkAPI
            .getProducts()
            .enqueue(object: retrofit2.Callback<List<ProductFamily>> {
                override fun onResponse(
                    call: Call<List<ProductFamily>>,
                    response: Response<List<ProductFamily>>
                ) {
                    onProductData.onSuccess((response.body() as List<ProductFamily>))
                }

                override fun onFailure(call: Call<List<ProductFamily>>, t: Throwable) {
                    onProductData.onFailure()
                }
            })
    }

    interface OnProductData {
        fun onSuccess(data: List<ProductFamily>)
        fun onFailure()
    }
}