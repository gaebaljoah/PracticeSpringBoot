package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
		//우선순위 컨테이너 안 스프링 빈에 등록되어있는 컨트롤러부터 매핑한 후 없으면 그때 static 폴더에있는 파일을 찾음.
		//@getmapping("/")이 homecontroller에 존재하므로 home.html 파일로 이동했다.

	}

}
