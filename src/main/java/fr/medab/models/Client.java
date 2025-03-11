package fr.medab.models;

public class Client {
    private String firstname;
    private String lastname;

    public Client(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    private Client(Builder builder) {
        firstname = builder.firstname;
        lastname = builder.lastname;
    }

    public static final class Builder {
        private String firstname;
        private String lastname;

        public Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder firstname(String val) {
            firstname = val;
            return this;
        }

        public Builder lastname(String val) {
            lastname = val;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }
}
