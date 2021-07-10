package Homework_8.Posts;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostDeletedResponse {
    private String code;
    private String meta;
    private String data;
}