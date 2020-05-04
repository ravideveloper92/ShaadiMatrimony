
package com.ravi.shaadimatches.data.model;

import com.google.gson.annotations.SerializedName;

public class Street {

    @SerializedName("name")
    private String mName;
    @SerializedName("number")
    private Long mNumber;
    @SerializedName("street")
    private Street mStreet;

    public String getName() {
        return mName;
    }

    public Long getNumber() {
        return mNumber;
    }

    public Street getStreet() {
        return mStreet;
    }

    public static class Builder {

        private String mName;
        private Long mNumber;
        private Street mStreet;

        public Street.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Street.Builder withNumber(Long number) {
            mNumber = number;
            return this;
        }

        public Street.Builder withStreet(Street street) {
            mStreet = street;
            return this;
        }

        public Street build() {
            Street street = new Street();
            street.mName = mName;
            street.mNumber = mNumber;
            street.mStreet = mStreet;
            return street;
        }

    }

}
