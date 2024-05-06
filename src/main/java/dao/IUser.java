package dao;

import java.util.List;

public interface IUser {
   void addUser(User user);

   List<User> getUsers();

   void Delete(Long id);

   void updateUser(User user);

   User getUser(Long id);
}

