import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.xspec.NULL;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class follow {

    void queryFollowees() {

    }

    public static class DynamoStatusResponse {
        //new Status("post", "user", "datetime", "url string list", "mentions string list")
        String post;
        String userAlias;
        String dateTime;
        List<String> urls;
        List<String> mentions;

        public DynamoStatusResponse(String post, String userAlias, String dateTime, List<String> urls, List<String> mentions) {
            this.post = post;
            this.userAlias = userAlias;
            this.dateTime = dateTime;
            this.urls = urls;
            this.mentions = mentions;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getUserAlias() {
            return userAlias;
        }

        public void setUserAlias(String userAlias) {
            this.userAlias = userAlias;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public List<String> getMentions() {
            return mentions;
        }

        public void setMentions(List<String> mentions) {
            this.mentions = mentions;
        }
    }

    public static void main(String[] args) {
        String hello = "hello!";
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));



//        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();
//
//        DynamoDB dynamoDB = new DynamoDB(client);
//
////QUERY FOLLOWS TABLE
//        Table table = dynamoDB.getTable("follows");
//
//        HashMap<String, Object> valueMap = new HashMap<String, Object>();
//        valueMap.put(":f", "@4");
//
//        boolean notEmpty = true;
//
//        String lastFollowerHandle = null;
//        String lastFolloweeHandle = null;
//        while (notEmpty) {
//            QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("follower_handle = :f")
//                    .withValueMap(valueMap).withMaxResultSize(1);
//
//            ItemCollection<QueryOutcome> items = null;
//            Iterator<Item> iterator = null;
//            Item item = null;
//
//            if (lastFolloweeHandle != null && lastFollowerHandle != null) {
//                querySpec.withExclusiveStartKey("follower_handle", lastFollowerHandle, "followee_handle", lastFolloweeHandle);
//            }
//            items = table.query(querySpec);
//            try {
//                System.out.println("CS340 data");
//
//
//                iterator = items.iterator();
//                while (iterator.hasNext()) {
//                    item = iterator.next();
//                    System.out.println(item.getString("follower_handle") + ": " + item.getString("followee_handle"));
//                }
//                if (items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey() == null) {
//                    notEmpty = false;
//                } else {
//                    lastFollowerHandle = items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey().get("follower_handle").getS();
//                    lastFolloweeHandle = items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey().get("followee_handle").getS();
//                    System.out.println(lastFollowerHandle + lastFolloweeHandle);
//                }
//            } catch (Exception e) {
//                System.err.println("CS340 data");
//                System.err.println(e.getMessage());
//            }
//        }
//
//
// QUERY INDEX
//        Table table = dynamoDB.getTable("follows");
//        Index index = table.getIndex("follows_index");
//        HashMap<String, Object> valueMap = new HashMap<String, Object>();
//        valueMap.put(":f", "@4");
//
//        boolean notEmpty = true;
//
//        String lastFollowerHandle = null;
//        String lastFolloweeHandle = null;
//        while (notEmpty) {
//            QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("followee_handle = :f")
//                    .withValueMap(valueMap).withMaxResultSize(5).withScanIndexForward(false);
//
//            ItemCollection<QueryOutcome> items = null;
//            Iterator<Item> iterator = null;
//            Item item = null;
//
//            if (lastFolloweeHandle != null && lastFollowerHandle != null) {
//                querySpec.withExclusiveStartKey("followee_handle", lastFolloweeHandle, "follower_handle", lastFollowerHandle);
//            }
//            items = index.query(querySpec);
//            try {
//                System.out.println("CS340 data");
//
//
//                iterator = items.iterator();
//                while (iterator.hasNext()) {
//                    item = iterator.next();
//                    System.out.println(item.getString("followee_handle") + ": " + item.getString("follower_handle"));
//                }
//                if (items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey() == null) {
//                    notEmpty = false;
//                } else {
//                    lastFolloweeHandle = items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey().get("followee_handle").getS();
//                    lastFollowerHandle = items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey().get("follower_handle").getS();
//                    System.out.println(lastFollowerHandle + lastFolloweeHandle);
//                }
//            } catch (Exception e) {
//                System.err.println("CS340 data");
//                System.err.println(e.getMessage());
//            }
//        }
//
//
//POPULATE
//        final Map<String, Object> infoMap = new HashMap<String, Object>();
//        infoMap.put("plot", "Nothing happens at all.");
//        infoMap.put("rating", 0);
////
//        try {
//            System.out.println("Adding a new item...");
//            PutItemOutcome outcome = table.putItem(new Item()
//                            .withPrimaryKey("follower_handle", "@zzzz", "followee_handle", "@pppp")
//                            .with("follower_name", "zzzz").with("followee_name", "pppp"));
//
//            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());
//
//        } catch (Exception e) {
//            System.err.println("Unable to add item.");
//            System.err.println(e.getMessage());
        }
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (i != j) {
//                    try {
//                        System.out.println("Adding a new item...");
//                        PutItemOutcome outcome = table
//                                .putItem(new Item()
//                                        .withPrimaryKey("follower_handle", "@" + String.valueOf(i), "followee_handle", "@" + String.valueOf(j))
//                                        .with("follower_name", String.valueOf(i)).with("followee_name", String.valueOf(j)));
//
//                        System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());
//
//                    } catch (Exception e) {
//                        System.err.println("Unable to add item.");
//                        System.err.println(e.getMessage());
//                    }
//                }
//            }
//        }
//
//
//
//GET
//        GetItemSpec spec = new GetItemSpec().withPrimaryKey("follower_handle", "@4", "followee_handle", "@5");
//
//        try {
//            System.out.println("Attempting to read the item...");
//            Item outcome = table.getItem(spec);
//            System.out.println("GetItem succeeded: " + outcome);
//
//        }
//        catch (Exception e) {
//            System.err.println("Unable to read item.");
//            System.err.println(e.getMessage());
//        }
//
////UPDATE
//        UpdateItemSpec spec = new UpdateItemSpec().withPrimaryKey("follower_handle", "@4", "followee_handle", "@5").with(count, num);
//
//        try {
//            System.out.println("Attempting to read the item...");
//            UpdateItemOutcome outcome = table.updateItem(spec);
//            System.out.println("Update Item succeeded: " + outcome.toString());
//        }
//        catch (Exception e) {
//            System.err.println("Unable to update item.");
//            System.err.println(e.getMessage());
//        }
//
//DELETE
//        DeleteItemSpec spec = new DeleteItemSpec().withPrimaryKey("follower_handle", "@4", "followee_handle", "@5");
//
//        try {
//            System.out.println("Attempting to read the item...");
//            DeleteItemOutcome outcome = table.deleteItem();
//            System.out.println("Update Item succeeded: " + outcome.toString());
//        }
//        catch (Exception e) {
//            System.err.println("Unable to update item.");
//            System.err.println(e.getMessage());
//        }

//    }
}
