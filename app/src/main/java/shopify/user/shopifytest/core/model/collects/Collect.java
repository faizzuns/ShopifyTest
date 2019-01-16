
package shopify.user.shopifytest.core.model.collects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collect {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("collection_id")
    @Expose
    private Integer collectionId;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("featured")
    @Expose
    private Boolean featured;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("sort_value")
    @Expose
    private String sortValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getSortValue() {
        return sortValue;
    }

    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

}
