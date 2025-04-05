package com.yasmin.trabalho.crud_mongo.domain.users;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "usuarios")
public class User {

    @Id
    private ObjectId objectId;
    private Long id;
    private String name;
    private String telephone;
    private LocalDate birthday;



    public User(UserRequestCreateDTO userRequestDTO) {
        this.id = userRequestDTO.id();
        this.name = userRequestDTO.name();
        this.telephone = userRequestDTO.telephone();
        this.birthday = userRequestDTO.birthday();
    }

    public User(UserRequestUpdateDTO userRequestDTO) {
        this.id = userRequestDTO.id();
        this.name = userRequestDTO.name();
        this.telephone = userRequestDTO.telephone();
        this.birthday = LocalDate.parse(userRequestDTO.birthday());
    }


}
