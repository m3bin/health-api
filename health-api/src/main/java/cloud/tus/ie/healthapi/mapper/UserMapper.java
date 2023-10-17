/*
 * package cloud.tus.ie.healthapi.mapper;
 * 
 * import java.time.LocalDateTime; import java.time.format.DateTimeFormatter;
 * 
 * import org.mapstruct.Mapper; import org.mapstruct.Mapping; import
 * org.springframework.stereotype.Component;
 * 
 * import cloud.tus.ie.healthapi.model.User;
 * 
 * 
 * @Mapper public interface UserMapper {
 * 
 * @Mapping(target = "status", source = "completed")
 * 
 * @Mapping(target = "dateTime", expression = "java(getCurrentDateTime())") User
 * domUserToModUserDto(cloud.tus.ie.healthapi.domain.User user);
 * 
 * default String getCurrentDateTime() { String formattedDateTime =
 * LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
 * );
 * 
 * // Print the formatted date and time
 * System.out.println("Current date and time: " + formattedDateTime); return
 * formattedDateTime; } }
 */