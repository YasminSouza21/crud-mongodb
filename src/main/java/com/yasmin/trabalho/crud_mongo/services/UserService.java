package com.yasmin.trabalho.crud_mongo.services;

import com.yasmin.trabalho.crud_mongo.domain.users.User;
import com.yasmin.trabalho.crud_mongo.dtos.UserRequestCreateDTO;
import com.yasmin.trabalho.crud_mongo.dtos.UserRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequestCreateDTO userRequestDTO){
        return userRepository.save(new User(userRequestDTO));
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User findUserTopId(){
        return userRepository.findTopByOrderByIdDesc();
    }

    public User findUserById(Long id){
        return userRepository.findById(id);
    }

    public void updateUser(UserRequestUpdateDTO userRequestUpdateDTO) {

        User user = userRepository.findById(userRequestUpdateDTO.id());

        user.setId(userRequestUpdateDTO.id());
        user.setName(userRequestUpdateDTO.name());
        user.setTelephone(userRequestUpdateDTO.telephone());
        user.setBirthday(LocalDate.parse(userRequestUpdateDTO.birthday()));

        userRepository.save(user);

    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
