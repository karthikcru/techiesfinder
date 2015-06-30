import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetTwitterConnection {

    public static Twitter getConnection(String consumerKey, String consumerToken, String authKey, String authToken ) {

    Twitter twitter = new TwitterFactory().getInstance();

    //	My Applications Consumer and Auth Access Token
    twitter.setOAuthConsumer(consumerKey, consumerToken);
    twitter.setOAuthAccessToken(new AccessToken(authKey, authToken));
    return twitter;
    }
}



