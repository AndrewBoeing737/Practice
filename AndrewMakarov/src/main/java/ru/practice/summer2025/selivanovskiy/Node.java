package ru.practice.summer2025.selivanovskiy;


import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Node {
    int Id;
    String name;
    public ArrayList<Node> Childrens;

    public Node(String name) {
        Childrens=new ArrayList<Node>();
        this.name = name;
        Id= LocalTime.now().getNano();
    }

    public Node(int id) {
        Childrens=new ArrayList<Node>();
        Id = id;
    }

    public Node(int id, String name, ArrayList<Node> childrens) {
        Id = id;
        this.name = name;
        Childrens = childrens;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildrens(ArrayList<Node> childrens) {
        Childrens = childrens;
    }

    public List<Node> getChildrens() {
        return Childrens;
    }

    public Node() {
        Childrens=new ArrayList<Node>();
        Id= LocalTime.now().getNano();
    }


    public String getName() {
        return name;
    }

    public void addChild(Node child) {
        Childrens.add(child);
    }

    public List<Node> getChildren() {
        return Childrens;
    }

    public int getId() {
        return Id;
    }

    public void SetName(String newName) {
        name=newName;
    }

    public void AddChildren(Node child) {
        Childrens.add(child);
    }
    Node Search(String name){
        for(int i=0;i<getChildren().size();++i){
            if(Childrens.get(i).getName()==name){
                return Childrens.get(i);
            }else {
                return this.Childrens.get(i).Search(name);
            }

        }
        return null;
    }
    Node Search(int id){
        for(int i=0;i<getChildren().size();++i){
            if(getChildren().get(i).getId()==id){
                return getChildren().get(i);
            }else {
                getChildren().get(i).Search(id);
            }

        }
        return null;
    }

    public void DeleteChildrensFromName(String name) {
        for(int i=0;i<getChildrens().size();++i){
            if(Childrens.get(i).name==name){
                for(int j=0;j<Childrens.get(i).Childrens.size();++j){
                    Childrens.get(i).Childrens.remove(j);
                }
                Childrens.remove(i);
            }else{
                Childrens.get(i).DeleteChildrensFromName(name);
            }
        }
    }
}
