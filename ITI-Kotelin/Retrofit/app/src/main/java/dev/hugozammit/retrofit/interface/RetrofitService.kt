package dev.vic.retrofit.`interface`

import dev.vic.retrofit.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET( "marvel" )
    fun getMovieList(): Call<MutableList<Movie>>

}