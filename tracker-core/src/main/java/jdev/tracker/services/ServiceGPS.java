package jdev.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ServiceGPS {
    // Выполнить по расписанию
    @Scheduled(cron = "${gps.cron}")
    // Эмулирование случайных значений (широта, долгота, азимут, мгн.скорость)
    void emulateValue() throws JsonProcessingException, InterruptedException {
        PointDTO pointDTO = new PointDTO();

        // Радоминг точки GPS
        pointDTO.setLon(Math.random() * 180);
        pointDTO.setLat(Math.random() * 90);
        pointDTO.setAzimuth((int)(Math.random() * 360));
        pointDTO.setInstantSpeed(Math.random() * 130);

        // Запись точки в очередь
        ServiceSaveMsg.putMsg(pointDTO.toJson());
    }
}
