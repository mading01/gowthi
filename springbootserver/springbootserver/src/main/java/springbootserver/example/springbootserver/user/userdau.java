package springbootserver.example.springbootserver.user;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class userdau {
    private static List<user> users =new ArrayList<>();
    private static int usersCount = 3;
    static {
    	users.add(new user(1, "Loke", new Date()));
    	users.add(new user(2, "Lokesh", new Date()));
    	users.add(new user(3, "Mloke", new Date()));
    }
    public List<user> findAll(){
    	return users;
    }
    public user save(user userfind) {
    	if(userfind.getId()==null) {
    		userfind.setId(++usersCount);
    	}
    	users.add(userfind);
    	return userfind;
    }
    public user findOne(int id) {
    	for(user userfind:users) {
    		if(userfind.getId()==id) {
    			return userfind;
    		}
    	}
    	return null;
    }
}
