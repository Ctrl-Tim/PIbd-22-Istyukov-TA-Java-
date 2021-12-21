public enum EnumerationOfMissiles {
    Two,
    Four,
    Six;

    public static EnumerationOfMissiles getChosenNumber(int number) {
        switch (number) {
            case 2:
                return EnumerationOfMissiles.Two;
            case 4:
                return EnumerationOfMissiles.Four;
            case 6:
                return EnumerationOfMissiles.Six;
        }
        return null;
    }
}