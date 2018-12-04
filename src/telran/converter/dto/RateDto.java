package telran.converter.dto;

import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RateDto {
	boolean success;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate date;
	long timestamp;
	String base;
	Map<String, Double> rates;

}
