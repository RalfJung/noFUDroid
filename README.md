noFUDroid
=========

> Fear, uncertainty, and doubt (often shortened to FUD) is a disinformation strategy used in sales, marketing, public relations, politics and propaganda. FUD is generally a strategy to influence perception by disseminating negative and dubious or false information and a manifestation of the appeal to fear.

-- [Wikipedia on Fear, uncertainty and doubt](https://en.wikipedia.org/wiki/Fear,_uncertainty_and_doubt)

This is a simple Xposed Module which gets rid of the annoying *Network may be monitored* warning 
triggered by adding a CA cert to the key store.
It is a fork of the original [NetworkMonitoredBlocker](https://github.com/Skarafaz/NetworkMonitoredBlocker), adding support for newer versions of Android.
Right now, Android KitKat (4.4), Lollipop (5) and Marshmallow (6) have been tested.
Contributions for other versions, and other forms of FUD, are welcome.


## Building

You will need version 54 or later of the Xposed Framework.
Put the `XposedBridgeApi.jar` into the folder `app/libs/`.

You may have to create a file `local.properties` to tell gradle where the Android build tools are located, with content like this:
```
sdk.dir=/path/to/android-sdk
```

Then run `gradle assemble`.
