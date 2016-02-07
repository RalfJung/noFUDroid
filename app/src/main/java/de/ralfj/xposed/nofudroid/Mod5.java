package de.ralfj.xposed.nofudroid;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/* "Network May Be Monitored" blocker for Android 5. */

public class Mod5 implements IXposedHookLoadPackage {
    // Just a helper function, useful to figure out package names
    private void tryToLoad(String className, ClassLoader loader) {
        try {
            XposedHelpers.findClass(className, loader);
            XposedBridge.log("  Found " + className);
        }
        catch (Throwable t) {}
    }

    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("android"))
            return;
        
        final Class<?> userHandle = XposedHelpers.findClass("android.os.UserHandle", lpparam.classLoader);
        final Class<?> notifyTask = XposedHelpers.findClass("com.android.server.devicepolicy.DevicePolicyManagerService$MonitoringCertNotificationTask", lpparam.classLoader);
        
        XposedHelpers.findAndHookMethod(notifyTask, "manageNotification", userHandle,
            new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    XposedBridge.log("Not showing FUD notification");
                    return null;
                }
        });
    }
}
