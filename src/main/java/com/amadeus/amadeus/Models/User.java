package com.amadeus.amadeus.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String name;


    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private List<String> roles = new ArrayList<>();
    

    public User(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void addRole(String role)
    {
        roles.add(role);
    }

    public void removeRole(String role)
    {
        roles.remove(role);
    }

    public void clearRoles()
    {
        roles.clear();
    }

    public List<String> getRoles()
    {
        return this.roles;
    }

    public void setRoles(List<String> roles)
    {
        this.roles = roles;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }


    public void setUserName(String username)
    {
        this.username = username;
    }



}
