package springbootserver.example.springbootserver.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class userResource {

	@Autowired
	private userdau service;
	@GetMapping("/users")
	public List<user> retrieveallusers(){
		return service.findAll();
	}
	@GetMapping("/users/{id}")
	public user retrieveuser(@PathVariable int id){
		user user = service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+ id);
		return user;
	
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody user user) {
		user savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
