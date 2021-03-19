package com.example.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
/*This is the data class for repo that will be use in recyler view*/
data class repo(
    var user_repo : String,
    var user_repo_des : String,
    var user_repo_lang : String ,
) : Parcelable

@Parcelize
/*This is the data class for trending dev that will be use in list view*/
data class trending_dev(
        var dev_name: String,
        var dev_username: String,
        var dev_img: Int,
        var dev_country: String,
        var dev_comp: String,
        var dev_followers: String,
        var dev_following: String,
        var dev_repo: String,
) : Parcelable