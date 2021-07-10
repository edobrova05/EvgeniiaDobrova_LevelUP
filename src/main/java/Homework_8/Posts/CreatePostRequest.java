package Homework_8.Posts;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostRequest {
    private String id;
    private String user_id;
    private String title;
    private String body;
    //private String created_at;
    //private String updated_at;
}
