package net.oreandlore.api.utils;

public enum PluginVersion {
    VERSION_18("1.8", 8),
    VERSION_19("1.9", 9),
    VERSION_110("1.10", 10),
    VERSION_111("1.11", 11),
    VERSION_112("1.12", 12),
    VERSION_113("1.13", 13),
    VERSION_114("1.14", 14),
    VERSION_115("1.15", 15),
    VERSION_116("1.16", 16),
    VERSION_117("1.17", 17),
    VERSION_118("1.18", 18),
    VERSION_119("1.19", 19),
    UNKNOWN_VERSION("This server version is incompatible, try using 1.8 or higher.", -1);

    private final String versionString;
    private final int versionNumber;

    private PluginVersion(String versionString, int versionNumber) {
        this.versionString = versionString;
        this.versionNumber = versionNumber;
    }

    public String getVersionString() {
        return this.versionString;
    }

    public int getVersionInt() {
        return this.versionNumber;
    }
}
