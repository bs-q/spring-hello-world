package com.quan.rest.webservices.quickreview.user;

import java.net.URI;
import java.util.List;


import com.quan.rest.webservices.quickreview.post.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    // GET /users
    // retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id-"+id);
        return service.findOne(id);
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
    }
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPost(@PathVariable int id){
        return service.getPost(id);
    }
    @GetMapping("/users/{id}/post/{pid}")
    public Post retrieveSinglePost(@PathVariable int id,@PathVariable int pid){
        return service.getPostById(id, pid);
        
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User saved = service.save(user);
        // path append to uri
        // fromCurrentRequest get request URI

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
