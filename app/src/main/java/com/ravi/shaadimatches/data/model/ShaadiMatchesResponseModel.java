
package com.ravi.shaadimatches.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShaadiMatchesResponseModel {

    @SerializedName("results")
    @Expose
    private List<ShaadiMatchesModel> shadiMatchesModels = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<ShaadiMatchesModel> getShaadiMatchesModels() {
        return shadiMatchesModels;
    }

    public void setShadiMatchesModels(List<ShaadiMatchesModel> shadiMatchesModels) {
        this.shadiMatchesModels = shadiMatchesModels;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
