package net.oreandlore.api.utils;

public enum TaskType {
    A_SYNC(false),
    SYNC(false),
    SYNC_REPEAT(true),
    A_SYNC_REPEAT(true);

    private final boolean Repeating;

    private TaskType(boolean repeating) {
        this.Repeating = repeating;
    }

    public boolean isRepeating() {
        return this.Repeating;
    }
}
