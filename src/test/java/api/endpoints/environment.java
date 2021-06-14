package api.endpoints;

public class environment {
    /**
     * The base url - where all services are running
     */
    public static String base_url  ="http://localhost:8080/api/v3";

    public static String post_url  ="/pet";

    public static String get_post_delete_url="/pet/{petId}";

    public static String find_status_url="/findByStatus";

    public static String find_tags_url="/findByTags";

    public static String upload_image_url="/pet/{petId}/uploadImage";


}
