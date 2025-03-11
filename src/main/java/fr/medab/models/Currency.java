package fr.medab.models;

public class Currency {
    private String code;
    private String symbol;

    public Currency(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    private Currency(Builder builder) {
        code = builder.code;
        symbol = builder.symbol;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return code + " (" + symbol + ")";
    }


    public static final class Builder {
        private String code;
        private String symbol;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder symbol(String val) {
            symbol = val;
            return this;
        }

        public Currency build() {
            return new Currency(this);
        }
    }
}
