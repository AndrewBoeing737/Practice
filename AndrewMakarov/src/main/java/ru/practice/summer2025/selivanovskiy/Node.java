package ru.practice.summer2025.selivanovskiy;


import java.util.List;

public class Node {
    int Id;
    String name;
    List<Node> Childrens;

    public Node(String name) {
        this.name = name;
    }

    public Node(int id) {
        Id = id;
    }

    public Node(int id, String name, List<Node> childrens) {
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

    public void setChildrens(List<Node> childrens) {
        Childrens = childrens;
    }

    public List<Node> getChildrens() {
        return Childrens;
    }

    public Node() {

    }


    public String getName() {
        return "";
    }

    public void addChild(Node child) {

    }

    public List<Node> getChildren() {
        return null;
    }

    public int getId() {
        return 0;
    }

    public void SetName(String newName) {
    }

    public void AddChildren(Node child) {
    }
    Node Search(String name){
        for(int i=0;i<getChildren().size();++i){
            if(getChildren().get(i).getName()==name){
                return getChildren().get(i);
            }else {
                getChildren().get(i).Search(name);
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

    }
}
