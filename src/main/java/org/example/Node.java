package org.example;


import java.io.FileWriter;
import java.io.IOException;
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
    public Node Search(String name){
        for(int i=0;i<getChildren().size();++i){
            if(Childrens.get(i).getName()==name){
                return Childrens.get(i);
            }else {
                return this.Childrens.get(i).Search(name);
            }

        }
        return null;
    }
    public Node Search(int id){
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
    public void Print_tree(int level){
        if(level==0){
            System.out.println(name);
        }
        for(int i=0;i<Childrens.size();++i){
            System.out.println("   ".repeat(level+1)+Childrens.get(i).name);
            Childrens.get(i).Print_tree(level+1);
        }
    }
    public void Print_tree_Html(int level){
        if(level==0){
            System.out.println("<ol><li>"+name+"</li>");
        }if(Childrens.size()!=0){
            System.out.println("<ol>");
        }
        for(int i=0;i<Childrens.size();++i){
            System.out.println("  ".repeat(level+1)+"<li>"+Childrens.get(i).name+"</li>");
            Childrens.get(i).Print_tree_Html(level+1);
        }
        if(Childrens.size()!=0){
            System.out.println("</ol>");
        }
    }
    public void Html_to_String_tree(StringBuilder code,int level){
        if(level==0){
            code.append("<ol><li>"+name+"</li>\n");
        }if(Childrens.size()!=0){
            code.append("<ol>\n");
        }
        for(int i=0;i<Childrens.size();++i){
            code.append("  ".repeat(level+1)+"<li>"+Childrens.get(i).name+"</li>\n");
            Childrens.get(i).Html_to_String_tree( code, level+1);
        }
        if(Childrens.size()!=0){
            code.append("</ol>\n");
        }
    }
    public void to_HTML_file(String way){
        StringBuilder sb=new StringBuilder();
        Html_to_String_tree(sb,0);
        try {
            FileWriter myWriter = new FileWriter(way);
            myWriter.write(sb.toString());
            myWriter.close();
            System.out.println("Записано");
            try {
                ProcessBuilder pb = new ProcessBuilder(
                        "cmd", "/c", "start", "msedge",
                        "--kiosk", "file://"+way
                );
                pb.start();
        } catch (IOException e) {
            System.out.println("Ошибка!");
            e.printStackTrace();
        }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
