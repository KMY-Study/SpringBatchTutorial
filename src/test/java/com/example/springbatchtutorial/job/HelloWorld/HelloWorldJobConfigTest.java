package com.example.springbatchtutorial.job.HelloWorld;

import com.example.springbatchtutorial.SpringBatchTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") // test시 profile지정으로 H2 database 사용.
@SpringBatchTest
@SpringBootTest(classes = {SpringBatchTestConfig.class, HelloWorldJobConfig.class})
class HelloWorldJobConfigTest {
    @Autowired private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void success() throws Exception{
        //when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        //then
        Assertions.assertEquals(jobExecution.getExitStatus(), ExitStatus.COMPLETED);
    }
}