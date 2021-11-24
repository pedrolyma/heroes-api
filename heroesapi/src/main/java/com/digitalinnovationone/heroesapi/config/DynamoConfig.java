package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.basicAWSCredentials;
import com.amazonaws.services.dynamobdv2.AmazonDynamoDB;
import com.amazonaws.services.dynamobdv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SpringUtils;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${aws_access_ky_id}")
    private String amazonAWSAccesskey;

    @Value("${aws_secret_access_key}")
    private String amazonAWSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccesskey,amazonAWSecretKey);
    }
}
