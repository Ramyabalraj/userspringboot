
package com.kgisl.demo.controller;
import java.util.List;

import com.kgisl.demo.entity.User;
//import com.kgisl.demo.entity.TeamDto;
import com.kgisl.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
* UserController
*/

@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/Users")
public class UserController {

   @Autowired
   private UserService userService;

   // @Autowired
   // private ModelMapper modelMapper;

   @PostMapping(value = "/", headers = "Accept=application/json")
   public ResponseEntity<User> create(@RequestBody User user) {
      
       User actual=userService.create(user);
       HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(team.getTeamid()).toUri());
       return new ResponseEntity<>(actual,headers, HttpStatus.CREATED);
   }


@PostMapping(value="/value/")
public ResponseEntity<User> login(@RequestBody User current){
 User user = userService.login(current);
       if (user == null)  {
           System.out.println("no data");
           
           return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
       }
      
    return new ResponseEntity<>(user, HttpStatus.OK);
}
   @GetMapping("/")
   public @ResponseBody ResponseEntity<List<User>> all() {
       return new ResponseEntity<>(userService.get(), HttpStatus.OK);
   }

   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<User> getTeamById(@PathVariable("id") long id) {
       User user = userService.findById(id);
       if (user == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(user, HttpStatus.OK);
   }

   @PutMapping(value = "/{id}", headers="Accept=application/json")
   public ResponseEntity<User> update(@PathVariable("id") long id,@RequestBody User current)
   {
       User user=userService.update(id,current);
       return new ResponseEntity<>(user,HttpStatus.OK);
   }

   @DeleteMapping(value="/{id}", headers ="Accept=application/json")
   public ResponseEntity<User> delete(@PathVariable("id") Long id){
       User user = userService.findById(id);
       if (user == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       userService.deleteById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }


}