package com.example.demo.schedule.service;

import com.example.demo.global.util.WebDriverUtil;
import com.example.demo.schedule.dto.ScheduleResponse;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ScheduleService {

    public List<ScheduleResponse> getGameSchedule() {

        List<ScheduleResponse> schedules = new ArrayList<>();

        WebDriver driver = WebDriverUtil.getChromeDriver();

        String url = "https://game.naver.com/esports/League_of_Legends/schedule/world_championship";
        driver.get(url);

        if (!ObjectUtils.isEmpty(driver)) {

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));

            List<WebElement> cardItems = driver.findElements(By.className("card_item__3Covz"));

            for (WebElement cardItem : cardItems) {

                String date = cardItem.findElement(By.className("card_date__1kdC3")).getText();

                List<WebElement> rowItems = cardItem.findElements(By.className("row_item__dbJjy"));

                for (WebElement rowItem : rowItems) {
                    String time = rowItem.findElement(By.className("row_time__28bwr")).getText();
                    List<WebElement> teams = rowItem.findElements(By.className("row_name__IDFHz"));
                    List<WebElement> logos = rowItem.findElements(By.className("row_logo__c8gh0"));

                    ScheduleResponse scheduleResponse = ScheduleResponse.builder()
                            .date(date)
                            .time(time)
                            .blueTeam(teams.get(0).getText())
                            .redTeam(teams.get(1).getText())
                            .blueTeamLogo(logos.get(0).getAttribute("src"))
                            .redTeamLogo(logos.get(1).getAttribute("src"))
                            .build();

                    schedules.add(scheduleResponse);
                }
            }

//            parentElement.click();
//            parentElement.submit();
        }

        WebDriverUtil.quit(driver);
        return schedules;
    }
}
