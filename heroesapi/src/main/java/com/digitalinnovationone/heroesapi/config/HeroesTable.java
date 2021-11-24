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
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.attributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.REGION_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;

import java.util.Arrays;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {
   public static void main (String [] args) throws Exception {
       AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
               .withEntpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
               .build();
       DynamoDB dynamoDB = new DynamoDB(client);
       string tableName="Heroes_Table";
       try {
           Table table = dynamoDB.createTable(tableName,
                   Arrays.asList( new KeySchemaElement( "id", KeyType_HASH)),
                   Arrays.asList( new AttributeDefinition( "id", ScalarAttributeType.S)),
                   new ProvisionedThroughput(5L, 5L));
           table.waitForActive();
       }
       catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
   }
}
