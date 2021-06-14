package api.payload;

import java.util.List;

public class pet {

    private Integer petId;

    private String petName;

    private Integer categoryId;

    private String categoryName;

    private List photoUrl;

    private Integer tagId;

    private String tagName;

    private String status;


    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override

    public String toString() {

        return "Pet [petId=" + petId + ", petName=" + petName + ", categoryId=" + categoryId + ", categoryName="

                + categoryName + ", photoUrl=" + photoUrl + ", tagId=" + tagId + ", tagName="

                + tagName + ", status " + status + "]";
    }

}
