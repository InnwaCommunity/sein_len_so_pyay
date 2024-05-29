package com.example.crane.config

object RoutesName{
    const val splash: String = "splash"
    const val onboard: String = "onboard"
    const val login: String = "login"
    const val signup: String = "signup"
    const val dashboard: String = "dashboard"
    const val home: String = "home"
    const val search: String = "search"
    const val createnew: String = "createNew"
    const val plants: String = "plants"
    const val profile: String = "profile"
    const val championsPage: String = "championship"
    const val championsProfilePage: String = "championsprofilepage"
    const val notificationListPage: String = "notificationListPage"
}


sealed class DetailsScreen(val route: String) {
    data object ChampionsPage : DetailsScreen(route = "ChampionsPage")
    data object ChampionsProfilePage : DetailsScreen(route = "ChampionsProfilePage")
}
