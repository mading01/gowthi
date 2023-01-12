package springbootserver.example.springbootserver.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  
	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	//helloworld-bean 
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	//helloworld-bean-pathvariable 
		@GetMapping(path="/hello-world-bean/path-variable/{name}")
		public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello, %s", name));
		}
}
