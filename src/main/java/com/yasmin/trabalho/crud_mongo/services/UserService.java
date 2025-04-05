package com.yasmin.trabalho.crud_mongo.services;

import com.yasmin.trabalho.crud_mongo.domain.users.User;
import com.yasmin.trabalho.crud_mongo.domain.users.UserRequestCreateDTO;
import com.yasmin.trabalho.crud_mongo.domain.users.UserRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public void updateUser(UserRequestUpdateDTO userRequestUpdateDTO) {

        Optional<User> user = userRepository.findById(userRequestUpdateDTO.id());

        if(user.isPresent()){
            User existingUser = user.get();

            existingUser.setId(userRequestUpdateDTO.id());
            existingUser.setName(userRequestUpdateDTO.name());
            existingUser.setTelephone(userRequestUpdateDTO.telephone());
            existingUser.setBirthday(LocalDate.parse(userRequestUpdateDTO.birthday()));

            userRepository.save(existingUser);
        }

    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
