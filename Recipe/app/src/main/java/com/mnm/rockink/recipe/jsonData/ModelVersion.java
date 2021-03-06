
package com.mnm.rockink.recipe.jsonData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelVersion {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("status")
    @Expose
    private Status__ status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Status__ getStatus() {
        return status;
    }

    public void setStatus(Status__ status) {
        this.status = status;
    }

}
