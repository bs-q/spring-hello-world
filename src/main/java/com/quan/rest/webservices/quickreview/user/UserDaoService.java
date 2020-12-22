package com.quan.rest.webservices.quickreview.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.quan.rest.webservices.quickreview.post.Post;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount=3;
    static {
        List<Post> user1= new ArrayList<>();
        user1.add(new Post("hello", 1, 1));
        user1.add(new Post("hi",2,1));
        user1.add(new Post("bonjour",3,1));
        users.add(new User(1, "adam", new Date(),user1));
        users.add(new User(2, "eva", new Date(),user1));
        users.add(new User(3, "quan", new Date(),user1));

    }
    public List<User> findAll(){
        return users;
    }
    public List<Post> getPost(int id){    
        for(User user:users){
            if(user.getId()==id){
                return user.getPosts();
            }
        }
        return null;
    }
    public Post getPostById(int uid,int pid){
        for (User user : users) {
            if (user.getId() == uid) {
                List<Post> tmp= user.getPosts();
                Post post=tmp.get(pid);
                if(post!=null){
                    return post; 
                }
            }
        }
        return null;
    }
    public User save(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id) {
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
