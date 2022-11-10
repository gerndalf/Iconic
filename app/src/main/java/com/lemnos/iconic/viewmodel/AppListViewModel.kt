package com.lemnos.iconic.viewmodel

import androidx.lifecycle.ViewModel

class AppListViewModel: ViewModel() {

    /*
    TODO:
    Write in database logic, using Room

    Write input validation for images

    Write functions for:
        selected app:
            icon
            format name
            package name
        bool for SwapScreen visibility
        bool for revert confirmation visibility
        bool for didTapSwapButton to trigger ICONIFY button appearance change

    Write function to set state variable that contains a user's selected package
        var for current icon
        var for formatted name
        var for package name

    Write function to update a list item with user's new icon
        When a user changes an icon, that package's info is added to the db (w/ OLD ICON)
        If the user changes icon more than once, DO NOT update the old icon saved in db
        The db is used to perform checks for a row's 'undo' button

    Write function to revert/undo icons back to default
    Write function to revert ALL icons back to default
        Either actions above will revert to the stored old icon
        and then DELETE the package's info from the db

     */

}