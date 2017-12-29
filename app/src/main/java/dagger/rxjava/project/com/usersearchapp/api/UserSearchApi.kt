package dagger.rxjava.project.com.usersearchapp.api

import dagger.rxjava.project.com.usersearchapp.mvp.model.SearchUser
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by bineesh on 29/12/17.
 */
interface UserSearchApi {
    @GET("/search/users")
    fun searchUser(@Query("q")searchQuery: String,@Query("sort") sort:String?,@Query("order")order:String?): Observable<SearchUser>?
}