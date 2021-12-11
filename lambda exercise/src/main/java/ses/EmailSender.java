package ses;

// these are the imports for SDK v1
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.regions.Regions;

import java.util.ArrayList;
import java.util.List;

public class EmailSender {
    public EmailResult handleRequest(EmailRequest request, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Entering send_email");
        SendEmailResult sendEmailResult = new SendEmailResult();
        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()

                            // Replace US_WEST_2 with the AWS Region you're using for
                            // Amazon SES.
                            .withRegion(Regions.US_WEST_2).build();

            System.out.print("This is 1");
            //Make Destination Object
            List<String> emailList = new ArrayList<>();
            emailList.add(request.to);
            System.out.print("This is 2");
            Destination destination = new Destination(emailList);
            //Make Message Object
                //Make Content Object
            System.out.print("This is 3");
            Content content = new Content(request.textBody);
                //Make Body Object
            System.out.print("This is 4");
            Content content1 = new Content(request.subject);
            System.out.print("This is 5");
            Body body = new Body(content).withHtml(new Content(request.htmlBody));
            Message message = new Message(content1, body);
            System.out.print("This is 6");
            SendEmailRequest sendEmailRequest = new SendEmailRequest(request.from, destination, message);
            System.out.print("This is 7");
            sendEmailResult = client.sendEmail(sendEmailRequest);
            System.out.print("This is 8");
            logger.log("Email sent!");
        } catch (Exception ex) {
            logger.log("The email was not sent. Error message: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        finally {
            logger.log("Leaving send_email");
        }
        System.out.print("This is 9");
        EmailResult emailResult = new EmailResult();
        emailResult.message = sendEmailResult.getMessageId();
        System.out.print("This is 10");
        emailResult.timestamp = new java.util.Date().toString();
        return emailResult;
    }

}