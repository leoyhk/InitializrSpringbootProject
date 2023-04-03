/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leoyuen.Lab3;

/**
 *TODO ID NAME Year Rank
 * @author konoleoda
 */
public class Movie {

    private int id;
    private String name ;
     private int year;
    private float rank;
   
    public Movie(int id, String name,int year,float rank) {
        this.id = id;
        this.name = name;    
                this.year = year;
                 this.rank = rank;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getRank() {
        return rank;
    }

    public void setRank(Float rank) {
       this.rank = rank;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
       this.year = year;
    }

    
}
