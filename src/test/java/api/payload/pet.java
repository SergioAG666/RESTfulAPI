package api.payload;

public class pet {

    private Integer petId;

    private String petName;

    private String categoryId;

    private String categoryName;

    private String photoUrl;

    private String tagId;

    private String tagName;


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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }



    @Override

    public String toString() {

        return "Pet [petId=" + petId + ", petName=" + petName + ", categoryId=" + categoryId + ", categoryName="

                + categoryName + ", photoUrl=" + photoUrl + ", tagId=" + tagId + ", tagName="

                + tagName + "]";

    }


}
