# Iconic
A simplistic application icon swap utility for Android S(31).

==============================================================

This app was requested due to a lack of free tools to replace package icons for Android devices.

Solo designed/developed with user feedback/insight from my spouse.

## *WARNING!*
This app uses a PackageManager query flag that most certainly violates Google Play policies. 
I have left comments in the AndroidManifest.xml detailing a safer way to find individual packages.

Although unconfirmed I *highly suspect* any developer brave enough to attempt to publish this app would be **banned**.


Also, the specific `getInstalledPackages()` query method used is being *depreciated* in API33 so expect that to need updating eventually.
