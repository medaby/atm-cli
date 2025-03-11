package fr.medab.models;

public enum BankNoteValue {
        TEN(10),
        TWENTY(20),
        FIFTY(50),
        ONE_HUNDRED(100),
        TWO_HUNDRED(200),
        FIVE_HUNDRED(500);

        private final int value;

        BankNoteValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
}
