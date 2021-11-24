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
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemDutcome;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.REGION_DYNAMO;
import static com.digitalinnovationone.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;

public class HeroesData {

    public static void main (String [] args) throws Exception {
        AmazonDynamoDb client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynammoDB(client);
        Table table = dynamoDB.getTable("Heroes_Table");
        Item hero = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Mulher Maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 3);
        PutItemOutcome = table.putItem(hero);
    }
}
