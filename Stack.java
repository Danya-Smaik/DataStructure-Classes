
package com.mycompany.datastructure;

import java.util.ArrayList;

public class Stack {
    ArrayList list;
    public Stack(){
    list = new ArrayList();} 
    
    public void push(Object data){
    list.add(data);}
    
    public Object pop(){
    if(!isEmpty()){
        return list.remove(list.size()-1);
         }else{
             return "cant remove : stack empty ";}
    }
    public Object peek(){
        if(!isEmpty()){
        return list.get(list.size()-1);}
        else{return "cant remove : stack empty ";}
    }
    public int size(){ return list.size();}
    
        public boolean isEmpty() {
        return list.size()==0?true:false;
    }
}
