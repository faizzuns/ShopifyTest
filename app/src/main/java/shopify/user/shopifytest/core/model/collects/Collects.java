
package shopify.user.shopifytest.core.model.collects;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collects {

    @SerializedName("collects")
    @Expose
    private List<Collect> collects = null;

    public List<Collect> getCollects() {
        return collects;
    }

    public void setCollects(List<Collect> collects) {
        this.collects = collects;
    }

}
