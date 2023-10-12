package org.kmo.program.P17;

public interface UserService {
    void login(String loginName, String password) throws Exception;
    void deleteUsers() throws Exception;
    String[] selectUsers() throws Exception;
}
