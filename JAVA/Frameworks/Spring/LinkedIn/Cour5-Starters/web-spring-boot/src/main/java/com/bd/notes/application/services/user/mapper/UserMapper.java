package com.bd.notes.application.services.user.mapper;

import java.util.List;

import com.bd.notes.data.entity.UserEntity;
import com.bd.notes.domain.aggregates.user.User;

public interface UserMapper {

	User mapDatabaseEntityToDomainEntity(UserEntity entity);

	UserEntity mapDomainEntityToDatabaseEntity(User user);

	List<User> mapDatabaseEntitiesToDomainEnties(Iterable<UserEntity> entities);

	List<UserEntity> mapDomainEntitiesToJpaEntities(List<User> entities);

}