package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Users {

    private List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users of(List<User> users) {
        return new Users(users);
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

}
