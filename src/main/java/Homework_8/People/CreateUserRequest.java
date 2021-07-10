package Homework_8.People;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private String created_at;
    private String updated_at;
}
