package com.example.pojo;

public class Tbuser {
    private Integer userid;

    private String username;

    private String realname;

    private Long telephonenum;

    private String email;

    private String userdescribe;

    private String password;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Long getTelephonenum() {
        return telephonenum;
    }

    public void setTelephonenum(Long telephonenum) {
        this.telephonenum = telephonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserdescribe() {
        return userdescribe;
    }

    public void setUserdescribe(String userdescribe) {
        this.userdescribe = userdescribe == null ? null : userdescribe.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
