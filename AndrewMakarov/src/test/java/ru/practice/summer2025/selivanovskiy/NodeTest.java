package ru.practice.summer2025.selivanovskiy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    @Test
    void CreateNode(){
        Node node=new Node("root");
        assertEquals("root",node.getName());
    }
    @Test
    void AddNode(){
        Node root = new Node("root");
        Node child=new Node("child");
        root.addChild(child);
        assertEquals(1,root.getChildren().size());
        assertEquals("child",root.getChildren().get(0).getName());
    }
    @Test
    void SearchNodeById(){
        Node root = new Node("root");
        Node child=new Node("child");
        Node chil1=new Node("children");
        Node chil2=new Node("childre");
        Node chil3=new Node("children");
        root.AddChildren(child);
        child.AddChildren(chil1);
        child.AddChildren(chil2);
        Node search_result=new Node();
        search_result=root.Search(child.getId());
        assertEquals(child,search_result);
        search_result=root.Search(chil3.getId());
        assertEquals(null,search_result);
    }
    @Test
    void SearchNodeByName(){
        Node root = new Node("root");
        Node child=new Node("child");
        Node chil1=new Node("children");
        Node chil2=new Node("children");
        Node chil3=new Node("children");
        root.AddChildren(child);
        child.AddChildren(chil1);
        child.AddChildren(chil2);
        Node search_result=new Node();
        search_result=root.Search("children");
        assertEquals(chil1,search_result);
        search_result=root.Search("2");
        assertEquals(null,search_result);
    }
    @Test
    void DeleteNodeFromName(){
        Node root = new Node("root");
        Node child=new Node("child");
        Node chil1=new Node("children");
        Node chil2=new Node("childre");
        root.AddChildren(child);
        child.AddChildren(chil1);
        child.AddChildren(chil2);
        root.DeleteChildrensFromName("children");
        assertEquals(1,child.getChildren().size());
    }
    @Test
    void DeleteAllNodes(){
        Node root = new Node("root");
        root.getChildren().clear();
        assertEquals(0,root.getChildren().size());
    }
    @Test
    void SetNodeName(){
        Node root = new Node("root");
        root.SetName("new Name");
        assertEquals("new Name",root.getName());
    }

}