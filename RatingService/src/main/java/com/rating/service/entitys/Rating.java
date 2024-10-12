package com.rating.service.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("user_rating")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
