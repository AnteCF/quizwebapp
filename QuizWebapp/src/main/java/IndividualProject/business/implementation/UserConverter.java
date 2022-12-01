package IndividualProject.business.implementation;

import IndividualProject.domain.User;
import IndividualProject.persistence.entity.UserEntity;

final class UserConverter {

    private UserConverter(){

    }

    public static User convert(UserEntity userEntity){
        return User.builder()
                .name(userEntity.getName())
                .id(userEntity.getId())
                .totalScore(userEntity.getTotalScore())
                .build();
    }

}
