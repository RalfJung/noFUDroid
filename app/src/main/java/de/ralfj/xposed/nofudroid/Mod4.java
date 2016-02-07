package de.ralfj.xposed.nofudroid;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;

/* "Network May Be Monitored" blocker for Android 4.4. */

public class Mod4 implements IXposedHookZygoteInit {
    private static final String CLASS_DEVICE_POLICY_MANAGER = "android.app.admin.DevicePolicyManager";

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        final Class<?> devicePolicyManager = XposedHelpers.findClass(CLASS_DEVICE_POLICY_MANAGER, null);

        XposedHelpers.findAndHookMethod(devicePolicyManager, "hasAnyCaCertsInstalled", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                return false;
            }
        });
    }
}
