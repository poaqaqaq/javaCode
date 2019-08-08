package cn.young.filter.exception;

public class LoginFailedException extends Exception {
    @Override
    public String getMessage() {
        return "账号或密码错误！";
    }
}
