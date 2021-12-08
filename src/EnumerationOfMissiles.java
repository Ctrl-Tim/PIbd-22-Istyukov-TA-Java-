public enum EnumerationOfMissiles {
    Two,
    Four,
    Six;
    public static EnumerationOfMissiles getChosenNumber(int number) {
        switch (number) {
            case 0:
                return EnumerationOfMissiles.Two;
            case 1:
                return EnumerationOfMissiles.Four;
            case 2:
                return EnumerationOfMissiles.Six;
        }
        return null;
    }
}