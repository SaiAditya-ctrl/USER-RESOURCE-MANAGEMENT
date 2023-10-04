package com.example.userresoucemanagement.dto;

import com.example.userresoucemanagement.entity.Project;
import com.example.userresoucemanagement.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;


@Data
@NoArgsConstructor
public class UserResponse {



    private String userName;



    private String email;

    private Date createDate;

    private List<Project> projects = new ArrayList<>();

    public UserResponse(User user, List<Project> projects) {

        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.createDate=user.getCreateDate();

        this.projects = projects;
    }
}
