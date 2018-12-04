package telran.converter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.converter.dto.RateDto;

public class ConverterAppl {

	public static void main(String[] args) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://data.fixer.io/api/latest?access_key=your API Key";
		RequestEntity<String> request = 
				new RequestEntity<>(HttpMethod.GET, new URI(url));
		ResponseEntity<RateDto> response = 
				restTemplate.exchange(request, RateDto.class);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter currency from: ");
			String from = reader.readLine().trim().toUpperCase();
			System.out.println("Enter currency to: ");
			String to = reader.readLine().trim().toUpperCase();
			System.out.println("Enter sum: ");
			double sum = Double.parseDouble(reader.readLine());
			Map<String, Double> rates = response.getBody().getRates();
			double res = rates.get(to) / rates.get(from) * sum;
			System.out.println("Result: " + res);
		} catch (IOException e) {
			System.out.println("I/O ERROR");
		}catch (Exception e) {
			System.out.println("Incorrect arguments");
		}
		

	

	}

}
