package com.wooyoungsoo.api_server.feed.entity;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dog_feed")
@Data
@Getter
@Setter
public class DogFeed {

    @Id
    private String id;
    private Integer rank;
    private String brand_name;
    private String product_name;
    private String product_price;
    private String image_url;
    private String sub_url;
}
