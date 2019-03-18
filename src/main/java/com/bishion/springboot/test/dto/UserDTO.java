package com.bishion.springboot.test.dto;

import java.util.Objects;

public class UserDTO {

    private Integer id;
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDTO)){
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(getId(), userDTO.getId()) &&
                Objects.equals(getUsername(), userDTO.getUsername()) &&
                Objects.equals(getAge(), userDTO.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getAge());
    }
}
