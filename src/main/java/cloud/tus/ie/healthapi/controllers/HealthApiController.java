package cloud.tus.ie.healthapi.controllers;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.tus.ie.healthapi.model.User;
import cloud.tus.ie.healthapi.service.HealthApiService;

@RestController
@RequestMapping("/healthapi")
public class HealthApiController {

	@Autowired
	HealthApiService healthApiService;

	@RequestMapping(value = "/local", method = RequestMethod.GET)
	public String createArray() {
		ArrayList arr = new ArrayList();
		return "Success: #Code : " + arr.hashCode();

	}

	@RequestMapping(value = "/ping-google", method = RequestMethod.GET)
	public String pingGoogle() {
		try {
			// Ping Google's IP address (8.8.8.8)
			InetAddress address = InetAddress.getByName("8.8.8.8");
			boolean isReachable = address.isReachable(5000); // Timeout: 5000ms

			if (isReachable) {
				return "OK";
			} else {
				return "Ping failed";
			}
		} catch (Exception e) {
			return "Exception occurred: " + e.getMessage();
		}
	}

	@Autowired
	MetricsEndpoint metrics;

//	private MetricsEndpoint metrics = null;
//
//	public void MetricsController(MetricsEndpoint metricsEndpoint) {
//		this.metrics = metricsEndpoint;
//	}

//	@RequestMapping(value = "/get-cpu", method = RequestMethod.GET)
//	public Double getCPU() {
//		return metrics.metric("process.cpu.usage", Arrays.asList()).getMeasurements().get(0).getValue();
//	}

	@RequestMapping(value = "/mem-metrics", method = RequestMethod.GET)
	public HashMap<String, Long> getMemoryInfo() {
		HashMap<String, Long> hm = new HashMap<>();
		hm.put("used memory : ", Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory());
		hm.put("total memory : ", Runtime.getRuntime().totalMemory());
		hm.put("free memory : ", Runtime.getRuntime().freeMemory());
		hm.put("No. of processors : ", (long) Runtime.getRuntime().availableProcessors());
		
		return hm;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserInfo(@PathVariable("id") int userId) {
		User user = healthApiService.getUserInfo(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
