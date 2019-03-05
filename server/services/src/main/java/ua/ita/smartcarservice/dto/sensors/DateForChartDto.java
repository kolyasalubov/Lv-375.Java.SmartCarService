package ua.ita.smartcarservice.dto.sensors;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class DateForChartDto {

    private String sensorType;

    private long carId;

    private String date;

    private String selection;

    // TODO change Date parsing
    public DateForChartDto(Map<String,String> parametersMap) {
        this.sensorType = parametersMap.get("sensorType");
        this.carId = Long.parseLong(parametersMap.get("carId"));
        this.date = parametersMap.get("date").replace('%', ' ');
        this.selection = parametersMap.get("selection");
    }

}
