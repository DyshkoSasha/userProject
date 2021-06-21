package my.delo;

import my.delo.model.User;
import my.delo.repository.DataBase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String dbName = "mnogo_users";

        DataBase dataBase = new DataBase();
        //dataBase.dropUsersTable(dbName);
        dataBase.createUsersTable(dbName);
        UUID id = UUID.randomUUID();
        User user1 = User.builder()
                .id(id)
                .firstName("Yuzik")
                .lastName("Labeckiy")
                .age(30)
                .phone("+375 29 2243454")
                .lastVizit(LocalDateTime.now()).build();

        User user2 = User.builder()
                .id(UUID.randomUUID())
                .firstName("Anton")
                .lastName("Samoilovskiy")
                .age(35)
                .phone("+375 29 3334909")
                .lastVizit(LocalDateTime.now()).build();

        User user3 = User.builder()
                .id(id)
                .firstName("Valentin")
                .lastName("Petyshinskiy")
                .age(29)
                .phone("+375 29 3353526")
                .lastVizit(LocalDateTime.now()).build();

        dataBase.addDatabase(user1, dbName);
        dataBase.addDatabase(user2, dbName);
        List<User> userList = dataBase.getAllUsers(dbName);
        dataBase.getUsersId(dbName, id);
        dataBase.reUserName(dbName, id, user3);
//        dataBase.removeUserName(dbName, id);
    }
}
