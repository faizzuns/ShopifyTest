
package shopify.user.shopifytest.core.model.collections;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomCollections {

    @SerializedName("custom_collections")
    @Expose
    private List<CustomCollection> customCollections = null;

    public List<CustomCollection> getCustomCollections() {
        return customCollections;
    }

    public void setCustomCollections(List<CustomCollection> customCollections) {
        this.customCollections = customCollections;
    }

}
