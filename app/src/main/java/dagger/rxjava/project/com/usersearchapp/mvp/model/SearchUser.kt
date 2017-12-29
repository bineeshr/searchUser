package dagger.rxjava.project.com.usersearchapp.mvp.model

/**
 * Created by bineesh on 29/12/17.
 */
data class SearchUser(var total_count:Int,var incomplete_results:Boolean,var items:MutableList<SearchItem>?)