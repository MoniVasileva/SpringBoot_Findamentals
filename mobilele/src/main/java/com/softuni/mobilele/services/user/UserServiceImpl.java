package com.softuni.mobilele.services.user;

import com.softuni.mobilele.domain.beans.LoggedUser;
import com.softuni.mobilele.domain.dtoS.banding.UserLoginFormDto;
import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.dtoS.model.UserModel;
import com.softuni.mobilele.domain.enitities.User;
import com.softuni.mobilele.repositories.UserRepository;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;
import com.softuni.mobilele.services.role.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, DataBaseInitServiceService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleService userRoleService, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
        this.loggedUser = loggedUser;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() > 0;
    }

    @Override
    public UserModel registerUser(UserRegisterFormDto userRegister) {
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRole(this.userRepository.count() == 0
                ? userRoleService.findAllRoles()
                : List.of(this.userRoleService.findRoleByName("USER")));

        User userToSave = this.modelMapper.map(userModel, User.class);
        return this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }

    @Override
    public void loginUser(UserLoginFormDto userLogin) {

        UserModel loginCandidate = this.modelMapper.map(this.userRepository.findByUsername(userLogin.getUsername()).get(),UserModel.class);


        if (loginCandidate.isValid()) {
            this.loggedUser.setId(loginCandidate.getId())
                    .setUsername(loginCandidate.getUsername())
                    .setRoleModels(loginCandidate.getRole());
        }

    }
    @Override
    public void logout(){
        this.loggedUser.clearFields();
    }
}