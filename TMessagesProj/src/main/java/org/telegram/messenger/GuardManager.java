package org.telegram.messenger.guard;

import java.util.concurrent.atomic.AtomicBoolean;

public final class GuardManager {

    private static volatile GuardManager instance;

    private final AtomicBoolean enabled = new AtomicBoolean(true);

    private GuardManager() {
    }

    public static GuardManager getInstance() {
        if (instance == null) {
            synchronized (GuardManager.class) {
                if (instance == null) {
                    instance = new GuardManager();
                }
            }
        }
        return instance;
    }

    /**
     * Guard holatini qaytaradi.
     */
    public boolean isEnabled() {
        return enabled.get();
    }

    /**
     * Guard'ni yoqadi yoki o‘chiradi.
     */
    public void setEnabled(boolean value) {
        enabled.set(value);
    }

    /**
     * Guard tekshiruvi.
     *
     * Keyinchalik bu yerga:
     * - storage protection
     * - access control
     * - sensitive data protection
     * - integrity checks
     * kabi funksiyalar ulanadi.
     */
    public boolean check() {
        return enabled.get();
    }

    /**
     * Guard holatini xavfsiz tarzda tiklash.
     */
    public void reset() {
        enabled.set(true);
    }
}
