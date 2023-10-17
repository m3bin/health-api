
package cloud.tus.ie.healthapi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import cloud.tus.ie.healthapi.model.User;

//import cloud.tus.ie.healthapi.mapper.UserMapper;
//import cloud.tus.ie.healthapi.model.User;

@Service
public class HealthApiService {

	@Autowired
	RestTemplate restTemplate;

//	 @Autowired 
//	 UserMapper userMapperImpl;

	@Value("${clientUrl}")
	String url;

	public User getUserInfo(int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<cloud.tus.ie.healthapi.domain.User> response = restTemplate.getForEntity(url + id,
				cloud.tus.ie.healthapi.domain.User.class);
		User user = domUserToModUserDto(response.getBody());
		System.out.println(user.toString());
		return user;
	}

	public User domUserToModUserDto(cloud.tus.ie.healthapi.domain.User user) {
		if (user == null) {
			return null;
		}

		User user1 = new User();

		user1.setStatus(user.getCompleted());
		user1.setUserId(user.getUserId());
		user1.setId(user.getId());
		user1.setTitle(user.getTitle());

		user1.setDateTime(getCurrentDateTime());

		return user1;
	}

	private String getCurrentDateTime() {
		String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return formattedDateTime;
	}

}
