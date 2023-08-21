package constants;

public enum BitMask {
    ALL_NETWORK_OFF(0),
    ALL_NETWORK_ON(6),
    AIRPLANE_MODE(1),
    WIFI_ONLY(2),
    DATA_ONLY(4);

    private final long value;

    BitMask(long value) {
        this.value = value;
    }

    public static long getValue(BitMask bitMask) {
        return bitMask.value;
    }
}
