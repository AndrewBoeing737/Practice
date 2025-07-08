package ru.practice.summer2025.selivanovskiy;


import java.util.List;

public class Node {


    public Node() {

    }
    public Node(String name_) {

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
